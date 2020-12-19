package me.yns.SpringBatchBank.batch;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.yns.SpringBatchBank.Entities.Transaction;
import me.yns.SpringBatchBank.dao.CompteRepo;
@Component
public class BankTransactionItemProcessor implements ItemProcessor<TransactionTemp, Transaction> {

	@Autowired
	private CompteRepo c;
	private SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy HH:mm");
	@Override
	public Transaction process(TransactionTemp item) throws Exception {
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date();
		Calendar calobj = Calendar.getInstance();
		Transaction t= new Transaction();
		t.setDateTransaction(df.parse(item.getDateTransaction()));
		t.setCompte(c.findById(item.getIdCompte()).orElse(null));
		t.setDateDebit(calobj.getTime());
		t.setIdTrasaction(item.getIdTransaction());
		t.setMontant(item.getMontant());
		//item.setDateTransaction(df.parse(item.get));
		return t;
	}

}
