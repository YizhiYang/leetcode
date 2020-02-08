package Iterator;

import java.util.Iterator;

/**
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().
 * <p>
 * Example:
 * <p>
 * Assume that the iterator is initialized to the beginning of the list: [1,2,3].
 * <p>
 * Call next() gets you 1, the first element in the list.
 * Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
 * You call next() the final time and it returns 3, the last element.
 * Calling hasNext() after that should return false.
 * <p>
 * How would you extend your design to be generic and work with all types, not just integer?
 */

public class PeekingIterator<T> implements Iterator<T> {

    private Iterator<T> iterator;
    private T next;

    public PeekingIterator(Iterator<T> iterator) {
        this.iterator = iterator;
        if (iterator.hasNext()) {
            next = iterator.next();
        }

    }

    // Returns the next element in the iteration without advancing the iterator.
    public T peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public T next() {
        T res = next;
        next = iterator.hasNext() ? iterator.next() : null;
        return next;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}
