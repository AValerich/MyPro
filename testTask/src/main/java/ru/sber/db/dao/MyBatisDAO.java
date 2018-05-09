package ru.sber.db.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class MyBatisDAO<T> {

    @Autowired
    @Qualifier("sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;

    public abstract T getMapper(SqlSession sqlSession);

    protected SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }


}
