package io.codeforall.bootcamp;

public class LinkedList {

    private Node head;
    private int length = 0;

    public LinkedList() {
        this.head = new Node(null);
    }

    public int size() {
        return length;
    }

    /**
     * Adds an element to the end of the list
     * @param data the element to add
     */
    public void add(Object data)  {

        Node node = new Node(data);
        Node iterator = head;
        while (iterator.getNext() != null){
            iterator = iterator.getNext();
        }
        iterator.setNext(node);
        length++;

    }

    /**
     * Obtains an element by index
     * @param index the index of the element
     * @return the element
     */
    public Object get(int index) {
        Node node = this.head;
        int i = -1;
        while (node.getNext() != null) {
            node = node.next;
            i++;
            if (i == index) {
                return node.data;
            }
        }
        return null;
    }

    /**
     * Returns the index of the element in the list
     * @param data element to search for
     * @return the index of the element, or -1 if the list does not contain element
     */
    public int indexOf(Object data) {
        int i = -1;
        Node node = this.head;
        while (node != null) {
            if (node.data == data) {
                return i;
            }
            node = node.next;
            i++;
        }
        return -1;


    }

    /**
     * Removes an element from the list
     * @param data the element to remove
     * @return true if element was removed
     */
    public boolean remove(Object data) {
        Node previousNode = this.head;
        Node currentNode = this.head;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
            if (currentNode.getData() == data) {
                previousNode.setNext(currentNode.getNext());
                currentNode.setNext(null);
                this.length--;
                return true;
            }
            previousNode = previousNode.getNext();

        }
        return false;
    }




    private class Node {

        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
            next = null;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
