package fi.jkauppa.treemap;

import java.util.BitSet;
import java.util.LinkedList;

public class BinaryTree<V> {
	private BinaryTreeNode rootnode = new BinaryTreeNode();
	
	private class BinaryTreeNode {
		public BinaryTreeNode nodezero = null;
		public BinaryTreeNode nodeone = null;
		public byte[] key = null;
		public LinkedList<V> value = null;
	}
	
	public void put(byte[] keyi, V valuei) {
		BinaryTreeNode currentnode = this.rootnode;
		BitSet keybits = BitSet.valueOf(keyi);
		for (int i=keybits.size()-1;i>=0;i--) {
			boolean keybit = keybits.get(i);
			BinaryTreeNode nextnode = currentnode;
			if (keybit) {
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
		LinkedList<V> newvalue = currentnode.value;
		if (newvalue==null) {
			currentnode.key = keyi.clone();
			newvalue = new LinkedList<V>();
		}
		newvalue.add(valuei);
		currentnode.value = newvalue;
	}
	
	public LinkedList<V> get(byte[] keyi) {
		BinaryTreeNode currentnode = this.rootnode;
		BitSet keybits = BitSet.valueOf(keyi);
		boolean notfound = false;
		for (int i=keybits.size()-1;(i>=0)&&(!notfound);i--) {
			boolean keybit = keybits.get(i);
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
		LinkedList<V> newvalue = currentnode.value;
		return newvalue;
	}
	
	public LinkedList<byte[]> getKeys() {
		LinkedList<byte[]> newkeys = new LinkedList<byte[]>();
		LinkedList<BinaryTreeNode> dfsearch = new LinkedList<BinaryTreeNode>();
		dfsearch.add(this.rootnode);
		while (dfsearch.size()>0) {
			BinaryTreeNode dfsearchnode = dfsearch.getFirst();
			dfsearch.removeFirst();
			if (dfsearchnode.value!=null) {
				for (int i=0;i<dfsearchnode.value.size();i++) {
					newkeys.add(dfsearchnode.key);
				}
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
	
	public LinkedList<V> getValues() {
		LinkedList<V> newkeys = new LinkedList<V>();
		LinkedList<BinaryTreeNode> dfsearch = new LinkedList<BinaryTreeNode>();
		dfsearch.add(this.rootnode);
		while (dfsearch.size()>0) {
			BinaryTreeNode dfsearchnode = dfsearch.getFirst();
			dfsearch.removeFirst();
			if (dfsearchnode.value!=null) {
				newkeys.addAll(dfsearchnode.value);
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
