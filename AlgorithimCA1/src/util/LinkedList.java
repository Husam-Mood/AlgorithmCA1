package util;

import application.Employee;

public class LinkedList<T> implements LinkedListADT<T> {
    private int count; 
    private LinearNode<T> front; 
    private LinearNode<T> last; 

    public LinkedList() {
        this.count = 0;
        this.front = null;
        this.last = null;
    }

    public void add(T element) {
        LinearNode<T> node = new LinearNode<>(element);

        if (isEmpty()) {
            this.front = node; 
            this.last = node; 
        } else {
            this.last.setNext(node); 
            this.last = node;      
        }
        this.count++; 
    }

    @Override
    public void add(T element, int position) {
        if (position < 1 || position > count + 1) {
            System.out.println("Invalid position. Must be between 1 and " + (count + 1) + ".");
            return; 
        }

        LinearNode<T> newNode = new LinearNode<>(element);

        if (position == 1) { 
            newNode.setNext(this.front);
            this.front = newNode;
            if (this.last == null) { 
                this.last = newNode;
            }
        } else if (position == count + 1) { 
            this.last.setNext(newNode);
            this.last = newNode;
        } else { 
            LinearNode<T> previous = this.front;
            for (int i = 1; i < position - 1; i++) { 
                previous = previous.getNext();
            }
            newNode.setNext(previous.getNext());
            previous.setNext(newNode);
        }

        this.count++;
    }

    
    public LinearNode<T> getFirstNode() {
        return this.front;
    }

    public LinearNode<T> getLastNode() {
        return this.last; 
    }

    public T getFirstElement() {
        if (isEmpty()) {
            System.out.println("The list is empty.");
            return null; 
        }
        return this.front.getElement();
    }

    public T getLastElement() {
        if (isEmpty()) {
            System.out.println("The list is empty.");
            return null; 
        }
        return this.last.getElement();
    }

    public T remove(T element) {
        if (isEmpty()) {
            System.out.println("List is empty. Cannot remove element.");
            return null;
        }

        LinearNode<T> current = front; 
        LinearNode<T> previous = null; 

        while (current != null && !current.getElement().equals(element)) {
            previous = current; 
            current = current.getNext(); 
        }

        if (current == null) {
            System.out.println("Element not found in the list.");
            return null;
        }

        if (current == front) { 
            front = front.getNext(); 
            if (front == null) {
                last = null; 
            }
        } else if (current == last) { 
            last = previous;
            if (last != null) { 
                last.setNext(null); 
            }
        } else { 
            previous.setNext(current.getNext()); 
        }

        count--; 
        return current.getElement();
    }


    public boolean isEmpty() {
        return this.front == null;
    }

    public int size() {
        return this.count;
    }
    
    public void displayCourses() {
        if (isEmpty()) {
            System.out.println("\nNo employees are in any Training Courses.");
        } else {
            System.out.println("\n=== Employees in Training Courses ===");
            LinearNode<T> current = this.getFirstNode();

            while (current != null) {
                System.out.println(current.getElement().toString());
                current = current.getNext();
            }
        }
    }
    
   
        public int removeEmployeesFromCourse(String courseName) {
            int removedCount = 0;
            LinearNode<T> current = this.front;
            LinearNode<T> previous = null;

            while (current != null) {
                Employee currentEmployee = (Employee) current.getElement();
                if (currentEmployee.getCourseName().equalsIgnoreCase(courseName)) {
                    if (current == front) { 
                        front = front.getNext();
                        if (front == null) { 
                            last = null;
                        }
                    } else if (current == last) { 
                        last = previous;
                        last.setNext(null);
                    } else {
                        previous.setNext(current.getNext());
                    }
                    removedCount++;
                    count--; 
                } else {
                    previous = current; 
                }
                current = current.getNext();
            }

            return removedCount;
        }
    
        public boolean awardCert(String courseName, String employeeName) {
            if (isEmpty()) {
                System.out.println("The list is empty. No employees to evaluate.");
                return false;
            }

            LinearNode<T> current = this.front;
            boolean certificateAwarded = false;

            while (current != null) {
                Employee employee = (Employee) current.getData();

                if (employee.getCourseName().equalsIgnoreCase(courseName) &&
                    employee.getName().equalsIgnoreCase(employeeName)) {
                    employee.awardCertification();
                    certificateAwarded = true;
                    
                }
                current = current.getNextNode();
            }

            if (!certificateAwarded) {
                System.out.println("No employee found with the name \"" + employeeName + 
                                   "\" enrolled in the course \"" + courseName + "\".");
            }

            return certificateAwarded;
        }
        
        




        public LinearNode<T> getFront()
        {
        	return this.front;
        }


    public String toString() {
        if (isEmpty()) {
            return "The list is empty.";
        }
            LinearNode<T> current = null;
            String fullList = "";

            for (current = this.front; current != null; current = current.getNext()) {
                fullList = fullList + "\n" + current.getElement().toString();
            } 

            return fullList + "\n";
        }

 	   
    


}


