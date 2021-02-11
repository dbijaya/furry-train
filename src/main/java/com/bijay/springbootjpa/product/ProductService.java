package com.bijay.springbootjpa.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    private Pageable firstPageWithTwoElements;
    Page<Product> allProducts = productRepository.findAll(firstPageWithTwoElements);

}
