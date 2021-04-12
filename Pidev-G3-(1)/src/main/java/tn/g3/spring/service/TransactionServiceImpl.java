package tn.g3.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.g3.spring.entity.Transaction;
import tn.g3.spring.repository.TransactionRepository;

@Service
@Transactional

public class TransactionServiceImpl implements ITransactionService{

	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public Transaction addTransaction(Transaction t) {
		Transaction transaction = transactionRepository.save(t);
		return transaction;
	}

	@Override
	public void deleteTransaction(int id) {
		transactionRepository.deleteById(id);		
	}

	@Override
	public List<Transaction> retrieveAllTransactions() {
		List<Transaction> transaction = (List<Transaction>) transactionRepository.findAll();
		return transaction;
	}

	@Override
	public Transaction retrieveTransactions(int id) {

		Optional<Transaction> TransOptional=transactionRepository.findById(id);
		Transaction t=TransOptional.get();	        
		return t;

	}

	@Override
	public List<Transaction> listAll() {

		return (List<Transaction>) transactionRepository.findAll();

	}

}

