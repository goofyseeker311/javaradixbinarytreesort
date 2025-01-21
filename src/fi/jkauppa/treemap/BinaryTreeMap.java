package fi.jkauppa.treemap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeMap;

public class BinaryTreeMap<T,V> {
	BinaryNode<T,V> root = new BinaryNode<T,V>();
	
	public void add(T key, V value) {
		int hash = key.hashCode();
		BinaryNode<T,V> node = root;
		for (int i=0;i<32;i++) {
			if ((hash&(1<<(31-i)))==0) {
				if (node.zero==null) {
					node.zero = new BinaryNode<T,V>();
					node.zero.parent = node;
				}
				node = node.zero;
			} else {
				if (node.one==null) {
					node.one = new BinaryNode<T,V>();
					node.one.parent = node;
				}
				node = node.one;
			}
		}
		if (node.data==null) {
			node.data = new TreeMap<T,V>();
		}
		node.data.put(key, value);
	}
	public void addAll(T[] keys, V[] values) {
		for (int i=0;i<keys.length;i++) {
			add(keys[i],values[i]);
		}
	}
	
	public V get(T key) {
		V k = null;
		int hash = key.hashCode();
		BinaryNode<T,V> node = root;
		for (int i=0;(i<32)&&(node!=null);i++) {
			if ((hash&(1<<(31-i)))==0) {
				if (node.zero==null) {
					node = null;
				}
				if (node!=null) {
					node = node.zero;
				}
			} else {
				if (node.one==null) {
					node = null;
				}
				if (node!=null) {
					node = node.one;
				}
			}
		}
		if ((node!=null)&&(node.data!=null)) {
			k = node.data.get(key);
		}
		return k;
	}
	public ArrayList<T> getKeys() {
		ArrayList<T> k = new ArrayList<T>();
		LinkedList<BinaryNode<T,V>> nodes = new LinkedList<BinaryNode<T,V>>();
		nodes.add(root);
		while (!nodes.isEmpty()) {
			BinaryNode<T,V> node = nodes.removeFirst();
			if (node.data!=null) {
				k.addAll(node.data.keySet());
			}
			if (node.one!=null) {
				nodes.addFirst(node.one);
			}
			if (node.zero!=null) {
				nodes.addFirst(node.zero);
			}
		}
		return k;
	}
	
	public void remove(T key) {
		int hash = key.hashCode();
		BinaryNode<T,V> node = root;
		for (int i=0;(i<32)&&(node!=null);i++) {
			if ((hash&(1<<(31-i)))==0) {
				if (node.zero==null) {
					node = null;
				}
				node = node.zero;
			} else {
				if (node.one==null) {
					node = null;
				}
				node = node.one;
			}
		}
		if (node.data!=null) {
			node.data.remove(key);
			if (node.data.isEmpty()) {
				node.data = null;
			}
			int i = 31;
			while ((node.parent!=null)&&(node.zero==null)&&(node.one==null)&&(node.data==null)) {
				if ((hash&(1<<(31-i)))==0) {
					node.parent.zero = null;
				} else {
					node.parent.one = null;
				}
				node = node.parent;
				i--;
			}
		}
	}
	public void removeAll() {
		root = new BinaryNode<T,V>();
	}
	
	public static class BinaryNode<T,V> {
		BinaryNode<T,V> parent = null;
		BinaryNode<T,V> zero = null;
		BinaryNode<T,V> one = null;
		TreeMap<T,V> data = null;
	}
}
