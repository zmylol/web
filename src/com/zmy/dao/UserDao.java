package com.zmy.dao;

import com.zmy.entity.User;
import com.zmy.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {
    private static JdbcUtil util =new JdbcUtil();
    private static ResultSet resultSet;
    private static ArrayList<User> users= new ArrayList<>();

    public static boolean check(User user){
        String sql="select * from users";
        PreparedStatement ps = util.createStatement(sql);
        try {
            ps.execute();
            resultSet=ps.getResultSet();
            while (resultSet.next()) {
                User user1 = new User();
                user1.setUsername(resultSet.getString(1));
                user1.setPassword(resultSet.getString(2));

                users.add(user1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
        }

        for(User element: users)
        {
            if (element.equals(user)){
                return true;
            }
        }
       return false;
    }
}
