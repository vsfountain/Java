package com.dao;

public interface H2DAO {

	void h2InitDaoInserts();

	void h2InitDaoTriggers();

	void h2InitDaoFunProc();

	void h2InitDao();

	void h2InitDaoSeq();

	void h2DestroyDao();

}
