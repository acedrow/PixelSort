package pixelData;

import java.util.Comparator;

public class PixelDataBlueComparator implements Comparator<PixelData>{

	@Override
	public int compare(PixelData o1, PixelData o2) {
		if (o1.getPval()[3] > o2.getPval()[3]){
			return 1;
		} else if (o1.getPval()[3] < o2.getPval()[3]){
			return -1;
		} else return 0;
	}

}
