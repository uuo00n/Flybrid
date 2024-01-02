package flyingbrid;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 地面类
 */
public class Ground {
    //    定义地面图片
    public BufferedImage image;
    //    定义坐标
    int x, y;

    public Ground() {
        try {
            image = ImageIO.read(getClass().getResource("./img/ground.png"));
            x = 0;
            y = 499;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("图片未找到");
        }
    }

    //    地面滚动
    public void step() {
        x--;
//        当向左移动到某一个位置时，又回到原位
        if (x == -100) {
            x = 0;
        }
    }
}