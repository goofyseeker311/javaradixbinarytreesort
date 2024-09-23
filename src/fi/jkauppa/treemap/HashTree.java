package fi.jkauppa.treemap;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.LinkedList;

import fi.jkauppa.treemap.BinaryTree.ByteValue;

public class HashTree<K,V> {
	private BinaryTree<KeyValue<K,V>> hashtree = new BinaryTree<KeyValue<K,V>>();
	
	public static class KeyValue<K,V> {
		public K key = null;
		public V value = null;
	}
	
	public void put(K keyi, V valuei) {
		byte[] hashcodebytes = this.getHashCode(keyi);
		KeyValue<K,V> keyvalue = new KeyValue<K,V>();
		keyvalue.key = keyi;
		keyvalue.value = valuei;
		hashtree.put(hashcodebytes, keyvalue);
	}

	public V get(K keyi) {
		return this.getRemove(keyi, false);
	}

	public V remove(K keyi) {
		return this.getRemove(keyi, true);
	}
	
	public LinkedList<KeyValue<K,V>> getAll() {
		LinkedList<KeyValue<K,V>> getlist = new LinkedList<KeyValue<K,V>>();
		LinkedList<ByteValue<KeyValue<K,V>>> getall = hashtree.getAll();
		for (Iterator<ByteValue<KeyValue<K,V>>> i=getall.iterator();i.hasNext();) {
			ByteValue<KeyValue<K,V>> nextvalue = i.next();
			getlist.add(nextvalue.value);
		}
		return getlist;
	}

	private V getRemove(K keyi, boolean removei) {
		byte[] hashcodebytes = this.getHashCode(keyi);
		LinkedList<ByteValue<KeyValue<K,V>>> values = hashtree.get(hashcodebytes);
		V getnode = null;
		if (values!=null) {
			for (Iterator<ByteValue<KeyValue<K,V>>> i=values.iterator();(i.hasNext())&&(getnode==null);) {
				ByteValue<KeyValue<K,V>> nextvalue = i.next();
				if (nextvalue.value.key.equals(keyi)) {
					getnode = nextvalue.value.value;
					if (removei) {
						i.remove();
					}
				}
			}
		}
		return getnode;
	}
	
	private byte[] getHashCode(K keyi) {
		Integer hashcodeint = keyi.hashCode();
		ByteBuffer hashcodeintbuffer = ByteBuffer.allocate(4);
		hashcodeintbuffer.order(ByteOrder.LITTLE_ENDIAN);
		hashcodeintbuffer.putInt(hashcodeint);
		hashcodeintbuffer.rewind();
		byte[] hashcodebytes = new byte[4];
		hashcodeintbuffer.get(hashcodebytes);
		return hashcodebytes;
	}
}
