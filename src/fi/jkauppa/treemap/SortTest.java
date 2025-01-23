package fi.jkauppa.treemap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Random;
import java.util.TreeMap;

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
		for (int i=0;i<len;i++) {
			datatreemap.add(array[i],i);
		}
		long et = System.nanoTime();
		long td = et-st;
		float tt = ((float)td) / 1000000.0f;
		float itemsec = ((float)len)*(1000.0f/tt)*(1.0f/1000000.0f);
		long st2 = System.nanoTime();
		for (int i=0;i<len;i++) {
			array2[i] = datatreemap.get(array[i]);
		}
		long et2 = System.nanoTime();
		long td2 = et2-st2;
		float tt2 = ((float)td2) / 1000000.0f;
		float itemsec2 = ((float)len)*(1000.0f/tt2)*(1.0f/1000000.0f);
		long st3 = System.nanoTime();
		ArrayList<Integer> keys = datatreemap.getValues();
		array2 = keys.toArray(new Integer[keys.size()]);
		long et3 = System.nanoTime();
		long td3 = et3-st3;
		float tt3 = ((float)td3) / 1000000.0f;
		float itemsec3 = ((float)len)*(1000.0f/tt3)*(1.0f/1000000.0f);
		//System.out.print("array2:"); for (int i=0;i<array2.length;i++) {System.out.print(" "+array2[i]);} System.out.println();
		System.out.println("radix binary hash tree map add: "+String.format("%.4f", tt).replace(",", ".")+"ms: "+itemsec+" Mitems/s.");
		System.out.println("radix binary hash tree map get: "+String.format("%.4f", tt2).replace(",", ".")+"ms: "+itemsec2+" Mitems/s.");
		System.out.println("radix binary hash tree map all: "+String.format("%.4f", tt3).replace(",", ".")+"ms: "+itemsec3+" Mitems/s.");

		Hashtable<Integer,Integer> hashtable = new Hashtable<Integer,Integer>(); 
		long st4 = System.nanoTime();
		for (int i=0;i<len;i++) {
			hashtable.put(array[i],i);
		}
		long et4 = System.nanoTime();
		long td4 = et4-st4;
		float tt4 = ((float)td4) / 1000000.0f;
		float itemsec4 = ((float)len)*(1000.0f/tt4)*(1.0f/1000000.0f);
		long st5 = System.nanoTime();
		for (int i=0;i<len;i++) {
			array2[i] = hashtable.get(array[i]);
		}
		long et5 = System.nanoTime();
		long td5 = et5-st5;
		float tt5 = ((float)td5) / 1000000.0f;
		float itemsec5 = ((float)len)*(1000.0f/tt5)*(1.0f/1000000.0f);
		long st6 = System.nanoTime();
		Collection<Integer> keys2 = hashtable.values();
		array2 = keys2.toArray(array2);
		long et6 = System.nanoTime();
		long td6 = et6-st6;
		float tt6 = ((float)td6) / 1000000.0f;
		float itemsec6 = ((float)len)*(1000.0f/tt6)*(1.0f/1000000.0f);
		System.out.println("hash table add: "+String.format("%.4f", tt4).replace(",", ".")+"ms: "+itemsec4+" Mitems/s.");
		System.out.println("hash table get: "+String.format("%.4f", tt5).replace(",", ".")+"ms: "+itemsec5+" Mitems/s.");
		System.out.println("hash table all: "+String.format("%.4f", tt6).replace(",", ".")+"ms: "+itemsec6+" Mitems/s.");
		
		TreeMap<Integer,Integer> treemap = new TreeMap<Integer,Integer>(); 
		long st7 = System.nanoTime();
		for (int i=0;i<len;i++) {
			treemap.put(array[i],i);
		}
		long et7 = System.nanoTime();
		long td7 = et7-st7;
		float tt7 = ((float)td7) / 1000000.0f;
		float itemsec7 = ((float)len)*(1000.0f/tt7)*(1.0f/1000000.0f);
		long st8 = System.nanoTime();
		for (int i=0;i<len;i++) {
			array2[i] = treemap.get(array[i]);
		}
		long et8 = System.nanoTime();
		long td8 = et8-st8;
		float tt8 = ((float)td8) / 1000000.0f;
		float itemsec8 = ((float)len)*(1000.0f/tt8)*(1.0f/1000000.0f);
		long st9 = System.nanoTime();
		Collection<Integer> keys3 = treemap.values();
		array2 = keys3.toArray(array2);
		long et9 = System.nanoTime();
		long td9 = et9-st9;
		float tt9 = ((float)td9) / 1000000.0f;
		float itemsec9 = ((float)len)*(1000.0f/tt9)*(1.0f/1000000.0f);
		System.out.println("tree map add: "+String.format("%.4f", tt7).replace(",", ".")+"ms: "+itemsec7+" Mitems/s.");
		System.out.println("tree map get: "+String.format("%.4f", tt8).replace(",", ".")+"ms: "+itemsec8+" Mitems/s.");
		System.out.println("tree map all: "+String.format("%.4f", tt9).replace(",", ".")+"ms: "+itemsec9+" Mitems/s.");
		
		System.out.println("exit.");
}

	public static void main(String[] args) {
		System.out.println("SortTest v0.0.5");
		int re = 10000000;
		try {re = Integer.parseInt(args[0]);} catch(Exception ex) {}
		SortTest app = new SortTest(re);
		app.run();
	}
}
