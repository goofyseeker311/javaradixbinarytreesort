package fi.jkauppa.treemap;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;

public class HashTreeMap<K,V>
extends AbstractMap<K,V>
implements NavigableMap<K,V>, Cloneable, java.io.Serializable {
	private static final long serialVersionUID = 1L;
	HashTreeMapNode rootnode = new HashTreeMapNode();
	
	private static class HashTreeMapNode {
	}

	@Override public Comparator<? super K> comparator() {return null;}
	@Override public K firstKey() {return null;}
	@Override public K lastKey() {return null;}
	@Override public Set<Entry<K, V>> entrySet() {return null;}
	@Override public Entry<K, V> lowerEntry(K key) {return null;}
	@Override public K lowerKey(K key) {return null;}
	@Override public Entry<K, V> floorEntry(K key) {return null;}
	@Override public K floorKey(K key) {return null;}
	@Override public Entry<K, V> ceilingEntry(K key) {return null;}
	@Override public K ceilingKey(K key) {return null;}
	@Override public Entry<K, V> higherEntry(K key) {return null;}
	@Override public K higherKey(K key) {return null;}
	@Override public Entry<K, V> firstEntry() {return null;}
	@Override public Entry<K, V> lastEntry() {return null;}
	@Override public Entry<K, V> pollFirstEntry() {return null;}
	@Override public Entry<K, V> pollLastEntry() {return null;}
	@Override public NavigableMap<K, V> descendingMap() {return null;}
	@Override public NavigableSet<K> navigableKeySet() {return null;}
	@Override public NavigableSet<K> descendingKeySet() {return null;}
	@Override public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {return null;}
	@Override public NavigableMap<K, V> headMap(K toKey, boolean inclusive) {return null;}
	@Override public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive) {return null;}
	@Override public SortedMap<K, V> subMap(K fromKey, K toKey) {return null;}
	@Override public SortedMap<K, V> headMap(K toKey) {return null;}
	@Override public SortedMap<K, V> tailMap(K fromKey) {return null;}
}
