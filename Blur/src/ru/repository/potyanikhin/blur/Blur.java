package ru.repository.potyanikhin.blur;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

//Реализация размытия изображения.

public class Blur {
    public static void changeOutOfRangeValues(double[] pixel) {
        for (int i = 0; i < pixel.length; i++) {
            if (pixel[i] < 0) {
                pixel[i] = 0;
            } else if (pixel[i] > 255) {
                pixel[i] = 255;
             }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedImage sourceImage = ImageIO.read(new File("image.jpg"));
        WritableRaster sourceImageRaster = sourceImage.getRaster();

        int width = sourceImageRaster.getWidth();
        int height = sourceImageRaster.getHeight();

        BufferedImage resultingImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        WritableRaster resultingImageRaster = resultingImage.getRaster();

        final int COLORS_COUNT_IN_RGB = 3;
        final double BLUR_COEFFICIENT = 1.0 / 9;

        double[][] blurMatrix = {
                {BLUR_COEFFICIENT, BLUR_COEFFICIENT, BLUR_COEFFICIENT},
                {BLUR_COEFFICIENT, BLUR_COEFFICIENT, BLUR_COEFFICIENT},
                {BLUR_COEFFICIENT, BLUR_COEFFICIENT, BLUR_COEFFICIENT}};

        int loopBorder = blurMatrix.length / 2;

        double[] pixel = new double[COLORS_COUNT_IN_RGB];

        int blurHeight = height - loopBorder;
        int blurWidth = width - loopBorder;

        for (int y = loopBorder; y < blurHeight; ++y) {
            for (int x = loopBorder; x < blurWidth; ++x) {
                double[] resultPixel = new double[COLORS_COUNT_IN_RGB];

                for (int i = -loopBorder, j = 0; i <= loopBorder; i++, j++) {
                    for (int k = -loopBorder, m = 0; k <= loopBorder; k++, m++) {
                        sourceImageRaster.getPixel(x + i, y + k, pixel);

                        for (int n = 0; n < COLORS_COUNT_IN_RGB; n++) {
                            resultPixel[n] += blurMatrix[j][m] * pixel[n];
                        }
                    }
                }

                changeOutOfRangeValues(resultPixel);
                resultingImageRaster.setPixel(x, y, resultPixel);
            }
        }

        ImageIO.write(resultingImage, "png", new File("out.png"));
    }
}