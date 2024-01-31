package cn.itcast.fruitstore.test;

import cn.itcast.fruitstore.view.AbstractAdminDialog;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class AbstractAdminDialogTest extends AbstractAdminDialog {
    //构造方法
    public  AbstractAdminDialogTest(){
        super();
        queryFruitItem();//查询水果信息
    }
    public void queryFruitItem(){
        String[] thead=new String[]{"水果编号","水果名称","水果单价(/元)","计价单位"};
        String [][] tbody=new String[][]{
                {"1","苹果","5.0","kg"},{"2","葡萄","3.2","斤"},
                {"3","雪梨","3.8","斤"},{"4","泰国大榴莲","120","个"}
        };
        TableModel data=new DefaultTableModel(tbody,thead);
        table.setModel(data);
    }
    public   void addFruitItem(){}
    public  void updateFruitItem(){}
    public  void delFruitItem(){}

    public static void main(String[] args) {
        new AbstractAdminDialogTest().setVisible(true);
        /*AbstractAdminDialogTest ab1=new AbstractAdminDialogTest();
        ab1.setVisible(true);
        ab1.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);*/
    }
}
