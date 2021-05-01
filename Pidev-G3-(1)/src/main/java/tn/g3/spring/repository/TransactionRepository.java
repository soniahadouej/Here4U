package tn.g3.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.g3.spring.entity.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction,Integer> {

	@Query("select c from Transaction c where c.transactionprice = '2L'  ")
    List<Transaction> findAllByIdTran();

}
