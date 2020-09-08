package ru.repository.potyanikhin.black_and_white_conversion;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

//Преобразование цветного изображения в черно-белое.

public class BlackAndWhiteConversion {
    public static void main(String[] args) throws IOException {
        BufferedImage image = ImageIO.read(new File("image.jpg"));

        WritableRaster raster = image.getRaster();

        int width = raster.getWidth();
        int height = raster.getHeight();

        final int COLORS_COUNT_IN_RGB = 3;
        final double RED_COEFFICIENT = 0.3;
        final double GREEN_COEFFICIENT = 0.59;
        final double BLUE_COEFFICIENT = 0.11;

        double[] pixel = new double[COLORS_COUNT_IN_RGB];

        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                raster.getPixel(x, y, pixel);

                double blackAndWhitePixel = RED_COEFFICIENT * pixel[0] + GREEN_COEFFICIENT * pixel[1] + BLUE_COEFFICIENT * pixel[2];

                for (int k = 0; k < COLORS_COUNT_IN_RGB; ++k) {
                    pixel[k] = blackAndWhitePixel;
                }

                raster.setPixel(x, y, pixel);
            }
        }

        ImageIO.write(image, "png", new File("out.png"));
    }
}