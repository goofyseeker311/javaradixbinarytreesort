package fi.jkauppa.treemap;

import java.util.ArrayList;
import java.util.Random;

public class SortTest {
	private Random rand = new Random();
	private int len = 0, max = Integer.MAX_VALUE;
	public SortTest(int re) {
		len = re;
	}
	
	public void run() {
		System.out.println("init.");
		Integer[] array = new Integer[len];
		for (int i=0;i<len;i++) {array[i] = rand.nextInt(max);}
		Integer[] array2 = array.clone();
		System.out.println("Items: "+len);
		//System.out.print("array:"); for (int i=0;i<array.length;i++) {System.out.print(" "+array[i]);} System.out.println();
		
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
		//System.out.print("array2:"); for (int i=0;i<array2.length;i++) {System.out.print(" "+array2[i]);} System.out.println();
		System.out.println("radix binary hash tree map add: "+String.format("%.4f", tt).replace(",", ".")+"ms: "+itemsec+" Mitems/s.");
		System.out.println("radix binary hash tree map get: "+String.format("%.4f", tt2).replace(",", ".")+"ms: "+itemsec2+" Mitems/s.");
		System.out.println("exit.");
}
	
	public static void main(String[] args) {
		System.out.println("SortTest v0.0.2");
		int re = 10000000;
		try {re = Integer.parseInt(args[0]);} catch(Exception ex) {}
		SortTest app = new SortTest(re);
		app.run();
	}
}
