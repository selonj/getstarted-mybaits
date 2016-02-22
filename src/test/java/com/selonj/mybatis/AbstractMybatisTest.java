package com.selonj.mybatis;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.After;
import org.junit.Before;

/**
 * Created by L.x on 16-2-22.
 */
abstract public class AbstractMybatisTest {
    protected Configuration configuration;
    protected SqlSession session;

    @Before
    final public void buildConfiguration() throws Exception {
        configuration = new Configuration(new Environment("dev", new JdbcTransactionFactory(), MySQL.dataSource()));
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        session = sessionFactory.openSession();
    }

    @After
    final public void closeSession() throws Exception {
        session.close();
    }

    protected void addMapper(Class<?> mapperClass) {
        configuration.getMapperRegistry().addMapper(mapperClass);
    }
}
