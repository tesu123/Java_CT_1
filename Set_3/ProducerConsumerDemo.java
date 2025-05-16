// Shared resource class
class Store {
    private int itemCount = 0;

    // Synchronized method to produce an item
    public synchronized void produce() {
        itemCount++;
        System.out.println("Produced an item. Total items: " + itemCount);
    }

    // Synchronized method to consume an item
    public synchronized void consume() {
        if (itemCount > 0) {
            itemCount--;
            System.out.println("Consumed an item. Remaining items: " + itemCount);
        } else {
            System.out.println("No items to consume.");
        }
    }
}

// Producer class
class Producer extends Thread {
    private Store store;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        // Produce 5 items
        for (int i = 0; i < 5; i++) {
            store.produce();
            try {
                Thread.sleep(100); // simulate production time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Consumer class
class Consumer extends Thread {
    private Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        // Consume 5 items
        for (int i = 0; i < 5; i++) {
            store.consume();
            try {
                Thread.sleep(150); // simulate consumption time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Main class
public class ProducerConsumerDemo {
    public static void main(String[] args) {
        Store store = new Store();

        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);

        producer.start();
        consumer.start();
    }
}
