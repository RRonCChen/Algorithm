package binaryTree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BinaryTree {
    private Node root;

    public void addNode(Node node) {
        this.root = addNode(this.root, node);
    }

    private Node addNode(Node rootNode, Node node) {
        if (rootNode == null) {
            rootNode = node;
        } else {
            if (rootNode.getValue() >= node.getValue()) {
                if (rootNode.getLeft() == null) {
                    rootNode.setLeft(node);
                } else {
                    addNode(rootNode.getLeft(), node);
                }
            } else {
                if (rootNode.getRight() == null) {
                    rootNode.setRight(node);
                } else {
                    addNode(rootNode.getRight(), node);
                }
            }
        }
        return rootNode;
    }

    public List<Node> getPreorderTraversalList() {
        var result = new ArrayList<Node>();
        preorder(result, this.root);
        return result;
    }

    private void preorder(List<Node> list, Node node) {
        if (node != null) {
            list.add(node);
            preorder(list, node.getLeft());
            preorder(list, node.getRight());
        }
    }

    public List<Node> getInorderTraversalList() {
        var result = new ArrayList<Node>();
        inorder(result, this.root);
        return result;
    }

    private void inorder(List<Node> list, Node node) {
        if (node != null) {
            preorder(list, node.getLeft());
            list.add(node);
            preorder(list, node.getRight());
        }
    }

    public List<Node> getPostorderTraversalList() {
        var result = new ArrayList<Node>();
        postorder(result, this.root);
        return result;
    }

    private void postorder(List<Node> list, Node node) {
        if (node != null) {
            preorder(list, node.getLeft());
            preorder(list, node.getRight());
            list.add(node);
        }
    }

    public List<Node> getLevelOrderTraversalList() {
        var result = new ArrayList<Node>();
        var queue = new LinkedList<Node>();

        queue.add(this.root);

        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            if (tempNode.getLeft() != null) {
                queue.add(tempNode.getLeft());
            }
            if (tempNode.getRight() != null) {
                queue.add(tempNode.getRight());
            }
            result.add(tempNode);
        }

        return result;
    }
}
