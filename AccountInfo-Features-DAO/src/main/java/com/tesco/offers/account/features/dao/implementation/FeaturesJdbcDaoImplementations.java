package com.tesco.offers.account.features.dao.implementation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.tesco.offers.account.features.dao.beans.AccountFeaturesDao;
import com.tesco.offers.account.features.dao.beans.FeaturesDaoRequest;
import com.tesco.offers.account.features.dao.beans.FeaturesDaoResponse;
import com.tesco.offers.account.features.dao.exception.FeatureBusinessException;
import com.tesco.offers.account.features.dao.exception.FeatureServiceException;
import com.tesco.offers.account.features.dao.interf.FeaturesDao;

public class FeaturesJdbcDaoImplementations implements FeaturesDao {

	public FeaturesDaoResponse getAccountFeatures(FeaturesDaoRequest request)
			throws FeatureBusinessException, FeatureServiceException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		FeaturesDaoResponse response = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/swethaRTP4223", "root", "root");
			String sql = "{call Get_Features(?,?,?,?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			System.out.println("Features Implemetation callable" + cs);

			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);

			System.out.println("Getting and checking:::::: " + request.getAccountnumber());
			cs.setString(1, request.getClientid());
			cs.setString(2, request.getChannelid());
			cs.setString(3, request.getAccountnumber());
			cs.execute();

			ResultSet rs = cs.executeQuery();
			System.out.println("ResultSetException::::::::::" + rs);
			System.out.println(rs);

			System.out.println("output parameter of respcode:::::::" + cs.getString(4));
			System.out.println("output parameter of respMsg:::::::" + cs.getString(5));
			System.out.println(cs);

			String dbRespCode = cs.getString(4);
			String dbRespMsg = cs.getString(5);

			System.out.println("dbrespcode:::::::::" + dbRespCode);
			List<AccountFeaturesDao> accountfeatures = new ArrayList<AccountFeaturesDao>();

			if ("0".equals(dbRespCode)) {
				System.out.println("entering into if in feature");
				while (rs.next()) {
					AccountFeaturesDao feature1 = new AccountFeaturesDao();
					System.out.println("get Code from feature:::" + rs.getString(3));
					System.out.println("get code from desc::" + rs.getString(4));
					System.out.println("get code from eligibilty:::" + Boolean.valueOf(rs.getString(2)));
					feature1.setCode(rs.getString(3));
					feature1.setDesc(rs.getString(4));
					feature1.setEligibility(Boolean.valueOf(rs.getString(2)));
					//feature1.setExpiryDate(rs.getString(5));

					
					accountfeatures.add(feature1);
					System.out.println("List in Feature for AccountFeaturesDao::::::::" + accountfeatures);

					response = new FeaturesDaoResponse();
					response.setStatusCode(cs.getString(4));
					response.setStatusMsg(cs.getString(5));

					response.setAccountfeatures(accountfeatures);
				}
			} else if ("100".equals(dbRespCode)) {
				throw new FeatureBusinessException("100", "FeatureDatabaseException");
			} else {
				throw new FeatureServiceException("101", "Feature Service Exception");
			}
		} catch (FeatureBusinessException fbe) {
			throw fbe;
		} catch (FeatureServiceException fse) {
			throw fse;
		}
		System.out.println("exit dao response :" + response);
		return response;
	}

}
