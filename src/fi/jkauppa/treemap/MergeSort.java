package fi.jkauppa.treemap;

public class MergeSort<T> {
	public void sort(T[] data) {
		@SuppressWarnings("unchecked")
		Comparable<T>[] array = (Comparable<T>[]) data;
		int maxstep = (int)Math.ceil(Math.log(array.length) / Math.log(2));
		System.out.println("maxstep: "+maxstep);
		for (int b=0;b<maxstep;b++) {
			int seg = (int)Math.pow(2, b);
			System.out.println("seg: "+seg);
		}
	}
}
