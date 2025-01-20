package fi.jkauppa.treemap;

public class MergeSort<T> {
	@SuppressWarnings("unchecked")
	public void sort(T[] data) {
		Comparable<T>[] array = (Comparable<T>[]) data;
		int maxstep = (int)Math.ceil(Math.log(array.length) / Math.log(2));
		System.out.println("maxstep: "+maxstep);
		for (int k=0;k<maxstep;k++) {
			int seg = (int)Math.pow(2, k);
			int seg2 = (int)Math.pow(2, k+1);
			int sc = (int)Math.pow(2, maxstep-(k+1));
			int sc2 = (int)Math.pow(2, maxstep-k);
			System.out.println("seg: "+seg+", seg2: "+seg2+", sc: "+sc+", sc2: "+sc2);
			for (int j=0;j<sc;j++) {
				int p1 = j*seg2;
				int p2 = j*seg2+seg;
				int p = p1;
				int pm = p+seg2;
				if (pm>array.length) {
					pm = array.length;
				}
				System.out.println("j: "+j+" p1: "+p1+" p2: "+p2);
				for (int i=p;i<pm;i++) {
				}
			}
		}
	}
}
