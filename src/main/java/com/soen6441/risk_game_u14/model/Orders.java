package com.soen6441.risk_game_u14.model;

/***
 * This class is a model for the orders given by the game players
 * @author Aditya, Karandeep
 */
public class Orders {
	private String d_Orders;
	private Map d_Map;
	public Orders() {}

	/***
	 * This constructor initialises the order and map
	 * @param p_Orders this is the order string given by the player
	 * @param p_Map this is the map object where the order has to be performed
	 */
	public Orders(String p_Orders,Map p_Map) {
		this.d_Orders = p_Orders;
		this.d_Map = p_Map;
	}

	public String getD_Orders() {
		return d_Orders;
	}

	public void setD_Orders(String d_Orders) {
		this.d_Orders = d_Orders;
	}

	/***
	 * This method executes the deploy order by subtracting the reinforcement armies from the player and adding it to the corresponding country
	 */
	public void execute() {
		String l_OrderSplit[] = d_Orders.split(" ");
		String l_CountryName = l_OrderSplit[1];
		int l_noOfArmiesToDeploy = Integer.parseInt(l_OrderSplit[2]);
		
		Country l_TagretCountry = d_Map.findCountryByName(l_CountryName);
		int l_InitialCountryArmies = l_TagretCountry.getD_NoOfArmies();
		l_TagretCountry.setD_NoOfArmies(l_InitialCountryArmies+l_noOfArmiesToDeploy);	
	}
}
