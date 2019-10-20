package imageUtils;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import pixelData.PixelData;

public class EdgeDetector {

	public BufferedImage sobelEdgeDetection(BufferedImage source){

		        int x = source.getWidth();
		        int y = source.getHeight();

		        int maxGval = 0;
		        int[][] edgeColors = new int[x][y];
		        int maxGradient = -1;

		        for (int i = 1; i < x - 1; i++) {
		            for (int j = 1; j < y - 1; j++) {

		                int val00 =  PixelData.getGrayVal(source.getRGB(i - 1, j - 1));
		                int val01 =  PixelData.getGrayVal(source.getRGB(i - 1, j));
		                int val02 =  PixelData.getGrayVal(source.getRGB(i - 1, j + 1));

		                int val10 =  PixelData.getGrayVal(source.getRGB(i, j - 1));
		                int val11 =  PixelData.getGrayVal(source.getRGB(i, j));
		                int val12 =  PixelData.getGrayVal(source.getRGB(i, j + 1));

		                int val20 =  PixelData.getGrayVal(source.getRGB(i + 1, j - 1));
		                int val21 =  PixelData.getGrayVal(source.getRGB(i + 1, j));
		                int val22 =  PixelData.getGrayVal(source.getRGB(i + 1, j + 1));

		                int gx =  ((-1 * val00) + (0 * val01) + (1 * val02)) 
		                        + ((-2 * val10) + (0 * val11) + (2 * val12))
		                        + ((-1 * val20) + (0 * val21) + (1 * val22));

		                int gy =  ((-1 * val00) + (-2 * val01) + (-1 * val02))
		                        + ((0 * val10) + (0 * val11) + (0 * val12))
		                        + ((1 * val20) + (2 * val21) + (1 * val22));

		                double gval = Math.sqrt((gx * gx) + (gy * gy));
		                int g = (int) gval;

		                if(maxGradient < g) {
		                    maxGradient = g;
		                }

		                edgeColors[i][j] = g;
		            }
		        }

		        double scale = 255.0 / maxGradient;

		        for (int i = 1; i < x - 1; i++) {
		            for (int j = 1; j < y - 1; j++) {
		                int edgeColor = edgeColors[i][j];
		                edgeColor = (int)(edgeColor * scale);
		                edgeColor = 0xff000000 | (edgeColor << 16) | (edgeColor << 8) | edgeColor;

		                source.setRGB(i, j, edgeColor);
		            }
		        }
		        return source;
		    }
	}
	

