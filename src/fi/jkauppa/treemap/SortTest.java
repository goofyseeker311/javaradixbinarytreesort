package fi.jkauppa.treemap;

import java.util.Arrays;
import java.util.Random;

public class SortTest {
	Random rand = new Random();
	public SortTest() {}
	
	public void run() {
		int len = 10, max = 100;
		Integer[] array = new Integer[len];
		System.out.print("array: ");
		for (int i=0;i<len;i++) {
			array[i] = rand.nextInt(2*max)-max;
			System.out.print(" "+array[i]);
		}
		System.out.println();
		Integer[] array1 = array.clone();
		Integer[] array2 = array.clone();
		long st1 = System.nanoTime();
		Arrays.sort(array1);
		long et1 = System.nanoTime();
		long td1 = et1-st1;
		float tt1 = ((float)td1) / 1000000.0f;
		System.out.print("array1: "+tt1+"ms:"); for (int i=0;i<len;i++) {System.out.print(" "+array1[i]);} System.out.println();
		MergeSort<Integer> datasort = new MergeSort<Integer>();
		long st2 = System.nanoTime();
		datasort.sort(array2);
		long et2 = System.nanoTime();
		long td2 = et2-st2;
		float tt2 = ((float)td2) / 1000000.0f;
		System.out.print("array2: "+tt2+"ms:"); for (int i=0;i<len;i++) {System.out.print(" "+array2[i]);} System.out.println();
	}
	
	public static void main(String[] args) {
		System.out.println("init.");
		SortTest app = new SortTest();
		app.run();
		System.out.println("exit.");
	}
}
