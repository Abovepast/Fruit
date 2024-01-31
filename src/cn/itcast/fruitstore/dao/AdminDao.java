package cn.itcast.fruitstore.dao;


import cn.itcast.fruitstore.domain.FruitItem;
import cn.itcast.fruitstore.tools.JDBCUILS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminDao {
    //管理员数据访问
    //获取所以数据
    //管理员，数据访问
    //1.获取所有数据
    public ArrayList<FruitItem> queryAllData() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        ArrayList<FruitItem> list = new ArrayList<>();
        try {
            conn = JDBCUILS.getConnection();   //获得数据连接
            stmt = conn.createStatement();  //获得Statement对象
            String sql = "select * from fruit";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                FruitItem fruitItem = new FruitItem();
                fruitItem.setNumber(rs.getString("number"));
                fruitItem.setName(rs.getString("fruitname"));
                fruitItem.setPrice(rs.getDouble("price"));
                fruitItem.setUnit(rs.getString("unit"));
                list.add(fruitItem);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUILS .release(rs,stmt,conn);
        }
        return list;
    }
    //2.添加数据
    public void addFruitItem(FruitItem fruitItem) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = JDBCUILS.getConnection();
            stmt = conn.createStatement();
            String sql = "insert into fruit(number, fruitname, price, unit) VALUES ("+fruitItem.getNumber()+",'"+fruitItem.getName()+"','"+fruitItem.getPrice()+"','"+fruitItem.getUnit()+"')";
//                    formatted(fruitItem.getNumber(), fruitItem.getName(), fruitItem.getPrice(), fruitItem.getUnit());
            int num = stmt.executeUpdate(sql);
            if (num>0) {
                System.out.println("插入数据成功！");
                System.out.println("有"+num+"行受影响");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUILS.release(stmt,conn);
        }
    }
    //3.修改数据(本质是删再加)
    //4.删除数据
    public void delFruitItem(String delNumber) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = JDBCUILS.getConnection();
            stmt = conn.createStatement();
            String sql = "delete from fruit where number="+delNumber;
            int num = stmt.executeUpdate(sql);
            if (num > 0) {
                System.out.println("删除成功！");
                System.out.println("受影响行数为"+num);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUILS.release(stmt,conn);
        }
    }
}
