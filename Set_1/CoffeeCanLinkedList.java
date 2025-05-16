public class CoffeeCanLinkedList {

    // Inner class CoffeeCan: No existence outside the linked list
    private class CoffeeCan {
        String label;
        CoffeeCan next;

        CoffeeCan(String label) {
            this.label = label;
            this.next = null;
        }
    }

    private CoffeeCan head = null;

    // Method to add a CoffeeCan at the end
    public void add(String label) {
        CoffeeCan newCan = new CoffeeCan(label);
        if (head == null) {
            head = newCan;
        } else {
            CoffeeCan current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newCan;
        }
    }

    // Method to display the linked list
    public void display() {
        CoffeeCan current = head;
        while (current != null) {
            System.out.println("CoffeeCan: " + current.label);
            current = current.next;
        }
    }

    // Main method to test
    public static void main(String[] args) {
        CoffeeCanLinkedList list = new CoffeeCanLinkedList();
        list.add("Espresso");
        list.add("Latte");
        list.add("Cappuccino");

        list.display();
    }
}
