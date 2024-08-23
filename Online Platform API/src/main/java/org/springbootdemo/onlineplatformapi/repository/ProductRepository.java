package org.springbootdemo.onlineplatformapi.repository;

import org.springbootdemo.onlineplatformapi.Entity.Product;
import org.springbootdemo.onlineplatformapi.dto.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findByVendor(String vendor);
}
