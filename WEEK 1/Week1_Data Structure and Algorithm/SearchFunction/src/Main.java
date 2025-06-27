public class Main {
    public static void main(String[] args) {
        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Shoes", "Footwear"),
                new Product(103, "Phone", "Electronics"),
                new Product(104, "Shirt", "Clothing")
        };

        System.out.println("Search by ID:");
        System.out.println(Search.linearSearchById(products, 103));

        System.out.println("\nSearch by Category:");
        Product[] electronics = Search.linearSearchByCategory(products, "Electronics");
        for (Product p : electronics) System.out.println(p);

        System.out.println("\nBinary Search by ID:");
        System.out.println(Search.binarySearchById(products, 104));
    }
}
