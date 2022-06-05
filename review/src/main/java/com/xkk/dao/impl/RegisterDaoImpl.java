package com.xkk.dao.impl;

import com.xkk.JavaBean.RegisterUser;
import com.xkk.dao.RegisterDao;
import com.xkk.utils.DataBaseConnection;

import java.sql.*;

public class RegisterDaoImpl implements RegisterDao {
    @Override
    public Integer register(RegisterUser registerUser) throws SQLException {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection connection = dataBaseConnection.getConnection();
        String sql = "insert into t_user(username, password, email) values (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, registerUser.getUsername());
        preparedStatement.setString(2, registerUser.getPassword());
        preparedStatement.setString(3, registerUser.getEmail());
        int result = preparedStatement.executeUpdate();
        dataBaseConnection.close();
        return result;
    }
}
