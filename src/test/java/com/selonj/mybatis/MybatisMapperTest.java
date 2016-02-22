package com.selonj.mybatis;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-2-22.
 */
public class MybatisMapperTest extends AbstractMybatisTest {

    private UserMapper userMapper;

    @Before
    public void setUp() throws Exception {
        userMapper = session.getMapper(UserMapper.class);
    }

    @Test
    public void listUsers() throws Exception {
        List<User> users = userMapper.list();

        assertThat(users.size(), equalTo(2));
        assertThat(users, allOf(
                hasItem(new User("zhangsan", "123456")),
                hasItem(new User("lisi", "666666"))
        ));
    }
}
