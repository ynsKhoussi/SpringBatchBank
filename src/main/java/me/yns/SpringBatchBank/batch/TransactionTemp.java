package me.yns.SpringBatchBank.batch;

public class TransactionTemp {

	private Long idTransaction;
	private Long idCompte;
	private Long montant;
	private String dateTransaction;
	public Long getIdTransaction() {
		return idTransaction;
	}
	public void setIdTransaction(Long idTransaction) {
		this.idTransaction = idTransaction;
	}
	public Long getIdCompte() {
		return idCompte;
	}
	public void setIdCompte(Long idCompte) {
		this.idCompte = idCompte;
	}
	public Long getMontant() {
		return montant;
	}
	public void setMontant(Long montant) {
		this.montant = montant;
	}
	public String getDateTransaction() {
		return dateTransaction;
	}
	public void setDateTransaction(String dateTransaction) {
		this.dateTransaction = dateTransaction;
	}
	public TransactionTemp() {
		super();
	}
	public TransactionTemp(Long idTransaction, Long idCompte, Long montant, String dateTransaction) {
		super();
		this.idTransaction = idTransaction;
		this.idCompte = idCompte;
		this.montant = montant;
		this.dateTransaction = dateTransaction;
	}
	
}
