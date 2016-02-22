package com.selonj.mybatis;

import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by L.x on 16-2-22.
 */
public interface UserMapper {
    @ResultType(User.class)
    @Select("select * from users")
    List<User> list();

    @ResultType(Integer.class)
    @Select("select count(*) from users")
    Integer count();
}
