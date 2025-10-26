package main;

public class PagIbigOffice {

    public static void main(String[] args) {
        
    	QueuingSystem queue = QueuingSystem.getInstance();
    	
    	System.out.println("Welcome to Pag-Ibig Office!\n");

        // Simulate visitors taking queue numbers
        queue.issueQueueNumber(); // Queue Number 1
        queue.issueQueueNumber(); // Queue Number 2
        queue.issueQueueNumber(); // Queue Number 3

        // Simulate help desks calling numbers
        queue.callNextNumber(1); // Desk 1 serves Queue Number 1
        queue.callNextNumber(2); // Desk 2 serves Queue Number 2
        queue.callNextNumber(3); // Desk 3 serves Queue Number 3

        // Simulate a reset
        queue.resetQueue(100); // Reset to 100 

        // Issue new queue numbers after reset
        queue.issueQueueNumber(); // Queue Number 101
        queue.issueQueueNumber(); // Queue Number 102
        queue.callNextNumber(2); // Desk 2 serves Queue Number 101

    }    
}