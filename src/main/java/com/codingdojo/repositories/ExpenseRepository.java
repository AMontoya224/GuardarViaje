package com.codingdojo.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.models.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long>{
	List<Expense> findAll();
	
	@SuppressWarnings("unchecked")
	Expense save( Expense expense );
	
	List<Expense> findByid( int id );
	
	@Transactional
	void deleteByid( int id );
}
