package cn.hjq.collection;

public class MyLinkedList {
    Node head = null;

    public void add(Object data)
    {
        Node newnode = new Node(data);

        if (head == null)
        {
            head = newnode;
            return;
        }
        Node temp = head;
        while (temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = newnode;
    }

    public int length()
    {
        int num = 0;
        Node temp = head;
        while (temp != null)
        {
            num++;
            temp = temp.next;
        }
        return num;
    }

    public void delet(int index)
    {
        if (index < 1 || index > length())
        {
            System.out.println("无此节点");
        }
        else if (index == 1)
        {
            head = head.next;
        }
        else
        {
            Node temp = head;
            Node last = temp.next;
            int i = 2;
            while(last != null){
                if (i == index){
                    temp.next = last.next;
                }else{
                temp = temp.next;
                last = last.next;
                }
                i++;
            }
        }
    }

    public void print()
    {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList a = new MyLinkedList();
        a.add(123);
        a.add(456);
        a.add(789);
        a.add(111);
        a.print();
        System.out.println(a.length());

        a.delet(4);
        a.print();
    }
}
