package fi.jkauppa.treemap;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;

public class HashTreeSet<E>
	extends AbstractSet<E>
	implements Set<E>, Cloneable, java.io.Serializable {
	private static final long serialVersionUID = 1L;
	HashTreeSetNode rootnode = new HashTreeSetNode();
	
	private static class HashTreeSetNode {
	}

	@Override public int size() {return 0;}
	@Override public Iterator<E> iterator() {return null;}

}
