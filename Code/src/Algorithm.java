import java.util.*;

public class Algorithm {

	List<Box> boxes = new ArrayList<Box>();
	List<Truck> trucks = new ArrayList<Truck>();

	public Algorithm(List<Box> boxesList, List<Truck> trucksList) {
		boxes = boxesList;
		trucks = trucksList;
	}

	public void nextFit() {
		// Getting length & width of trucks
		int sizeWidth = trucks.get(0).getWidth();
		int sizeHeight = trucks.get(0).getHeight();

		int newWidth = sizeWidth;

		// Width of current top box
		int bottomBoxWidth = sizeWidth;
		// Height of current box stack
		int totalBoxHeight = 0;

		// Counting amount of boxes stacked
		int boxCount = 0;

		// Bin count for comparison
		int binCount = 1;

		// Iterate through boxes
		for (int i = 0; boxes.size() > i; i++) {
			// Stacking boxes here
			if (totalBoxHeight + boxes.get(i).getHeight() <= sizeHeight && boxes.get(i).getWidth() <= bottomBoxWidth) {
				bottomBoxWidth = boxes.get(i).getWidth();
				totalBoxHeight += boxes.get(i).getHeight();
				boxCount++;
				// If can not longer stack higher or next box is too wide, start new stack
			} else {
				newWidth = newWidth - boxes.get(i - boxCount).getWidth();
				if (boxes.get(i).getWidth() <= newWidth) {
					boxCount = 0;
					totalBoxHeight = 0;
					bottomBoxWidth = newWidth;
					i--;
					// If no more space on truck to start a new stack, create new truck
				} else {
					binCount++;
					boxCount = 0;
					totalBoxHeight = 0;
					bottomBoxWidth = sizeWidth;
					newWidth = sizeWidth;
					i--;
				}
			}
		}
		// Number of trucks used
		System.out.println("Number of trucks required: " + binCount);
	}

	public void firstFit() {
		// Getting length & width of trucks
		int sizeWidth = trucks.get(0).getWidth();
		int sizeHeight = trucks.get(0).getHeight();
		int hold = 0;

		int newWidth = 0;

		// Bin count for comparison
		int binCount = 1;


		// Iterate through boxes
		for (int i = 0; boxes.size() > i; i++) {
			// Iterate through trucks
			for (int j = 0; trucks.size() > j; j++) {
				hold = j;
				if (trucks.get(j).getTotalBoxHeight() <= sizeHeight && boxes.get(i).getWidth() <= trucks.get(j).getBottomBox()) {
					// If this is the first box on the stack store the element in boxCount
					if(sizeWidth == trucks.get(j).getBottomBox() || newWidth == trucks.get(j).getBottomBox()) {
						trucks.get(j).setBoxCount(i);
					}
					trucks.get(j).setBottomBox(boxes.get(i).sizeWidth);
					trucks.get(j).setTotalBoxHeight(trucks.get(j).totalBoxHeight += boxes.get(i).sizeHeight);
					hold = j;
					break;
				}
			}
			// If can not longer stack higher or next box is too wide, start new stack
			if (trucks.get(hold).getTotalBoxHeight() > sizeHeight || boxes.get(i).getWidth() > trucks.get(hold).getBottomBox()) {
				newWidth = newWidth - boxes.get(trucks.get(hold).boxCount).getWidth();
				if (boxes.get(i).getWidth() <= newWidth) {
					trucks.get(hold).setTotalBoxHeight(0);
					trucks.get(hold).setBottomBox(newWidth);
					i--;
				}
				// If no more space on truck to start a new stack, create new truck
				else {
					binCount++;
					Truck truck = new Truck(60, 60);
					trucks.add(truck);
					trucks.get(hold).setTotalBoxHeight(0);
					trucks.get(hold).setBottomBox(sizeWidth);
					newWidth = sizeWidth;
					i--;
				}
			}
		}
		// Number of trucks used
		System.out.println("Number of trucks required: " + binCount);
	}
}
