package mooc.文件处理.xu01.basic;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
//crop 裁切（照片/图画）
public class ImageTest {

    public static void main(String[] args) throws Exception {
        //raw();
        //readC();
        //cropImage("C:\\Users\\k1326\\Desktop\\学习\\Test\\1.jpg","C:\\Users\\k1326\\Desktop\\学习\\Test\\crop.jpg",0,0,100,100,"jpg","jpg");
        //combineImagesHorizontally("C:\\Users\\k1326\\Desktop\\学习\\Test\\1.jpg","C:\\Users\\k1326\\Desktop\\学习\\Test\\crop.jpg","jpg","C:\\Users\\k1326\\Desktop\\学习\\Test\\l.jpg");

        //combineImagesVertically("C:\\Users\\k1326\\Desktop\\学习\\Test\\1.jpg","C:\\Users\\k1326\\Desktop\\学习\\Test\\crop.jpg","jpg","C:\\Users\\k1326\\Desktop\\学习\\Test\\r.jpg");
        //readC();


        rotate("C:\\Users\\k1326\\Desktop\\1.jpg","C:\\Users\\k1326\\Desktop\\2.jpg");
   }

    public static void raw() throws IOException {
        BufferedImage read = ImageIO.read(new File("C:\\Users\\k1326\\Desktop\\学习\\Test\\1.jpg"));
        System.out.println(read.getWidth());
        System.out.println(read.getHeight());
        ImageIO.write(read,"png",new File("C:\\Users\\k1326\\Desktop\\学习\\Test\\1.png"));
    }

    public static void readC() throws IOException {
        System.out.println("测试不同方式的加载速度");

        // ImageIO需要测试图片的类型，加载合适的ImageReader来读取图片，耗时更长
        long startTime = System.nanoTime();
        BufferedImage read = ImageIO.read(new File("C:\\Users\\k1326\\Desktop\\学习\\Test\\1.jpg"));
        System.out.println(read.getWidth());
        System.out.println(read.getHeight());
        long endTime = System.nanoTime();
        System.out.println((endTime-startTime)/1000000.0+"毫秒");

        //指定用 jpg Reader 来加载，速度会更快
        startTime = System.nanoTime();
        Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName("jpg");

        ImageReader reader = readers.next();
        System.out.println(readers.hasNext());
        //com.sun.imageio.plugins.jpeg.JPEGImageReader
        System.out.println(reader.getClass().getName());

        ImageInputStream imageInputStream = ImageIO.createImageInputStream(new File("C:\\Users\\k1326\\Desktop\\学习\\Test\\1.jpg"));

        reader.setInput(imageInputStream,true);
       // System.out.println("width:" + reader.getWidth(0));
        //System.out.println("Height:" + reader.getHeight(0));
        BufferedImage read1 = reader.read(0);
        System.out.println(read1.getHeight());
        System.out.println(read1.getWidth());


        endTime = System.nanoTime();
        System.out.println((endTime-startTime)/1000000.0+"毫秒");
    }



    public static void readAndWrite() throws Exception {
        BufferedImage image = ImageIO.read(new File("c:/temp/ecnu.jpg"));
        System.out.println("Height: " + image.getHeight()); // 高度像素
        System.out.println("Width: " + image.getWidth()); // 宽度像素
        ImageIO.write(image, "png", new File("c:/temp/ecnu.png"));
    }

    public static void readComparison() throws Exception {
        System.out.println("===========加载速度测试==============");

        // ImageIO需要测试图片的类型，加载合适的ImageReader来读取图片，耗时更长
        long startTime = System.nanoTime();
        BufferedImage image = ImageIO.read(new File("c:/temp/ecnu.jpg"));
        System.out.println("Height: " + image.getHeight()); // 高度像素
        System.out.println("Width: " + image.getWidth()); // 宽度像素
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1000000.0 + "毫秒");
        // 指定用jpg Reader来加载，速度会加快
        startTime = System.nanoTime();




        Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName("jpg");
        ImageReader reader = (ImageReader) readers.next();



        System.out.println(reader.getClass().getName());
        ImageInputStream iis = ImageIO.createImageInputStream(new File("c:/temp/ecnu.jpg"));
        reader.setInput(iis, true);
        System.out.println("Height:" + reader.getHeight(0));
        System.out.println("Width:" + reader.getWidth(0));
        endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1000000.0 + "毫秒");
    }

    /**
     * cropImage 将原始图片文件切割一个矩形，并输出到目标图片文件
     * @param fromPath 原始图片
     * @param toPath  目标图片
     * @param x       坐标起点x
     * @param y       坐标起点y
     * @param width   矩形宽度
     * @param height  矩形高度
     * @param readImageFormat  原始文件格式
     * @param writeImageFormat 目标文件格式
     * @throws Exception
     */
    public static void cropImage(String fromPath, String toPath, int x, int y, int width, int height, String readImageFormat,
                                 String writeImageFormat) throws Exception {
        FileInputStream fis = null;
        ImageInputStream iis = null;
        try {
            // 读取原始图片文件
            fis = new FileInputStream(fromPath);
            //根据已知的图片类型 获取对应的  图片读取器
            Iterator<ImageReader> it = ImageIO.getImageReadersByFormatName(readImageFormat);
            //迭代器中只有一个对象
            ImageReader reader = it.next();
            //固定写法
            iis = ImageIO.createImageInputStream(fis);
            reader.setInput(iis, true);

            //默认读取参数
            // 定义一个矩形 并放入切割参数中
            ImageReadParam param = reader.getDefaultReadParam();
            //属于 图形中的  矩形   x点 y点 宽高
            Rectangle rect = new Rectangle(x, y, width, height);
            //给参数 设置 裁切  源区域
            param.setSourceRegion(rect);
            //设置目的地
            //param.setDestination();


            //从源文件读取一个矩形大小的图像
            BufferedImage bi = reader.read(0, param);

            //写入到目标文件
            ImageIO.write(bi, writeImageFormat, new File(toPath));
        } finally {
            fis.close();
            iis.close();
        }
    }

    /**
     * 横向拼接两张图片，并写入到目标文件
     * 拼接的本质，就是申请一个大的新空间，然后将原始的图片像素点拷贝到新空间，最后保存
     * @param firstPath 第一张图片的路径
     * @param secondPath    第二张图片的路径
     * @param imageFormat   拼接生成图片的格式
     * @param toPath    目标图片的路径
     */
    public static void combineImagesHorizontally(String firstPath, String secondPath,String imageFormat, String toPath){
        try {
            //读取第一张图片
            File  first  =  new  File(firstPath);
            BufferedImage  imageOne = ImageIO.read(first);
            int  width1  =  imageOne.getWidth();//图片宽度
            int  height1  =  imageOne.getHeight();//图片高度
            //从第一张图片中读取RGB
            int[]  firstRGB  =  new  int[width1*height1];
            firstRGB  =  imageOne.getRGB(0,0,width1,height1,firstRGB,0,width1);

            //对第二张图片做同样的处理
            File  second  =  new  File(secondPath);
            BufferedImage  imageTwo  =  ImageIO.read(second);
            int width2 = imageTwo.getWidth();
            int height2 = imageTwo.getHeight();
            int[]   secondRGB  =  new  int[width2*height2];
            secondRGB  =  imageTwo.getRGB(0,0,width2,height2,secondRGB,0,width2);


            //生成新图片
            int height3 = (height1>height2)?height1:height2; //挑选高度大的，作为目标文件的高度
            int width3  = width1 + width2;                   //宽度，两张图片相加
            BufferedImage  imageNew  =  new  BufferedImage(width3,height3,BufferedImage.TYPE_INT_RGB);

            //设置左半部分的RGB 从(0,0) 开始
            imageNew.setRGB(0,0,width1,height1,firstRGB,0,width1);
            //设置右半部分的RGB 从(width1, 0) 开始
            imageNew.setRGB(width1,0,width2,height2,secondRGB,0,width2);

            //保存图片
            ImageIO.write(imageNew,  imageFormat,  new  File(toPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 纵向拼接图片（两张）
     * 拼接的本质，就是申请一个大的新空间，然后将原始的图片像素点拷贝到新空间，最后保存
     * @param firstPath 读取的第一张图片
     * @param secondPath    读取的第二张图片
     * @param imageFormat 图片写入格式
     * @param toPath    图片写入路径
     */
    public static void combineImagesVertically(String firstPath, String secondPath,String imageFormat, String toPath){
        try {
            //读取第一张图片
            File  first  =  new  File(firstPath);
            BufferedImage  imageOne = ImageIO.read(first);
            int  width1  =  imageOne.getWidth();//图片宽度
            int  height1  =  imageOne.getHeight();//图片高度
            //从图片中读取RGB
            int[]  firstRGB  =  new  int[width1*height1];
            firstRGB  =  imageOne.getRGB(0,0,width1,height1,firstRGB,0,width1);

            //对第二张图片做相同的处理
            File  second  =  new  File(secondPath);
            BufferedImage  imageTwo  =  ImageIO.read(second);
            int width2 = imageTwo.getWidth();
            int height2 = imageTwo.getHeight();
            int[]   secondRGB  =  new  int[width2*height2];
            secondRGB  =  imageTwo.getRGB(0,0,width2,height2,secondRGB,0,width2);

            //生成新图片
            int width3 = (width1>width2)?width1:width2; //挑选宽度大的，作为目标文件的宽度
            int height3 = height1+height2;              //高度，两张图片相加
            BufferedImage  imageNew  =  new  BufferedImage(width3,height3,BufferedImage.TYPE_INT_RGB);
            //设置上半部分的RGB 从(0,0) 开始
            imageNew.setRGB(0,0,width1,height1,firstRGB,0,width1);
            //设置下半部分的RGB 从(0, height1) 开始
            imageNew.setRGB(0,height1,width2,height2,secondRGB,0,width2);

            //保存图片
            ImageIO.write(imageNew, imageFormat, new File(toPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
     * 横向拼接两张图片，并写入到目标文件
     * 拼接的本质，就是申请一个大的新空间，然后将原始的图片像素点拷贝到新空间，最后保存
     * @param firstPath 第一张图片的路径
     * @param secondPath    第二张图片的路径
     * @param imageFormat   拼接生成图片的格式
     * @param toPath    目标图片的路径
     */
    public static void lr(String firstPath, String secondPath,String imageFormat, String toPath,int lr){
        try {
            //读取第一张图片
            File  first  =  new  File(firstPath);
            BufferedImage  imageOne = ImageIO.read(first);
            int  width1  =  imageOne.getWidth();//图片宽度
            int  height1  =  imageOne.getHeight();//图片高度
            //从第一张图片中读取RGB
            int[]  firstRGB  =  new  int[width1*height1];
            firstRGB  =  imageOne.getRGB(0,0,width1,height1,firstRGB,0,width1);

            //对第二张图片做同样的处理
            File  second  =  new  File(secondPath);
            BufferedImage  imageTwo  =  ImageIO.read(second);
            int width2 = imageTwo.getWidth();
            int height2 = imageTwo.getHeight();
            int[]   secondRGB  =  new  int[width2*height2];
            secondRGB  =  imageTwo.getRGB(0,0,width2,height2,secondRGB,0,width2);
            int width3;
            int height3;

            if (lr==0){
                //生成新图片
                width3 = (width1>width2)?width1:width2; //挑选宽度大的，作为目标文件的宽度
                height3 = height1+height2;              //高度，两张图片相加
            }else {
                height3 = (height1>height2)?height1:height2; //挑选高度大的，作为目标文件的高度
                width3  = width1 + width2;                   //宽度，两张图片相加
            }

            BufferedImage  imageNew  =  new  BufferedImage(width3,height3,BufferedImage.TYPE_INT_RGB);

            //设置左半部分的RGB 从(0,0) 开始
            imageNew.setRGB(0,0,width1,height1,firstRGB,0,width1);
            //设置右半部分的RGB 从(width1, 0) 开始
            imageNew.setRGB(width1,0,width2,height2,secondRGB,0,width2);

            //保存图片
            ImageIO.write(imageNew,  imageFormat,  new  File(toPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void rotate(String firstPath,String toPath) throws IOException {

        Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName("jpg");
        ImageReader reader = readers.next();
        ImageInputStream imageInputStream = ImageIO.createImageInputStream(new File(firstPath));
        reader.setInput(imageInputStream,true);
        BufferedImage sourceBuffer = reader.read(0);

        int [][] data = new int[sourceBuffer.getWidth()][sourceBuffer.getHeight()];
        //方式一：通过getRGB()方式获得像素矩阵
        //此方式为沿Height方向扫描
        for(int i=0;i<sourceBuffer.getWidth();i++){
            for(int j=0;j<sourceBuffer.getHeight();j++){
                data[i][j]=sourceBuffer.getRGB(i,j);
            }
        }


        int[] targetArray = new int[sourceBuffer.getWidth()*sourceBuffer.getHeight()];



        int  sourceWidth =  sourceBuffer.getWidth();//图片宽度
        int  sourceHeight =  sourceBuffer.getHeight();//图片高度

        int k = 0;
//        for (int i = sourceHeight-1; i >=0; i--) {
//            for (int j = 0; j < sourceWidth; j++) {
//                targetArray[k++] = data[j][i];
//            }
//        }
        for (int i = 0; i < sourceWidth; i++) {
            for (int j = 0; j < sourceHeight; j++) {
                targetArray[k++] = data[i][j];
            }
        }
        BufferedImage  targetBuffer  =  new  BufferedImage(sourceWidth,sourceHeight,BufferedImage.TYPE_INT_RGB);

        //设置左半部分的RGB 从(0,0) 开始
        targetBuffer.setRGB(0,0,sourceWidth,sourceHeight,targetArray,0,sourceWidth);
        //保存图片
        ImageIO.write(targetBuffer,  "jpg",  new  File(toPath));

//        BufferedImage  targetBuffer  =  new  BufferedImage(sourceHeight,sourceWidth,BufferedImage.TYPE_INT_RGB);
//
//        //设置左半部分的RGB 从(0,0) 开始
//        targetBuffer.setRGB(0,0,sourceHeight,sourceWidth,targetArray,0,sourceHeight);
//        //保存图片
//        ImageIO.write(targetBuffer,  "jpg",  new  File(toPath));

    }


}
