public class MyStack<E>{

    private MyStack.Node<E> top;
    private int size;

    public MyStack() {
        top = null;
        size = 0;
    }

    public void push(E value) {
        MyStack.Node<E> newNode = new Node<>(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if (index == 0) {
            top = top.next;
        } else {
            Node<E> prevNode = getNode(index - 1);
            prevNode.next = prevNode.next.next;
        }
        size--;
    }

    public E peek() {
        if (top == null) {
            return null;
        }
        return top.value;
    }

    public E pop() {
        if (top == null) {
            return null;
        }
        MyStack.Node<E> removedNode = top;
        top = top.next;
        size--;
        return removedNode.value;
    }

    private Node<E> getNode(int index) {
        Node<E> currentNode = top;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    private static class Node<E> {
        private final E value;
        private MyStack.Node<E> next;

        public Node(E value) {
            this.value = value;
            this.next = null;
        }
    }
}
