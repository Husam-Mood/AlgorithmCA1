/*
* File name : LinkedListADT.java
* Author : Husam Mehmood
* Student number : C23465252
* Description of class : LinkedListADT interface to store and manipulate data
*/

package util;

public interface LinkedListADT<T> {
	
    public void add(T element);

    public void add(T element, int position);
    
    public LinearNode<T> getFirstNode();

    public LinearNode<T> getLastNode();
   
    public T getFirstElement();

    public T getLastElement();

    public T remove(T element);

    public boolean isEmpty();

    public int size();
    
    public void displayCourses();
   
    public int removeEmployeesFromCourse(String courseName);


    public String toString();
}
