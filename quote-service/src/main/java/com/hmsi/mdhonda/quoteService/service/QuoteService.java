package com.hmsi.mdhonda.quoteService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public List<QuoteDto> getAllQuotes(){
		List<Quote> quoteList = quoteRepository.findAll();
		return quoteMapper.quoteEntityToDto(quoteList);
	}

	public List<QuoteDto> addQuotes(List<QuoteDto> quotes) {
		List<Quote> quoteEntitys = quoteMapper.quoteDtoToEntity(quotes);
		quoteRepository.saveAll(quoteEntitys);
		return getAllQuotes();
	}
	
	
}
