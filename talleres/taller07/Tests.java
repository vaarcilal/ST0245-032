import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * Write a description of class Test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tests
{
	@Test
	public void testInsert() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insert(5, 0);
		list.insert(4, 0);
		list.insert(3, 0);
		list.insert(2, 0);
		list.insert(1, 0);

		assertEquals(list.getData(0),new Integer(1));
		assertEquals(list.getData(1),new Integer(2));
		assertEquals(list.getData(2),new Integer(3));
		assertEquals(list.getData(3),new Integer(4));
		assertEquals(list.getData(4),new Integer(5));			
	}

	@Test
	public void testRemove() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insert(5, 0);
		list.insert(4, 0);
		list.insert(3, 0);
		list.insert(2, 0);
		list.insert(1, 0);
		assertTrue(list.contains(3));
		list.remove(2);
		assertFalse(list.contains(3));
	}

	@Test
	public void testContains() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insert(5, 0);
		list.insert(4, 0);
		list.insert(3, 0);
		list.insert(2, 0);
		list.insert(1, 0);
		assertTrue(list.contains(3));
		assertFalse(list.contains(10));
	}
}
