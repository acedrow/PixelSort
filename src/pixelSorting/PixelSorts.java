package pixelSorting;

import java.io.File;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import pixelData.PixelData;
import pixelData.PixelDataAlphaComparator;
import pixelData.PixelDataBlueComparator;
import pixelData.PixelDataGreenComparator;
import pixelData.PixelDataRedComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class PixelSorts {
	
	public BufferedImage straightSort(BufferedImage img, int sortParameter, boolean sortRows){
		return straightSortImpl(img, sortParameter, sortRows, 0, 0, 0, 0);
	}
	public BufferedImage straightSort(
			BufferedImage img, 
			int sortParameter, 
			boolean sortRows, 
			int startxBound,
			int startyBound,
			int xBoundLength,
			int yBoundLength) {
		
		return straightSortImpl(img, sortParameter, sortRows, startxBound, 
				startyBound, xBoundLength, yBoundLength);
	}

	//sorts pixels along rows or columns
	public BufferedImage straightSortImpl(
			BufferedImage img, 
			int sortParameter, 
			boolean sortRows, 
			int xStartBound,
			int yStartBound,
			int xBoundLength,
			int yBoundLength) {
		
		boolean boundedSort = false;
		
		if (xBoundLength > 0 
			&& yBoundLength > 0 
			&& xStartBound >= 0
			&& xStartBound < img.getWidth()
			&& yStartBound >= 0
			&& yStartBound < img.getHeight()){
			
			boundedSort = true;
		}
		
		int y = img.getHeight();
		int x = img.getWidth();
		int startY = 0;
		int startX = 0;
		
		if (boundedSort){
			y = yStartBound + yBoundLength;
			x = xStartBound + xBoundLength;
			startY = yStartBound;
			startX = xStartBound;
		} 
		
		if (!sortRows) {
			int temp = x;
			x = y;
			y = temp;
			
			temp = startX;
			startX = startY;
			startY = temp;
		}
		
		// loop through rows, y
		for (int cy = startY; cy < y; cy++) {
			List<PixelData> pdal = new ArrayList<PixelData>();
			//PixelData[] pixelDataArray = new PixelData[x];
			
			// loop through columns, x (iterate /along/ each row)
			for (int cx = startX; cx < x; cx++) {
				// prepare a PixelData object of the current pixel
				if (sortRows){
				pdal.add(new PixelData(img.getRGB(cx, cy)));
				} else{
					pdal.add(new PixelData(img.getRGB(cy, cx)));

				}
			}
			//sort pixelDataArray based on designated parameter.
			
			switch(sortParameter){
			case 0:
				Collections.sort(pdal, new PixelDataAlphaComparator());
				break;
			case 1:
				Collections.sort(pdal, new PixelDataRedComparator());
				break;
			case 2:
				Collections.sort(pdal, new PixelDataGreenComparator());
				break;
			case 3:
				Collections.sort(pdal, new PixelDataBlueComparator());
				break;
			default:
				Collections.sort(pdal, new PixelDataAlphaComparator());
				break;
			}
			
			Collections.sort(pdal, new PixelDataAlphaComparator());
			
			//loop through columns
			for (int cx = startX; cx < x; cx++) {
				//add sorted pixels back into the image
				if(sortRows){
					img.setRGB(cx, cy, pdal.get(cx - startX).getRgbInt());
				}else{
					img.setRGB(cy, cx, pdal.get(cx - startX).getRgbInt());
				}

				
			}
		}
		
		return img;
	}
}
