package org.springbootdemo.onlineplatformapi;

import org.springbootdemo.onlineplatformapi.Entity.Product;
import org.springbootdemo.onlineplatformapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    public void testSaveAndFindProduct() {
       Product product = new Product();
        product.setName("Test Product");
        product.setVendor("Amazon");
        product.setPrice(100.0);
        product.setUrl("https://amazon.com/product/test");

        productRepository.save(product);

        List<Product> products = productRepository.findByVendor("Amazon");
        assertEquals(1, products.size());
        assertEquals("Test Product", products.getFirst().getName());
    }
}
