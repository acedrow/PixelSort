package main;

import java.awt.image.BufferedImage;

import pixelData.PixelData;
import pixelSorting.PixelSorts;
import utils.FileOperations;
import imageUtils.EdgeDetector;

public class TestDriver {
	public static void main(String args[]){
		System.out.println("Main() entry");
		
		String imgPath = "C://Users//gamebox//Desktop//Linden Images//";
		String outPath = "C://Users//gamebox//Desktop//Linden Images//psoutput//";
		
		PixelSorts ps = new PixelSorts();
		FileOperations fo = new FileOperations(imgPath, outPath, true);
		
		//READ COUNTER (For titling output file)
		
		
		//FILE IO
		String testPath = "C://Users//gamebox//Desktop//Linden Images//AESTHETICWOW6.jpg";
	
		BufferedImage img = fo.readImageFromFile(testPath);
		
		//TEST PIXEL DATA IO
		int val = img.getRGB(10, 10);
		System.out.println(val);
		PixelData testpd = new PixelData(val);
		System.out.println(testpd.toString());
		val = testpd.getRgbInt();
		System.out.println(val);
		
		//TEST STRAIGHTSORT
		
		//String outPut = "C://Users//gamebox//Desktop//Linden Images//out.jpg";
		img = ps.straightSort(img, 3, true, 320, 180, 640, 360);
		fo.writeImageToFile(img);
		
		//TEST SOBEL
//		String outPut = "C://Users//gamebox//Desktop//Linden Images//out.jpg";
//		EdgeDetector ed = new EdgeDetector();
//		ed.sobelEdgeDetection(img);
//		fo.writeImageToFile(img);
		
	
//		System.out.println("width= " + width + ", height= " + height + ", rgb= " + p);
//		System.out.println("Alpha= " + a + ", red= " + r + ", green= " + g + ", blue= " + b);
	}
}
