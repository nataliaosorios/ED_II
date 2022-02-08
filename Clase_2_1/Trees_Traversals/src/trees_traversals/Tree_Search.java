/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees_traversals;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author racedo
 */
public class Tree_Search {

     public static class Nodes{
        String data;
        Nodes left;
        Nodes right;
        
        public Nodes(String data){
            //Constructor
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
     
     
    public Nodes root;
    public static boolean Level_search(Nodes root, String value){
        if (root == null){
            return false;
        }
        // Vamos a crear nuestra cola
        Queue<Nodes> q = new LinkedList<Nodes>();
        // Agregamos la raiz a la cola
        q.add(root);
        // Mientras que la cola sea distinto de vacio
        // es decir mientras tengamos objetos de tipo Nodo HAGA
        while(q.size() > 0){
            Nodes current_node = q.poll();
            if (current_node.data == value) return true;
            if (current_node.left != null)  q.add(current_node.left);
            if (current_node.right != null)  q.add(current_node.right);
        }
        return false;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Tree_Search tree = new Tree_Search();
        tree.root = new Nodes("A");
        tree.root.left = new Nodes("B");
        tree.root.right = new Nodes("C");
        tree.root.left.left = new Nodes("D");
        tree.root.left.right = new Nodes("E");
        tree.root.right.left = new Nodes("F");
        
        System.out.println(tree.Level_search(tree.root, "A")?
                "El valor esta en arbol\n":"El valor no esta en el arbol\n");
    }
    
}
