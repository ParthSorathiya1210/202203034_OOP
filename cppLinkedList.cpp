#include <iostream>
using namespace std;

class Node
{
public:
    int data;
    Node *next;

    Node(int data)
    {
        this->data = data;
        this->next = NULL;
    }
};

class LinkedList
{
public:
    Node *head = NULL;
    Node *temp = NULL;
    int size = 0;

    void create(int data)
    {
        Node *newNode = new Node(data);
        if (head == NULL)
        {
            head = temp = newNode;
        }
        else
        {
            temp->next = newNode;
            temp = newNode;
        }
        size++;
    }

    void display()
    {
        temp = head;
        while (temp != NULL)
        {
            cout << temp->data << " ";
            temp = temp->next;
        }
        cout << endl;
    }

    void insertBegin(int data)
    {
        Node *newNode = new Node(data);
        if (head == NULL)
        {
            head = newNode;
        }
        else
        {
            newNode->next = head;
            head = newNode;
        }
        size++;
    }

    void insertEnd(int data)
    {
        Node *newNode = new Node(data);
        if (head == NULL)
        {
            head = newNode;
        }
        else
        {
            temp = head;
            while (temp->next != NULL)
            {
                temp = temp->next;
            }
            temp->next = newNode;
        }
        size++;
    }

    void insertPosition(int data, int pos)
    {
        if (pos == 1)
            insertBegin(data);
        else if (pos <= size + 1)
        {
            temp = head;
            int i = 2;
            while (i < pos)
            {
                temp = temp->next;
                i++;
            }
            if (temp == NULL)
            {
                insertEnd(data);
            }
            else
            {
                Node *newNode = new Node(data);
                newNode->next = temp->next;
                temp->next = newNode;
                size++;
            }
        }
        else
        {
            cout << "invalid Position" << endl;
        }
    }

    void deleteBegin()
    {
        if (head == NULL)
        {
            cout << "LinkedList is empty" << endl;
        }
        else
        {
            temp = head;
            head = head->next;
            cout << "deleted : " << temp->data << endl;
            delete(temp);
            size--;
        }
    }

    void deleteEnd()
    {
        if (head == NULL)
        {
            cout << "LinkedList is empty" << endl;
        }
        else if (head->next == NULL)
        {
            temp = head;
            head = NULL;
            cout << "deleted : " << temp->data << endl;
            delete(temp);
            size--;
        }
        else
        {
            temp = head;
            Node *preTemp = NULL;
            while (temp->next != NULL)
            {
                preTemp = temp;
                temp = temp->next;
            }
            preTemp->next = NULL;
            cout << "deleted : " << temp->data << endl;
            delete(temp);
            size--;
        }
    }

    void deletePosition(int pos)
    {
        if (pos == 1)
        {
            deleteBegin();
        }
        else if (pos <= size)
        {
            int i = 1;
            temp = head;
            Node *PreTemp = NULL;
            while (i < pos)
            {
                PreTemp = temp;
                temp = temp->next;
                i++;
            }
            if (temp == NULL)
            {
                deleteEnd();
            }
            else
            {
                PreTemp->next = temp->next;
                cout << "deleted : " << temp->data << endl;
                delete(temp);
                size--;
            }
        }
        else
        {
            cout << "invalid Position" << endl;
        }
    }
};

int main()
{
    LinkedList List1;
    cout<<"Create the Linked List :-"<<endl;
    for (int i = 1; i < 7; i++)
    {
        List1.create(i);
        cout << "inserted : " << i << endl;
    }
    List1.display();
    List1.insertPosition(7, 7);
    List1.display();
    List1.insertPosition(0, 1);
    List1.display();
    List1.insertPosition(1001, 3);
    List1.display();
    List1.deletePosition(9);
    List1.display();
    List1.deletePosition(3);
    List1.display();
    List1.deletePosition(1);
    List1.display();
}