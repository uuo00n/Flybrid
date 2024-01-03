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
    //    绘制开始和技术图片
    public BufferedImage gstart, gend;
    public BufferedImage gd;
    //    游戏状态
    int state;
    public static final int STATRT = 0;
    public static final int RUNNING = 1;
    public static final int END = 2;

    //    声明地面
    public Ground ground;
    //    声明小鸟
    public Bird bird;

    //    赋值
    public BirdGame() {
        try {
            state = STATRT;
//            创建ground对象，调用Ground类
            ground = new Ground();
//            创建小鸟对象
            bird = new Bird();
//            异常：程序在运行时发生不可控的事件
//            getClass().getResource() 获取资源路径
            bg = ImageIO.read(getClass().getResource("./img/bg.png"));
            gstart = ImageIO.read(getClass().getResource("./img/start.png"));
            gend = ImageIO.read(getClass().getResource("./img/gameover.png"));

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("图片未找到！");
        }
    }

    //    画画(Graphics 画笔)
    public void paint(Graphics g) {
        g.drawImage(bg, 0, 0, null);
        g.drawImage(ground.image, ground.x, ground.y, null);
        g.drawImage(bird.bImage, bird.x, bird.y, null);
        switch (state) {
            case STATRT:
                g.drawImage(gstart, 0, 0, null);
                break;
            case RUNNING:
                break;
            case END:
                g.drawImage(gend, 0, 0, null);
                break;
        }
    }

    //    游戏开始
    public void action() {
        //    来回进行滚动--死循环
        while (true) {
            switch (state) {
                case STATRT:
                    ground.step();
                    bird.fly();
                    break;
                case RUNNING:
                    ground.step();
                    bird.fly();
                    break;
                case END:
                    break;
            }
            repaint();
            try {
                Thread.sleep(1000 / 60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
//        让地面一直动起来,重新绘制，一直进行循环
    }
}
