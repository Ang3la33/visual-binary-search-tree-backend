package com.keyin.visual_binary_search_tree_backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class TreeData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String inputNumbers;

    @Lob
    private String treeJson;

    private LocalDateTime createdAt;
}
