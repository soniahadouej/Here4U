package tn.g3.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.g3.spring.entity.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction,Integer> {

}
