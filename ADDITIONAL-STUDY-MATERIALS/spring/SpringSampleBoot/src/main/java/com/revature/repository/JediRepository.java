package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Jedi;

@Transactional
public interface JediRepository extends JpaRepository<Jedi, Long> {
	public List<Jedi> findByNameLike(String name);

}
