package com.hmsi.mdhonda.catalogService.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.hmsi.mdhonda.catalogService.dto.Catalog;
import com.hmsi.mdhonda.catalogService.entities.ProductCatalog;

@Component
public class CatalogMapper {

	public List<Catalog> catalogEntityToDto( List<ProductCatalog> catalogEntities) {
		return catalogEntities.stream().map(catalog -> new Catalog(catalog.getId(), catalog.getName(), catalog.getDescription(), catalog.getCategory(), catalog.getImageUrl())).collect(Collectors.toList());
	}
	
	public List<ProductCatalog> catalogDtoToEntity( List<Catalog> catalogs) {
		return catalogs.stream().map(catalog -> new ProductCatalog(catalog.getId(), catalog.getName(), catalog.getDescription(), catalog.getCategory(), catalog.getImageUrl())).collect(Collectors.toList());
	}
}
