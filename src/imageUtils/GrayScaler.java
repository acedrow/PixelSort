package imageUtils;

import java.awt.image.BufferedImage;

import pixelData.PixelData;

public class GrayScaler {
	
	/*
	 * grayscales' the image via the algorithm:
	 * (red*0.3 + green*0.59 + blue*0.11)
	 */
	public BufferedImage grayScaleImage(BufferedImage input){
		for (int x = 0; x < input.getWidth(); x++){
			for (int y = 0; y < input.getHeight(); y++){
				PixelData pd = new PixelData(input.getRGB(x, y));
				pd.setPixelGrayScale();
			}
		}
		return input;
	}

	
}
