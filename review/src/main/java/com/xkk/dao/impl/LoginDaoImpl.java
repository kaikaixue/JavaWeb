package com.xkk.dao.impl;

import com.xkk.JavaBean.User;
import com.xkk.dao.LoginDao;
import com.xkk.utils.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDaoImpl implements LoginDao {
    @Override
    public Integer login(User user) throws SQLException {
        int flag = -1;
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection connection = dataBaseConnection.getConnection();

        String sql = "select count(*) from t_user where username = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            flag = resultSet.getInt(1);
        }
        dataBaseConnection.close();
        return flag;
    }

}
