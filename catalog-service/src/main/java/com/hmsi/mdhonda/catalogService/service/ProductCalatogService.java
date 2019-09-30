package com.hmsi.mdhonda.catalogService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmsi.mdhonda.catalogService.dto.Catalog;
import com.hmsi.mdhonda.catalogService.entities.ProductCatalog;
import com.hmsi.mdhonda.catalogService.mapper.CatalogMapper;
import com.hmsi.mdhonda.catalogService.repo.ProductCatalogRepository;

@Service
public class ProductCalatogService {
	
	@Autowired
	private ProductCatalogRepository productCatalogRepository;

	@Autowired
	private CatalogMapper catalogMapper;
	
	
	public List<Catalog> getAllCatalogs(){
		 List<ProductCatalog> catalogEntities = productCatalogRepository.findAll();
		 return catalogMapper.catalogEntityToDto(catalogEntities);
	}
	
	public List<Catalog> addCatalogs(List<Catalog>catalogs) {
		List<ProductCatalog> catalogEntities = productCatalogRepository.findAll();
		if(!catalogs.isEmpty() && catalogEntities!=null) {
			List<ProductCatalog> newEntities = catalogMapper.catalogDtoToEntity(catalogs);
			catalogEntities.addAll(newEntities);
		}
		productCatalogRepository.saveAll(catalogEntities);
		return getAllCatalogs();
	}
	
	public List<Catalog> deleteCatalogs(List<Catalog>catalogs) {
		if(!catalogs.isEmpty()) {
			List<ProductCatalog> newEntities = catalogMapper.catalogDtoToEntity(catalogs);
			productCatalogRepository.deleteAll(newEntities);
		}
		
		return getAllCatalogs();
	}
}
