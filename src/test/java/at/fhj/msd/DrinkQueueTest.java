package at.fhj.msd;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class DrinkQueueTest
{

    private SimpleDrink wodka;
    private SimpleDrink gin;

    @Before
    public void initDrinks() {
        Liquid wodkaLiquid = new Liquid("Wodka", 1.0, 40);
        Liquid ginLiquid = new Liquid("Gin", 1.0, 37.5);
        wodka = new SimpleDrink("Jodka", wodkaLiquid);
        gin = new SimpleDrink("Jin", ginLiquid);
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAllowToCreateQueue()
    {
        DrinkQueue drinkQueue = new DrinkQueue(1);
        drinkQueue.offer(gin);
        assertEquals(gin, drinkQueue.poll());
        assertNull(drinkQueue.poll());
    }

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

    @Test
    public void removeshouldAllowToRemove()
    {
        DrinkQueue drinkQueue = new DrinkQueue(2);
        drinkQueue.offer(gin);
        drinkQueue.offer(wodka);
        assertEquals(gin, drinkQueue.remove());
        assertEquals(wodka, drinkQueue.remove());

    }

    @Test(expected = NoSuchElementException.class)
    public void removeShouldThrowExceptionOnEmpty()
    {
        DrinkQueue drinkQueue = new DrinkQueue(1);
        drinkQueue.remove();

    }

    @Test
    public void peekShouldNotRemove()
    {
        DrinkQueue drinkQueue = new DrinkQueue(1);
        drinkQueue.offer(gin);
        assertEquals(gin, drinkQueue.peek());
        drinkQueue.offer(wodka);
        assertEquals(gin, drinkQueue.peek());
    }

    @Test
    public void peekShouldReturnNullIfEmpty()
    {
        DrinkQueue drinkQueue = new DrinkQueue(1);
        assertNull(drinkQueue.peek());
    }

    @Test
    public void elementShouldNotRemove()
    {
        DrinkQueue drinkQueue = new DrinkQueue(1);
        drinkQueue.offer(gin);
        assertEquals(gin, drinkQueue.element());
        drinkQueue.offer(wodka);
        assertEquals(gin, drinkQueue.element());
    }

    @Test(expected = NoSuchElementException.class)
    public void elementShouldThrowExceptionOnEmpty()
    {
        DrinkQueue drinkQueue = new DrinkQueue(1);
        assertNull(drinkQueue.element());
    }

}
