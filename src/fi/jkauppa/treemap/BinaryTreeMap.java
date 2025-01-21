package fi.jkauppa.treemap;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreeMap<T,V> {
	BinaryTreeNode<T,V> root = new BinaryTreeNode<T,V>();
	
	public void add(T key, V value) {
		int hash = key.hashCode();
		BinaryTreeNode<T,V> node = root;
		for (int i=0;i<32;i++) {
			if ((hash&(1<<(31-i)))==0) {
				if (node.zero==null) {
					node.zero = new BinaryTreeNode<T,V>();
					node.zero.parent = node;
				}
				node = node.zero;
			} else {
				if (node.one==null) {
					node.one = new BinaryTreeNode<T,V>();
					node.one.parent = node;
				}
				node = node.one;
			}
		}
		if (node.data==null) {
			node.data = new ArrayList<KeyValue<T,V>>();
		}
		node.data.add(new KeyValue<T,V>(key, value));
	}
	public void addAll(T[] keys, V[] values) {
		for (int i=0;i<keys.length;i++) {
			add(keys[i],values[i]);
		}
	}
	
	public V get(T key) {
		V k = null;
		int hash = key.hashCode();
		BinaryTreeNode<T,V> node = root;
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
			for (int i=0;(i<node.data.size())&&(k==null);i++) {
				KeyValue<T,V> kv = node.data.get(i);
				if (kv.key==key) {
					k = kv.value;
				}
			}
		}
		return k;
	}
	public ArrayList<T> getKeys() {
		ArrayList<T> k = new ArrayList<T>();
		LinkedList<BinaryTreeNode<T,V>> nodes = new LinkedList<BinaryTreeNode<T,V>>();
		nodes.add(root);
		while (!nodes.isEmpty()) {
			BinaryTreeNode<T,V> node = nodes.removeFirst();
			if (node.data!=null) {
				for (int i=0;i<node.data.size();i++) {
					k.add(node.data.get(i).key);
				}
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

	public ArrayList<V> getValues() {
		ArrayList<V> k = new ArrayList<V>();
		LinkedList<BinaryTreeNode<T,V>> nodes = new LinkedList<BinaryTreeNode<T,V>>();
		nodes.add(root);
		while (!nodes.isEmpty()) {
			BinaryTreeNode<T,V> node = nodes.removeFirst();
			if (node.data!=null) {
				for (int i=0;i<node.data.size();i++) {
					k.add(node.data.get(i).value);
				}
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
	
	public V remove(T key) {
		V k = null;
		int hash = key.hashCode();
		BinaryTreeNode<T,V> node = root;
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
			for (int i=0;(i<node.data.size())&&(k==null);i++) {
				KeyValue<T,V> kv = node.data.get(i);
				if (kv.key==key) {
					k = kv.value;
				}
			}
			node.data = null;
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
		return k;
	}
	public void removeAll() {
		root = new BinaryTreeNode<T,V>();
	}
	
	public static class BinaryTreeNode<T,V> {
		BinaryTreeNode<T,V> parent = null;
		BinaryTreeNode<T,V> zero = null;
		BinaryTreeNode<T,V> one = null;
		ArrayList<KeyValue<T,V>> data = null;
	}
	
	public static class KeyValue<T,V> {
		public KeyValue() {}
		public KeyValue(T vkey, V vvalue) {key=vkey;value=vvalue;}
		public T key = null;
		public V value = null;
	}
	
}
