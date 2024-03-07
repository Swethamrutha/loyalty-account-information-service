/* @CopyRight Tesco.All Rights are reserved */
package com.tesco.offers.account.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import com.tesco.offers.account.linkedcard.config.LinkedCardConfigClass;
import com.tesco.offers.cardverifyservice.config.Config_CardVerifyService;
import com.tesco.offers.config.ConfigurationFile_Balance;

/**
 * @author:Tesco
 * @Date:Mar 1, 2019
 * @Time:6:21:55 PM
 * @Description:Tesco Project
 */

@Configuration
@ComponentScan(basePackages={"com.tesco.offers.account","com.tesco.offers.account.process.implementation"})
@Import({JavaConfiguration_Feature.class,ConfigurationFile_Balance.class, LinkedCardConfigClass.class, Config_CardVerifyService.class})
public class ConfigurationClass {
	

}
