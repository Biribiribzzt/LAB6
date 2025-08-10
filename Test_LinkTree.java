public class Test_LinkTree {
    public static void main(String[] args) {
        LinkTree<String> tree = new LinkTree<>();

        Position<String> root = tree.addRoot("Root");
        Position<String> Fruit = tree.addChild(root, "Fruit");
        Position<String> Veggies = tree.addChild(root, "Veggies");
        Position<String> Orange = tree.addChild(Fruit, "Orange");
        Position<String> Apple = tree.addChild(Fruit, "Apple");
        Position<String> Pinkapple = tree.addChild(Apple, "Pinkapple");
        Position<String> Carrot = tree.addChild(Veggies, "Carrot");
        Position<String> Potato = tree.addChild(Veggies, "Potato");
        Position<String> Mandarin = tree.addChild(Orange, "Mandarin");
        Position<String> Lemon = tree.addChild(Orange, "Lemon");
        Position<String> Shogun = tree.addChild(Orange, "Shogun");
        Position<String> BabyCarrot = tree.addChild(Carrot, "BabyCarrot");
        System.out.println("Root: " + tree.root().getElement());
        System.out.println("Children of root:");
        tree.printfamilyTree(root, " "," | ");

        System.out.println("Preorder traversal:");
        tree.PreOrder(root, true, " ");
        System.out.println("Postorder traversal:");
        tree.postOrder(root,true," ");
    }
}

