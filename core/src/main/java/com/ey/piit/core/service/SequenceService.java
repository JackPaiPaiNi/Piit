package com.ey.piit.core.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.piit.core.repository.SequenceDao;

@Service
public class SequenceService {

	@Autowired
	private SequenceDao sequenceDao;
	
	public String findNextSequence(String name){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("name", name);
		return sequenceDao.selectNextSequence(param);
	}
	
	public String findNextSequence(String prefix,String name){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("name", name);
		return prefix + sequenceDao.selectNextSequence(param);
	}

	public SequenceDao getSequenceDao() {
		return sequenceDao;
	}

	public void setSequenceDao(SequenceDao sequenceDao) {
		this.sequenceDao = sequenceDao;
	}
	
}
