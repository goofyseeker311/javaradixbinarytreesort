package fi.jkauppa.treemap;

public class MergeSort<T> {
	@SuppressWarnings("unchecked")
	public void sort(T[] data) {
		Comparable<T>[] array = (Comparable<T>[]) data;
		int maxstep = (int)Math.ceil(Math.log(array.length) / Math.log(2));
		//System.out.println("maxstep: "+maxstep);
		for (int k=0;k<maxstep;k++) {
			int seg = 1<<k;
			int seg2 = 1<<(k+1);
			int sc = 1<<(maxstep-(k+1));
			int sc2 = 1<<(maxstep-k);
			//System.out.println("seg: "+seg+", seg2: "+seg2+", sc: "+sc+", sc2: "+sc2);
			for (int j=0;j<sc;j++) {
				int p1 = j*seg2;
				int p2 = j*seg2+seg;
				int p = p1;
				int pm = p+seg2;
				if (pm>array.length) {pm = array.length;}
				//System.out.print("j: "+j+", p1: "+p1+", p2: "+p2+", val:");
				Comparable<T> tmp = null;
				for (int i=p;i<pm;i++) {
					Comparable<T> tmpv = array[i];
					Comparable<T> p1v = null;
					Comparable<T> p2v = null;
					if (p1<array.length) {p1v=array[p1];}
					if (p2<array.length) {p2v=array[p2];}
					tmp = tmpv;
					//System.out.print(" "+array[i]);
				}
				//System.out.println();
			}
		}
	}
}
