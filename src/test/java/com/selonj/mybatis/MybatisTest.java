package com.selonj.mybatis;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-2-22.
 */
public class MybatisTest extends AbstractMybatisTest {

    public static final String TABLES = "tables";

    @Before
    public void addMappedStatement() throws Exception {
        configuration.addMappedStatement(select(TABLES, "show tables", as(String.class)));
    }

    @Test
    public void connection() throws Exception {
        List<String> tableNames = session.selectList(TABLES);
        assertThat(tableNames, anyOf(hasItem("users"), hasItem("USERS")));
    }

}
