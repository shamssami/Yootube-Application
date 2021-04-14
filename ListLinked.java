package project1;

class ListLinked {	// as DoublyLinkedList

    public DoublyLinkedList head;
    public DoublyLinkedList trail;

    int size = 0;

    public DoublyLinkedList getHead() {
        return head;
    }

    public void setHead(DoublyLinkedList head) {
        this.head = head;
    }

    public DoublyLinkedList getTrail() {
        return trail;
    }

    public void setTrail(DoublyLinkedList trail) {
        this.trail = trail;
    }

    public ListLinked() {

        head = new DoublyLinkedList();
        head.listname = "Favourites";
        head.Next = new DoublyLinkedList();
        head.Next.listname = "watchLater";

        head.Next.Next = new DoublyLinkedList();
        head.Next.Next.listname = "History";

        head.Next.Next.Next = new DoublyLinkedList();
        head.Next.Next.Next.listname = "myVideo";

        head.Next.Next.Next.Next = new DoublyLinkedList();
        head.Next.Next.Next.Next.listname = "random";
    }

    // Adding a node at the front of the list
    public void push(DoublyLinkedList new_List) {
        /* 1. allocate node 
	         * 2. put in the data */
        new_List = new DoublyLinkedList();

        /* 3. Make next of new node as head and previous as NULL */
        new_List.Next = head;
        new_List.previous = null;

        /* 4. change prev of head node to new node */
        if (head != null) {
            head.previous = new_List;
        }

        /* 5. move the head to point to the new node */
        head = new_List;
    }

    // Add a node at the end of the list
    void append(DoublyLinkedList newList) {
        /* 1. allocate node 
	         * 2. put in the data */
        DoublyLinkedList new_node = newList;

        DoublyLinkedList last = head;
        /* used in step 5*/

 /* 3. This new node is going to be the last node, so
	         * make next of it as NULL*/
        new_node.Next = null;

        /* 4. If the Linked List is empty, then make the new
	         * node as head */
        if (head == null) {
            new_node.previous = null;
            head = new_node;
            return;
        }

        /* 5. Else traverse till the last node */
        while (last.Next != null) {
            last = last.Next;
        }

        /* 6. Change the next of last node */
        last.Next = new_node;

        /* 7. Make last node as previous of new node */
        new_node.previous = last;
    }

    public void addFirst(DoublyLinkedList newList) {

        DoublyLinkedList pointer = head.Next;

        newList.Next = head.Next;
        newList.trailer.next = head.Next.header;
        head.Next = newList;
        head.Next.trailer.next = newList.header;
        //newDNode.next.prev=newDNode;
        pointer.previous = newList;
        pointer.header.prev = newList.trailer;
        newList.previous = head;
        newList.header.prev = head.trailer;
        size++;
    }

   
    public void printList() {
        DoublyLinkedList pointer;

        pointer = head;
        int i = 1;
        while (pointer != trail) {

            System.out.println(i + "- " + pointer.listname);
            pointer = pointer.Next;
            i++;
        }

    }
    ////////////////////////////////////////////////////////////////////////

    public void printAllVideos() {
        DoublyLinkedList ptr;
        ptr = head.Next;
        while (ptr != trail) {
            ptr.printList();
            ptr = ptr.Next;
        }
    }

    public void removeList(DoublyLinkedList removeList) {
        DoublyLinkedList pointer = head;
        int i = 0;

        while (i < size) {
            if (pointer.listname.equals(removeList.listname)) {
                pointer.previous = pointer;
                pointer.Next.Next.previous = removeList.Next;
                size--;

            } else {
                pointer = pointer.Next;
                i++;
            }
        }
    }

    void deleteNode(DoublyLinkedList head, DoublyLinkedList del) {
        // Base case
        if (head == null || del == null) {
            return;
        }

        // If node to be deleted is head node
        if (head == del || del == head.Next || del == head.Next.Next) {
            System.out.println("You can not delete this list!");
        }

        // Change next only if node to be deleted
        // is NOT the last node
        if (del.previous != null) {
            del.previous.Next = del.Next;
        }

        // Finally, free the memory occupied by del
        return;
    }

}
