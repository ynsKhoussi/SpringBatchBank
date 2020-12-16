package me.yns.SpringBatchBank.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import me.yns.SpringBatchBank.Entities.Transaction;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	@Autowired
	private ItemReader<TransactionTemp> bankTransactionItemReader;
	@Autowired
	private ItemWriter<Transaction> bankTransactionItemWriter;
	@Autowired
	private ItemProcessor<TransactionTemp,Transaction> bankTransactionItemProcessor;
	
	public Job bankJob() {
		Step step=stepBuilderFactory.get("step-load-data")
				.<TransactionTemp,Transaction>chunk(100)
				.reader(bankTransactionItemReader)
				.processor(bankTransactionItemProcessor)
				.writer(bankTransactionItemWriter)
				.build();
		return jobBuilderFactory.get("bank-data-loader-job")
				.start(step).build();
	}
	@Bean
	public FlatFileItemReader<TransactionTemp> flatFileItemReader(@Value("${inputFile}") Resource inputFile){
		FlatFileItemReader<TransactionTemp> fileItemReader=new FlatFileItemReader<>();
		fileItemReader.setName("FFIR1");
		fileItemReader.setLinesToSkip(1);
		fileItemReader.setResource(inputFile);
		fileItemReader.setLineMapper(lineMapper());
		return fileItemReader;
	}
	@Bean
	public LineMapper<TransactionTemp> lineMapper() {
		// TODO Auto-generated method stub
		DefaultLineMapper<TransactionTemp> lineMapper=new DefaultLineMapper<>();
		DelimitedLineTokenizer lineTokenizer= new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames("idTransaction","idCompte","montant","dateTransaction");
		BeanWrapperFieldSetMapper fieldSetMapper =new BeanWrapperFieldSetMapper();
		fieldSetMapper.setTargetType(TransactionTemp.class);
		return lineMapper;
	}
	
	
	
}
