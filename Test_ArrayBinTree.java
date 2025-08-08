public class Test_ArrayBinTree {
    public static void main(String[] args) {
        ArrayBinaryTree<String> tree = new ArrayBinaryTree<>(20);

        tree.add("Root");
        tree.add("Fruit");
        tree.add("Veggies");
        tree.add("Orange");
        tree.add("Apple");
        tree.add("Carrot");
        tree.add("Potato");     
        tree.add("Mandarin");
        tree.add("Lemon");
        tree.add("Shogun");
        tree.add("Pinkapple");
        tree.add("BabyCarrot");
        System.out.println("Size of tree: " + tree.size());
        System.out.println("Is tree empty? " + tree.isEmpty());
        tree.PrintInOrder(0);
    }
}
