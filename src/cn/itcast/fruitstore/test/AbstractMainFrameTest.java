package cn.itcast.fruitstore.test;

import cn.itcast.fruitstore.view.AbstractMainFrame;

import javax.swing.*;

public class AbstractMainFrameTest extends AbstractMainFrame {
    public    void showAdminDialog(){
        System.out.println("进入管理界面");
    }

    public static void main(String[] args) {
        new AbstractMainFrameTest().setVisible(true);
    }
}
