package tn.g3.spring.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="transactionID")
	private int transactionid;
	
	@Temporal(TemporalType.DATE)
	private Date transactionDate;

	private float transactionAmount;
	
	@Enumerated(EnumType.STRING)
	private TransType transactionType;
	
	  private int nbreC;
	  private float amountC;
	    
	
    @ManyToOne
    @JoinColumn(name = "idcontract",referencedColumnName="Id")
	@JsonIgnore
    private Contract transactionprice;


	public int getTransactionid() {
		return transactionid;
	}


	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}


	public Date getTransactionDate() {
		return transactionDate;
	}


	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}


	public float getTransactionAmount() {
		return transactionAmount;
	}


	public void setTransactionAmount(float transactionAmount) {
		this.transactionAmount = transactionAmount;
	}


	public TransType getTransactionType() {
		return transactionType;
	}


	public void setTransactionType(TransType transactionType) {
		this.transactionType = transactionType;
	}


	public int getNbreC() {
		return nbreC;
	}


	public void setNbreC(int nbreC) {
		this.nbreC = nbreC;
	}


	public float getAmountC() {
		return amountC;
	}


	public void setAmountC(float amountC) {
		this.amountC = amountC;
	}


	public Contract getTransactionprice() {
		return transactionprice;
	}


	public void setTransactionprice(Contract transactionprice) {
		this.transactionprice = transactionprice;
	}


	@Override
	public String toString() {
		return "Transaction [transactionid=" + transactionid + ", transactionDate=" + transactionDate
				+ ", transactionAmount=" + transactionAmount + ", transactionType=" + transactionType + ", nbreC="
				+ nbreC + ", amountC=" + amountC + ", transactionprice=" + transactionprice + "]";
	}


	public Transaction(int transactionid, Date transactionDate, float transactionAmount, TransType transactionType,
			int nbreC, float amountC, Contract transactionprice) {
		super();
		this.transactionid = transactionid;
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
		this.transactionType = transactionType;
		this.nbreC = nbreC;
		this.amountC = amountC;
		this.transactionprice = transactionprice;
	}


	public Transaction(Date transactionDate, float transactionAmount, TransType transactionType, int nbreC,
			float amountC, Contract transactionprice) {
		super();
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
		this.transactionType = transactionType;
		this.nbreC = nbreC;
		this.amountC = amountC;
		this.transactionprice = transactionprice;
	}


	public Transaction(Date transactionDate, float transactionAmount, TransType transactionType) {
		super();
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
		this.transactionType = transactionType;
	}


	public Transaction() {
		super();
	}
    
    
    

}
