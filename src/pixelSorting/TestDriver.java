package pixelSorting;

import java.awt.image.BufferedImage;

import pixelData.PixelData;

public class TestDriver {
	public static void main(String args[]){
		System.out.println("Main() entry");
		
		PixelSorts ps = new PixelSorts();
		FileOperations fo = new FileOperations();
		
		//READ COUNTER (For titling output file)
		
		
		//FILE IO
		String testPath = "C://Users//gamebox//Desktop//Linden Images//MOUNTAINS.jpg";
	
		BufferedImage img = fo.readImageFromFile(testPath);
		
		//TEST PIXEL DATA IO
		int val = img.getRGB(10, 10);
		System.out.println(val);
		PixelData testpd = new PixelData(val);
		System.out.println(testpd.toString());
		val = testpd.getRgbInt();
		System.out.println(val);
		
		//TEST STRAIGHTSORT
		
		String outPut = "C://Users//gamebox//Desktop//Linden Images//out.jpg";
		ps.straightSort(img, 2, false);
		fo.writeImageToFile(outPut, "jpg", img);
		
	
//		System.out.println("width= " + width + ", height= " + height + ", rgb= " + p);
//		System.out.println("Alpha= " + a + ", red= " + r + ", green= " + g + ", blue= " + b);
	}
}
