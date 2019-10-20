package pixelData;

import utils.Constants;

public class PixelData {
	// CONSTANTS:
	int ALPHA = Constants.INDEX_ALPHA;
	int RED = Constants.INDEX_RED;
	int GREEN = Constants.INDEX_GREEN;
	int BLUE = Constants.INDEX_BLUE;

	/*
	 * array to hold pixel values, 0 is alpha 1 is red 2 is green 3 is blue
	 */
	int pval[];

	public PixelData() {
		pval = new int[] { 0, 0, 0, 0 };
	}

	public PixelData(int a, int r, int g, int b) {
		pval = new int[4];
		pval[ALPHA] = a;
		pval[RED] = r;
		pval[GREEN] = g;
		pval[BLUE] = b;
	}

	public PixelData(int[] p) {
		if (p.length != 4) {
			System.err.println("Could not construct pval, incorrect argument length");
		} else {
			pval = p;
		}
	}

	public PixelData(int p) {
		pval = new int[4];
		// get ALPHA - 'right shift the 32 bits of the pixels by 24 positions,
		// and bitwise ADD 0xFF'
		pval[ALPHA] = (p >> 24) & 0xff;
		// get RED
		pval[RED] = (p >> 16) & 0xff;
		// get GREEN
		pval[GREEN] = (p >> 8) & 0xff;
		// get BLUE
		pval[BLUE] = p & 0xff;
	}
	
	/*
	 * Grayscale methods use (gray = red *0.3 + green * 0.59 + blue * 0.11)
	 */
	
	//note, this method doesn't actually set the pixel value, just returns the gray value
	public int getGrayPixelValue(){
		int gray = (int) ((pval[1] * 0.3) + (pval[2] * 0.59) + (pval[3] * 0.11));
		return gray;
	}
	
	public void setPixelGrayScale(){
		int gray = getGrayPixelValue();
		for (int i = 1; i < 4; i++){
			pval[i] = gray;
		}
	}
	
	public static int getGrayVal(int rgb){
        int r = getRed(rgb);
        int g = getGreen(rgb);
        int b = getBlue(rgb);
        
        int gray = (int) ((r * 0.3) + (g * 0.59) + (b * 0.11));
        
        return gray;
	}

	public int getRgbInt() {
		int p = (pval[ALPHA] << 24) | (pval[RED] << 16) | (pval[GREEN] << 8) | pval[BLUE];
		return p;
	}

	public String toString() {
		String s = pval[ALPHA] + ", " + pval[RED] + ", " + pval[GREEN] + ", " + pval[BLUE];
		return s;
	}
	
	public static int getRgbInt(int a, int r, int g, int b) {
		int p = (a << 24) | (r << 16) | (g << 8) | b;
		return p;
	}

	public static int getAlpha(int rgb) {
		return (rgb >> 24) & 0xff;
	}

	public static int getRed(int rgb) {
		return (rgb >> 16) & 0xff;
	}

	public static int getGreen(int rgb) {
		return (rgb >> 8) & 0xff;
	}

	public static int getBlue(int rgb) {
		return rgb & 0xff;
	}

	public int[] getPval() {
		return pval;
	}

	public void setPval(int[] p) {
		if (p.length != 4) {
			System.err.println("Could not set pval, incorrect argument length");
		} else {
			pval = p;
		}
	}

	public void setPval(int a, int r, int g, int b) {
		pval[0] = a;
		pval[1] = r;
		pval[2] = g;
		pval[3] = b;
	}

}
