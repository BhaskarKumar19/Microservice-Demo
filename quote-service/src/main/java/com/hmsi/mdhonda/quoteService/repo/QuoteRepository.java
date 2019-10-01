package com.hmsi.mdhonda.quoteService.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hmsi.mdhonda.quoteService.entities.Quote;


@Repository
public interface QuoteRepository extends JpaRepository<Quote, Integer>{

	
	
}
