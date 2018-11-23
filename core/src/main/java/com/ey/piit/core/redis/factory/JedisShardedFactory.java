package com.ey.piit.core.redis.factory;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import com.ey.piit.core.redis.JedisShardedTemplate;
import com.ey.piit.core.redis.pool.JedisPool;
import com.ey.piit.core.redis.pool.JedisPoolBuilder;

public class JedisShardedFactory implements FactoryBean<JedisShardedTemplate>, InitializingBean {
	
	private JedisShardedTemplate jedisTemplate;

	private Set<String> address;

	@Override
	public JedisShardedTemplate getObject() throws Exception {
		return jedisTemplate;
	}

	@Override
	public Class<? extends JedisShardedTemplate> getObjectType() {
		return (this.jedisTemplate != null ? this.jedisTemplate.getClass()
				: JedisShardedTemplate.class);
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		List<JedisPool> pool = new JedisPoolBuilder().setShardedMasterNames(address.toArray(new String[address.size()])).setPoolSize(10).buildShardedPools();
		jedisTemplate = new JedisShardedTemplate(pool);
	}

	public Set<String> getAddress() {
		return address;
	}

	public void setAddress(Set<String> address) {
		this.address = address;
	}
}