package com.selonj.mybatis;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Created by L.x on 16-2-22.
 */
abstract public class AbstractMybatisTest {
    public static final String MYBATIS_CONFIG_XML = "mybatis-config.xml";
    protected SqlSession session;

    @Before
    final public void buildConfiguration() throws Exception {
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(from(MYBATIS_CONFIG_XML));
        session = sessionFactory.openSession();
    }

    private BufferedReader from(String resource) throws UnsupportedEncodingException {
        return new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(resource), "UTF-8"));
    }

    @After
    final public void closeSession() throws Exception {
        session.close();
    }

}
