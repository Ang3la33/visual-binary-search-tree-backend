package com.keyin.visual_binary_search_tree_backend.service;

import com.keyin.visual_binary_search_tree_backend.model.BinarySearchTree;
import com.keyin.visual_binary_search_tree_backend.model.Node;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeService {

    public Node buildBinarySearchTree(List<Integer> numbers) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insertAll(numbers);
        return bst.getRoot();
    }
}
