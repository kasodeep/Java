package BinarySearchTrees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Added Utility Class to create a binary tree to check and test other codes.
 */
public class Construct {
    public static Node construct(String[] arr){
        int x = Integer.parseInt(arr[0]);
        int n = arr.length;

        Node root = new Node(x);
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int i = 1;
        while(i < n - 1){
            Node temp = q.remove();
            Node left = new Node(10);
            Node right = new Node(10);
            if(arr[i].equals("")){
                left = null;
            } else{
                left.val = Integer.parseInt(arr[i]);
                q.add(left);
            }

            if(arr[i + 1].equals("")){
                right = null;
            }else{
                 right.val = Integer.parseInt(arr[i + 1]);
                q.add(right);
            }

            temp.left = left;
            temp.right = right;
            i += 2;
        }
         return root;
    }

    public static void main(String[] args) {

    }
}
