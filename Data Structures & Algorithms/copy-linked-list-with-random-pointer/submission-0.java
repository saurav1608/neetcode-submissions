/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        //hashmap to keep original node and the copy
        HashMap<Node, Node> map = new HashMap<>();
        map.put(null, null);

        //populate map with nodes from original and a copy
        Node curr = head;
        while(curr != null) {
            Node copy = new Node(curr.val);
            map.put(curr, copy);
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            Node currentCopy = map.get(curr);
            currentCopy.next = map.get(curr.next);
            currentCopy.random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);    
    }
}
