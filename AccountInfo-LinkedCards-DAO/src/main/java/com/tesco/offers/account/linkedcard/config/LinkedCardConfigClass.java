/* @CopyRight Tesco.All Rights are reserved */
package com.tesco.offers.account.linkedcard.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import com.tesco.offers.config.ConfigurationFile_Balance;

/**
 * @author:Tesco
 * @Date:Mar 3, 2019
 * @Time:7:38:19 PM
 * @Description:Tesco Project
 */

@Configuration
//@ImportResource("classpath:/config/applicationContextsss.xml")
@Import({ConfigurationFile_Cards.class})
@ComponentScan(basePackages="com.tesco.offers.account.linkedcard.dao.implentation")
public class LinkedCardConfigClass {

}
