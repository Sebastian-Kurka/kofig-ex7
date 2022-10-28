package at.fhj.msd;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Unit test for DrinkQueue class.
 */
public class DrinkQueueTest
{

    private SimpleDrink wodka;
    private SimpleDrink gin;

    /**
     * Before every test two new Liquids and two new SimpleDrinks get created.
     */
    @Before
    public void initDrinks() {
        Liquid wodkaLiquid = new Liquid("Wodka", 1.0, 40);
        Liquid ginLiquid = new Liquid("Gin", 1.0, 37.5);
        wodka = new SimpleDrink("Wodka", wodkaLiquid);
        gin = new SimpleDrink("Gin", ginLiquid);
    }

    /**
     * Checks if it is possible to create a new queue.
     * Checks if it is possible to append new items to this queue by adding it and checks if ist's in queue.
     * Checks if polling is possible by polling the added item an checks if queue ist empty after that.
     */
    @Test
    public void shouldAllowToCreateQueue()
    {
        DrinkQueue drinkQueue = new DrinkQueue(1);
        drinkQueue.offer(gin);
        assertEquals(gin, drinkQueue.poll());
        assertNull(drinkQueue.poll());
    }

    /**
     * Checks if the order of the addet items is right by appending two items and polling them afterwarts
     * in correct order.
     */
    @Test
    public void correctQueueOrder()
    {
        DrinkQueue drinkQueue = new DrinkQueue(2);
        drinkQueue.offer(gin);
        drinkQueue.offer(wodka);
        assertEquals(gin, drinkQueue.poll());
        assertEquals(wodka, drinkQueue.poll());
        assertNull(drinkQueue.poll());
    }

    /**
     * Checks if removing an item from the queue is possible by creating a queue with two items and
     * then removing them.
     */
    @Test
    public void removeshouldAllowToRemove()
    {
        DrinkQueue drinkQueue = new DrinkQueue(2);
        drinkQueue.offer(gin);
        drinkQueue.offer(wodka);
        assertEquals(gin, drinkQueue.remove());
        assertEquals(wodka, drinkQueue.remove());

    }

    /**
     * Checks if removing an item from an empty queue throws NoSuchElementException.
     */
    @Test(expected = NoSuchElementException.class)
    public void removeShouldThrowExceptionOnEmpty()
    {
        DrinkQueue drinkQueue = new DrinkQueue(1);
        drinkQueue.remove();

    }

    /**
     * Checks if items don't get removed when peeking in queue by appending two items and checking
     * after each if the first one is returned.
     */
    @Test
    public void peekShouldNotRemove()
    {
        DrinkQueue drinkQueue = new DrinkQueue(1);
        drinkQueue.offer(gin);
        assertEquals(gin, drinkQueue.peek());
        drinkQueue.offer(wodka);
        assertEquals(gin, drinkQueue.peek());
    }

    /**
     * Checks if peeking an item from an empty queue returns null.
     */
    @Test
    public void peekShouldReturnNullIfEmpty()
    {
        DrinkQueue drinkQueue = new DrinkQueue(1);
        assertNull(drinkQueue.peek());
    }

    /**
     * Checks if element function does not remove items from queue by appending two items and checks after each
     * if the firs one ist returned.
     */
    @Test
    public void elementShouldNotRemove()
    {
        DrinkQueue drinkQueue = new DrinkQueue(1);
        drinkQueue.offer(gin);
        assertEquals(gin, drinkQueue.element());
        drinkQueue.offer(wodka);
        assertEquals(gin, drinkQueue.element());
    }

    /**
     * Checks if element throws NoSuchElementException on empty queue.
     */
    @Test(expected = NoSuchElementException.class)
    public void elementShouldThrowExceptionOnEmpty()
    {
        DrinkQueue drinkQueue = new DrinkQueue(1);
        assertNull(drinkQueue.element());
    }

}
