package com.xkk.dao;

import com.xkk.JavaBean.User;

import java.sql.SQLException;

public interface LoginDao {
    Integer login(User user) throws SQLException;
}
