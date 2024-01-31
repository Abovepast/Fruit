package cn.itcast.fruitstore.service;

import cn.itcast.fruitstore.dao.AdminDao;
import cn.itcast.fruitstore.domain.FruitItem;

import java.util.ArrayList;

public class AdminService {
    //管理服务
    //查询服务
    private AdminDao adminDao = new AdminDao();
    public ArrayList<FruitItem> queryFruitItem() {
        ArrayList<FruitItem> data = adminDao.queryAllData();
        return data;
    }
    //添加服务
    public boolean addFruitItem(String number, String name, String price, String unit) {
        ArrayList<FruitItem> data = queryFruitItem();
        for (int i = 0; i < data.size(); i++) {
            FruitItem fruitItem = data.get(i);
            if (number.equals(fruitItem.getNumber())) {
                return false;
            }
        }
        FruitItem thisFruitItem = new FruitItem(number, name, Double.parseDouble(price), unit);
        adminDao.addFruitItem(thisFruitItem);
        return true;
    }
    //修改服务
    public boolean updateFruitItem(String number,String name,String price,String unit){
        ArrayList<FruitItem> data=queryFruitItem();
        for(int i=0;i<data.size();i++){
            FruitItem fruititem=data.get(i);
            if(number.equals(fruititem.getNumber())){
                adminDao.delFruitItem(number);
                FruitItem thisFruitItem= new FruitItem(number,name,Double.parseDouble(price),unit);
                adminDao.addFruitItem(thisFruitItem);
                return true;
            }
        }
        return false;
    }
    public boolean delFruitItem(String delNumber){

        ArrayList<FruitItem>data=queryFruitItem();
        for (int i = 0; i < data.size(); i++) {
           FruitItem fruititem=data.get(i);
            if (delNumber.equals(fruititem.getNumber())){
                adminDao.delFruitItem(delNumber);
                return true;
            }
        }
        return false;
    }
}
