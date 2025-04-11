package com.keyin.visual_binary_search_tree_backend;

import com.keyin.visual_binary_search_tree_backend.model.Node;
import com.keyin.visual_binary_search_tree_backend.service.TreeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class VisualBinarySearchTreeBackendApplicationTests {

	@Autowired
	private TreeService treeService;

	@Test
	void contextLoads() {
	}

	@Test
	void testBuildTree_ReturnsCorrectRoot() {
		List<Integer> input = List.of(5,3,7);
		Node root = treeService.buildBinarySearchTree(input);

		assertEquals(5, root.getValue());
		assertEquals(3, root.getLeft().getValue());
		assertEquals(7, root.getRight().getValue());
	}

	@Test
	void testBuildTreeWithEmptyInput_ReturnsNull() {
		List<Integer> input = List.of();
		Node root = treeService.buildBinarySearchTree(input);

		assertNull(root);
	}

	@Test
	void testLeftHeavyTreeStructure_ReturnsNullRight() {
		List<Integer> input = List.of(5,4,3);
		Node root = treeService.buildBinarySearchTree(input);

		assertEquals(5, root.getValue());
		assertEquals(4, root.getLeft().getValue());
		assertEquals(3, root.getLeft().getLeft().getValue());
		assertNull(root.getRight());
	}

}
