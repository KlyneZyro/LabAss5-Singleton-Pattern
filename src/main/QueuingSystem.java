package main;

public class QueuingSystem {
    private static QueuingSystem instance;
    private int currentNumber;
    private int nowServing;
    private int[] desks;

    private QueuingSystem() {
        currentNumber = 0;
        nowServing = 0;
        desks = new int[3];
        for(int i = 0; i < desks.length;i++) {
        	desks[i] = 0;
        }
        
    }
    
    public static synchronized QueuingSystem getInstance() {
        if (instance == null)
                instance = new QueuingSystem();
        return instance;
    }
    
    public void issueQueueNumber() {
    	currentNumber++;
    	System.out.println("Issued Queue Number: " + currentNumber);
    }
    
    public void callNextNumber(int deskId) {
    	if(deskId < 1 || deskId > 3) {
    		System.out.println("Invalid Desk ID. Must be 1, 2, or 3."	);
    		return;
    	}
    	
    	if(nowServing < currentNumber) {
    		nowServing++;
    		desks[deskId - 1] = nowServing;
    		System.out.println("Desk " + deskId + " is now serving: " + nowServing);
            displayCurrentQueue(); // Update display
        } else {
            System.out.println("No more customers in queue for Desk " + deskId);
        }
    }

    public void displayCurrentQueue() {
        System.out.println("\n=== Queue Status ===");
        
        for (int i = 0; i < desks.length; i++) {
            System.out.println("Desk " + (i + 1) + ": Now Serving " + desks[i]);
        }
        
        System.out.println("Current Queue Number: " + currentNumber);

    
        System.out.println("Online Monitoring: Now Serving " + nowServing);
        System.out.println("==================\n");
    }
    
    public void resetQueue(int newNumber) {
        
        if (newNumber < 0) {
            System.out.println("Reset failed: Invalid queue number.");   
        }
        
        currentNumber = newNumber;
        nowServing = newNumber;
        
        for (int i = 0; i < desks.length; i++) {
            desks[i] = newNumber;
        }
        System.out.println("Queue reset to: " + newNumber);
        displayCurrentQueue();
    }
}