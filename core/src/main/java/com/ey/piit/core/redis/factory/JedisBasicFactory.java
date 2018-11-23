package com.ey.piit.core.redis.factory;

import java.util.Set;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import com.ey.piit.core.redis.JedisTemplate;
import com.ey.piit.core.redis.pool.JedisPool;
import com.ey.piit.core.redis.pool.JedisPoolBuilder;

public class JedisBasicFactory implements FactoryBean<JedisTemplate>, InitializingBean {
	
	private JedisTemplate jedisTemplate;
	
	private Set<String> address;

	@Override
	public JedisTemplate getObject() throws Exception {
		return jedisTemplate;
	}

	@Override
	public Class<? extends JedisTemplate> getObjectType() {
		return (this.jedisTemplate != null ? this.jedisTemplate.getClass()
				: JedisTemplate.class);
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		String hostPortStr = address.toArray(new String[address.size()])[0];
		String[] hostPort = hostPortStr.split(":");
		JedisPool pool = new JedisPoolBuilder().setDirectHostAndPort(JedisPoolBuilder.DIRECT_POOL_PREFIX + hostPort[1], hostPort[2]).setPoolSize(10).buildPool();
		jedisTemplate = new JedisTemplate(pool);
	}

	public Set<String> getAddress() {
		return address;
	}

	public void setAddress(Set<String> address) {
		this.address = address;
	}
}
