package me.start.Day01;

/**
 * 141. ��������
 * ����һ�������ͷ�ڵ� head ���ж��������Ƿ��л���
 * �����������ĳ���ڵ㣬����ͨ���������� next ָ���ٴε���������д��ڻ���
 * Ϊ�˱�ʾ���������еĻ�������ϵͳ�ڲ�ʹ������ pos
 * ����ʾ����β���ӵ������е�λ�ã������� 0 ��ʼ����
 * ע�⣺pos ����Ϊ�������д��ݡ�������Ϊ�˱�ʶ�����ʵ�������
 * ��������д��ڻ����򷵻� true �� ���򣬷��� false ��
 */
public class LC0060141 {
    class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode l1 = head, l2 = head.next;
        while (l1 != null && l2 != null && l2.next != null) {
            if (l1 == l2) {
                return true;
            }
            l1 = l1.next;
            l2 = l2.next.next;
            // һ��ָ��ÿ���ƶ�һ���ڵ㣬һ��ָ��ÿ���ƶ������ڵ㣬
            // ������ڻ�����ô������ָ��һ��������
            // Ϊʲô������ͷ���ֲ�������Ϊ�����ܲ�������ͷ���г�
            // ���磬0 -> 1 -> 2 -> 1��
            // �����ͻ��г�һ��1-2��
        }
        return false;
    }
}
