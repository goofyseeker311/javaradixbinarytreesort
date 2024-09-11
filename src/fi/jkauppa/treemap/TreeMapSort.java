package fi.jkauppa.treemap;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class TreeMapSort {
	public static void main(String[] args) {
		int[] checksort = {12}; //13 /12
		int[] unsorted = {5, 1, 13, 4, 11, 2, 14, 7};
		/*
		Random rand = new Random();
		int randnum = 10000000;
		unsorted = new int[randnum];
		for (int i=0;i<randnum;i++) {
			unsorted[i] = rand.nextInt();
		}
		*/
		int[] systemsort = Arrays.copyOf(unsorted, unsorted.length);
		long systemstart = System.currentTimeMillis();
		Arrays.sort(systemsort);
		long systemend = System.currentTimeMillis();
		long systemdelta = systemend - systemstart;
		System.out.print("systemdelta="+systemdelta+"ms:");
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
		LinkedList<Integer> checkint = treesort.get(checkbytes);
		if (checkint!=null) {
			System.out.print("check:");
			for (int i=0;i<checkint.size();i++) {
				System.out.print(" "+checkint.get(i));
			}
			System.out.println();
		} else {
			System.out.println("check: not found");
		}
		long treesortend = System.currentTimeMillis();
		long treesortdelta = treesortend - treesortstart;
		System.out.print("treesortdelta="+treesortdelta+"ms:");
		LinkedList<byte[]> treekeys = treesort.getKeys();
		for (Iterator<byte[]> e=treekeys.iterator();e.hasNext();) {
			ByteBuffer treekeybytes = ByteBuffer.wrap(e.next());
			treekeybytes.order(ByteOrder.LITTLE_ENDIAN);
			System.out.print(" "+treekeybytes.getInt());
		}
		System.out.println();
		long treegetvaluesstart = System.currentTimeMillis();
		LinkedList<Integer> treevalues = treesort.getValues();
		long treegetvaluesend = System.currentTimeMillis();
		long treegetvaluesdelta = treegetvaluesend - treegetvaluesstart;
		System.out.print("treegetvaluesdelta="+treegetvaluesdelta+"ms:");
		for (Iterator<Integer> e=treevalues.iterator();e.hasNext();) {
			System.out.print(" "+e.next());
		}
	}

}
