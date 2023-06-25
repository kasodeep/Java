package BinarySearchTrees;

public class ListToBST {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static Node helper(int[] arr, int low, int high) {
        if (low > high) return null;
        int mid = (low + high) / 2;

        Node root = new Node(arr[mid]);
        root.left = helper(arr, low, mid - 1);
        root.right = helper(arr, mid + 1, high);
        return root;
    }

    public static Node sortedListToBST(ListNode head) {
        ListNode temp = head;
        int n = 0;
        while (temp != null) {
            n++;
            temp = temp.next;
        }

        int[] nums = new int[n];
        int i = 0;
        temp = head;
        while (temp != null) {
            nums[i++] = temp.val;
            temp = temp.next;
        }
        return helper(nums, 0, n - 1);
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(10);
        Node root = sortedListToBST(node);
        System.out.println(root.val);
    }
}
