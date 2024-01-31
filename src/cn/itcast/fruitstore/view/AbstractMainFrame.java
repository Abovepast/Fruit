package cn.itcast.fruitstore.view;

import cn.itcast.fruitstore.tools.GUITools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public abstract class AbstractMainFrame extends JFrame {
    private JLabel titletable=new JLabel(new ImageIcon("C:\\idea\\Fruit\\img\\FruitStore.png"));
    private JButton btn=new JButton("进入系统");
    public  AbstractMainFrame()
    {
        this.init();//初始化操作
        this.addComponent();//添加组件
        this.addListener();//添加监视器
    }
    private  void init()//初始化操作
    {
        this.setTitle("水果超市欢迎您");
        this.setSize(600,400);
        GUITools.center(this);//设置窗口在屏幕居中位置
        GUITools.setTitleImage(this,"C:\\idea\\Fruit\\img\\title.png");
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    private void addComponent()//添加组件
    {
        this.add(this.titletable, BorderLayout.NORTH);
        JPanel btnPanel=new JPanel();
        btnPanel.setLayout(null);//取消布局
        this.add(btnPanel);
        btn.setBounds(240,20,120,50);
        btnPanel.add(btn);
    }
    private  void addListener()//添加监视器
    {
        btn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAdminDialog();//设为抽象方法
            }
        });
    }
    //展示管理员界面方法
    public  abstract  void showAdminDialog();
}
