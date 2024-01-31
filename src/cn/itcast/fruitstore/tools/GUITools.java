package cn.itcast.fruitstore.tools;

import javax.swing.*;
import java.awt.*;

public class GUITools {
    static Toolkit kit=Toolkit.getDefaultToolkit();
    //将指定组件屏幕居中
    public  static  void center(Component c)
    {
        int x=(kit.getScreenSize().width-c.getWidth())/2;
        int y=(kit.getScreenSize().height-c.getHeight())/2;
        c.setLocation(x,y);
    }
    //为指定窗口设置图标
    public static  void setTitleImage(JFrame frame,String titleIconPath)
    {
            frame.setIconImage(kit.createImage(titleIconPath));
    }
}

