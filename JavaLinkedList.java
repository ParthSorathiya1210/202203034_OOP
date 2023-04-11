package Java.Lab_4;
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
}

public class JavaLinkedList {
    public static void main(String args[])
    {
        Scanner ip = new Scanner(System.in);
        System.out.println("Create the Linked List :-");
        // System.out.print("enter 1 for new node else 0 : ");
        // int n = ip.nextInt();
        linkedList List1 = new linkedList();
        // while(n != 0)
        // {
        //     System.out.print("enter the data of new node : ");
        //     int data = ip.nextInt();
        //     List1.create(data);
        //     System.out.print("enter 1 for new node else 0 : ");
        //     n = ip.nextInt();
        // }
        for(int i = 1; i < 7; i++)
        {
            List1.create(i);
            System.out.println("inserted : "+i);
        }
        List1.display();
        List1.insertPosition(7,7);
        List1.display();
        List1.insertPosition(0,1);
        List1.display();
        List1.insertPosition(1001,3);
        List1.display();
        List1.deletePosition(9);
        List1.display();
        List1.deletePosition(3);
        List1.display();
        List1.deletePosition(1);
        List1.display();
    }
}
