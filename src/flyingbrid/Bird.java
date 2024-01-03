package flyingbrid;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 小鸟类：
 * 1.先声明
 * 2.初始化
 * 3.在画板上画画
 */
public class Bird {
    //    小鸟图片
    public BufferedImage bImage;
    //    所有图片状态(0-7)
    public BufferedImage bImages[];
    //    高度，宽度
    int height, width;
    //    坐标
    int x, y;
//    初始位置下标
    int index = 0;
    public Bird() {
        try {
            bImage = ImageIO.read(getClass().getResource("./img/0.png"));
            bImages = new BufferedImage[8];
            for (int i = 0; i < bImages.length; i++) {
                bImages[i] = ImageIO.read(getClass().getResource("./img/" + i + ".png"));
            }
//            小鸟位置
            x = 120;
            y = 220;
//            小鸟的宽高
            width = bImage.getWidth();
            height = bImage.getHeight();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("图片未找到");
        }
    }
//    小鸟飞
    public void fly(){
//        连续访问0~7张图片(变成小数)
        bImage = bImages[index/10%8];
        index++;
    }
}
