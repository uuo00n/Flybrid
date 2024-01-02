package flyingbrid;

import javax.swing.*;

/**
 * 游戏入口
 * javax.swing 图形界面设计技术
 * */
public class StartGame {
    public static void main(String[] args) {
//        绘制游戏窗口
        JFrame frame = new JFrame("飞扬的小鸟");
//        设置窗口大小
        frame.setSize(600,970);
//        布局样式---居中
        frame.setLocationRelativeTo(null);
//        添加可视化窗口
        frame.setVisible(true);
//        关闭应用程序
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
