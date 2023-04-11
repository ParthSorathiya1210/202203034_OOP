import java.util.Scanner;
class Node
{
    int data;
    Node next;

    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}

class linkedList
{
    Node head = null;
    Node temp = null;
    int size = 0;
    void create(int data)
    {
        Node newNode = new Node(data);
        if(head == null)
        {
            head = temp = newNode;
        }
        else
        {
            temp.next = newNode;
            temp = newNode;
        }
        size++;
    }
    void display()
    {
        temp = head;
        while(temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    void insertBegin(int data)
    {
        Node newNode = new Node(data);
        if(head == null)
        {
            head = newNode;
        }
        else
        {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    void insertEnd(int data)
    {
        Node newNode = new Node(data);
        if(head == null)
        {
            head = newNode;
        }
        else
        {
            temp = head;
            while(temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }
    void insertPosition(int data,int pos)
    {
        if(pos == 1) insertBegin(data);
        else if(pos<=size+1)
        {
            temp = head;
            int i = 2;
            while(i<pos)
            {
                temp = temp.next;
                i++;
            }
            if(temp == null)
            {
                insertEnd(data);
            }
            else
            {
                Node newNode = new Node(data);
                newNode.next = temp.next;
                temp.next = newNode;
                size++;
            }
        }
        else
        {
            System.out.println("invalid Position");
        }
    }
    void deleteBegin()
    {
        if(head == null)
        {
            System.out.println("LinkedList is empty");
        }
        else
        {
            temp = head;
            head = head.next;
            System.out.println("deleted : "+temp.data);
            size--;
        }
    }
    void deleteEnd()
    {
        if(head == null)
        {
            System.out.println("LinkedList is empty");
        }
        else if(head.next == null)
        {
            temp = head;
            head = null;
            System.out.println("deleted : "+temp.data);
            size--;
        }
        else
        {
            temp = head;
            Node preTemp = null;
            while(temp.next!=null)
            {
                preTemp = temp;
                temp = temp.next;
            }
            preTemp.next = null;
            System.out.println("deleted : "+temp.data);
            size--;
        }       
    }
    void deletePosition(int pos)
    {
        if(pos == 1)
        {
            deleteBegin();
        }
        else if(pos<=size)
        {
            int i = 1;
            temp = head;
            Node PreTemp = null;
            while(i<pos)
            {
                PreTemp = temp;
                temp = temp.next;
                i++;
            }
            if(temp == null)
            {
                deleteEnd();
            }
            else
            {
                PreTemp.next = temp.next;
                System.out.println("deleted : "+temp.data);
                size--;
            }
        }
        else
        {
            System.out.println("invalid Position");
        }
    }

    int search(int data)
    {
        int i = 0;
        temp = head;
        while(temp.next!=null)
        {
            i++;
            if(data == temp.data)
            {
                return i;
            }
            temp = temp.next;
        }
        return 0;
    }
}

public class Q2_Search 
{
    public static void main(String args[])
    {
        Scanner ip = new Scanner(System.in);
        System.out.println("Create the Linked List :-");
        linkedList List1 = new linkedList();
        List1.create(1);
        List1.create(5);
        List1.create(7);
        List1.create(3);
        List1.create(8);
        List1.create(2);
        List1.create(3);
        List1.display();
        int data = 1;
        int idx = List1.search(data);
        if(idx == 0)
        {
            System.out.println("Element is not in the Linklist");
        }
        else
        {
            System.out.println("index of "+data+" is : "+idx);
        }
    }
}