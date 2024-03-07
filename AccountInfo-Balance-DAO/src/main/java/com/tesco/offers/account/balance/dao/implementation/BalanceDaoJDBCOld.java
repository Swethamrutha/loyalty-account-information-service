
	package com.tesco.offers.account.balance.dao.implementation;


	import java.sql.CallableStatement;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Types;

import org.springframework.stereotype.Component;

import com.tesco.offers.account.balance.dao.BalanceDAOInterface;
	import com.tesco.offers.account.balance.dao.exception.BalanceBusinessException;
	import com.tesco.offers.account.balance.dao.exception.BalanceSystemException;
	import com.tesco.offers.account.balances.dao.beans.BalanceDAOResponse;
	import com.tesco.offers.account.balances.dao.beans.BalanceDaoRequest;

	/**
	 * @author:Tesco
	 * @Date:Jan 7, 2019
	 * @Time:7:51:59 PM 
	 * @Description:Tesco Developing Project
	 */
	@Component
	public class BalanceDaoJDBCOld implements BalanceDAOInterface{


		public BalanceDAOResponse getBalance(BalanceDaoRequest request) throws BalanceBusinessException, BalanceSystemException, ClassNotFoundException, SQLException 
		{
			BalanceDAOResponse response = null;	
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/swethaRTP4223" ,"root","root");
				String sql="{call Get_Balances(?,?,?,?,?)}";
				CallableStatement cs = con.prepareCall(sql);
				System.out.println(cs);
				
				
				cs.registerOutParameter(4, Types.VARCHAR);
				cs.registerOutParameter(5, Types.VARCHAR);
				
				System.out.println("Getting and checking:::::: "+request.getAccountnumber());
				cs.setString(1, request.getClientid());
				cs.setString(2, request.getChannelid());
				cs.setString(3, request.getAccountnumber());
				cs.execute();
				
				ResultSet rs = cs.executeQuery();
				System.out.println(rs);
				
				
			     System.out.println("output parameter of respcode:::::::"+cs.getString(4));
				System.out.println("output parameter of respMsg:::::::"+cs.getString(5));
				System.out.println(cs);
				
				String dbRespCode=cs.getString(4);
				String dbRespMsg=cs.getString(5);
				
	         System.out.println("dbrespcode:::::::::"+dbRespCode);			
			if("0".equals(dbRespCode))
			{
			// TODO Auto-generated method stub
			System.out.println("Entered into Dao Layer:::::"+request);
			
		
			while(rs.next())
			{
				System.out.println("Input parameter:::::::"+rs.getString(1)+"::::"+rs.getString(2)+"::::"+rs.getString(3));
				 response =new BalanceDAOResponse();
				 response.setAvailablePts(Long.valueOf(rs.getString(5)));
				response.setBalanceAmt(Double.valueOf(rs.getString(3)));
				response.setCreditLimit(Double.valueOf(rs.getString(4)));
				
			}
			
			}
			else if("100".equals(dbRespCode) || "101".equals(dbRespCode) )
			{
				System.out.println("100");
				throw new BalanceBusinessException(dbRespCode,dbRespMsg);
			}
			else
			{
				throw new BalanceSystemException(dbRespCode,dbRespMsg);
			}
			}
			catch(BalanceBusinessException bbe)
			{
				System.out.println("catch:::::::::"+bbe.getRespCode());
				
				bbe.getRespMsg();
				throw bbe;
			}
			catch(BalanceSystemException bse)
			{
				System.out.println("catch:::::::::"+bse.getRespCode());
				
				throw bse;
			}
			
			System.out.println("Balance Dao Response"+response);

			
			return response;
			
		}
		public static void main(String[] args)
		{
			System.out.println("ok");
		}
		
	}