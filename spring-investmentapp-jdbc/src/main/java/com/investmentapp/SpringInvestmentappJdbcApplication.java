package com.investmentapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.investmentapp.model.Investment;
import com.investmentapp.model.Nominee;
import com.investmentapp.model.PlanType;
import com.investmentapp.model.Purpose;
import com.investmentapp.model.Risk;
import com.investmentapp.service.IInvestmentService;

@SpringBootApplication
public class SpringInvestmentappJdbcApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringInvestmentappJdbcApplication.class, args);
	
		
	
	}
//	@Autowired
//IInvestmentService iInvestmentService;
//	@Override
//	public void run(String... args) throws Exception {
//		iInvestmentService.addInvestment(new Investment("Voya Mutual", 10, PlanType.mutual.type, 2000, Purpose.MARRIAGE.name(), Risk.HIGH.name(), Nominee.SON.name(), 10));
//		
//	}
	@Autowired
	IInvestmentService investmentService;
	@Override
	public void run(String... args) throws Exception {
		Investment investment = new Investment("Voya Mutual", 1, PlanType.mutual.type, 2000, Purpose.MARRIAGE.name(), Risk.HIGH.name(), Nominee.SON.name(), 1);
		investmentService.addInvestment(investment);
		
		
	}

	
	
	
}
