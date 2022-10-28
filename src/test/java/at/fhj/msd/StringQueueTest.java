package at.fhj.msd;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Unit test for StringQueue class.
 */
public class StringQueueTest
{
    /**
     * Checks if it is possible to create a new queue.
     * Checks if it is possible to append new items to this queue by adding it and checks if ist's in queue.
     * Checks if polling is possible by polling the added item an checks if queue ist empty after that.
     */
    @Test
    public void shouldAllowToCreateQueue()
    {
        StringQueue stringQueue = new StringQueue(1);
        stringQueue.offer("Gin");
        assertEquals("Gin", stringQueue.poll());
        assertNull(stringQueue.poll());
    }

    /**
     * Checks if the order of the addet items is right by appending two items and polling them afterwarts
     * in correct order.
     */
    @Test
    public void correctQueueOrder()
    {
        StringQueue stringQueue = new StringQueue(2);
        stringQueue.offer("Gin");
        stringQueue.offer("Wine");
        assertEquals("Gin", stringQueue.poll());
        assertEquals("Wine", stringQueue.poll());
        assertNull(stringQueue.poll());
    }

    /**
     * Checks if removing an item from the queue is possible by creating a queue with two items and
     * then removing them.
     */
    @Test
    public void removeshouldAllowToRemove()
    {
        StringQueue stringQueue = new StringQueue(2);
        stringQueue.offer("Gin");
        stringQueue.offer("Wine");
        assertEquals("Gin", stringQueue.remove());
        assertEquals("Wine", stringQueue.remove());

    }

    /**
     * Checks if removing an item from an empty queue throws NoSuchElementException.
     */
    @Test(expected = NoSuchElementException.class)
    public void removeShouldThrowExceptionOnEmpty()
    {
        StringQueue stringQueue = new StringQueue(1);
        stringQueue.remove();

    }

    /**
     * Checks if items don't get removed when peeking in queue by appending two items and checking
     * after each if the first one is returned.
     */
    @Test
    public void peekShouldNotRemove()
    {
        StringQueue stringQueue = new StringQueue(1);
        stringQueue.offer("Gin");
        assertEquals("Gin", stringQueue.peek());
        stringQueue.offer("Wine");
        assertEquals("Gin", stringQueue.peek());
    }

    /**
     * Checks if peeking an item from an empty queue returns null.
     */
    @Test
    public void peekShouldReturnNullIfEmpty()
    {
        StringQueue stringQueue = new StringQueue(1);
        assertNull(stringQueue.peek());
    }

    /**
     * Checks if element function does not remove items from queue by appending two items and checks after each
     * if the firs one ist returned.
     */
    @Test
    public void elementShouldNotRemove()
    {
        StringQueue stringQueue = new StringQueue(1);
        stringQueue.offer("Gin");
        assertEquals("Gin", stringQueue.element());
        stringQueue.offer("Wine");
        assertEquals("Gin", stringQueue.element());
    }

    /**
     * Checks if element throws NoSuchElementException on empty queue.
     */
    @Test(expected = NoSuchElementException.class)
    public void elementShouldThrowExceptionOnEmpty()
    {
        StringQueue stringQueue = new StringQueue(1);
        assertNull(stringQueue.element());
    }

}
