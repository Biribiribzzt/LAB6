import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;


public class ArrayBinaryTree<E> {
    private class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;

        Node(E e) {
            element = e;
            left = null;
            right = null;
        }
        public E getElement() {
            return element;
        }
    }

    List<Node<E>> elements;
    int size;
    Node<E> root;
    public ArrayBinaryTree(int capacity) {
        this.elements = new ArrayList<>(capacity);
        size = 0;
        root = null;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void add(E e) {
        if (size >= elements.size()) {
            List<Node<E>> newElements = new ArrayList<>(elements.size() * 2);
            newElements.addAll(elements);
            this.elements = newElements;
        }
        Node<E> newNode = new Node<>(e);
        elements.add(newNode);
        if (root == null) {
            root = newNode;
        } else {
            int index = (size - 1) / 2; // Parent index
            if (size % 2 == 0) {
                elements.get(index).left = newNode; // Left child
            } else {
                elements.get(index).right = newNode; // Right child
            }
        }
        size++;
    }
    
    public Node<E> getRoot() {
        return root;
    }

    public E getParent(int index) {
        if (index <= 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index");
        }
        int parentIndex = (index - 1) / 2;
        return elements.get(parentIndex).getElement();
    }

    public E getleftChild(int index) {
        int leftIndex = 2 * index + 1;
        if (leftIndex >= size) {
            throw new IllegalArgumentException("No left child");
        }
        return elements.get(leftIndex).getElement();
    }

    public E getRightChild(int index) {
        int rightIndex = 2 * index + 2;
        if (rightIndex >= size) {
            throw new IllegalArgumentException("No right child");
        }
        return elements.get(rightIndex).getElement();
    }

    public void PrintInOrder(int index) {
        if (isEmpty()) {
            System.out.println("Tree is empty");
            return;
        }
        System.out.print(elements.get(index ).getElement() + " ");
        if (index < elements.size()) {
            if (2 * index + 1 < elements.size()) {
                PrintInOrder(2 * index + 1); // Left child
            }
            if (2 * index + 2 < elements.size()) {
                PrintInOrder(2 * index + 2); // Right child
            }
        }
    }
}
