package com.hmsi.mdhonda.quoteService.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hmsi.mdhonda.quoteService.dto.QuoteDto;
import com.hmsi.mdhonda.quoteService.entities.Quote;

@Component
public class QuoteMapper {
	
	@Autowired
    private ModelMapper modelMapper;
	

	public List<QuoteDto> quoteEntityToDto( List<Quote> quotes) {
		return quotes.stream().map(entity -> modelMapper.map(entity, QuoteDto.class)).collect(Collectors.toList());
	}
	
	public List<Quote> quoteDtoToEntity( List<QuoteDto> quotes) {
		return quotes.stream().map(dto -> modelMapper.map(dto, Quote.class)).collect(Collectors.toList());
	}
}
