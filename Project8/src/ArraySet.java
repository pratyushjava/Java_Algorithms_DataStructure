
// @author Pratyush Singh

public class ArraySet<E> implements Set<E> {

	private Object[] elements;
	private int n;

	public ArraySet() {
		super();
		n = 0;
		elements = new Object[2];
	}

	@Override
	public int size() {
		return n;
	}

	@Override
	public boolean add(E element) throws IllegalArgumentException {
		if (n == elements.length) {
			Object[] newElements = new Object[n * 2];
			for (int i = 0; i < n; i++) {
				newElements[i] = elements[i];
			}
			elements = newElements;
		}

		for (int i = 0; i < n; i++) {
			if (element.equals(elements[i]))
				return false;
		}

		elements[n] = element;
		n++;

		return true;
	}

	@Override
	public boolean contains(E element) {
		for (int i = 0; i < n; i++) {
			if (element.equals(elements[i])) {
				return true;
			}
		}
		return false;
	}

}
