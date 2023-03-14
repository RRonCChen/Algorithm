package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BinaryTreeMain {

    public static void main(String[] args) {
        var binaryTree = new BinaryTree();
        binaryTree.addNode(new Node().setValue(1));
        binaryTree.addNode(new Node().setValue(0));
        binaryTree.addNode(new Node().setValue(2));

        printNodeList(binaryTree.getPreorderTraversalList());   //  1, 0, 2
        printNodeList(binaryTree.getInorderTraversalList());    //  0, 1, 2
        printNodeList(binaryTree.getPostorderTraversalList());  //  0, 2, 1
        printNodeList(binaryTree.getLevelOrderTraversalList()); //  1, 0, 2
    }

    public static void printNodeList(List<Node> list) {
        list = Optional.ofNullable(list).orElseGet(ArrayList::new);
        list.stream().map(Node::getValue).forEach(v -> System.out.printf("%d ", v));
        System.out.println();
    }
}
