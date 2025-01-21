package fi.jkauppa.treemap;

import java.util.ArrayList;
import java.util.Random;

public class SortTest {
	Random rand = new Random();
	public SortTest() {}
	
	public void run() {
		int len = 30000000, max = Integer.MAX_VALUE;
		Integer[] array = new Integer[len];
		for (int i=0;i<len;i++) {array[i] = rand.nextInt(max);}
		Integer[] array2 = array.clone();
		System.out.println("Items: "+len);
		
		BinaryTreeMap<Integer,Integer> datatreemap = new BinaryTreeMap<Integer,Integer>();
		long st = System.nanoTime();
		datatreemap.addAll(array2,array2);
		long et = System.nanoTime();
		long td = et-st;
		float tt = ((float)td) / 1000000.0f;
		float itemsec = ((float)len)*(1000.0f/tt)*(1.0f/1000000.0f);
		long st2 = System.nanoTime();
		ArrayList<Integer> keys = datatreemap.getKeys();
		array2 = keys.toArray(new Integer[keys.size()]);
		long et2 = System.nanoTime();
		long td2 = et2-st2;
		float tt2 = ((float)td2) / 1000000.0f;
		float itemsec2 = ((float)len)*(1000.0f/tt2)*(1.0f/1000000.0f);
		System.out.println("radix binary hash tree map put: "+String.format("%.4f", tt)+"ms: "+itemsec+" Mitems/s.");
		System.out.println("radix binary hash tree map get: "+String.format("%.4f", tt2)+"ms: "+itemsec2+" Mitems/s.");
	}
	
	public static void main(String[] args) {
		System.out.println("init.");
		SortTest app = new SortTest();
		app.run();
		System.out.println("exit.");
	}
}
