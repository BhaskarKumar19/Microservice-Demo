package com.hmsi.mdhonda.quoteService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hmsi.mdhonda.quoteService.dto.CatalogDto;
import com.hmsi.mdhonda.quoteService.dto.QuoteDto;
import com.hmsi.mdhonda.quoteService.entities.Quote;
import com.hmsi.mdhonda.quoteService.mapper.QuoteMapper;
import com.hmsi.mdhonda.quoteService.repo.QuoteRepository;

@Service
public class QuoteService {
	
	@Autowired
	private QuoteRepository quoteRepository;
	@Autowired
	private QuoteMapper quoteMapper;
	@Autowired
	private RestTemplate restTemplate;
	
	public List<QuoteDto> getAllQuotes(){
		List<Quote> quoteList = quoteRepository.findAll();
		return quoteMapper.quoteEntityToDto(quoteList);
	}

	public List<QuoteDto> addQuotes(List<QuoteDto> quotes) {
		List<Quote> quoteEntitys = quoteMapper.quoteDtoToEntity(quotes);
		
		// simulate inter-microservice call to validate if catalog id is valid
		// make call to catalog-service
		
		ResponseEntity<List<CatalogDto>> response = restTemplate.exchange("http://CATALOG-SERVICE/catalog-api/catalogs",HttpMethod.GET,
				  null,
				  new ParameterizedTypeReference<List<CatalogDto>>(){});
		
		List<CatalogDto> Catalogs = response.getBody();
		
		
		quoteRepository.saveAll(quoteEntitys);
		return getAllQuotes();
	}
	
	
}
