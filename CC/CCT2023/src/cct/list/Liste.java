package cct.list;

import java.util.Iterator;

public class Liste implements Iterable<Integer> {
	private Cellule first;
	private Liste() {
		first = null;
	}
	Liste(int v, int ...values) {
		for (int i = values.length-1; i>=0; i--) {
			add(values[i]);
		}
		add(v);
	}
	private class ListeIterator implements Iterator<Integer> {
		private Cellule current = Liste.this.first; 
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Integer next() {
			int v = current.element;
			current = current.next;
			return v;
		}
	}
	
	public int size() {
		int res = 0;
		Cellule current = first;
		while (current != null) {
			res++;
			current = current.next;
		}
		return res;
	}
	public void add(int v) {
		first = new Cellule(v, first);
	}
	public void removeFirst() {
		if (first == null) throw new RuntimeException("List is empty");
		first = first.next;
	}
	public int contains(int v) {
		Cellule current = first;
		int pos = 0;
		while (current != null) {
			if (current.element == v) return pos;
			current = current.next;
			pos ++;
		}
		return -1;
	}
	
	public Liste reverse() {
		Liste res = new Liste();
		Cellule current = first;
		while (current != null) {
			res.add(current.element);
			current = current.next;
		}
		return res;
	}
	
	public void concat(Liste autre) {
		if (first == null) {
			first = autre.first;
			return ;
		}
		Cellule current = first;
		while (current.next != null) {
			current = current.next;
		}
		current.next = autre.first;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String sep = "[";
		for (int v : this) {
			sb.append(sep);
			sb.append(v);
			sep = ", ";
		}
		sb.append(']');
		return sb.toString();
	}
	
	@Override
	public Iterator<Integer> iterator() {
		return new ListeIterator();
	}
}
