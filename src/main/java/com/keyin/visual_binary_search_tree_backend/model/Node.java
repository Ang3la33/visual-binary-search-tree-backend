package com.keyin.visual_binary_search_tree_backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Node {
    private int value;
    private Node left;
    private Node right;
}
