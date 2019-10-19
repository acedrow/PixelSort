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

	//sorts pixels along rows or columns
	public BufferedImage straightSort(BufferedImage img, int sortParameter, boolean sortRows) {

		int y = img.getHeight();
		int x = img.getWidth();

		if (!sortRows) {
			x = img.getHeight();
			y = img.getWidth();
		}
		
		// loop through rows, y
		for (int cy = 0; cy < y; cy++) {
			List<PixelData> pdal = new ArrayList<PixelData>();
			//PixelData[] pixelDataArray = new PixelData[x];
			
			// loop through columns, x (iterate /along/ each row)
			for (int cx = 0; cx < x; cx++) {
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
			
			//loop through columns, 
			for (int cx = 0; cx < x; cx++) {
				//add sorted pixels back into the image
				if(sortRows){
					img.setRGB(cx, cy, pdal.get(cx).getRgbInt());
				}else{
					img.setRGB(cy, cx, pdal.get(cx).getRgbInt());
				}

				
			}
		}
		
		return img;
	}
}
