package day18;

import java.util.*;

public class BinaryTree {

    Node root;

    public void create(String pair) {
        root = new Node(null, null);
        root = addRecursive(root, pair);
    }

    private Node addRecursive(Node current, String pairString) {
        if(pairString.matches("-?\\d+")){
            return new Node(Integer.parseInt(pairString), current);
        }
        else {
            int brackets = 0;
            String leftSide = "", rightSide = "";
            for (int i = 1; i < pairString.length(); i++) {
                if (pairString.charAt(i) == '[') {
                    brackets++;
                }
                if (pairString.charAt(i) == ']') {
                    brackets--;
                }
                if (pairString.charAt(i) == ',' && brackets == 0) {
                    leftSide = pairString.substring(1, i);
                    rightSide = pairString.substring(i+1, pairString.length()-1);
                    break;
                }
            }
//            System.out.println(leftSide);
//            System.out.println(rightSide);
            Node left = new Node(null, current);
            Node right = new Node(null, current);
            current.left = addRecursive(left, leftSide);
            current.right = addRecursive(right, rightSide);
        }


        if (current == null) {
            return new Node(Integer.parseInt(pairString), null);
        }

        return current;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int getSize() {
        return getSizeRecursive(root);
    }

    private int getSizeRecursive(Node current) {
        return current == null ? 0 : getSizeRecursive(current.left) + 1 + getSizeRecursive(current.right);
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }

        if (value == current.value) {
            return true;
        }

        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            // Case 1: no children
            if (current.left == null && current.right == null) {
                return null;
            }

            // Case 2: only 1 child
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }

            // Case 3: 2 children
            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }

        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private int findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    private Node findClosestLeftValueNode(Node child) {
        List<Node> nodeOrder = nodeList(this.root);

        Node returnNode = null;
        if(nodeOrder.indexOf(child) > 0)
          returnNode = nodeOrder.get(nodeOrder.indexOf(child) - 1);
        if (returnNode != null) {
            return returnNode;
        } else
            return null;
    }
//        if(child.parent == null){
//            return null;
//        }
//        if(child.parent.left.value != null){
//            return child.parent;
//        }
//        else{
//            return findClosestLeftValueNode(child.parent);
//        }
//    }

    private Node findClosestRightValueNode(Node child) {
        List<Node> nodeOrder = nodeList(this.root);
//        for (Node node:nodeOrder
//             ) {
//            System.out.print(node.value+" ");
//        }
//        System.out.println();
        Node returnNode = null;
        if(nodeOrder.indexOf(child)+1 < nodeOrder.size())
            returnNode = nodeOrder.get(nodeOrder.indexOf(child) + 1);
        if (returnNode != null) {
            return returnNode;
        } else
            return null;
    }
//        if(child.parent == null){
//            if(child.right.value == null){
//                return findClosestLeftDownValueNode(child.right);
//            }
//            else
//                return null;
//        }
//        if(child.parent.right.value != null){
//            return child.parent.right;
//        }
//        else{
//            return findClosestRightValueNode(child.parent);
//        }
//    }
//
//    private Node findClosestLeftDownValueNode(Node child){
//        if(child.left.value != null){
//            return child.left;
//        }
//        else{
//            return findClosestLeftDownValueNode(child.right);
//        }
//    }

    public boolean explode(Node node, int level) {

        if (level == 4) {
            if(node == null) {
                return false;
            }

            if(node.left == null || node.right == null){
                return false;
            }
            int nLeft, nRight;
            if (node.left.value == null) {
                nLeft = node.left.left.value;
                nRight = node.left.right.value;
//                node.left.left = null;
//                node.left.right = null;

                //Left
                Node leftNode = findClosestLeftValueNode(node.left.left);
                if (leftNode != null)  {
                    leftNode.value = leftNode.value + nLeft;
                }

                //Right
                Node rightNode = null;
//                if(node.right.value != null){
//                    rightNode = node;
//                }
//                else {
                    rightNode = findClosestRightValueNode(node.left.right);
//                    rightNode = findClosestLeftValueNode(node);
//                }
                if (rightNode != null) {
                    rightNode.value = rightNode.value + nRight;
                }

                //Replace left node with 0 regular number node
                node.left.left = null;
                node.left.right = null;
                node.left.value = 0;

                return true;
            }
            if (node.right.value == null) {
                nLeft = node.right.left.value;
                nRight = node.right.right.value;
//                node.right.left = null;
//                node.right.right = null;

                //Left
                Node leftNode = null;
//                if(node.left.value != null){
//                    leftNode = node;
//                }
//                else {
                    leftNode = findClosestLeftValueNode(node.right.left);
//                }
                if (leftNode != null) {
                    leftNode.value = leftNode.value + nLeft;
                }

                //Right
                Node rightNode = findClosestRightValueNode(node.right.right);
                if (rightNode != null)  {
                    rightNode.value = rightNode.value + nRight;
                }

                //Replace right node with 0 regular number node
                node.right.left = null;
                node.right.right = null;
                node.right.value = 0;

                return true;
            }
            return false;
        }
        else{
            if(node != null) {
                level++;
                return (explode(node.left, level) || explode(node.right, level));
            }
            else{
                return false;
            }
        }
    }

    public boolean split(Node node) {
        if(node == null)
            return false;
        if(node.value != null && node.value > 9){
            int highValue = node.value;
            int leftValue = highValue / 2;
            int rightValue =highValue / 2;
            if(Math.floorMod(highValue, 2) > 0)
                rightValue++;
            Node rightNode = new Node(rightValue,node);
            Node leftNode = new Node(leftValue,node);
            node.value = null;
            node.left = leftNode;
            node.right = rightNode;
           // System.out.println("Original: " + highValue +" Left split: " + leftValue + " Right split: "+rightValue);
            return true;
        }
        return (split(node.left) || split(node.right));

    }

    private List<Node> nodeList(Node node){
        List<Node> nodeOrder = new ArrayList<>();
        if(node != null) {
            if (node.value == null) {
               nodeOrder.addAll(nodeList(node.left));
               nodeOrder.addAll(nodeList(node.right));
            }
            else{
                nodeOrder.add(node);
            }
        }
        return nodeOrder;

    }

    public long magnitude(Node node){
        long magnitude = 0;
        if(node != null){
            if(node.value == null){
                magnitude = magnitude + (3*magnitude(node.left));
                magnitude = magnitude + (2*magnitude(node.right));
            }
            else{
                magnitude = magnitude + node.value;
            }
        }
        return magnitude;
    }

    public String traverseInOrder(Node node) {
        String returnString = "";
        if (node != null) {
            if(node.value == null) {
                returnString = returnString +"[";
                returnString = returnString + traverseInOrder(node.left);
                returnString = returnString +",";
                returnString = returnString + traverseInOrder(node.right);
                returnString = returnString +"]";
            }
            else {
                returnString = returnString +""+node.value;
            }
        }
        return  returnString;

//        if (node != null) {
//            traverseInOrder(node.left);
//            if(node.value != null)
//                visit(node.value);
//            traverseInOrder(node.right);
//        }
    }

    public void traversePreOrder(Node node) {
        if (node != null) {
            visit(node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            visit(node.value);
        }
    }

    public void traverseLevelOrder() {
        if (root == null) {
            return;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {

            Node node = nodes.remove();

            System.out.print(" " + node.value);

            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right != null) {
                nodes.add(node.right);
            }
        }
    }

    public void traverseInOrderWithoutRecursion() {
        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            Node top = stack.pop();
            visit(top.value);
            current = top.right;
        }
    }

    public void traversePreOrderWithoutRecursion() {
        Stack<Node> stack = new Stack<>();
        Node current = root;
        stack.push(root);

        while (current != null && !stack.isEmpty()) {
            current = stack.pop();
            visit(current.value);

            if (current.right != null)
                stack.push(current.right);

            if (current.left != null)
                stack.push(current.left);
        }
    }

    public void traversePostOrderWithoutRecursion() {
        Stack<Node> stack = new Stack<>();
        Node prev = root;
        Node current = root;
        stack.push(root);

        while (current != null && !stack.isEmpty()) {
            current = stack.peek();
            boolean hasChild = (current.left != null || current.right != null);
            boolean isPrevLastChild = (prev == current.right || (prev == current.left && current.right == null));

            if (!hasChild || isPrevLastChild) {
                current = stack.pop();
                visit(current.value);
                prev = current;
            } else {
                if (current.right != null) {
                    stack.push(current.right);
                }
                if (current.left != null) {
                    stack.push(current.left);
                }
            }
        }
    }

    private void visit(int value) {
        System.out.print(value);
    }
    public void add(String pairString){
        if(this.root == null){
            Node root = new Node(null, null);
            this.root = addRecursive(root,pairString);
        }
        else{
            Node newRoot = new Node(null, null);
            newRoot.left = this.root;
            newRoot.right = addRecursive(newRoot,pairString);
            this.root = newRoot;
        }
    }

    class Node {
        Integer value;
        Node left;
        Node right;
        Node parent;

        Node(Integer value, Node parent) {
            this.value = value;
            right = null;
            left = null;
            this.parent = parent;
        }
    }
}
