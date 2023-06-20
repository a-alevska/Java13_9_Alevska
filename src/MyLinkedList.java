public class MyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(E value) {
        Node<E> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        } else {
            newNode.previous = tail;
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if (size == 1) {
            head = null;
            tail = null;
        } else if (index == 0) {
            head = head.next;
            head.previous = null;
        } else if (index == size - 1) {
            tail = tail.previous;
            tail.next = null;
        } else {
            Node<E> currentNode = getNode(index);
            currentNode.previous.next = currentNode.next;
            currentNode.next.previous = currentNode.previous;
        }
        size--;
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        Node<E> currentNode = getNode(index);
        return currentNode.value;
    }

    private Node<E> getNode(int index) {
        Node<E> currentNode;
        if (index < size / 2) {
            currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else {
            currentNode = tail;
            for (int i = size - 1; i > index; i--) {
                currentNode = currentNode.previous;
            }
        }
        return currentNode;
    }

    private class Node<E> {
        private E value;
        private Node<E> previous;
        private Node<E> next;

        public Node(E value) {
            this.value = value;
            this.previous = null;
            this.next = null;
        }
    }
}
