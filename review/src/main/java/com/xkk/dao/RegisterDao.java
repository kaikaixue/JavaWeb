package com.xkk.dao;

import com.xkk.JavaBean.RegisterUser;

import java.sql.SQLException;

public interface RegisterDao {
    Integer register(RegisterUser registerUser) throws SQLException;
}
