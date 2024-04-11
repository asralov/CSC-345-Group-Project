import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import src.main.java.*;
import org.junit.jupiter.api.DisplayName;

/*
 * Authors : Jin Kim

 */

public class QueueTest {

    @Test
    @DisplayName("Enqueue and Dequeue Test")
    public void testEnqueueAndDequeue() {
        Queue queue = new Queue();
        TrieNode node1 = new TrieNode();
        TrieNode node2 = new TrieNode();
        
        queue.enqueue(node1);
        queue.enqueue(node2);
        
        assertEquals(node1, queue.dequeue());
        assertEquals(node2, queue.dequeue());
    }

    @Test
    @DisplayName("Empty Queue Test")
    public void testIsEmpty() {
        Queue queue = new Queue();
        assertTrue(queue.isEmpty());

        TrieNode node = new TrieNode();
        queue.enqueue(node);
        assertFalse(queue.isEmpty());

        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    @DisplayName("Peek Test")
    public void testPeek() {
        Queue queue = new Queue();
        assertNull(queue.peek());

        TrieNode node = new TrieNode();
        queue.enqueue(node);
        assertEquals(node, queue.peek());
    }

    @Test
    @DisplayName("Resize Test")
    public void testResize() {
        Queue queue = new Queue(2);
        TrieNode node1 = new TrieNode();
        TrieNode node2 = new TrieNode();
        TrieNode node3 = new TrieNode();

        queue.enqueue(node1);
        queue.enqueue(node2);
        assertEquals(2, queue.getCapacity());

        // Enqueue third elemenet to trigger resize
        queue.enqueue(node3);
        assertTrue(queue.getCapacity() > 2);
    }
}
