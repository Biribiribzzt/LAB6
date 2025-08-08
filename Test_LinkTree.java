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
        tree.printfamilyTree(root, " ");
        tree.PreOrder(root, true, " ");
        tree.PostOrder(Potato, true, " ");

        Iterable<Position<String>> positions = tree.positions();
        for (Position<String> pos : positions) {
            System.out.println("Position: " + pos.getElement());
        }
        System.out.println("Family tree before removal:");
        tree.printfamilyTree(root, " ");
        positions = tree.positions();
        for (Position<String> pos : positions) {
            if (pos.getElement().equals("Mandarin")) {
                tree.remove(pos);
                System.out.println("Removed: " + pos.getElement());
                break;
            }
        }
        System.out.println("Family tree after removal:");
        tree.printfamilyTree(root, " "," | ");
    }
}

