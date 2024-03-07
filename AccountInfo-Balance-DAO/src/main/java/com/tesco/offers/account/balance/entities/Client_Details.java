package com.tesco.offers.account.balance.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="client_details")
public class Client_Details implements Serializable {

	private static final long serialVersionUID = 6940329778649150845L;
	
	   @Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		
		@Column
		private Integer id;
		
        @Column
        private String client;
        
        @Column
        private String desc;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getClient() {
			return client;
		}

		public void setClient(String client) {
			this.client = client;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}
        
	
	
	
	

}
