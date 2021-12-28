package day18;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    Node root;

    public void create(String pair) {
        root = new Node(null);
        root = addRecursive(root, pair);
    }

    private Node addRecursive(Node current, String pairString) {
        if(pairString.matches("-?\\d+")){
            return new Node(Integer.parseInt(pairString));
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
            Node left = new Node(null);
            Node right = new Node(null);
            current.left = addRecursive(left, leftSide);
            current.right = addRecursive(right, rightSide);
        }


        if (current == null) {
            return new Node(Integer.parseInt(pairString));
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

//    public boolean explode(Node node, int level) {
//        if(node==null)
//            return false;
//        if(node.left == null){
//            return false;
//        }
//        if(node.right == null){
//            return false;
//        }
//        if(node.left.value !=null && node.right.value != null){
//
//            if(level == 5) {
//                System.out.println("level 4: " + node.left.value + " " + node.right.value);
//                return false;
//            }
//            else
//                return false;
//        }
//        else{
//            return (explode(node.left, level+1) || explode(node.right,level+1));
//        }
//    }

    public int explode(Node node, int level, int left) {
        if (level == 4) {
            int nLeft, nRight;
            if (node.left.value == null) {
                nLeft = node.left.left.value;
                nRight = node.left.right.value;
                node.left.left = null;
                node.left.right = null;
                if (left == 0) {
                    node.left.value = 0;
                } else {
                    node.left.value = left + nLeft;
                }
                return nRight;
            }
            if (node.right.value == null) {
                nLeft = node.right.left.value;
                nRight = node.right.right.value;
                node.right.left = null;
                node.right.right = null;
                if (left == 0) {
                    node.left.value = 0;
                }
                return nRight;
            }
        }
        return -1;
    }

    public boolean pair(Node node) {
        return false;
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
            Node root = new Node(null);
            this.root = addRecursive(root,pairString);
        }
        else{
            Node newRoot = new Node(null);
            newRoot.left = this.root;
            newRoot.right = addRecursive(newRoot,pairString);
            this.root = newRoot;
        }
    }

    class Node {
        Integer value;
        Node left;
        Node right;

        Node(Integer value) {
            this.value = value;
            right = null;
            left = null;
        }
    }
}
