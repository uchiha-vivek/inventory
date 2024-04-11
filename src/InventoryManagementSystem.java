import java.util.LinkedList;
import java.util.Scanner;

class Product {
    private int id;
    private String name;
    private int quantity;
    private double price;

    public Product(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
// The project is basically an inventory for products and it has been implemented using linked lists.
public class InventoryManagementSystem {
    private LinkedList<Product> inventory;

    public InventoryManagementSystem() {
        inventory = new LinkedList<>();
    }

    public void addProduct(Product product) {
        inventory.add(product);
    }

    public void removeProduct(int id) {
        for (Product p : inventory) {
            if (p.getId() == id) {
                inventory.remove(p);
                break;
            }
        }
    }

    public void displayInventory() {
        System.out.println("Inventory:");
        for (Product p : inventory) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Product\n2. Remove Product\n3. Display Inventory\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter product ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter product name: ");
                    String name = scanner.next();
                    System.out.print("Enter product quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    ims.addProduct(new Product(id, name, quantity, price));
                    break;
                case 2:
                    System.out.print("Enter product ID to remove: ");
                    int productIdToRemove = scanner.nextInt();
                    ims.removeProduct(productIdToRemove);
                    break;
                case 3:
                    ims.displayInventory();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
