package at.fhj.msd;

/**
 * represents an interface for the drink-queue
 */
public interface IDrinkQueue {

    /**
     * adds object to queue,
     *
     * @return true if works, otherwise false.
     */
    public abstract boolean offer(Drink obj);

    /**
     * returns and deletes first element.
     *
     * @return null if no element in queue.
     */
    public abstract Drink poll();

    /**
     * returns and deletes first element.
     *
     * @throws java.util.NoSuchElementException if no element in queue.
     */
    public abstract Drink remove();

    /**
     * gives first element but does not delete.
     *
     * @return null if nothing in queue.
     */
    public abstract Drink peek();

    /**
     * gives first element but does not delete.
     *
     * @throws java.util.NoSuchElementException if no element in queue.
     */
    public abstract Drink element();
}