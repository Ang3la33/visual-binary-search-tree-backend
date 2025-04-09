package com.keyin.visual_binary_search_tree_backend.model;

public class BinarySearchTree {

    private Node root;

    public void insert(int value) {
        if (root == null) {
            root = new Node(value,null,null);
            return;
        }

        Node current = root;

        while (true) {
            if (value < current.getValue()) {
                if (current.getLeft() == null) {
                    current.setLeft(new Node(value,null,null));
                    break;
                }
                current = current.getLeft();
            }
            else if (value > current.getValue()) {
                if (current.getRight() == null) {
                    current.setRight(new Node(value,null,null));
                    break;
                }
                current = current.getRight();
            }

            else { // Ignore duplicate numbers
                break;
            }
        }
    }

    public Node getRoot() {
        return root;
    }
}
