import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductProcessor {
    private static final String INPUT_PATH = "data/products.csv";
    private static final String OUTPUT_PATH = "data/transformed_products.csv";
    
    static class Product {
        int productId;
        String name;
        double price;
        String category;
        String priceRange;
        
        public Product(String[] data) {
            this.productId = Integer.parseInt(data[0]);
            this.name = data[1];
            this.price = Double.parseDouble(data[2]);
            this.category = data[3];
        }
        
        @Override
        public String toString() {
            return String.format("%d,%s,%.2f,%s,%s", 
                productId, name, price, category, priceRange);
        }
    }
    
    public static void main(String[] args) {
        try {
            List<Product> products = readProducts();
            transformProducts(products);
            writeProducts(products);
            System.out.println("Product transformation completed successfully!");
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing numeric values: " + e.getMessage());
        }
    }
    
    private static List<Product> readProducts() throws IOException {
        List<Product> products = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH))) {
            // Skip header
            reader.readLine();
            
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                products.add(new Product(data));
            }
        }
        
        return products;
    }
    
    private static void transformProducts(List<Product> products) {
        for (Product product : products) {
            // Convert name to uppercase
            product.name = product.name.toUpperCase();
            
            // Apply discount to Electronics category
            if (product.category.equals("Electronics")) {
                product.price = Math.round(product.price * 0.9 * 100.0) / 100.0;
            }
            
            // Update category for premium electronics
            if (product.category.equals("Electronics") && product.price > 500) {
                product.category = "Premium Electronics";
            }
            
            // Set price range
            if (product.price <= 10) {
                product.priceRange = "Low";
            } else if (product.price <= 100) {
                product.priceRange = "Medium";
            } else if (product.price <= 500) {
                product.priceRange = "High";
            } else {
                product.priceRange = "Premium";
            }
        }
    }
    
    private static void writeProducts(List<Product> products) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(OUTPUT_PATH))) {
            // Write header
            writer.println("ProductID,Name,Price,Category,PriceRange");
            
            // Write transformed products
            for (Product product : products) {
                writer.println(product.toString());
            }
        }
    }
} 