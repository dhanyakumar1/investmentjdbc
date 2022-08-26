package com.investmentapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.investmentapp.model.Investment;
import com.investmentapp.repository.IInvestmentRepository;
@Service
public class InvestmentServiceImpl implements IInvestmentService {
	private IInvestmentRepository investmentRepository;
	
	@Autowired
	public void setInvestmentRepository(IInvestmentRepository investmentRepository) {
		this.investmentRepository = investmentRepository;
	}
	
	@Override
	public void addInvestment(Investment investment) {
		investmentRepository.addInvestment(investment);
		

	}

	

	@Override
	public void updateInvestment(int planId, double amount) {
		investmentRepository.updateInvestment(planId, amount);
		

	}

	@Override
	public void deleteInvestment(int planId) {
		investmentRepository.deleteInvestment(planId);
		
	}

	@Override
	public List<Investment> getByType(String type) {
		List<Investment> investments =investmentRepository.findByType(type);
		return investments;
	}

	@Override
	public List<Investment> getByRiskAndTerm(String risk, int term) {
		List<Investment> investments =investmentRepository.findByRiskAndTerm(risk, term);
		return investments;
	}

	@Override
	public List<Investment> getByPurpose(String type) {
		List<Investment> investments=investmentRepository.findByPurpose(type);
		return investments;
	}

	@Override
	public List<Investment> getall() {
		List<Investment> investments= investmentRepository.findall();
		return investments;
	}

	@Override
	public double calculateMaturity(Investment investment) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Investment getById(int planId) {
		// TODO Auto-generated method stub
		return null;
	}

}
