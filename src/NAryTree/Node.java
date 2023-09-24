package NAryTree;

import java.util.ArrayList;

public class Node {
    int data;

    ArrayList<Node> children = new ArrayList<>();

    Node(int data) {
        this.data = data;
    }
}
