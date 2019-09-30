package com.hmsi.mdhonda.catalogService.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hmsi.mdhonda.catalogService.entities.ProductCatalog;


@Repository
public interface ProductCatalogRepository extends JpaRepository<ProductCatalog, Integer>{

}
