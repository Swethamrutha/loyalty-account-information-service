/* @CopyRight Tesco.All Rights are reserved */
package com.tesco.offers.account.balance.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author:Tesco
 * @Date:Feb 4, 2019
 * @Time:8:24:58 PM
 * @Description:Tesco Project
 */

@Entity
@Table(name="channel_details")
public class Channel_Details implements Serializable {

	private static final long serialVersionUID = -3907726985368411794L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column
	private Integer id;
	
    @Column
    private String channel;
    
    @Column
    private String desc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
    
    
    


}
