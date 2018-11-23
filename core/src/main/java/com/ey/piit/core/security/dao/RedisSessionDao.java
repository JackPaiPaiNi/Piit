package com.ey.piit.core.security.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ey.piit.core.redis.JedisShardedTemplate;
import com.ey.piit.core.utils.SerializeUtils;

public class RedisSessionDao extends AbstractSessionDAO {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	private String keyPrefix = "shiro_session:";
	
	@Autowired
	private JedisShardedTemplate jedisTemplate;

	@Override
	public void update(Session session) throws UnknownSessionException {
		logger.debug("now update session");
		
		this.saveSession(session);
	}

	@Override
	public void delete(Session session) {
		logger.debug("now delete session");
		
		byte[] key = getByteKey(session.getId());
		jedisTemplate.del(key);
	}

	@Override
	public Collection<Session> getActiveSessions() {
		logger.debug("now getActiveSessions session");

		Set<Session> sessions = new HashSet<Session>();
		
		Set<byte[]> keys = jedisTemplate.keys(SerializeUtils.serialize(this.keyPrefix + "*"));
		if(keys != null && keys.size()>0){
			for(byte[] key:keys){
				Session s = (Session)SerializeUtils.deserialize(jedisTemplate.get(key));
				sessions.add(s);
			}
		}
		
		return sessions;
	}

	@Override
	protected Serializable doCreate(Session session) {
		logger.debug("now doCreate session");
		
		Serializable sessionId = generateSessionId(session);
		this.assignSessionId(session, sessionId);
		this.saveSession(session);

		return sessionId;
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		logger.debug("now doReadSession session");
		
		if(sessionId == null){
			logger.error("session id is null");
			
			return null;
		}
		
		Session session = (Session) SerializeUtils.deserialize(jedisTemplate.get(this.getByteKey(sessionId)));
		
		return session;
	}
	
	/**
	 * save session
	 * @param session
	 * @throws UnknownSessionException
	 */
	private void saveSession(Session session) throws UnknownSessionException{
		if(session == null || session.getId() == null){
			logger.error("session or session id is null");
			
			return;
		}
		
		byte[] key = getByteKey(session.getId());
		byte[] value = SerializeUtils.serialize(session);
		jedisTemplate.set(key, value);
		jedisTemplate.expire(key, 7200);
	}
	
	/**
	 * 获得byte[]型的key
	 * @param key
	 * @return
	 */
	private byte[] getByteKey(Serializable sessionId){
		String preKey = this.keyPrefix + sessionId;
		
		return preKey.getBytes();
	}

}
