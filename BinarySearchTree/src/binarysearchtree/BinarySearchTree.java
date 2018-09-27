package binarysearchtree;

class Node {

    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        String out = "" + this.data;
        return out;
    }
}

class BinaryTree {

    Node root;
    Boolean isEmpty;
    int nodeCount;

    BinaryTree() {
        isEmpty = true;

    }

    public void add(int item) {
        Node newNode;
        if (root == null) { //make item the root of tree
            root = new Node(item);
        }
        Node runner;
        runner = root;
        boolean added = false;
        while (!added) {
            if (item < runner.data) {
                if (runner.left == null) {
                    runner.left = new Node(item);
                    added = true;
                } else {
                    runner = runner.left;
                }
            }

            if (runner.right == null) {
                runner.right = new Node(item);
                added = true;

            } else {
                runner = runner.right;
            }

        }

    }

    public boolean inTree(Node root, int item) {
        boolean foundIt = false;
        if(root == null){
            return false;
        }
        if(root.data == item){
            return true;
        }
        if(item < root.data){
            inTree(root.left, item);
        }
        if(item > root.data){
            inTree(root.right, item);
        }
        
        

        return foundIt;
    }
    
    public void printTree(Node weHere, int depth, boolean withNulls) {
        //Gives a little graphical view starting with node weHere.

        depth++;
        if (weHere != null) {
            printTree(weHere.right, depth, withNulls);
        }
        {  //Print Current Node
            String nodeData;
            if (weHere != null) {
                nodeData = weHere.toString();
            } else {
                nodeData = "X";
            }
            int numSpaces = depth * 14 - nodeData.length();//adjust if needed
            for (int i = 0; i < numSpaces; i++) {
                System.out.print(" ");
            }
            System.out.println(nodeData);

        }

        if (weHere != null) {
            printTree(weHere.left, depth, withNulls);
        }
    }
     

}

public class BinarySearchTree {

    public static void main(String[] args) {
        BinaryTree myTree = new BinaryTree();
        myTree.add(4);
        myTree.add(2);
        myTree.add(3);
        myTree.add(5);
        System.out.println(myTree.inTree(myTree.root, 6));
        myTree.printTree(myTree.root,1, true);
    }

}