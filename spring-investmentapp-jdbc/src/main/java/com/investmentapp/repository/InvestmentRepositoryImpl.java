package com.investmentapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.investmentapp.model.Investment;
import com.investmentapp.util.DBQueries;

@Repository
public class InvestmentRepositoryImpl implements IInvestmentRepository {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	@Override
	public void addInvestment(Investment investment) {
		String sql = DBQueries.INSERTQUERY;
		Object[] investmentArray = {
			investment.getPlanName(),investment.getEntryAge(),investment.getType(),investment.getAmount(),investment.getPurpose(),investment.getRisk(),investment.getNominee(),investment.getTerm()	
		};
		jdbcTemplate.update(DBQueries.INSERTQUERY, investmentArray);
	}

	@Override
	public void updateInvestment(int planId, double amount) {
		String sql = DBQueries.UPDATEQUERY;
		jdbcTemplate.update(sql,amount,planId);

	}

	@Override
	public void deleteInvestment(int planId) {
		jdbcTemplate.update(DBQueries.DELETEQUERY,planId);
	}

	@Override
	public List<Investment> findByType(String type) {
		List<Investment> investments = jdbcTemplate.query(DBQueries.SELECTBTTYPE,
				(rs,rowNum)->{
					
					Investment investment = new Investment();
					investment.setAmount(rs.getDouble("amount"));
					investment.setEntryAge(rs.getInt("entry_age"));
					investment.setRisk(rs.getString("risk"));
					investment.setPlanName(rs.getString("plan_name"));
					investment.setPlanId(rs.getInt("plan_id"));
					investment.setNominee(rs.getString("nominee"));
					investment.setTerm(rs.getInt("term"));
					investment.setPurpose(rs.getString("purpose"));
					investment.setType(rs.getString("type"));
					return investment;
					
				}
				, type);
		
		return investments;
	}

	@Override
	public List<Investment> findByRiskAndTerm(String risk, int term) {
		List<Investment> investments = jdbcTemplate.query(DBQueries.SELECTBYRISKTERM,
				(rs,rowNum)->{
					
					Investment investment = new Investment();
					investment.setAmount(rs.getDouble("amount"));
					investment.setEntryAge(rs.getInt("entry_age"));
					investment.setRisk(rs.getString("risk"));
					investment.setPlanName(rs.getString("plan_name"));
					investment.setPlanId(rs.getInt("plan_id"));
					investment.setNominee(rs.getString("nominee"));
					investment.setTerm(rs.getInt("term"));
					investment.setPurpose(rs.getString("purpose"));
					investment.setType(rs.getString("type"));
					return investment;
					
				}
				,risk,term);
		return investments;
	}

	@Override
	public List<Investment> findByPurpose(String purpose) {
		List<Investment> investments = jdbcTemplate.query(DBQueries.SELECTBYPURPOSE,new RowMapper<Investment>() {

			@Override
			public Investment mapRow(ResultSet rs, int rowNum) throws SQLException {
				Investment investment = new Investment();
				investment.setAmount(rs.getDouble("amount"));
				investment.setEntryAge(rs.getInt("entry_age"));
				investment.setRisk(rs.getString("risk"));
				investment.setPlanName(rs.getString("plan_name"));
				investment.setPlanId(rs.getInt("plan_id"));
				investment.setNominee(rs.getString("nominee"));
				investment.setTerm(rs.getInt("term"));
				investment.setPurpose(rs.getString("purpose"));
				investment.setType(rs.getString("type"));
				return investment;
				
			}
		
		} , purpose);
		
		return investments;
	}

	@Override
	public List<Investment> findall() {
		RowMapper<Investment> mapper = (RowMapper<Investment>) new InvestmentMapper();
		List<Investment> investments = jdbcTemplate.query(DBQueries.SELECTQUERY,mapper );
		return investments;
	}

	@Override
	public Investment findById(int planId) {
		return jdbcTemplate.queryForObject(DBQueries.SELECTBYID,new InvestmentMapper(),planId);
			
	}

}
