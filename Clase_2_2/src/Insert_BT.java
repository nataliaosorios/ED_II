import java.util.LinkedList;
import java.util.Queue;

public class Insert_BT {
    public static class Node{
        int data;
        Node left;
        Node right;
        
        public Node(int d){
            this.data = d;
            this.left = null;
            this.right = null;
        }
    }
    public Node root;
    public Node temp = root;

    public void insert_node(Node temp, int value){
        if (temp == null){
            root = new Node(value);
            return;
        }

        // Create an empty queue for level traversal
        Queue<Node> q = new LinkedList<Node>();
        q.add(temp);

        // Level order traversal until empty space is found
        while(q.size() > 0){
            temp = q.peek(); // Examine the information that just got out of the queue
            q.remove();      // Remove the information from the queue that we just saw

            if (temp.left == null){
                temp.left = new Node(value);
                break;
            }else
                q.add(temp.left); // left child of temp (current node) is not empty so 
                                  // so we add it to queue
            
            if (temp.right == null){
                temp.right = new Node(value);
                break;
            }else
                q.add(temp.right); // right child of temp (current node) is not empty so 
                                  // so we add it to queue
        }
    }

    public void printInorden(Node node){
        if (node == null)
            return;
        
        printInorden(node.left);

        System.out.print(node.data + " ");

        printInorden(node.right);
    }

    public static void main(String[] args) throws Exception {
        Insert_BT tree = new Insert_BT();
        tree.root = new Node(1);
        tree.root.left = new Node(7);
        tree.root.right = new Node(5);
        tree.root.left.right = new Node(6);
        tree.root.left.right.right = new Node(2);
        tree.root.left.right.left = new Node(11);
        tree.root.right.left = new Node(4);

        System.out.println("Tree before insertion");
        tree.printInorden(tree.root);
        System.out.println("");
        tree.insert_node(tree.root, 12);
        System.out.println("Tree after insertion");
        tree.printInorden(tree.root);
        System.out.println("");
    }
}
