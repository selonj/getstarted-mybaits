package com.selonj.mybatis;

import org.apache.ibatis.builder.StaticSqlSource;
import org.apache.ibatis.mapping.*;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.After;
import org.junit.Before;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by L.x on 16-2-22.
 */
abstract public class AbstractMybatisTest {
    protected Configuration configuration;
    protected SqlSession session;

    @Before
    public void buildConfiguration() throws Exception {
        configuration = new Configuration(new Environment("dev", new JdbcTransactionFactory(), MySQL.dataSource()));
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        session = sessionFactory.openSession();
    }

    @After
    public void closeSession() throws Exception {
        session.close();
    }

    protected MappedStatement select(String id, String sql, ResultMap... types) {
        return new MappedStatement.Builder(configuration, id, sql(sql), SqlCommandType.SELECT).resultMaps(Arrays.asList(types)).build();
    }

    protected ResultMap as(Class<?> type) {
        return new ResultMap.Builder(configuration, "<can omit>", type, Collections.<ResultMapping>emptyList()).build();
    }

    private StaticSqlSource sql(String sql) {
        return new StaticSqlSource(configuration, sql);
    }
}
