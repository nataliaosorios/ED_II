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
public class Trees_Traversals {

    public static class Node{
        String data;
        Node left;
        Node right;
        
        public Node(String data){
            //Constructor
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    public Node root;
    

    
    
    // Escribir raiz, se va a subarbol IZQ, se va a subarbol DER
    public void printPreOrden(Node node){
        if (node == null){
            return;
        }
        // Escribir raiz
        System.out.print(node.data + " ");
        
        // Dirigirse al sub arbol IZQ
        printPreOrden(node.left);
        
        // Dirigirse al sub arbol DER
        printPreOrden(node.right);
    }
    // se va a subarbol IZQ, Escribir raiz,  se va a subarbol DER
    public void printInOrden(Node node){
        if (node == null){
            return;
        }
    
        // Dirigirse al sub arbol IZQ
        printInOrden(node.left);
        // Escribir raiz
        System.out.print(node.data + " ");
        // Dirigirse al sub arbol DER
        printInOrden(node.right);
    }
    
    
    // se va a subarbol IZQ, se va a subarbol DER, Escribir raiz
    public void printPostOrden(Node node){
        if (node == null){
            return;
        }
        // Dirigirse al sub arbol IZQ
        printPostOrden(node.left);
        
        // Dirigirse al sub arbol DER
        printPostOrden(node.right);
        
        // Escribir raiz
        System.out.print(node.data + " ");
    }
    
    
    /*
        Por nivel
        1. Guardar en una cola el nodo actual
        2. Se saca de la cola y escribimos la informacion del nodo
        3. Nos movemos al hijo IZQ y si es distinto de nulo guardamos el nodo
            en la cola
        4. Nos movemos al hijo DER y si es distinto de nulo guardamos el nodo
            en la cola
        5. Repetimos proceso desde el paso 2 hasta que la COLA este vacia
    */
    
    public void Level_traversal(Node root){
        if (root == null){
            return;
        }
        // Vamos a crear nuestra cola
        Queue<Node> q = new LinkedList<Node>();
        // Agregamos la raiz a la cola
        q.add(root);
        // Mientras que la cola sea distinto de vacio
        // es decir mientras tengamos objetos de tipo Nodo HAGA
        while(q.size() > 0){
            Node current_node = q.poll();
            System.out.print(current_node.data + " ");
            if (current_node.left != null)  q.add(current_node.left);
            if (current_node.right != null)  q.add(current_node.right);
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Trees_Traversals tree = new Trees_Traversals();
        tree.root = new Node("A");
        tree.root.left = new Node("B");
        tree.root.right = new Node("C");
        tree.root.left.left = new Node("D");
        tree.root.left.right = new Node("E");
        tree.root.right.left = new Node("F");
        System.out.println("Preorden es");
        tree.printPreOrden(tree.root);
        System.out.print("\n");
        System.out.println("Inorden es");
        tree.printInOrden(tree.root);
        System.out.print("\n");
        System.out.println("Postorden es");
        tree.printPostOrden(tree.root);
         System.out.print("\n");
        System.out.println("Level es");
        tree.printPostOrden(tree.root);
        System.out.print("\n");

    }
    
}
