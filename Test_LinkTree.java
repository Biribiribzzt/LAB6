public class Test_LinkTree {
    public static void main(String[] args) {
        LinkTree<String> tree = new LinkTree<>();

        Position<String> root = tree.addRoot("Root");
        Position<String> child1 = tree.addChild(root, "Child 1");
        Position<String> child2 = tree.addChild(root, "Child 2");
        Position<String> grandchild1 = tree.addChild(child1, "Grandchild 1_1");
        Position<String> grandchild2 = tree.addChild(child2, "Grandchild 2_1");
        Position<String> Greatgrandchild = tree.addChild(grandchild2, "Grandchild 2_2");
        System.out.println("Root: " + tree.root().getElement());
        System.out.println("Children of root:");
        tree.printfamilyTree(root, " ");
    }
}

