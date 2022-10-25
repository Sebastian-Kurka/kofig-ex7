package at.fhj.msd;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * class represents a queue where drinks can be stored.
 */
public class DrinkQueue implements IDrinkQueue  {

    /**
     * Creates an ArrayList called elements.
     */
    private List<Drink> elements = new ArrayList<Drink>();

    /**
     * defines maximal size of the ArrayList
     */
    private int maxSize = 5;

    /**
     * Creates Queue based of the max size
     *
     * @param maxsize maximal size of the Queue
     */
    public DrinkQueue(int maxsize) {
        maxSize = maxSize;
    }

    /**
     * Appends an objekt to the Queue
     *
     * @param obj Drink-Objekt
     *
     * @return false if the max size of the queue is reached, true otherwise.
     */
    @Override
    public boolean offer(Drink obj) {
        if (elements.size() != maxSize)
            elements.add(obj);
        else
            return false;

        return true;
    }

    /**
     * returns and deletes first element of queue.
     *
     * @return null if no element in queue, else returns the element.
     */
    @Override
    public Drink poll() {
        Drink element = peek();

        if (elements.size() != 0) {
            elements.remove(0);
        }

        return element;
    }

    /**
     * returns and deletes first element of queue.
     *
     * @throws NoSuchElementException if no  element in queue.
     * @return element if there is an element to return in queue.
     */
    @Override
    public Drink remove() {
        Drink element = poll();
        if (element == null)
            throw new NoSuchElementException("there's no element any more");

        return element;
    }

    /**
     * returns but don't deletes first element in queue.
     *
     * @return null if no element in queue, else returns the element.
     */
    @Override
    public Drink peek() {
        Drink element;
        if (elements.size() > 0)
            element = elements.get(0);
        else
            element = null;

        return element;
    }

    /**
     * returns but don't deletes first element in queue.
     *
     * @throws NoSuchElementException if no  element in queue.
     * @return element if there is an element to return in queue.
     */
    @Override
    public Drink element() {
        Drink element = peek();
        if (element == null)
            throw new NoSuchElementException("there's no element any more");

        return element;
    }


}
