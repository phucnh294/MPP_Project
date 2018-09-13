package Service;


import DAO.OrderDAO;
import Interface.IOrder;
import Interface.IParty;

public class OrderFactory extends OrderDAO{
	public static final IOrder createInstance() {
		return new OrderDAO();
	}
}
