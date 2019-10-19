package pixelData;

import java.util.Comparator;

public class PixelDataGreenComparator implements Comparator<PixelData>{

	@Override
	public int compare(PixelData o1, PixelData o2) {
		if (o1.getPval()[2] > o2.getPval()[2]){
			return 1;
		} else if (o1.getPval()[2] < o2.getPval()[2]){
			return -1;
		} else return 0;
	}

}