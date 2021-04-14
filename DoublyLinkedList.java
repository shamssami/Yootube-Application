package project1;

public class DoublyLinkedList {

    public DNode header;
    public DNode trailer;
    DoublyLinkedList Next;
    DoublyLinkedList previous;
    String listname = null;

    int size;

    public DoublyLinkedList() {
        header = new DNode();
        trailer = new DNode();
        header.next = trailer;
        trailer.prev = header;
    }
    //////////////////////////////////////

    
   
    //This method add video at the beginning of the list
    public void addFirst(DNode newDNode) {

        DNode pointer = header.next;

        newDNode.next = header.next;
        header.next = newDNode;
        // newDNode.next.prev=newDNode;
        pointer.prev = newDNode;
        newDNode.prev = header;

        size++;
    }
    
    //This method add video at the last of the list
    public void addLast(DNode newDNode) {
        DNode pointer = trailer.prev;

        newDNode.next = trailer;
        // trailer.prev.next=newDNode;
        pointer.next = newDNode;

        newDNode.prev = pointer;
        trailer.prev = newDNode;

        size++;
    }

    public void removeLast() {
        DNode pointer = trailer.prev.prev;
        pointer.next = trailer;
        trailer.prev = pointer;
        size--;
    }
    //This method remove the video at the beginning of the list
    public void removeFirst() {

        DNode pointer = header.next.next;
        pointer.prev = header;
        header.next = pointer;
        size--;

    }
    //This method add video at any index in the list
    public void addDNode(DNode n, int i) {

        DNode pointer = header;
        DNode pNext;

        for (int c = 0; pointer != trailer && c < i; c++) {
            pointer = pointer.next;
        }

        pNext = pointer.next;

        n.next = pointer.next;
        pointer.next = n;
        n.prev = pointer;
        // n.next.prev=n;
        pNext.prev = n;

        size++;

    }
    
    void printList2(DNode node) {
        while (node != null) {
            System.out.println(node.videoTitle + " ");
            node = node.next;
        }
    }

    public void printList() {
        DNode pointer;

        pointer = header.next;

        while (pointer != trailer) {

            System.out.println(pointer.videoTitle);
            pointer = pointer.next;
        }

    }

    void printList(DNode node) {
        DNode ptr = node.next;
        while (ptr.videoTitle != null) {
            System.out.print(ptr.videoTitle + " \n");
            ptr = ptr.next;
        }
    }
    //This method reverse any list
    void reverse() {
        DNode temp = null;
        DNode current = header;

        /* swap next and prev for all nodes of
         doubly linked list */
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        /* Before changing head, check for the cases like
         empty list and list with only one node */
        if (temp != trailer) {
            header = temp.prev;
        }
    }

    void playList() {
        DNode pointer = header.next;

        while (pointer.next != null) {
            System.out.println(pointer.videoTitle + " is running!!");
            for (int i = 1; i <= 3; i++) {
                System.out.println(i + "sec");
            }
            if (pointer.next != null || pointer.videoTitle == null) {
                System.out.println("The end of " + pointer.videoTitle + " video");
                //System.out.println("The next video will run now");
            }
            pointer = pointer.next;
        }
        System.out.println("End of the list :)");

    }

    void playList2() {
        DNode pointer = header.next;

        while (pointer.next != null) {
            System.out.println(pointer.videoTitle);

            pointer = pointer.next;
        }
        System.out.println("End of the list :)");

    }


    void deleteNod(DNode head, DNode del) {
        // Base case
        if (head == null || del == null) {
            return;
        }

        // If node to be deleted is head node
        // Change next only if node to be deleted
        // is NOT the last node
        if (del.next != null) {
            del.next.prev = del.prev;
        }

        // Change prev only if node to be deleted
        // is NOT the first node
        if (del.prev != null) {
            del.prev.next = del.next;
        }

        // Finally, free the memory occupied by del
        return;
    }
    //This method shuffle videos within the same list
    static DNode rearrange(DNode head) {
        if (head == null) // Base case. 
        {
            return null;
        }

        // two pointer variable. 
        DNode curr = head.next;
        DNode prev = head;

        try {
            while (curr != null) {
                // swap function for swapping data. 
                if (prev.videoTitle.compareTo(curr.videoTitle) == 1) {
                    String t = prev.videoTitle;
                    prev.videoTitle = curr.videoTitle;
                    curr.videoTitle = t;
                }

                // swap function for swapping data. 
                if (curr.next != null && curr.next.videoTitle.compareTo(curr.videoTitle) > 1) {
                    String t = curr.next.videoTitle;
                    curr.next.videoTitle = curr.videoTitle;
                    curr.videoTitle = t;
                }

                prev = curr.next;

                if (curr.next == null) {
                    break;
                }
                curr = curr.next.next;
            }
        } catch (NullPointerException e) {
            
        }

        return head;

    }

//function to display Node of linked list. 
    void display(DNode head) {
        DNode curr = head.next; // add .next
        while (curr != null) {
            System.out.println(curr.videoTitle);
            curr = curr.next;
        }
    }

}
