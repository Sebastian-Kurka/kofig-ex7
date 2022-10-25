package at.fhj.msd;

/**
 * represents an interface for a queue.
 */
public interface IQueue {

  /**
   * adds object to queue,
   *
   * @return true if works, otherwise false.
   */
  public abstract boolean offer(String obj);

  /**
   * returns and deletes first element.
   *
   * @return null if no element in queue.
   */
  public abstract String poll();

  /**
   * returns and deletes first element.
   *
   * @throws java.util.NoSuchElementException if no element in queue.
   */
  public abstract String remove();

  /**
   * gives first element but does not delete.
   *
   * @return null if nothing in queue.
   */
  public abstract String peek();

  /**
   * gives first element but does not delete.
   *
   * @throws java.util.NoSuchElementException if no element in queue.
   */
  public abstract String element();
}