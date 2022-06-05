package com.xkk.utils;

import javax.xml.crypto.Data;
import java.sql.Connection;

public class Demo {
    public static void main(String[] args) {
        DataBaseConnection baseConnection = new DataBaseConnection();
        Connection connection = baseConnection.getConnection();
        System.out.println(connection);
    }
}
