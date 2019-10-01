package com.hmsi.mdhonda.quoteService.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.hmsi.mdhonda.quoteService.dto.QuoteDto;
import com.hmsi.mdhonda.quoteService.entities.Quote;

@Component
public class QuoteMapper {

	public List<QuoteDto> quoteEntityToDto( List<Quote> quotes) {
		return quotes.stream().map(entity -> new QuoteDto(entity.getId(), entity.getVehicle(), entity.getCustomer(), entity.getComment())).collect(Collectors.toList());
	}
	
	public List<Quote> quoteDtoToEntity( List<QuoteDto> quotes) {
		return quotes.stream().map(dto -> new Quote(dto.getId(), dto.getVehicle(), dto.getCustomer(), dto.getComment())).collect(Collectors.toList());
	}
}
