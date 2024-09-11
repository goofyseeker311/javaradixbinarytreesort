package fi.jkauppa.treemap;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;

public class BinaryTreeMap<V>
extends AbstractMap<byte[],V>
implements NavigableMap<byte[],V>, Cloneable, java.io.Serializable {
	private static final long serialVersionUID = 1L;
	BinaryTreeMapNode rootnode = new BinaryTreeMapNode();
	
	private static class BinaryTreeMapNode {
		public BinaryTreeMapNode zero = null;
		public BinaryTreeMapNode one = null;
	}

	@Override public Comparator<? super byte[]> comparator() {return null;}
	@Override public byte[] firstKey() {return null;}
	@Override public byte[] lastKey() {return null;}
	@Override public Set<Entry<byte[], V>> entrySet() {return null;}
	@Override public Entry<byte[], V> lowerEntry(byte[] key) {return null;}
	@Override public byte[] lowerKey(byte[] key) {return null;}
	@Override public Entry<byte[], V> floorEntry(byte[] key) {return null;}
	@Override public byte[] floorKey(byte[] key) {return null;}
	@Override public Entry<byte[], V> ceilingEntry(byte[] key) {return null;}
	@Override public byte[] ceilingKey(byte[] key) {return null;}
	@Override public Entry<byte[], V> higherEntry(byte[] key) {return null;}
	@Override public byte[] higherKey(byte[] key) {return null;}
	@Override public Entry<byte[], V> firstEntry() {return null;}
	@Override public Entry<byte[], V> lastEntry() {return null;}
	@Override public Entry<byte[], V> pollFirstEntry() {return null;}
	@Override public Entry<byte[], V> pollLastEntry() {return null;}
	@Override public NavigableMap<byte[], V> descendingMap() {return null;}
	@Override public NavigableSet<byte[]> navigableKeySet() {return null;}
	@Override public NavigableSet<byte[]> descendingKeySet() {return null;}
	@Override public NavigableMap<byte[], V> subMap(byte[] fromKey, boolean fromInclusive, byte[] toKey, boolean toInclusive) {return null;}
	@Override public NavigableMap<byte[], V> headMap(byte[] toKey, boolean inclusive) {return null;}
	@Override public NavigableMap<byte[], V> tailMap(byte[] fromKey, boolean inclusive) {return null;}
	@Override public SortedMap<byte[], V> subMap(byte[] fromKey, byte[] toKey) {return null;}
	@Override public SortedMap<byte[], V> headMap(byte[] toKey) {return null;}
	@Override public SortedMap<byte[], V> tailMap(byte[] fromKey) {return null;}
}
