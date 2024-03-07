package com.tesco.offers.account.features.dao.interf;

import java.sql.SQLException;

import com.tesco.offers.account.features.dao.beans.FeaturesDaoRequest;
import com.tesco.offers.account.features.dao.beans.FeaturesDaoResponse;
import com.tesco.offers.account.features.dao.exception.FeatureBusinessException;
import com.tesco.offers.account.features.dao.exception.FeatureServiceException;

public interface FeaturesDao {
	
	public FeaturesDaoResponse getAccountFeatures(FeaturesDaoRequest request) throws FeatureBusinessException, FeatureServiceException, ClassNotFoundException, SQLException;
	

}
