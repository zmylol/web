package com.zmy.util;

import java.sql.*;

public class JdbcUtil {
    private static Connection con= null;
    private static PreparedStatement ps =null;
    static {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        System.out.println("driver接口实现类被注册了");
    }
    public Connection createCon(){

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zmy","root","123456");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("connection对象创建失败了！");
        }
        return con;
    }
    public PreparedStatement createStatement(String sql){

        Connection con = createCon();
        try {
            ps = con.prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ps;
    }
    public void close(){
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(con!=null){
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public void close(ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        close();
    }
}
