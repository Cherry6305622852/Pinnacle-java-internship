1
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

    public String toString() {
        return id + ". " + name + " - ₹" + price;
    }
}

class Cart {
    Map<Product, Integer> items = new HashMap<>();

    void addProduct(Product product, int quantity) {
        items.put(product, items.getOrDefault(product, 0) + quantity);
    }

    void removeProduct(Product product) {
        items.remove(product);
    }

    void viewCart() {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        System.out.println("Items in cart:");
        double total = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product p = entry.getKey();
            int qty = entry.getValue();
            double subtotal = p.price * qty;
            System.out.println(p.name + " x" + qty + " = ₹" + subtotal);
            total += subtotal;
        }
        System.out.println("Total: ₹" + total);
    }

    void checkout() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty. Add items first.");
        } else {
            viewCart();
            System.out.println("Checkout successful. Thank you for shopping!");
            items.clear();
        }
    }
}

public class ECommerceApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> products = Arrays.asList(
            new Product(1, "Laptop", 50000),
            new Product(2, "Smartphone", 20000),
            new Product(3, "Headphones", 2000)
        );

        Cart cart = new Cart();

        while (true) {
            System.out.println("\n--- E-commerce Shopping Cart ---");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. Remove from Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Checkout");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    for (Product p : products) {
                        System.out.println(p);
                    }
                    break;

                case 2:
                    System.out.print("Enter product ID to add: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter quantity: ");
                    int qty = scanner.nextInt();
                    if (id >= 1 && id <= products.size()) {
                        cart.addProduct(products.get(id - 1), qty);
                        System.out.println("Product added to cart.");
                    } else {
                        System.out.println("Invalid product ID.");
                    }
                    break;

                case 3:
                    System.out.print("Enter product ID to remove: ");
                    int rid = scanner.nextInt();
                    if (rid >= 1 && rid <= products.size()) {
                        cart.removeProduct(products.get(rid - 1));
                        System.out.println("Product removed from cart.");
                    } else {
                        System.out.println("Invalid product ID.");
                    }
                    break;

                case 4:
                    cart.viewCart();
                    break;

                case 5:
                    cart.checkout();
                    break;

                case 6:
                    System.out.println("Exiting... Thank you!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
