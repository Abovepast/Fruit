package cn.itcast.fruitstore.controller;

import cn.itcast.fruitstore.domain.FruitItem;
import cn.itcast.fruitstore.service.AdminService;
import cn.itcast.fruitstore.view.AbstractAdminDialog;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;

public class AdminDialogController extends AbstractAdminDialog {
    //管理员界面的操作
    //定义服务类，提供完整的功能
    private AdminService adminService=new AdminService();
    //构造方法
    public AdminDialogController()
    {super();}
    public  AdminDialogController(Frame owner,boolean modal)
    {
        super((JFrame)owner,modal);
        queryFruitItem();
    }
    //查询方法
    public void queryFruitItem()
    {
        String[]  thead={"水果编号","水果名称","水果单价","计价单位"};
        ArrayList<FruitItem> dataList=adminService.queryFruitItem();
        String[][] tbody=list2Arry(dataList);
        TableModel dataModel=new DefaultTableModel(tbody,thead);
        table.setModel(dataModel);
    }
    //集合数据转为二维数组方法
    public  String[][] list2Arry(ArrayList<FruitItem>list){
        String[][]tbody=new String[list.size()][4];
        for(int i=0;i<list.size();i++){
            FruitItem fruitItem=list.get(i);
            tbody[i][0]=fruitItem.getNumber();
            tbody[i][1]=fruitItem.getName();
            tbody[i][2]=fruitItem.getPrice()+"";
            tbody[i][3]=fruitItem.getUnit();
        }
        return tbody;
    }
    //添加方法
    public void addFruitItem(){
        String addNumber=addNumberText.getText();
        String addName=addNameText.getText();
        String addPrice=addPriceText.getText();
        String addUnit=addUnitText.getText();
        boolean addSuccess= adminService.addFruitItem(addNumber,addName,addPrice,addUnit);
        if(addSuccess)
        {
            queryFruitItem();
        }
        else
        {JOptionPane.showMessageDialog(this,"水果编号不能重复水果,请重新查数据");}
    }
    //修改方法
    public  void updateFruitItem()
    {
        String updateNumber=updateNumberText.getText();
        String updateName=updateNameText.getText();
        String updatePrice=updatePriceText.getText();
        String updateUnit=updateUnitText.getText();
        boolean updateSuccess= adminService.updateFruitItem(updateNumber,updateName,updatePrice,updateUnit);
       if(updateSuccess)
        {
            queryFruitItem();
        }
        else
        {JOptionPane.showMessageDialog(this,"没有这水果编号,请重新查数据");}
    }
    //删除方法
  public  void delFruitItem(){
        String delNumber=delNumberText.getText();
        boolean delSuccess=adminService.delFruitItem(delNumber);
        if(delSuccess)
        {
            queryFruitItem();
        }
        else {
            JOptionPane.showMessageDialog(this,"没有这编号，请重新查数据");
        }
  }
}
