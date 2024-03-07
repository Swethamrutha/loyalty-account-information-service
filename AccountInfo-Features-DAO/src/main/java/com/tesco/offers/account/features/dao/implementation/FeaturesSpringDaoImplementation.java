package com.tesco.offers.account.features.dao.implementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.object.StoredProcedure;

import com.tesco.offers.account.features.dao.beans.AccountFeaturesDao;
import com.tesco.offers.account.features.dao.beans.FeaturesDaoRequest;
import com.tesco.offers.account.features.dao.beans.FeaturesDaoResponse;
import com.tesco.offers.account.features.dao.exception.FeatureBusinessException;
import com.tesco.offers.account.features.dao.exception.FeatureServiceException;
import com.tesco.offers.account.features.dao.interf.FeaturesDao;

public class FeaturesSpringDaoImplementation extends StoredProcedure implements FeaturesDao, RowMapper<AccountFeaturesDao> {

	public FeaturesSpringDaoImplementation() {
		super(prepareFeatureJdbcTemplate(), "Get_Features");
		registerInOutParams();
	}

	private static JdbcTemplate prepareFeatureJdbcTemplate() {
		// TODO Auto-generated method stub
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/swethaRTP4223");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate;
	}

	private void registerInOutParams() {
		// TODO Auto-generated method stub
		declareParameter(new SqlReturnResultSet("featureResultSet", this));
		declareParameter(new SqlParameter("CLIENT_ID", Types.VARCHAR));
		declareParameter(new SqlParameter("CHANNEL_ID", Types.VARCHAR));
		declareParameter(new SqlParameter("CARD_NUMBER", Types.VARCHAR));
		declareParameter(new SqlOutParameter("RESPCODE", Types.VARCHAR));
		declareParameter(new SqlOutParameter("RESPMSG", Types.VARCHAR));
		compile();
	}

	public AccountFeaturesDao mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		AccountFeaturesDao accFeature = new AccountFeaturesDao();
		accFeature.setCode(rs.getString(3));
		accFeature.setDesc(rs.getString(4));
		accFeature.setEligibility(Boolean.valueOf(rs.getString(2)));
		//accFeature.setExpiryDate(rs.getString(5));

		return accFeature;
	}

	@SuppressWarnings("unchecked")
	public FeaturesDaoResponse getAccountFeatures(FeaturesDaoRequest request)
			throws FeatureBusinessException, FeatureServiceException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Map<String, Object> inputMap = new HashMap<String, Object>();
		inputMap.put("CLIENT_ID", request.getClientid());
		inputMap.put("CHANNEL_ID", request.getChannelid());
		inputMap.put("CARD_NUMBER", request.getAccountnumber());

		Map<String, Object> resMap = super.execute(inputMap);
		String dbRespCode = resMap.get("RESPCODE").toString();
		String dbRespMsg = resMap.get("RESPMSG").toString();

		FeaturesDaoResponse featuresDaoResponse = new FeaturesDaoResponse();
		List<AccountFeaturesDao> getFeatureList = new ArrayList<AccountFeaturesDao>();
		
		if ("0".equals(dbRespCode)) {
			getFeatureList = (List<AccountFeaturesDao>) resMap.get("featureResultSet");

			featuresDaoResponse.setStatusCode(dbRespCode);
			featuresDaoResponse.setStatusMsg(dbRespMsg);
			featuresDaoResponse.setAccountfeatures(getFeatureList);

		}

		else if ("100".equals(dbRespCode) || "101".equals(dbRespCode) || "102".equals(dbRespCode)) {
			throw new FeatureBusinessException(dbRespCode, dbRespMsg);
		} else {
			throw new FeatureServiceException(dbRespCode, dbRespMsg);
		}
System.out.println("FeatureDaoResponse::::::::::::::::"+featuresDaoResponse);
		return featuresDaoResponse;

	}

	public static void main(String[] args)
			throws ClassNotFoundException, FeatureBusinessException, SQLException, FeatureServiceException {
		// TODO Auto-generated method stub

		//FeaturesDaoImplementation springDaoFeature = new FeaturesDaoImplementation();
		FeaturesDaoRequest request = new FeaturesDaoRequest();
		request.setAccountnumber("1111222233334444");
		request.setChannelid("online");
		request.setClientid("web");

		/*FeaturesDaoResponse featureDAOResponse = springDaoFeature.getAccountFeatures(request);
		System.out.println(featureDAOResponse);
*/
	}


}
