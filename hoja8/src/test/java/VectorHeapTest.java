import com.example.VectorHeap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VectorHeapTest {

    private VectorHeap<Integer> heap;

    @BeforeEach
    void setUp() {
        heap = new VectorHeap<>();
    }

    @Test
    void testAddAndPeek() {
        assertTrue(heap.isEmpty(), "Heap should be empty initially");

        heap.add(10);
        assertEquals(10, heap.peek(), "Peek should return the first element added");

        heap.add(5);
        assertEquals(5, heap.peek(), "Peek should return the smallest element");

        heap.add(15);
        assertEquals(5, heap.peek(), "Peek should still return the smallest element after adding a larger one");
    }

    @Test
    void testRemove() {
        heap.add(10);
        heap.add(5);
        heap.add(15);

        assertEquals(5, heap.remove(), "Remove should return the smallest element");
        assertEquals(10, heap.peek(), "Peek should return the next smallest element after removal");
        assertFalse(heap.isEmpty(), "Heap should not be empty after removal");

        heap.remove();
        heap.remove();
        assertTrue(heap.isEmpty(), "Heap should be empty after removing all elements");
    }

    @Test
    void testIsEmpty() {
        assertTrue(heap.isEmpty(), "Heap should be initially empty");
        heap.add(10);
        assertFalse(heap.isEmpty(), "Heap should not be empty after adding an element");
        heap.remove();
        assertTrue(heap.isEmpty(), "Heap should be empty again after removing the element");
    }

    @Test
    void testSize() {
        assertEquals(0, heap.size(), "Heap size should be 0 initially");
        heap.add(10);
        assertEquals(1, heap.size(), "Heap size should be 1 after adding an element");
        heap.add(20);
        assertEquals(2, heap.size(), "Heap size should be 2 after adding another element");
        heap.remove();
        assertEquals(1, heap.size(), "Heap size should decrease back to 1 after removal");
    }
}

