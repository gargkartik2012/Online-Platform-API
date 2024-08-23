package org.springbootdemo.onlineplatformapi;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springbootdemo.onlineplatformapi.Service.ProductService;
import org.springbootdemo.onlineplatformapi.dto.ProductDto;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@SpringJUnitConfig

public class ProductServiceTest {
    @InjectMocks
    private ProductService productService;

    public ProductServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFetchFromAmazon() {
        List<ProductDto> products = productService.fetchFromAmazon("Laptop");
        assertEquals(1, products.size());
        assertEquals("Laptop - Amazon", products.get(0).getName());
    }

    @Test
    public void testFetchFromMyntra() {
        List<ProductDto> products = productService.fetchFromMyntra("Shirt");
        assertEquals(1, products.size());
        assertEquals("Shirt - Myntra", products.get(0).getName());
    }

}
