package fi.jkauppa.treemap;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

import fi.jkauppa.treemap.BinaryTree.KeyValue;

public class TreeMapSort {
	public static void main(String[] args) {
		Integer[] checksort = {12}; //13 /12
		//Integer[] unsorted = {5, 1, 13, 4, 11, 2, 14, 7};
		Integer[] unsorted = {5, 1, 13, 4, 11, 2, 14, 7, 230, 150, 254, 80, 46, 65, 255, 65534, 65570, 144858484, 947738383};
		/*
		Random rand = new Random();
		int randnum = 1000;
		unsorted = new Integer[randnum];
		for (int i=0;i<randnum;i++) {
			unsorted[i] = rand.nextInt(0, Integer.MAX_VALUE);
		}
		*/
		Integer[] systemsort = Arrays.copyOf(unsorted, unsorted.length);
		long systemstart = System.currentTimeMillis();
		Arrays.sort(systemsort);
		long systemend = System.currentTimeMillis();
		long systemdelta = systemend - systemstart;
		System.out.print("systemsrdelta="+systemdelta+"ms:");
		for (int i=0;i<systemsort.length;i++) {
			System.out.print(" "+systemsort[i]);
		}
		System.out.println();
		long treesortstart = System.currentTimeMillis();
		BinaryTree<Integer> treesort = new BinaryTree<Integer>();
		for (int i=0;i<unsorted.length;i++) {
			Integer currentunsorted = unsorted[i];
			ByteBuffer unsortedbytebuffer = ByteBuffer.allocate(4);
			unsortedbytebuffer.order(ByteOrder.LITTLE_ENDIAN);
			unsortedbytebuffer.putInt(currentunsorted);
			unsortedbytebuffer.rewind();
			byte[] unsortedbytes = new byte[4];
			unsortedbytebuffer.get(unsortedbytes);
			treesort.put(unsortedbytes, currentunsorted);
		}
		Integer checkunsorted = checksort[0];
		ByteBuffer checkbytebuffer = ByteBuffer.allocate(4);
		checkbytebuffer.order(ByteOrder.LITTLE_ENDIAN);
		checkbytebuffer.putInt(checkunsorted);
		checkbytebuffer.rewind();
		byte[] checkbytes = new byte[4];
		checkbytebuffer.get(checkbytes);
		LinkedList<KeyValue<Integer>> checkint = treesort.get(checkbytes);
		if (checkint!=null) {
			System.out.print("check:");
			for (Iterator<KeyValue<Integer>> i=checkint.iterator();i.hasNext();) {
				KeyValue<Integer> nextvalue = i.next();
				System.out.print(" "+nextvalue.value);
			}
			System.out.println();
		} else {
			System.out.println("check: not found");
		}
		long treesortend = System.currentTimeMillis();
		long treesortdelta = treesortend - treesortstart;
		System.out.print("treesortdelta="+treesortdelta+"ms:");
		long treegetvaluesstart = System.currentTimeMillis();
		LinkedList<KeyValue<Integer>> treekeyvalues = treesort.getKeyValues();
		long treegetvaluesend = System.currentTimeMillis();
		long treegetvaluesdelta = treegetvaluesend - treegetvaluesstart;
		for (Iterator<KeyValue<Integer>> e=treekeyvalues.iterator();e.hasNext();) {
			KeyValue<Integer> nextvalue = e.next();
			ByteBuffer treekeybytes = ByteBuffer.wrap(nextvalue.key);
			treekeybytes.order(ByteOrder.LITTLE_ENDIAN);
			Integer treekeyint = treekeybytes.getInt();
			System.out.print(" "+treekeyint);
		}
		System.out.println();
		System.out.print("treegetvdelta="+treegetvaluesdelta+"ms:");
		for (Iterator<KeyValue<Integer>> e=treekeyvalues.iterator();e.hasNext();) {
			KeyValue<Integer> nextvalue = e.next();
			Integer treevaluenext = nextvalue.value;
			System.out.print(" "+treevaluenext);
		}
		System.out.println();
		treesort = null;
		MergeSort<Integer> mergesort = new MergeSort<Integer>(unsorted);
		long mergesortstart = System.currentTimeMillis();
		LinkedList<Integer> mergesortedlist = mergesort.sort();
		long mergesortend = System.currentTimeMillis();
		long mergesortdelta = mergesortend - mergesortstart;
		System.out.print("mergesrtdelta="+mergesortdelta+"ms:");
		Integer[] mergesorted = mergesortedlist.toArray(new Integer[mergesortedlist.size()]);
		for (int i=0;i<mergesorted.length;i++) {
			Integer mergevalue = mergesorted[i];
			System.out.print(" "+mergevalue);
		}
		System.out.println();
		System.out.println("exit");
	}

}
