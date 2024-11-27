package util;

import application.Employee;

public class LinearNode<T> {
    private LinearNode<T> next; 
    private T element;         

    public LinearNode() {
        this.next = null;
        this.element = null;
    }

    public LinearNode(T elem) {
        this.next = null;
        this.element = elem;
    }

    public LinearNode<T> getNext() {
        return this.next;
    }

    public void setNext(LinearNode<T> node) {
        this.next = node;
    }

    public T getElement() {
        return this.element;
    }

    public void setElement(T elem) {
        this.element = elem;
    }

	public LinearNode<T> getNextNode() {
		// TODO Auto-generated method stub
		return null;
	}

	public Employee getData() {
		// TODO Auto-generated method stub
		return null;
	}
}
