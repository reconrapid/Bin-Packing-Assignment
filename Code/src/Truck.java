
public class Truck {

	// Global Variables
	int sizeHeight;
	int sizeWidth;
	int bottomBoxWidth;
	int totalBoxHeight = 0;
	int boxCount = 0;

	public Truck(int height, int width) {
		sizeHeight = height;
		sizeWidth = width;
		bottomBoxWidth = width;
	}

	public int getHeight() {
		return sizeHeight;
	}

	public int getWidth() {
		return sizeWidth;
	}
	public void setBottomBox(int newHeight) {
		bottomBoxWidth = newHeight;
	}

	public void setTotalBoxHeight(int newWidth) {
		totalBoxHeight = newWidth;
	}
	public int getBottomBox() {
		return bottomBoxWidth;
	}

	public int getTotalBoxHeight() {
		return totalBoxHeight;
	}
	public int getBoxCount() {
		return boxCount;
	}
	public void setBoxCount(int count) {
		boxCount = count;
	}
	

}
