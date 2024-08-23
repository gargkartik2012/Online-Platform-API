package org.springbootdemo.onlineplatformapi.Service;

import org.springbootdemo.onlineplatformapi.Entity.Product;
import org.springbootdemo.onlineplatformapi.dto.ProductDto;
import org.springbootdemo.onlineplatformapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> searchAndSaveProducts(String query) {
        List<ProductDto> products = new ArrayList<>();



        // Simulating API calls to Amazon, Myntra, Flipkart
        products.addAll(fetchFromAmazon(query));
        products.addAll(fetchFromMyntra(query));
        products.addAll(fetchFromFlipkart(query));
        for (ProductDto productDto : products) {
            Product product = new Product();
            product.setName(productDto.getName());
            product.setVendor(productDto.getVendor());
            product.setPrice(productDto.getPrice());
            product.setUrl(productDto.getUrl());
            productRepository.save(product);
        }
        return products;
    }

    public ProductDto addProduct(ProductDto productDto) {
        // Convert ProductDto to Product entity
        Product product = new Product();
        product.setName(productDto.getName());
        product.setVendor(productDto.getVendor());
        product.setPrice(productDto.getPrice());
        product.setUrl(productDto.getUrl());

        // Save the entity
        Product savedProduct = productRepository.save(product);

        // Convert back to ProductDto and return
        return new ProductDto(
                savedProduct.getName(),
                savedProduct.getVendor(),
                savedProduct.getPrice(),
                savedProduct.getUrl()
        );
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public List<Product> getProductsByVendor(String vendor) {
        return productRepository.findByVendor(vendor);
    }


    public void deleteAllProducts() {
        productRepository.deleteAll();
    }


    public List<ProductDto> fetchFromAmazon(String query) {
        List<ProductDto> amazonProducts = new ArrayList<>();
        amazonProducts.add(new ProductDto("Laptop - Amazon", "Amazon", 90000.0, "https://amazon.com/product/1"));
        return amazonProducts;
    }

    public List<ProductDto> fetchFromMyntra(String query) {
        // Mock data, in a real application this would be an API call
        List<ProductDto> myntraProducts = new ArrayList<>();
        myntraProducts.add(new ProductDto("Shirt - Myntra", "Myntra", 2500.0, "https://myntra.com/product/2"));
        return myntraProducts;
    }

    private List<ProductDto> fetchFromFlipkart(String query) {
        // Mock data, in a real application this would be an API call
        List<ProductDto> flipkartProducts = new ArrayList<>();
        flipkartProducts.add(new ProductDto("Mobile - Flipkart", "Flipkart", 30000.0, "https://flipkart.com/product/3"));
        return flipkartProducts;
    }



}
