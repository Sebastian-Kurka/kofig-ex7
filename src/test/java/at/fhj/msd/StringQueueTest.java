package at.fhj.msd;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class StringQueueTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAllowToCreateQueue()
    {
        StringQueue stringQueue = new StringQueue(1);
        stringQueue.offer("Gin");
        assertEquals("Gin", stringQueue.poll());
        assertNull(stringQueue.poll());
    }

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

    @Test
    public void removeshouldAllowToRemove()
    {
        StringQueue stringQueue = new StringQueue(2);
        stringQueue.offer("Gin");
        stringQueue.offer("Wine");
        assertEquals("Gin", stringQueue.remove());
        assertEquals("Wine", stringQueue.remove());

    }

    @Test(expected = NoSuchElementException.class)
    public void removeShouldThrowExceptionOnEmpty()
    {
        StringQueue stringQueue = new StringQueue(1);
        stringQueue.remove();

    }
    
    @Test
    public void peekShouldNotRemove()
    {
        StringQueue stringQueue = new StringQueue(1);
        stringQueue.offer("Gin");
        assertEquals("Gin", stringQueue.peek());
        stringQueue.offer("Wine");
        assertEquals("Gin", stringQueue.peek());
    }

    @Test
    public void peekShouldReturnNullIfEmpty()
    {
        StringQueue stringQueue = new StringQueue(1);
        assertNull(stringQueue.peek());
    }

    @Test
    public void elementShouldNotRemove()
    {
        StringQueue stringQueue = new StringQueue(1);
        stringQueue.offer("Gin");
        assertEquals("Gin", stringQueue.element());
        stringQueue.offer("Wine");
        assertEquals("Gin", stringQueue.element());
    }

    @Test(expected = NoSuchElementException.class)
    public void elementShouldThrowExceptionOnEmpty()
    {
        StringQueue stringQueue = new StringQueue(1);
        assertNull(stringQueue.element());
    }

}
