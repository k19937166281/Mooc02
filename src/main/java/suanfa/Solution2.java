package suanfa;


public class Solution2 {
//看到数字的加减就要想到  超出 long 位的 加减    123456789123456789123456789 -  987   妈的有点烦
    public static void main(String[] args) {
        Solution2 solution = new Solution2();


        ListNode listNode = new ListNode(1
                );

        ListNode listNode2 = new ListNode(9
                ,new ListNode(9
                ,new ListNode(1)));

        solution.addTwoNumbers(listNode,listNode2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //元 除 余
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }

//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        return dfs(l1, l2, 0);
//    }
//    //元  除  余
//    ListNode dfs(ListNode l, ListNode r, int i) {
//        if (l == null && r == null && i == 0) return null;
//        int sum = (l != null ? l.val : 0) + (r != null ? r.val : 0) + i;
//        var node = new ListNode(sum % 10);
//        node.next = dfs(l != null ? l.next : null, r != null ? r.next : null, sum / 10);
//        return node;
//    }



//    public  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode temp1 = l1;
//        ListNode temp2 = l2;
//        int i = 0;
//        int nodeVal = l1.val+l2.val;
//        if (nodeVal>9){
//            i = 1;
//            nodeVal -= 10;
//        }
//        ListNode result = new ListNode(nodeVal);
//        ListNode tempNext = null;
//        int first = 0;
//        while (temp1.next!=null&&temp2.next!=null){
//            temp1 = temp1.next;
//            temp2 = temp2.next;
//            nodeVal = temp1.val+temp2.val+i;
//            if (nodeVal>9){
//                i = 1;
//                nodeVal -= 10;
//            }else{
//                i = 0;
//            }
//            if(first==0) {
//                result.next = new ListNode(nodeVal);
//                tempNext = result.next;
//            }else{
//                tempNext.next = new ListNode(nodeVal);
//                tempNext = tempNext.next;
//            }
//            first++;
//        }
//        if (tempNext==null){
//            tempNext = result;
//        }
//        ListNode temp = temp1.next==null?temp2:temp1;
//        while(temp.next!=null){
//            temp = temp.next;
//            nodeVal = temp.val+i;
//            if (nodeVal>9){
//                i = 1;
//                nodeVal -= 10;
//            }else{
//                i = 0;
//            }
//            tempNext.next = new ListNode(nodeVal);
//            tempNext = tempNext.next;
//        }
//        if (i==1){
//            tempNext.next = new ListNode(i);
//        }
//        return result;
//    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
