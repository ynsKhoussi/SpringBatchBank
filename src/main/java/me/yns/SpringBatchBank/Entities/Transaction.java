package me.yns.SpringBatchBank.Entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {
	@Id
	private Long idTrasaction;
	private Long montant;
	private Date dateTransaction;
	private Date dateDebit;
	@ManyToOne
	@JoinColumn(name="id_compt")
	private Compte compte;
	public Transaction(Long idTrasaction, Long montant, Date dateTransaction, Date dateDebit, Compte compte) {
		super();
		this.idTrasaction = idTrasaction;
		this.montant = montant;
		this.dateTransaction = dateTransaction;
		this.dateDebit = dateDebit;
		this.compte = compte;
	}
	public Long getIdTrasaction() {
		return idTrasaction;
	}
	public void setIdTrasaction(Long idTrasaction) {
		this.idTrasaction = idTrasaction;
	}
	public Long getMontant() {
		return montant;
	}
	public void setMontant(Long montant) {
		this.montant = montant;
	}
	public Date getDateTransaction() {
		return dateTransaction;
	}
	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}
	public Date getDateDebit() {
		return dateDebit;
	}
	public void setDateDebit(Date dateDebit) {
		this.dateDebit = dateDebit;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public Transaction() {
		super();
	}
	
}
