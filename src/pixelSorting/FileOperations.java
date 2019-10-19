package pixelSorting;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FileOperations {
	
	public static BufferedImage readImageFromFile(String filePath){
		BufferedImage img = null;
		File f = null;
		
		try{
			f = new File(filePath);
			img = ImageIO.read(f);
		}catch(IOException e){
			System.err.println(e);
		}
		return img;
	}
	
	public static void writeImageToFile(String filePath, String imgType, BufferedImage img){
		File f = null;
		try {
			f = new File(filePath);
			ImageIO.write(img, imgType, f);
		}catch(IOException e){
			System.err.println(e);
		}
	}

}
