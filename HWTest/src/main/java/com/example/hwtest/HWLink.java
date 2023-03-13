package com.example.hwtest;

import java.util.Scanner;

public class HWLink {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int length = scanner.nextInt();
            ListNode header = new ListNode();
            ListNode temporary = new ListNode();
            int num;
            for (int i = 0; i < length; i++) {
                num = scanner.nextInt();
                ListNode listNode = new ListNode(num, null);
                temporary.next = listNode;
                temporary = listNode;
                if (i == 0) {
                    header = listNode;
                }
            }
            int getnum = scanner.nextInt();
            for (int j = 0; j < (length - getnum); j++) {
                header = header.next;
            }
            System.out.println(header.value);
        }
    }

    static class ListNode {
        int value;
        ListNode next;

        public ListNode() {

        }

        public ListNode(int value, ListNode listNode) {
            this.value = value;
            this.next = listNode;
        }
    }
}
