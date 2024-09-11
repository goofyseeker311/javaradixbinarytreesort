package fi.jkauppa.treemap;

import java.util.AbstractSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;

public class BinaryTreeSet extends AbstractSet<byte[]>
	implements NavigableSet<byte[]>, Cloneable, java.io.Serializable {
	private static final long serialVersionUID = 1L;
	BinaryTreeSetNode rootnode = new BinaryTreeSetNode();
	
	private static class BinaryTreeSetNode {
	}

	@Override public Comparator<? super byte[]> comparator() {return null;}
	@Override public byte[] first() {return null;}
	@Override public byte[] last() {return null;}
	@Override public int size() {return 0;}
	@Override public byte[] lower(byte[] e) {return null;}
	@Override public byte[] floor(byte[] e) {return null;}
	@Override public byte[] ceiling(byte[] e) {return null;}
	@Override public byte[] higher(byte[] e) {return null;}
	@Override public byte[] pollFirst() {return null;}
	@Override public byte[] pollLast() {return null;}
	@Override public Iterator<byte[]> iterator() {return null;}
	@Override public NavigableSet<byte[]> descendingSet() {return null;}
	@Override public Iterator<byte[]> descendingIterator() {return null;}
	@Override public NavigableSet<byte[]> subSet(byte[] fromElement, boolean fromInclusive, byte[] toElement,boolean toInclusive) {return null;}
	@Override public NavigableSet<byte[]> headSet(byte[] toElement, boolean inclusive) {return null;}
	@Override public NavigableSet<byte[]> tailSet(byte[] fromElement, boolean inclusive) {return null;}
	@Override public SortedSet<byte[]> subSet(byte[] fromElement, byte[] toElement) {return null;}
	@Override public SortedSet<byte[]> headSet(byte[] toElement) {return null;}
	@Override public SortedSet<byte[]> tailSet(byte[] fromElement) {return null;}
	
}
