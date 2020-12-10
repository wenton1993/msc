package algorithm;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * @author 文通
 * @since 2019/7/15
 */
public class Question2 {

    public static void main(String[] args) {
        ListNode l1 = new Question2.ListNode(2);
        l1.next = new Question2.ListNode(4);
        l1.next.next = new Question2.ListNode(3);
        ListNode l2 = new Question2.ListNode(5);
        l2.next = new Question2.ListNode(6);
        l2.next.next = new Question2.ListNode(4);
        l2.next.next.next = new Question2.ListNode(9);

        ListNode target = new Question2().addTwoNumbers(l1, l2);
        do {
            System.out.println(target.val);
        } while ((target = target.next) != null);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultList = null;
        ListNode currentNode = null;
        int sum = 0;

        do {
            int i = 0;
            int j = 0;

            if (l1 != null) {
                i = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                j = l2.val;
                l2 = l2.next;
            }

            if (sum < 10) {
                sum = i + j;
            } else {
                sum = i + j + 1;
            }

            if (resultList == null) {
                currentNode = new ListNode(sum % 10);
                resultList = currentNode;
            } else {
                currentNode.next = new ListNode(sum % 10);
                currentNode = currentNode.next;
            }

        } while (sum >= 10 || l1 != null || l2 != null);

        return resultList;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
