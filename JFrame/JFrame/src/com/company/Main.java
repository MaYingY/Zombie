package com.company;

/*created by myy at 2017.6.15 20:03*/
/*简单的窗体*/
import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        //创建一个标题为s的窗口
        JFrame jFrame = new JFrame("第一个窗口");
        JFrame jFrame1 = new JFrame("第二个窗口");
        //窗口位置，分别是左、上、宽、高
        jFrame.setBounds(60,100,188,108);
        jFrame1.setBounds(260,100,188,108);
        //容器类
        Container container = jFrame.getContentPane();
        container.setBackground(Color.lightGray);
        //设置窗口是否可见，默认窗口不可见
        jFrame.setVisible(true);
        jFrame1.setVisible(true);
        //设置单击窗体右上角的关闭图标后，程序会做出怎样的处理
        //DISPOSE_ON_CLOSE隐藏当前窗口，并释放窗体占有的其他资源
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //EXIT_ON_CLOSE结束窗口所在的应用程序
        jFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
