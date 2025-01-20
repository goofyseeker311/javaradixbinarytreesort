package fi.jkauppa.treemap;

public class MergeSort<T> {
	public void sort(T[] data) {
		@SuppressWarnings("unchecked")
		Comparable<T>[] array = (Comparable<T>[]) data;
		int maxstep = (int)Math.ceil(Math.log(array.length) / Math.log(2));
		System.out.println("maxstep: "+maxstep);
		for (int j=0;j<maxstep;j++) {
			int seg = (int)Math.pow(2, j);
			int seg2 = (int)Math.pow(2, j+1);
			int sc = (int)Math.pow(2, maxstep-(j+1));
			int sc2 = (int)Math.pow(2, maxstep-j);
			System.out.println("seg: "+seg+", seg2: "+seg2+", sc: "+sc+", sc2: "+sc2);
			for (int i=0;i<sc;i++) {
				int p1 = i*seg2;
				int p2 = i*seg2+seg;
				System.out.println("i: "+i+" p1: "+p1+" p2: "+p2);
			}
		}
	}
}
