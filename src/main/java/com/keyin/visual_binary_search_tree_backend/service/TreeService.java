package com.keyin.visual_binary_search_tree_backend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.keyin.visual_binary_search_tree_backend.model.BinarySearchTree;
import com.keyin.visual_binary_search_tree_backend.model.Node;
import com.keyin.visual_binary_search_tree_backend.model.TreeData;
import com.keyin.visual_binary_search_tree_backend.repository.TreeDataRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TreeService {

    private final TreeDataRepository treeDataRepository;
    private final ObjectMapper objectMapper;

    public TreeService(TreeDataRepository treeDataRepository, ObjectMapper objectMapper) {
        this.treeDataRepository = treeDataRepository;
        this.objectMapper = objectMapper;
    }

    public Node buildBinarySearchTree(List<Integer> numbers) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insertAll(numbers);
        Node root = bst.getRoot();

        try {
            TreeData treeData = new TreeData();
            treeData.setInputNumbers(numbers.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(",")));
            treeData.setTreeJson(objectMapper.writeValueAsString(root));
            treeData.setCreatedAt(LocalDateTime.now());

            // Save to database
            treeDataRepository.save(treeData);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return root;
    }

    public List<TreeData> getAllTrees() {
        return treeDataRepository.findAll();
    }

    private Node buildBalancedBST(List<Integer> sortedNumbers, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node node = new Node(sortedNumbers.get(mid));
        node.setLeft(buildBalancedBST(sortedNumbers, start, mid - 1));
        node.setRight(buildBalancedBST(sortedNumbers, mid + 1, end));
        return node;
    }

    public Node buildBalancedBST(List<Integer> numbers) {
        List<Integer> sortedNumbers = numbers.stream().sorted().toList();
        Node root = buildBalancedBST(sortedNumbers, 0, sortedNumbers.size() - 1);

        try {
            TreeData treeData = new TreeData();
            treeData.setInputNumbers(numbers.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(",")));
            treeData.setTreeJson(objectMapper.writeValueAsString(root));
            treeData.setCreatedAt(LocalDateTime.now());

            treeDataRepository.save(treeData);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return root;
    }

}
