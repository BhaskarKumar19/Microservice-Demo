package com.hmsi.mdhonda.catalogService.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hmsi.mdhonda.catalogService.dto.Catalog;
import com.hmsi.mdhonda.catalogService.service.ProductCalatogService;

@RestController
@RequestMapping("/catalog-api")
@EnableEurekaClient
public class CatalogController {

	@Autowired
	private ProductCalatogService productCalatogService;
	
	@GetMapping(path="/catalogs", produces= MediaType.APPLICATION_JSON_VALUE)
	public List<Catalog> getCatalogs() {
		return productCalatogService.getAllCatalogs();
	}
	
	@PutMapping(path="/catalogs", produces= MediaType.APPLICATION_JSON_VALUE)
	public List<Catalog> addCatalogs(@RequestBody List<Catalog> catalogs) {
		return productCalatogService.addCatalogs(catalogs);
	}
	
	@DeleteMapping(path="/catalogs", produces= MediaType.APPLICATION_JSON_VALUE)
	public List<Catalog> deleteCatalogs(@RequestBody List<Catalog> catalogs) {
		return productCalatogService.deleteCatalogs(catalogs);
	}
	
	
}
