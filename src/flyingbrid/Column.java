package flyingbrid;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 1.每两个管道一出先
 * 2.管道出现随机位置
 * 3.图层问题
 */
public class Column {
    //    管道图片
    public BufferedImage cImage;
    //    坐标
    int x, y;
    //    高度和宽度
    int width, height;
    //    管道个数
    static int count = 0;

    int distance = 270;

    Random random = new Random();


    public Column() {
        try {
            cImage = ImageIO.read(getClass().getResource("./img/column.png"));
            width = cImage.getWidth();
            height = cImage.getHeight();
            x = 450 + distance * count;
//            y坐标-500~-200随机数从0开始
            y = random.nextInt(300) + 100 - height / 2;
        } catch (IOException e) {
            e.printStackTrace();
        }
//        控制管道操作
        count++;
    }

    //    管道移动
    public void step() {
        //从右往左移动
        x--;
        //从第一个管道---第三个管道
        if (x == width / 2) {
            x = x + distance * 2;
            y = random.nextInt(300)+100-height/2;
        }
    }
}
