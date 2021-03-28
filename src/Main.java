import DataStructure.BST;

public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        bst.add(10);
        bst.add(12);
        bst.add(8);
        bst.add(4);
        bst.add(9);
        bst.add(11);
        bst.add(15);
        bst.removeValue(12);
        bst.levelOrder();
    }
}
