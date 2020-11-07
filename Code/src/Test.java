import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;


public class Test {
	
	
	public static void main(String[] args) {
		List<Box> boxes = new ArrayList<Box>();
		List<Truck> trucks = new ArrayList<Truck>();
		
		int boxAmount = 50;
		int stopLoop = 0;
		Random rand = new Random();
		int  parameterFirst;
		int  parameterSecond;
		
		// Test boxes
		while(boxAmount > stopLoop) {
			parameterFirst = rand.nextInt(60) + 1;
			parameterSecond = rand.nextInt(60) + 1;
			Box box = new Box(parameterFirst, parameterSecond);
			boxes.add(box);
			System.out.println("Box " + stopLoop + " Height " + box.getHeight() + " Width " + box.getWidth());
			stopLoop++;
		}

		// Base Truck
		Truck truck1 = new Truck(60, 60);
		trucks.add(truck1);
		
		// Algorithm Object
		Algorithm test = new Algorithm(boxes, trucks);
		
		//Testing Next Fit & measuring time performance in nanoseconds
		long startTimeNext = System.nanoTime();
		test.nextFit();
		long endTimeNext = System.nanoTime();
		long durationNext = (endTimeNext - startTimeNext);
		

		//Testing First Fit & measuring time performance in nanoseconds
		long startTimeFirst = System.nanoTime();
		test.firstFit();
		long endTimeFirst = System.nanoTime();
		long durationFirst = (endTimeFirst - startTimeFirst);
		
		System.out.println("Next Fit Duration: " + durationNext + " Nanoseconds \n" + "First Fit Duration: " + durationFirst + " Nanoseconds");
		
	}

}
