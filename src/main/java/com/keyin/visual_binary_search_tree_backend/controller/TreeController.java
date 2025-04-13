package com.keyin.visual_binary_search_tree_backend.controller;

import com.keyin.visual_binary_search_tree_backend.model.Node;
import com.keyin.visual_binary_search_tree_backend.model.TreeData;
import com.keyin.visual_binary_search_tree_backend.service.TreeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/trees")
public class TreeController {

    private final TreeService treeService;

    public TreeController(TreeService treeService) {
        this.treeService = treeService;
    }

    @PostMapping("/process-numbers")
    public ResponseEntity<Node> processNumbers(
            @RequestBody List<Integer> numbers,
            @RequestParam(defaultValue = "false") boolean balanced
    ) {
        Node root = balanced
                ? treeService.buildBalancedBST(numbers)
                : treeService.buildBinarySearchTree(numbers);
        return ResponseEntity.ok(root);
    }

    @GetMapping("/previous-trees")
    public ResponseEntity<List<TreeData>> getPreviousTrees() {
        List<TreeData> trees = treeService.getAllTrees();
        return ResponseEntity.ok(trees);
    }

}
