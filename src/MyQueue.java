public class MyQueue<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MyQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(E value) {
        Node<E> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public E peek() {
        if (head == null) {
            return null;
        }
        return head.value;
    }

    public E poll() {
        if (head == null) {
            return null;
        }
        Node<E> removedNode = head;
        head = head.next;
        size--;
        if (head == null) {
            tail = null;
        }
        return removedNode.value;
    }

    private static class Node<E> {
        private E value;
        private MyQueue.Node<E> next;

        public Node(E value) {
            this.value = value;
            this.next = null;
        }
    }
}
