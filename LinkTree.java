import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class LinkTree<E> implements Tree<E> {
    private class Node implements Position<E> {
        private E element;
        private Node parent;
        private List<Node> children;

        @Override
        public E getElement() throws IllegalStateException {
            return element;
        }

        public Position<E> getParent() {
            return parent;
        }

        public Iterable<Position<E>> getChildren() {
            List<Position<E>> positions = new ArrayList<>();
            for (Node child : children) {
                positions.add(child);
            }
            return positions;

        }
        public boolean hasChildren() {
            return !children.isEmpty();
        }
        @Override
        public String toString() {
            return element.toString();
        }
    }

    protected Position<E> root;
    protected int size;

    public LinkTree() {
        root = null;
        size = 0;
    }

    protected Node validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("Invalid position");
        }
        Node node = (Node) p;
        if (node.getParent() == null && !node.equals(root)) {
            throw new IllegalArgumentException("Position does not belong to this tree");
        }
        return node;
    }

    @Override
    public Position<E> root() {
        return root;
    }

    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node node = validate(p);
        if (node.getParent() == null) {
            throw new IllegalArgumentException("The position" + node.toString() + " has no parent.");
        }else
        return node.getParent();
    }

    @Override
    public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {
        Node node = validate(p);
        if (!node.hasChildren()) {
            throw new IllegalArgumentException("The position " + node.toString() + " has no children.");
        }
        return node.getChildren();
    }

    @Override
    public int numChildren(Position<E> p) throws IllegalArgumentException {
        return validate(p).children.size();
    }

    @Override
    public boolean isInternal(Position<E> p) throws IllegalArgumentException {
        return numChildren(p) > 0;
    }

    @Override
    public boolean isExternal(Position<E> p) throws IllegalArgumentException {
        return numChildren(p) == 0;
    }

    @Override
    public boolean isRoot(Position<E> p) throws IllegalArgumentException {
        return p == root;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        // Implementation for returning an iterator over the elements
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Iterable<Position<E>> positions() {
        // Implementation for returning all positions in the tree
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public Position<E> addRoot(E e) {
        if (!isEmpty()) {
            throw new IllegalStateException("Tree already has a root");
        }
        Node newNode = new Node();
        newNode.element = e;
        newNode.children = new ArrayList<>();
        root = newNode;
        size++;
        return root;
    }
    public Position<E> addChild(Position<E> p, E e) {
        Node parentNode = validate(p);
        Node newNode = new Node();
        newNode.element = e;
        newNode.parent = parentNode;
        newNode.children = new ArrayList<>();
        parentNode.children.add(newNode);
        size++;
        return newNode;
    }
    public void printfamilyTree(Position<E> p, String prefix) {
        Node node = validate(p);
        System.out.println(prefix + node.getElement());
        for (Position<E> child : node.getChildren()) {
            printfamilyTree(child, prefix + "  ");
        }
    }
    public void printfamilyTree(Position<E> p, String prefix,String suffix) {
        Node node = validate(p);
        System.out.println(prefix + node.getElement());
        for (Position<E> child : node.getChildren()) {
            printfamilyTree(child, prefix + suffix, suffix);
        }
    }
}
