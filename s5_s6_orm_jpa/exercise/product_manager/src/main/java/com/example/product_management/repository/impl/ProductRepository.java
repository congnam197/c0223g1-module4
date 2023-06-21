package com.example.product_management.repository;

import com.example.product_management.model.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepository implements IProductRepository {
    private static Map<Integer, Product> products;
    private static int size = 1;

    static {
        products = new HashMap<>();
        products.put(size++, new Product(1, "IphoneX", 1000, "IphoneX, 64GB, 4.4in", "Apple"));
        products.put(size++, new Product(2, "IphoneXS", 1100, "IphoneXS, 128GB, 4.7in", "Apple"));
        products.put(size++, new Product(3, "IphoneXSMax", 1220, "IphoneXSMax, 128G ,5.5in", "Apple"));
        products.put(size++, new Product(4, "GalaxyS23 Ultra", 2300, "GalaxyS23 Ultra , 256G, 5.7in", "SamSung"));
        products.put(size++, new Product(5, "Galaxy Z Fold4", 2100, "GalaxyZ Fold 4, 128Gb, 4,7in", "SamSung"));
        products.put(size++, new Product(6, "Galaxy Tab S8", 2000, "Galaxy Tab S8, 128Gb, 11in", "SamSung"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void add(Product product) {
        products.put(size++, product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> searchList = new ArrayList<>();
        for (Product product : findAll()) {
            if (product.getName().contains(name.toUpperCase(Locale.ROOT))) {
                searchList.add(product);
            }
        }
        return searchList;
    }

    @Override
    public boolean checkId(int id) {
        for (int i = 0; i < findAll().size(); i++) {
            if (id != findAll().get(i).getId()) {
                return false;
            }
        }
        return true;
    }
}
