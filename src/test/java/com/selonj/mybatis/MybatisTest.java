package com.selonj.mybatis;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-2-22.
 */
public class MybatisTest extends AbstractMybatisTest {

    @Test
    public void connection() throws Exception {
        List<String> tableNames = session.selectList("tables");
        assertThat(tableNames, anyOf(hasItem("users"), hasItem("USERS")));
    }

}
