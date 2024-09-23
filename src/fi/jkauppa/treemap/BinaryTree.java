package fi.jkauppa.treemap;

import java.util.LinkedList;

public class BinaryTree<V> {
	private BinaryTreeNode rootnode = new BinaryTreeNode();

	public static class KeyValue<V> {
		public KeyValue(byte[] keyi, V valuei) {
			this.key = keyi;
			this.value = valuei;
		}
		public byte[] key = null;
		public V value = null;
	}
	
	private class BinaryTreeNode {
		public BinaryTreeNode nodezero = null;
		public BinaryTreeNode nodeone = null;
		public LinkedList<KeyValue<V>> keyvalues = null;
	}
	
	public void put(byte[] keyi, V valuei) {
		BinaryTreeNode currentnode = this.rootnode;
		for (int j=keyi.length-1;j>=0;j--) {
			for (int i=7;i>=0;i--) {
				BinaryTreeNode nextnode = currentnode;
				if ((keyi[j]>>i&1)==1) {
					nextnode = currentnode.nodeone;
					if (nextnode==null) {
						nextnode = new BinaryTreeNode();
						currentnode.nodeone = nextnode;
					}
				} else {
					nextnode = currentnode.nodezero;
					if (nextnode==null) {
						nextnode = new BinaryTreeNode();
						currentnode.nodezero = nextnode;
					}
				}
				currentnode = nextnode;
			}
		}
		if (currentnode.keyvalues==null) {
			currentnode.keyvalues = new LinkedList<KeyValue<V>>();
		}
		currentnode.keyvalues.add(new KeyValue<V>(keyi, valuei));
	}
	
	public LinkedList<KeyValue<V>> get(byte[] keyi) {
		BinaryTreeNode currentnode = this.rootnode;
		boolean notfound = false;
		for (int j=keyi.length-1;(j>=0)&&(!notfound);j--) {
			for (int i=7;(i>=0)&&(!notfound);i--) {
				boolean keybit = (keyi[j]>>i&1)==1;
				BinaryTreeNode nextnode = currentnode;
				if (keybit) {
					nextnode = currentnode.nodeone;
					if (nextnode!=null) {
						currentnode = nextnode;
					} else {
						notfound = true;
					}
				} else {
					nextnode = currentnode.nodezero;
					if (nextnode!=null) {
						currentnode = nextnode;
					} else {
						notfound = true;
					}
				}
			}
		}
		return currentnode.keyvalues;
	}
	
	public LinkedList<KeyValue<V>> getKeyValues() {
		LinkedList<KeyValue<V>> newkeys = new LinkedList<KeyValue<V>>();
		LinkedList<BinaryTreeNode> dfsearch = new LinkedList<BinaryTreeNode>();
		dfsearch.add(this.rootnode);
		while (dfsearch.size()>0) {
			BinaryTreeNode dfsearchnode = dfsearch.removeFirst();
			if (dfsearchnode.keyvalues!=null) {
				newkeys.addAll(dfsearchnode.keyvalues);
			}
			if (dfsearchnode.nodeone!=null) {
				dfsearch.addFirst(dfsearchnode.nodeone);
			}
			if (dfsearchnode.nodezero!=null) {
				dfsearch.addFirst(dfsearchnode.nodezero);
			}
		}
		return newkeys;
	}

}
