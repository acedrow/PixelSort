package utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class FileOperations {
	
	public final String counterFileName = "counter.txt";
	public final String outputFileName = "out";
	public final String baseDirPath;
	public final String outputDirPath;
	private File counterFile;
	private boolean countOutput;
	private int outputCounter;
	
	
	public FileOperations(String baseDir, String outputPath, boolean imgCounter){
		baseDirPath = baseDir;
		outputDirPath = outputPath;
		countOutput = imgCounter;
		if (imgCounter){
			try{
				//System.out.println(baseDir + counterFileName);
				counterFile = new File(baseDir + counterFileName);
				Scanner sc = new Scanner(counterFile);
				//sc.useDelimiter("\\Z");
				//System.out.println("counter file line: " + sc.next());
				outputCounter = Integer.parseInt(sc.next());
			}catch(Exception e){
				System.err.println("failed to find, read, or parse counter file: " + e);
				countOutput = false;
			}
		}
	}
	
	public BufferedImage readImageFromFile(String filePath){
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
	
	public void writeImageToFile(BufferedImage img){
		File f = null;
		try {
			if (countOutput){
				f = new File(outputDirPath + outputFileName + outputCounter + ".jpg");
				outputCounter++;
				FileWriter fw = new FileWriter(counterFile);
				fw.write("" + outputCounter);
				fw.flush();
			} else{
				f = new File(outputDirPath + outputFileName);
			}

			ImageIO.write(img, "jpg", f);
		}catch(Exception e){
			System.err.println("error writing file: " + e);
		}
	}

}
