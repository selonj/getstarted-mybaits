package com.selonj.mybatis;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-2-22.
 */
public class MybatisTest extends AbstractMybatisTest {

    @Before
    public void setUp() throws Exception {
        addMapper(UserMapper.class);
    }

    @Test
    public void connection() throws Exception {
        Integer countOfUsers = session.selectOne("com.selonj.mybatis.UserMapper.count");
        assertThat(countOfUsers, equalTo(2));
    }

}
