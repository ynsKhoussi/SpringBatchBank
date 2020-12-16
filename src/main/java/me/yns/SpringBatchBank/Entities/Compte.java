package me.yns.SpringBatchBank.Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Compte {
	@Id
	private Long idCompt;
	private Long solde;
	@OneToMany(mappedBy="compte" ,fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Transaction> lt;
	public Compte(Long idCompt, Long solde, List<Transaction> lt) {
		super();
		this.idCompt = idCompt;
		this.solde = solde;
		this.lt = lt;
	}
	public List<Transaction> getLt() {
		return lt;
	}
	public void setLt(List<Transaction> lt) {
		this.lt = lt;
	}
	public Compte(Long idCompt, Long solde) {
		super();
		this.idCompt = idCompt;
		this.solde = solde;
	}
	public Compte() {
		super();
	}
	public Long getIdCompt() {
		return idCompt;
	}
	public void setIdCompt(Long idCompt) {
		this.idCompt = idCompt;
	}
	public Long getSolde() {
		return solde;
	}
	public void setSolde(Long solde) {
		this.solde = solde;
	}
	
}
