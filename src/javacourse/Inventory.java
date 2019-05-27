package javacourse;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {

    private ObservableList<Part> allParts = FXCollections.observableArrayList();
    private ObservableList<Product> allProducts = FXCollections.observableArrayList();

    public void addPart(Part part) {
        allParts.add(part);
    }

    public void addProduct(Product product) {
        allProducts.add(product);
    }

    public Part lookupPart(int partId) {
        for (Part part : allParts) {
            if (part.getId() == partId) {
                return part;
            }
        }
        return null;
    }

    public Product lookupProduct(int productId) {
        return allProducts.get(productId);
    }

    public ObservableList<Part> lookupPart(String partName) {
        ObservableList<Part> matchedPart = FXCollections.observableArrayList();
        for (Part part : allParts) {
            if (part.getName().equals(partName)) {
                matchedPart.add(part);
            }
        }
        return matchedPart;
    }

    public ObservableList<Product> lookupProduct(String productName) {
        return allProducts;
    }

    public void updatePart(int index, Part part) {

    }

    public void updateProduct(int index, Product product) {

    }

    public void deletePart(Part part) {
        allParts.removeAll(part);
    }

    public void deleteProduct(Product product) {
        allProducts.remove(product);
    }

    public ObservableList<Part> getAllParts() {
        return allParts;
    }

    public ObservableList<Product> getAllProducts() {
        return allProducts;
    }

}
