package cn.itcast.fruitstore.view;

import cn.itcast.fruitstore.tools.GUITools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public  abstract  class AbstractAdminDialog extends JDialog {
    //定义界面的成员变量
    private JLabel tableLabel=new JLabel("水果列表");
    private  JScrollPane tablePane=new JScrollPane();
    protected JTable table=new JTable();
    private JLabel numberLabel=new JLabel("水果编号");
    private JLabel nameLabel=new JLabel("水果名称");
    private JLabel priceLabel=new JLabel("水果单价");
    private JLabel unitLabel=new JLabel("计价单位");
    //添加组件
    protected JTextField addNumberText=new JTextField(6);
    protected JTextField addNameText=new JTextField(6);
    protected JTextField addPriceText=new JTextField(6);
    protected JTextField addUnitText=new JTextField(6);
    private JButton addBtn=new JButton("添加水果");
    //修改组件
    protected JTextField updateNumberText=new JTextField(6);
    protected JTextField updateNameText=new JTextField(6);
    protected JTextField updatePriceText=new JTextField(6);
    protected JTextField updateUnitText=new JTextField(6);
    private JButton updateBtn=new JButton("修改水果");
    //删除组件
    protected  JTextField delNumberText=new JTextField(6);
   private  JButton delBtn=new JButton("删除水果");
   public  AbstractAdminDialog(){
       this(null,true);
   }
   public  AbstractAdminDialog(Frame owner,boolean modal)
   {
       super(owner,modal);
       this.init();//初始化
       this.addComponent();//添加组件
       this.addListener();//添加监听器
   }
   //初始化操作
   private void init(){
        this.setTitle("超市货物管理!");
        this.setSize(600,400);
       GUITools.center(this);
       this.setResizable(false);
   }
   //添加组件
   private void addComponent(){
       this.setLayout(null);//取消布局
       tableLabel.setBounds(265,20,70,25);
       this.add(tableLabel);
       table.getTableHeader().setReorderingAllowed(false);//列不能移动
       table.getTableHeader().setResizingAllowed(false);//表格不移动
       table.setEnabled(false);//表格不可编辑
       tablePane.setBounds(50,50,500,200);
       tablePane.setViewportView(table);//表格嵌入可视表格中
       this.add(tablePane);
       //字段标题
       numberLabel.setBounds(50,250,70,25);
       nameLabel.setBounds(150,250,70,25);
       priceLabel.setBounds(250,250,70,25);
       unitLabel.setBounds(350,250,70,25);
       this.add(numberLabel);
       this.add(nameLabel);
       this.add(priceLabel);
       this.add(unitLabel);
       //增加组件
       addNumberText.setBounds(50,280,80,25);
       addNameText.setBounds(150,280,80,25);
       addPriceText.setBounds(250,280,80,25);
       addUnitText.setBounds(350,280,80,25);
       this.add(addNumberText);
       this.add(addNameText);
       this.add(addPriceText);
       this.add(addUnitText);
       addBtn.setBounds(460,280,90,25);
       this.add(addBtn);
       //修改组件
       updateNumberText.setBounds(50,310,80,25);
       updateNameText.setBounds(150,310,80,25);
       updatePriceText.setBounds(250,310,80,25);
       updateUnitText.setBounds(350,310,80,25);
       this.add(updateNumberText);
       this.add(updateNameText);
       this.add(updatePriceText);
       this.add(updateUnitText);
       updateBtn.setBounds(460,310,90,25);
       this.add(updateBtn);
       //删除组件
       delNumberText.setBounds(50,340,80,25);
       this.add(delNumberText);
       delBtn.setBounds(460,340,90,25);
       this.add(delBtn);
   }
   //添加监听器
    private  void addListener(){
       //添加按钮监听器
        addBtn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFruitItem();
            }
        });
        //添加组件监听器
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFruitItem();
            }
        });
        //添加删除监听器
        delBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delFruitItem();
            }
        });
    }
    public  abstract void addFruitItem();
   public abstract void updateFruitItem();
   public abstract void delFruitItem();
}
