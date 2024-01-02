package flyingbrid;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 画板类(游戏操作类)
 */
public class BirdGame extends JPanel {
    //    绘制背景图片(BufferedImage图片缓冲区)
    public BufferedImage bg;

    //    赋值
    public BirdGame() {
        try {
//            异常：程序在运行时发生不可控的事件
//            getClass().getResource() 获取资源路径
            bg = ImageIO.read(getClass().getResource("./img/bg.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("图片未找到！");
        }
    }

    //    画画(Graphics 画笔)
    public void paint(Graphics g) {
        g.drawImage(bg, 0, 0, null);

    }
}
