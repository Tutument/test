package com.example.test.io.image;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class ImageChage {

    public static void main(String[] args) {


    }

    public static BufferedImage chage(int width, int height){

        BufferedImage img = new BufferedImage(width, height,BufferedImage.TYPE_BYTE_GRAY);
        BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_BGR);
        WritableRaster raster = img.getRaster();
        WritableRaster rasterJPEG = image.getRaster();

        for(int h=0; h<height; h++)
            for(int w=0; w<width; w++) {
                int[] p = new int[4];
                rasterJPEG.getPixel(w, h, p);
                p[0] = (int) (0.3 * p[0]);
                p[1] = (int) (0.59 * p[1]);
                p[2] = (int) (0.11 * p[2]);
                int y = p[0] + p[1] + p[2];
                raster.setSample(w,h,0,y);
            }
        return img;
    }

    /**
     * 转换8位（从32位png格式图片转换成8位gif格式图片）
     */
    private static void convertToEight(String pngPath, String destination) throws IOException {
        //读取png图片路径
        ImageIcon ii = new ImageIcon(new File(pngPath).getCanonicalPath());
        Image i = ii.getImage();
        Image resizedImage = i.getScaledInstance(198, 198, Image.SCALE_SMOOTH);
        Image temp = new ImageIcon(resizedImage).getImage();
        BufferedImage bufferedImage = new BufferedImage(temp.getWidth(null), temp.getHeight(null), BufferedImage.TYPE_INT_BGR);

        Graphics2D gd = bufferedImage.createGraphics();
        bufferedImage = gd.getDeviceConfiguration().createCompatibleImage(198, 198, Transparency.TRANSLUCENT);
        gd = bufferedImage.createGraphics();
        gd.drawImage(temp, 0, 0, null);

        ImageIO.write(bufferedImage, "gif", new File(destination));
    }

}
