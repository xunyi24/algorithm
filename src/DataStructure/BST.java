package DataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class BST<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    public Node root;
    public int size;

    public BST() {
        root = null;
        size = 0;
    }

    public void add(E e) {
        root = addNode(e, root);
    }

    public boolean contains(E e) {
        return contains(e, root);
    }

    public E minimum() {
        if (size == 0) {
            throw new RuntimeException("BST size is 0");
        }

        return getMinimum(root).e;
    }

    public E maximum() {
        if (size == 0) {
            throw new RuntimeException("BST size is 0");
        }

        return getMaximum(root).e;
    }

    public E removeMin() {
       E removeE = minimum();
       removeMin(root);
       return removeE;
    }

    public E removeMax() {
        E removeE = maximum();
        removeMax(root);
        return removeE;
    }

    public E removeValue(E e) {
        root = removeValue(e, root);
        return e;
    }

    public void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void levelOrder() {
        if (root == null) {
            return;
        }

        Queue<Node> eQueue = new LinkedList<>();
        eQueue.offer(root);

        while (!eQueue.isEmpty()) {
            int size = eQueue.size();
            for (int i = 0; i < size; i++) {
                Node node = eQueue.poll();
                System.out.println(node.e);
                if (node.left != null) {
                    eQueue.offer(node.left);
                }
                if (node.right != null) {
                    eQueue.offer(node.right);
                }
            }
        }
    }

    private Node addNode(E e, Node node) {
        if (node == null) {
            size++;
            return new Node(e);
        } else if (e.compareTo(node.e) < 0) {
            node.left = addNode(e, node.left);
        } else if (e.compareTo(node.e) > 0) {
            node.right = addNode(e, node.right);
        }
        return node;
    }

    public boolean contains(E e, Node node) {
        if (node == null) {
            return false;
        } else if (e.compareTo(node.e) < 0) {
            return contains(e, node.left);
        } else if (e.compareTo(node.e) > 0) {
            return contains(e, node.right);
        } else {
            return true;
        }
    }

    private Node getMinimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return getMinimum(node.left);
    }

    private Node getMaximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return getMinimum(node.right);
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            size--;
            return node.right;
        }
        node.left = removeMin(node.left);
        return node;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            size--;
            return node.left;
        }
        node.right = removeMax(node.right);
        return node;
    }

    private Node removeValue(E e, Node node) {
        if (e.compareTo(node.e) == 0) {
            if (node.left == null) {
                size--;
                return node.right;
            } else if (node.right == null) {
                size--;
                return node.left;
            }
            Node newNode = getMinimum(node.right);
            newNode.right = removeMin(node.right);
            newNode.left = node.left;
            return newNode;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = removeValue(e, node.left);
        } else if (e.compareTo(node.e) > 0) {
            node.right = removeValue(e, node.right);
        }
        return node;
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }
}
