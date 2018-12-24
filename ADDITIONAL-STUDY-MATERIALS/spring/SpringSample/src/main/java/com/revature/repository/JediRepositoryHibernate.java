package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import com.revature.model.Jedi;

public class JediRepositoryHibernate implements JediRepository {

	@Override
	public List<Jedi> selectAll() {
		List<Jedi> jedis = new ArrayList<>();
		jedis.add(new Jedi(1,"Obi Wan","Blue"));
		jedis.add(new Jedi(2,"Yoda","Green"));
		
		return jedis;
	}

}
