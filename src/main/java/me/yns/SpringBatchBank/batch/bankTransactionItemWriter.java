package me.yns.SpringBatchBank.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.yns.SpringBatchBank.Entities.Compte;
import me.yns.SpringBatchBank.Entities.Transaction;
import me.yns.SpringBatchBank.dao.CompteRepo;
import me.yns.SpringBatchBank.dao.TransactionRepo;
@Component
public class bankTransactionItemWriter implements ItemWriter<Transaction> {

	@Autowired
	private CompteRepo c;
	@Autowired
	private TransactionRepo tr;
	@Override
	public void write(List<? extends Transaction> items) throws Exception {
		// TODO Auto-generated method stub
		
		for (Transaction l:items) {
			try {
				Compte compte=c.findById(l.getCompte().getIdCompt()).orElse(null);
				Long m=compte.getSolde()-l.getMontant();
				compte.setSolde(m);
				c.save(compte);
			} catch (Exception e) {
				System.out.println("pas de compte dans la base de donnee");
			}
			
			tr.save(l);
			
		}
	}
	

}
