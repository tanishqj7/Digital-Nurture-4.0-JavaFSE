import java.util.Arrays;
import java.util.Comparator;

public class Search {

    public static Product linearSearchByName(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    public static Product linearSearchById(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.getProductId() == targetId) {
                return product;
            }
        }
        return null;
    }

    public static Product[] linearSearchByCategory(Product[] products, String targetCategory) {
        return Arrays.stream(products)
                .filter(p -> p.getCategory().equalsIgnoreCase(targetCategory))
                .toArray(Product[]::new);
    }

    public static Product binarySearchByName(Product[] products, String targetName) {
        Arrays.sort(products, Comparator.comparing(Product::getProductName));
        int left = 0, right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            String midName = products[mid].getProductName();
            int cmp = midName.compareToIgnoreCase(targetName);

            if (cmp == 0) return products[mid];
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public static Product binarySearchById(Product[] products, int targetId) {
        Arrays.sort(products, Comparator.comparingInt(Product::getProductId));
        int left = 0, right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int midId = products[mid].getProductId();

            if (midId == targetId) return products[mid];
            else if (midId < targetId) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }
}
