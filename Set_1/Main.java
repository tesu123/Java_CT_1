import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

class StockItem {
    String itemCode;
    int quantity;
    private final ReentrantLock lock = new ReentrantLock();

    public StockItem(String itemCode, int quantity) {
        this.itemCode = itemCode;
        this.quantity = quantity;
    }

    // Thread-safe update using item-specific lock
    public void updateQuantity(int change) {
        lock.lock();
        try {
            quantity += change;
            System.out.println("Updated " + itemCode + " to " + quantity);
        } finally {
            lock.unlock();
        }
    }

    public int getQuantity() {
        return quantity;
    }
}

class StockList {
    // Thread-safe map
    ConcurrentHashMap<String, StockItem> items = new ConcurrentHashMap<>();

    public void addItem(String itemCode, int quantity) {
        items.put(itemCode, new StockItem(itemCode, quantity));
    }

    public void updateStock(String itemCode, int change) {
        StockItem item = items.get(itemCode);
        if (item != null) {
            item.updateQuantity(change);
        } else {
            System.out.println("Item not found: " + itemCode);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        StockList stockList = new StockList();
        stockList.addItem("A101", 50);
        stockList.addItem("B202", 100);

        // Two threads trying to update different items
        new Thread(() -> stockList.updateStock("A101", -5)).start();
        new Thread(() -> stockList.updateStock("B202", -10)).start();

        // Two threads trying to update the same item
        new Thread(() -> stockList.updateStock("A101", +15)).start();
        new Thread(() -> stockList.updateStock("A101", -7)).start();
    }
}
