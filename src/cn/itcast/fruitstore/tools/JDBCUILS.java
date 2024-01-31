package cn.itcast.fruitstore.tools;

import java.sql.*;

public class JDBCUILS {
    public static java.sql.Connection getConnection()throws SQLException,ClassNotFoundException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url ="jdbc:mysql://localhost:3306/jdbc?useSSL=false"
                +"&allowPublicKeyRetrieval=true&serverTimezone=UTC&useUnicode=true";
        String username="root";
        String password="123456zr";
        Connection conn= DriverManager.getConnection(url,username,password);
        return conn;
    }
    //获取数据库
    //
    public  static void release(Statement stmt, Connection conn)
    {
        if(stmt!=null)
        {
            try{
                stmt.close();
            }catch (SQLException e)
            {e.printStackTrace();}
            stmt=null;
        }
        if(conn!=null)
        {
            try{
                conn.close();
            }catch (SQLException e)
            {e.printStackTrace();}
            conn=null;
        }
    }
    public static void release(ResultSet rs, Statement stmt, Connection conn)
    {
        if (rs!=null)
        {
            try{rs.close();
            }catch (SQLException e)
            {
                e.printStackTrace();
            }
            rs=null;
        }
        release(stmt,conn);
    }

}
