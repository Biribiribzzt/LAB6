import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;



public class LinkTree<E> implements Tree<E> {
    private class Node implements Position<E> {
        private E element;
        private Node parent;
        private List<Node> children;


        /**
         * For Exercise 4, this class implements the Position interface.
         */
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
        public boolean hasparent() {
            return parent != null;
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
        return new Iterator<E>() {
            private Iterator<Position<E>> positionIterator = positions().iterator();

            @Override
            public boolean hasNext() {
                return positionIterator.hasNext();
            }

            @Override
            public E next() {
                return positionIterator.next().getElement();
            }
        };
    }


    @Override
    public Iterable<Position<E>> positions() {
        List<Position<E>> List_positions = new ArrayList<>();
        List_positions.add(root);
        for (Position<E> index : GetAllChildpositions(root)) {
            List_positions.add(index);
        }
        return List_positions;
    }

    private List<Position<E>> GetAllChildpositions(Position<E> p) {
        Node node = validate(p);
        List<Position<E>> nice = new ArrayList<>();
        if(node.hasChildren())
            for (Position<E> child : node.getChildren()) {
                nice.add(child);
                Node childcheck = validate(child);
                if(childcheck.hasChildren()) {
                    for (Position<E> grandChild : GetAllChildpositions(child)) {
                        nice.add(grandChild);
                    }
                }
                
            }
        return nice;
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

    public void remove(Position<E> p) throws IllegalArgumentException {
        Node node = validate(p);
        if (node == root) {
            root = null;
        } else {
            Position<E> parent = node.getParent();
            Node parentNode = validate(parent);
            parentNode.children.remove(node);
        }
        size--;
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
    // PreOrder and PostOrder methods for Exercise 5
    public E PreOrder(Position<E> p, boolean isPrint,String prefix) {
        Node node = validate(p);
        E result = node.getElement();
        if (isPrint) {
            System.out.println(prefix + result);
        }
        if (node.hasChildren()) {
            for (Position<E> child : node.getChildren()) {
                result = PreOrder(child, isPrint, prefix + "  ");
            }
        }
        return result;
    }

    public E PreOrder(Position<E> p, boolean isPrint,String prefix, String suffix) {
        Node node = validate(p);
        E result = node.getElement();
        if (isPrint) {
            System.out.println(prefix + result);
        }
        if (node.hasChildren()) {
            for (Position<E> child : node.getChildren()) {
                result = PreOrder(child, isPrint, prefix + suffix);
            }
        }
        return result;
    }
    
    public void postOrder(Position<E> p) {
    Node node = validate(p);

    if (node != null) {
        for (Position<E> child : node.getChildren()) {
            postOrder(child); 
        }
        System.out.println(node.element); 
    }
}
    public void postOrder(Position<E> p,boolean isPrint,String prefix) {
        Node node = validate(p);

        if (node != null) {
            for (Position<E> child : node.getChildren()) {
                postOrder(child,isPrint, prefix + "  "); 

            }
            if(isPrint){
                System.out.println(prefix + node.element); 
            }
        }
    }
}
