package org.slackyogi.data;

import org.slackyogi.model.Drink;
import org.slackyogi.model.Food;
import org.slackyogi.model.Product;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductRepository implements Serializable {

    private static TreeSet<Product> products = new TreeSet<>(); // TODO move database out of memory
    private FileManager fileManager;

    public ProductRepository() {
        fileManager = new FileManager();
            products = fileManager.importData()
                    .orElse(new TreeSet<>());
    }

    public void addProduct(Product product) {
        if (product != null)
            products.add(product);
    }

    public Optional<Product> findByName(String name) {
        for (Product product : findAll()) {
            if (product.getName().equals(name)) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    public SortedSet<Product> findAll() {
        return Collections.unmodifiableSortedSet(products);
    }

    public Long count() {
        return Long.valueOf(findAll().size());
    }

    public void delete(Product product) {
        if (product != null) {
            if(findByName(product.getName()).isPresent())
            {
                products.remove(product);
            }
        }
    }

    public void update(Product oldProduct, Product newProduct) {
        if (newProduct != null && products.contains(oldProduct)) {
            products.remove(oldProduct);
            products.add(newProduct);
        }
    }

    public void saveDatabase() {
        try {
            fileManager.exportData(products);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean exists(UUID primaryKey) {
        return true;                                                // TODO implement this
    }

    private static TreeSet<Product> fetchDataFromFakeDB() {
        Stream<Product> products = Stream.of(new Food("Banana", 2.0, 0.5),
                (new Food("Flour", 1.0, 1.0)),
                (new Food("Coffee", 12.5, 0.7)),
                (new Food("Egg", 0.2, 0.1)),
                (new Food("Tomato", 1.6, 0.2)),
                (new Food("Cookies", 5.1, 0.8)),
                (new Drink("Milk", 1.1, 1.0)),
                (new Drink("Coola", 2.0, 3.3)));
        return products.collect(Collectors.toCollection(TreeSet::new));

    }
}
