package fi.jkauppa.treemap;

import java.util.LinkedList;

public class MergeSort<K> {
	private LinkedList<MergeSortNode> sortnodes = new LinkedList<MergeSortNode>();
	
	public MergeSort(K[] datai) {
		for (int i=0;i<datai.length;i++) {
			MergeSortNode newnode = new MergeSortNode();
			newnode.data.add(datai[i]);
			sortnodes.add(newnode);
		}
	}
	
	public  LinkedList<K> sort() {
		while(this.sortnodes.size()>1) {
			MergeSortNode node1 = this.sortnodes.removeFirst();
			MergeSortNode node2 = this.sortnodes.removeFirst();
			MergeSortNode mergenode = node1.merge(node2);
			this.sortnodes.add(mergenode);
		}
		return this.sortnodes.getFirst().data;
	}
	
	private class MergeSortNode { 
		public LinkedList<K> data = new LinkedList<K>();
		
		@SuppressWarnings("unchecked")
		private MergeSortNode merge(MergeSortNode other) {
			MergeSortNode newdata = new MergeSortNode();
			while ((this.data.size()>0)||(other.data.size()>0)) {
				if (this.data.size()==0) {
					newdata.data.add(other.data.removeFirst());
				} else if (other.data.size()==0) {
					newdata.data.add(this.data.removeFirst());
				} else if (((Comparable<K>)this.data.getFirst()).compareTo(other.data.getFirst())<0) {
					newdata.data.add(this.data.removeFirst());
				} else {
					newdata.data.add(other.data.removeFirst());
				}
			}
			return newdata;
		}
	}
}
