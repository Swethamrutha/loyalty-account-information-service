	package com.tesco.offers.account.linkedcard.dao.implentation;

	import java.util.ArrayList;
	import java.util.List;

	import org.hibernate.Criteria;
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.criterion.Restrictions;

	import com.tesco.offers.account.balance.entities.Channel_Details;
	import com.tesco.offers.account.balance.entities.Client_Details;
	import com.tesco.offers.account.balance.entities.Customer_Details;
	import com.tesco.offers.account.balance.utils.HibernateUtils;
	import com.tesco.offers.account.linkedcard.dao.beans.CardsDAORequest;
	import com.tesco.offers.account.linkedcard.dao.beans.CardsDAOResponse;
	import com.tesco.offers.account.linkedcard.dao.exception.LinkedCardBusinessException;
	import com.tesco.offers.account.linkedcard.dao.exception.LinkedCardSystemException;
	import com.tesco.offers.account.linkedcard.dao.interf.CardsDAO;
	import com.tesco.offers.account.linkedcard.entities.LinkedCards_Info;




	public class  SpringDaoPureHibernate implements CardsDAO{

		public CardsDAOResponse getAllCards(CardsDAORequest request)
				throws LinkedCardBusinessException, LinkedCardSystemException  {
			
			System.out.println("entered into method");
			
			CardsDAOResponse response=new CardsDAOResponse();
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			System.out.println("SessionFactory::::::::"+sessionFactory);
			
			Session session=sessionFactory.openSession();
			
			//getting list of client
			Criteria criteria=session.createCriteria(Client_Details.class);
			criteria.add(Restrictions.eq("client", request.getClientid()));
		    List<Client_Details> clientList = criteria.list();
		    System.out.println("list in client::"+clientList);
			
		    for (Client_Details client_Details : clientList) {
				System.out.println(client_Details.getClient());
			}
		    
		    
		    if(clientList==null)
			{
			response.setStatusCode("100");
			response.setStatusMsg("InvalidClient");
			
			}
			
		   //getting list of channel
		    Criteria criteria1=session.createCriteria(Channel_Details.class);
			criteria1.add(Restrictions.eq("channel", request.getChannelid()));
		    List<Channel_Details> channelList = criteria1.list();
			
		    
		    for (Channel_Details channel_Details : channelList) {
				System.out.println(channel_Details.getChannel());
			}
		    if(channelList==null)
			{
			response.setStatusCode("101");
			response.setStatusMsg("Invalid ChannelId");
			throw new LinkedCardBusinessException(response.getStatusCode(),response.getStatusMsg());
			}
		    
		    //getting list of customer
		    
		    Criteria criteria2=session.createCriteria(Customer_Details.class);
			criteria2.add(Restrictions.eq("cardNumber", request.getAccountnumber()));
		    List<Customer_Details> customerList = criteria2.list();
			
		    
		    for (Customer_Details customer_Details : customerList) {
				System.out.println(customer_Details.getCardNumber());
			}
		    if(customerList==null)
			{
		    	
			response.setStatusCode("102");
	     	response.setStatusMsg("Invalid CardNumber");
			
			}
		    
		    //getting list of feature
		    
		    
		    
		    Criteria cardsCriteria=session.createCriteria(LinkedCards_Info.class);
		    cardsCriteria.add(Restrictions.eq("cardNumber", request.getAccountnumber()));
		    List<LinkedCards_Info> cardsList = cardsCriteria.list();
		    System.out.println(cardsList);
			
		    for (LinkedCards_Info linkedCards_Info : cardsList) {
		    	System.out.println(linkedCards_Info.getLinkedCards());
		    	String cardNum=linkedCards_Info.getLinkedCards();
		    	String[] cardNumSplit=cardNum.split(",");
		    	
		    	List<String> cardsAddList=new ArrayList<String>();
		    	
		    	for (String getCards : cardNumSplit) {
					
		    		System.out.println(getCards);
		    		cardsAddList.add(getCards);
				}
		    	
		    	response.setLinkedCards(cardsAddList);
			}
		    
		    
		    if(cardsList==null)
			{
			response.setStatusCode("102");
	     	response.setStatusMsg("Invalid CardNumber");
			
			}
	    
			response.setStatusCode("0");
			response.setStatusMsg("success");
			
		return response;
		}

		public static void main(String[] args) throws LinkedCardBusinessException, LinkedCardSystemException{
			// TODO Auto-generated method stub
	    System.out.println("Main Method");
		System.out.println("Request Completed");

		CardsDAORequest request =new CardsDAORequest();
		//System.out.println("Request Completed");

		request.setClientid("web");
		request.setChannelid("online");
		request.setAccountnumber("1111222233334444");
		
		//System.out.println("Request Completed");
		CardsDAOImplementation hibernateChecking=new CardsDAOImplementation();
		CardsDAOResponse CardsDAOResponse=hibernateChecking.getAllCards(request);
		System.out.println(CardsDAOResponse);
		
		
			}


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*public CardsDAOImplementation()
		{
			super(prepareCardJdbcTemplate(),"Get_LinkedCards");
			registerOutInParams();
		}
		
		
		private static JdbcTemplate prepareCardJdbcTemplate() {
			// TODO Auto-generated method stub
		DriverManagerDataSource datasource=new DriverManagerDataSource(); 
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/swethaRTP4223");
		datasource.setUsername("root");
		datasource.setPassword("root");
		JdbcTemplate jdbctemplate=new JdbcTemplate(datasource);
	     return jdbctemplate;
	}


	   private void registerOutInParams() {
			// TODO Auto-generated method stub
		   declareParameter(new SqlReturnResultSet("cardResultSet", this));
			//set balance daorequest 
			declareParameter(new SqlParameter("CLIENT_ID", Types.VARCHAR));
			declareParameter(new SqlParameter("CHANNEL_ID", Types.VARCHAR));
			declareParameter(new SqlParameter("CARD_NUMBER", Types.VARCHAR));
			declareParameter(new SqlOutParameter("RESPCODE", Types.VARCHAR));
			
			declareParameter(new SqlOutParameter("RESPMSG", Types.VARCHAR));
			compile();
		}

	   public CardsDAOResponse mapRow(ResultSet rs, int arg1) throws SQLException {
			// TODO Auto-generated method stub
		   CardsDAOResponse response=new CardsDAOResponse();
		   String getLinkedcards=rs.getString(3);
		   System.out.println("Getting Cards::"+getLinkedcards);
		  String[] getSeparateCard= getLinkedcards.split(",");
		  List l=new ArrayList();
		    
		  for(String get:getSeparateCard)
		  {
		    l.add(get);
		     response.setLinkedCards(l);
		  }
		  System.out.println("List getting::"+l.size());
		   System.out.println("Response printing::::::::::"+response);
		   return response;
		}


	   public CardsDAOResponse getAllCards(CardsDAORequest request)
				throws LinkedCardBusinessException, LinkedCardSystemException, ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
		   
		   
		   CardsDAOResponse cardsDAOResponse=new CardsDAOResponse();
		   System.out.println("coming to cardResponse");
		   Map<String,Object> inputMap=new HashMap<String,Object>();
		     inputMap.put("CLIENT_ID", request.getClientid());
		     inputMap.put("CHANNEL_ID", request.getChannelid());
		     inputMap.put("CARD_NUMBER", request.getAccountnumber());
		   
		     Map<String, Object> resMap = super.execute(inputMap);
			String dbRespCode = resMap.get("RESPCODE").toString();
			String dbRespMsg = resMap.get("RESPMSG").toString();
		   
			if("0".equals(dbRespCode))
		   {
			List<CardsDAOResponse>	list=(List<CardsDAOResponse>)resMap.get("cardResultSet");
			System.out.println("result Set list size::::::::"+list.size());
			
			for (CardsDAOResponse cardsRes : list) {
				System.out.println("cards data:::"+cardsRes.getLinkedCards());
		        List<String> ss=cardsRes.getLinkedCards();
		        cardsDAOResponse.setLinkedCards(ss);
		        cardsDAOResponse.setStatusCode(dbRespCode);
				cardsDAOResponse.setStatusMsg(dbRespMsg);
				}
			
		   }
	   
			else if("100".equals(dbRespCode) || "102".equals(dbRespCode) )
			{
				throw new LinkedCardBusinessException("100", "LinkedCardsBusinessException" );
			}
			else
			{
				throw new LinkedCardSystemException("101", "LinkedCardsSystemException");
			}
			
			System.out.println("cardsDaoResponse:::::"+cardsDAOResponse);
			return cardsDAOResponse;
		}
		

	   public static void main(String[] args) throws ClassNotFoundException, LinkedCardBusinessException, LinkedCardSystemException, SQLException {
			// TODO Auto-generated method stub

		   CardsDAO cardsSpringDao=new CardsDAOImplementation();
		   CardsDAORequest request=new CardsDAORequest();
			request.setAccountnumber("1111222233334444");
			request.setChannelid("online");
			request.setClientid("web");
			
		 CardsDAOResponse cardDAOResponse = cardsSpringDao.getAllCards(request);
		 cardsSpringDao.getAllCards(request);
	    System.out.println("Response of LinkedCards:::"+cardDAOResponse);
			
		}

	*/




























	/*public CardsDAOResponse getAllCards(CardsDAORequest request) throws LinkedCardBusinessException, LinkedCardSystemException, ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
			
			CardsDAOResponse response=null;
			
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/swethaRTP4223" ,"root","root");
				String sql="{call Get_LinkedCards(?,?,?,?,?)}";
				CallableStatement cs = con.prepareCall(sql);
				System.out.println("Features Implemetation callable"+cs);
				
				
				cs.registerOutParameter(4, Types.VARCHAR);
				cs.registerOutParameter(5, Types.VARCHAR);
				
				System.out.println("Getting and checking:::::: "+request.getAccountnumber());
				cs.setString(1, request.getClientid());
				cs.setString(2, request.getChannelid());
				cs.setString(3, request.getAccountnumber());
				cs.execute();
				
				ResultSet rs = cs.executeQuery();
				System.out.println("ResultSetException::::::::::"+rs);
				System.out.println(rs);
				
				
			     System.out.println("output parameter of respcode:::::::"+cs.getString(4));
				System.out.println("output parameter of respMsg:::::::"+cs.getString(5));
				System.out.println(cs);
				
				String dbRespCode=cs.getString(4);
				String dbRespMsg=cs.getString(5);
				
	         System.out.println("dbrespcode:::::::::"+dbRespCode);			
		
			if("0".equals(dbRespCode))
			{
				while(rs.next())
				{
			List<String> linkedcards=new ArrayList<String>();
			String cards=rs.getString(3);
			String[] split=cards.split(",");
			for (String gettingCards : split) {
	         linkedcards.add(gettingCards);
				}
			linkedcards.add(rs.getString(3));
			linkedcards.add("22222222222222222222");
			
			
	        response=new CardsDAOResponse();
			response.setStatusCode("0");
			response.setStatusMsg("success");
			response.setLinkedCards(linkedcards);
				}
			}
			else if("100".equals(dbRespCode))
			{
				throw new LinkedCardBusinessException("100", "LinkedCardsBusinessException" );
			}
			else
			{
				throw new LinkedCardSystemException("101", "LinkedCardsSystemException");
				
				
			}
			}
			catch(LinkedCardBusinessException lbe)
			{
				throw lbe;
				
			}
			catch(LinkedCardSystemException lse)
			{
				throw lse;
			}
			
			return response;
		}

	*/	
		
		
		
		
		
		

	}
