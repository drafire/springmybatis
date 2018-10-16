package com.drafire.springmybatis;

import java.sql.*;

public class DrafireSimpleExecutor implements DrafireExecutor {
    @Override
    public <E> E query(String statement, Object parameter) {
        Connection connection = getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(statement);
            ps.setInt(1, Integer.parseInt(String.valueOf(parameter)));

            ResultSet rs = ps.executeQuery();
            User user = new User();

            while (rs.next()) {
                user.setId(Integer.parseInt(String.valueOf(parameter)));
                user.setAmount(rs.getFloat("amount"));
                user.setName(rs.getString("name"));
            }
            return (E) user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ;
        return null;
    }

    private Connection getConnection() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/bank?useUnicode=true&characterEncoding=utf-8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String username = "root";
        String password = "123456";
        Connection conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
