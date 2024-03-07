/* @CopyRight Tesco.All Rights are reserved */
package com.tesco.offers.account.balance.dao.implementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.object.StoredProcedure;

import com.tesco.offers.account.balance.dao.BalanceDAOInterface;
import com.tesco.offers.account.balance.dao.exception.BalanceBusinessException;
import com.tesco.offers.account.balance.dao.exception.BalanceSystemException;
import com.tesco.offers.account.balances.dao.beans.BalanceDAOResponse;
import com.tesco.offers.account.balances.dao.beans.BalanceDaoRequest;

/**
 * @author:Tesco
 * @Date:Feb 5, 2019
 * @Time:11:52:30 AM
 * @Description:Tesco Project
 */

public class BalanceSpringDaoImplementation extends StoredProcedure implements BalanceDAOInterface, RowMapper<BalanceDAOResponse> {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws BalanceSystemException 
	 * @throws BalanceBusinessException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, BalanceBusinessException, BalanceSystemException, SQLException {
		// TODO Auto-generated method stub

		BalanceDAOImplementation springDaoBalance=new BalanceDAOImplementation();
		BalanceDaoRequest request=new BalanceDaoRequest();
		request.setAccountnumber("1111222233334444");
		request.setChannelid("online");
		request.setClientid("web");
		
		BalanceDAOResponse balanceDAOResponse=springDaoBalance.getBalance(request);
		System.out.println(balanceDAOResponse);
		
	}
	
	public BalanceSpringDaoImplementation()
	{
		super(prepareJdbcTemplate(),"Get_Balances");
		registersParams();
	}
	
	
	private static JdbcTemplate prepareJdbcTemplate() {
		// TODO Auto-generated method stub
		DriverManagerDataSource datasource=new DriverManagerDataSource(); 
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/swethaRTP4223");
		datasource.setUsername("root");
		datasource.setPassword("root");
		JdbcTemplate jdbctemplate=new JdbcTemplate(datasource);
	     return jdbctemplate;
	}

	private void registersParams() {
		// TODO Auto-generated method stub
		declareParameter(new SqlReturnResultSet("balanceResultSet", this));
		//set balance daorequest 
		declareParameter(new SqlParameter("CLIENT_ID", Types.VARCHAR));
		declareParameter(new SqlParameter("CHANNEL_ID", Types.VARCHAR));
		declareParameter(new SqlParameter("CARD_NUMBER", Types.VARCHAR));
		declareParameter(new SqlOutParameter("RESPCODE", Types.VARCHAR));
		
		declareParameter(new SqlOutParameter("RESPMSG", Types.VARCHAR));
		compile();
	}

	public BalanceDAOResponse getBalance(BalanceDaoRequest request) throws BalanceBusinessException, BalanceSystemException, ClassNotFoundException, SQLException 
	{
		BalanceDAOResponse response = new BalanceDAOResponse() ;
		Map<String, Object> inputmap=new HashMap<String,Object>();
		inputmap.put("CLIENT_ID", request.getClientid());
		inputmap.put("CHANNEL_ID", request.getChannelid());
		inputmap.put("CARD_NUMBER", request.getAccountnumber());
		
		Map<String,Object> respMap=super.execute(inputmap);
		
		String dbRespCode=respMap.get("RESPCODE").toString();
		String dbRespMsg=respMap.get("RESPMSG").toString();
		
		if("0".equals(dbRespCode))
		{
			
			List<BalanceDAOResponse> responses=(List<BalanceDAOResponse>)respMap.get("balanceResultSet");
			for (BalanceDAOResponse balanceDAOResponse : responses) {
			response.setAvailablePts(balanceDAOResponse.getAvailablePts());
			response.setBalanceAmt(balanceDAOResponse.getBalanceAmt());
			response.setCreditLimit(balanceDAOResponse.getCreditLimit());
			}
			response.setRespCode(dbRespCode);
			response.setRespMsg(dbRespMsg);
		}
		else if("100".equals(dbRespCode) || "101".equals(dbRespCode) || "102".equals(dbRespCode))
		{
			throw new BalanceBusinessException(dbRespCode,dbRespMsg);
		}
		else {
			throw new BalanceSystemException(dbRespCode,dbRespMsg);
		}
		
		return response;
	}
	
	
	public BalanceDAOResponse mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		BalanceDAOResponse response=new BalanceDAOResponse();
		response.setAvailablePts(Long.valueOf(rs.getString(5)));
		response.setBalanceAmt(Double.valueOf(rs.getString(3)));
		response.setCreditLimit(Double.valueOf(rs.getString(4)));
		
		return response;
		 
	}
	
	
}
