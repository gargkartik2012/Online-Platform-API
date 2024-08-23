package org.springbootdemo.onlineplatformapi.Controller;


import org.springbootdemo.onlineplatformapi.Entity.Product;
import org.springbootdemo.onlineplatformapi.Service.ProductService;
import org.springbootdemo.onlineplatformapi.dto.ProductDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping("/add")
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) {
        ProductDto newProduct = productService.addProduct(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductDto>> searchProducts(@RequestParam String query){
        List<ProductDto> products = productService.searchAndSaveProducts(query);
        return ResponseEntity.ok(products);
    }

    @GetMapping("AllProducts")
    public ResponseEntity<List<Product>> getAllAggregatedProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/vendor")
    public ResponseEntity<List<Product>> getProductsByVendor(@RequestParam String vendor) {
        List<Product> products = productService.getProductsByVendor(vendor);
        return ResponseEntity.ok(products);
    }
    @DeleteMapping("/deleteProduct")
    public ResponseEntity<String> deleteAllAggregatedProducts() {
        productService.deleteAllProducts();
        return ResponseEntity.ok("All aggregated products have been deleted.");
    }
}
