import java.util.*;

class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        return id == ((Product) o).id;
    }

    public int hashCode() {
        return Objects.hash(id);
    }
}

public class ShoppingCart {
    HashMap<Product, Integer> cart = new HashMap<>();

    void addProduct(Product p, int qty) {
        cart.put(p, cart.getOrDefault(p, 0) + qty);
    }

    void updateQuantity(Product p, int qty) {
        if (qty > 0) cart.put(p, qty);
        else cart.remove(p);
    }

    void removeProduct(Product p) {
        cart.remove(p);
    }

    double totalCost() {
        double total = 0;
        for (Map.Entry<Product, Integer> e : cart.entrySet())
            total += e.getKey().price * e.getValue();
        return total;
    }

    void displayCart() {
        int totalItems = 0;

        for (Map.Entry<Product, Integer> e : cart.entrySet()) {
            Product p = e.getKey();
            int qty = e.getValue();
            totalItems += qty;

            System.out.println(p.name + " | Qty: " + qty +
                    " | Cost: $" + (p.price * qty));
        }

        System.out.println("Total Items: " + totalItems);
        System.out.println("Total Cost: $" + totalCost());
    }

    public static void main(String[] args) {
        ShoppingCart sc = new ShoppingCart();

        Product p1 = new Product(1, "Laptop", 800);
        Product p2 = new Product(2, "Mouse", 20);

        sc.addProduct(p1, 1);
        sc.addProduct(p2, 2);
        sc.updateQuantity(p2, 3);

        sc.displayCart();
    }
}