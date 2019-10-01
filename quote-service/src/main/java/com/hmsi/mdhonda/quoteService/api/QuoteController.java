package com.hmsi.mdhonda.quoteService.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hmsi.mdhonda.quoteService.dto.QuoteDto;
import com.hmsi.mdhonda.quoteService.service.QuoteService;

@RestController
@RequestMapping("/quote-api")
@EnableEurekaClient
public class QuoteController {

	@Autowired
	private QuoteService quoteService;
	
	@GetMapping(path="/quotes", produces= MediaType.APPLICATION_JSON_VALUE)
	public List<QuoteDto> getCatalogs() {
		return quoteService.getAllQuotes();
	}
	
	@PutMapping(path="/quotes", produces= MediaType.APPLICATION_JSON_VALUE)
	public List<QuoteDto> addQuotes(@RequestBody List<QuoteDto> quotes) {
		return quoteService.addQuotes(quotes);
	}
	
	@DeleteMapping(path="/quotes", produces= MediaType.APPLICATION_JSON_VALUE)
	public List<QuoteDto> deleteCatalogs(@RequestBody List<QuoteDto> catalogs) {
		return null;//quoteService.deleteCatalogs(catalogs);
	}
	
	
}
