package util;


public class LinkedList<T> implements LinkedListADT<T> {
    
    private int count;  // the current number of elements in the list
    private LinearNode<T> front; //pointer to the first element 
    private LinearNode<T> last; //pointer to the last element 
     
    public LinkedList() {
       this.count = 0;
       this.last = null;
       this.front = null;
    }

    public void add(T element) {
        LinearNode<T> node = new LinearNode<T>(element);

        if (isEmpty()) {
            this.front = node;
            this.last = node;
        } else {
            node.setNext(this.front); 
            this.front = node;       
        }

        this.count++;
    }


    public T remove() {
        LinearNode<T> temp = null;
        T result = null;
        if (isEmpty()) {
            System.out.println("There are no books in the list");
        } else {
            result = this.front.getElement();
            temp = this.front;
            this.front = this.front.getNext();
            temp.setNext(null);
            count--;
        }
        return result;
    }

    
    public T get(int i) {
        if (i < 1 || i > count) {
            return null;
        }

        LinearNode<T> current = front;
        int position = 1;

        while (current != null && position < i) {
            current = current.getNext();
            position++;
        }

        return current != null ? current.getElement() : null;
    }

    
    public boolean contains(T element) {
        LinearNode<T> current = front;

        while (current != null) {
            if (current.getElement().equals(element)) {
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    public boolean isEmpty() {
        return this.front == null;
    }

    public int size() {
        return this.count;
    }

    
    public String toString() {
        LinearNode<T> current = null;
        String fullList = "";
        
        for (current = this.front; current != null; current = current.getNext()) {
            fullList += "\n" + current.getElement().toString();
        }
        
        return fullList + "\n";
    }
}
