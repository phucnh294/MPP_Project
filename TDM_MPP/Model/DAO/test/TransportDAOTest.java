/**
 * 
 */
package DAO.test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import DAO.TransportDAO;
import Data.Transport;

/**
 * @author ptkie
 *
 */
public class TransportDAOTest {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) {
		
		TransportDAO dao = new TransportDAO();
		Transport tran = new Transport();
//		tran.setBrand("Jeep");
//		tran.setCreatedDate(LocalDate.now());
//		tran.setDescription("new car");
//		tran.setFuelType("GAS");
//		tran.setManufactor("Toyota");
//		tran.setMileage(100);
//		tran.setModel("2018");
//		tran.setName("Camry");
//		tran.setNumberOfEngine(4);
//		tran.setPrice(140000);
//		tran.setSeatCapacity(4);
//		tran.setTranmissionType(1);
//		tran.setTransportType("CAR");
//		try {
//			dao.insertTransport(tran);
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
		
//		tran.setBrand("Mini");
//		tran.setCreatedDate(LocalDate.now());
//		tran.setDescription("new car");
//		tran.setFuelType("Gas");
//		tran.setManufactor("Toyota");
//		tran.setMileage(100);
//		tran.setModel("2018");
//		tran.setName("Innova");
//		tran.setNumberOfEngine(4);
//		tran.setPrice(140000);
//		tran.setSeatCapacity(7);
//		tran.setTranmissionType(1);
//		tran.setTransportType("CAR");
//		try {
//			dao.insertTransport(tran);
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
		
//		tran.setBrand("");
//		tran.setCreatedDate(LocalDate.now());
//		tran.setDescription("new car");
//		tran.setFuelType("Gas");
//		tran.setManufactor("Suzuki");
//		tran.setMileage(100);
//		tran.setModel("2017");
//		tran.setName("Wave");
//		tran.setNumberOfEngine(1);
//		tran.setPrice(1000);
//		tran.setSeatCapacity(2);
//		tran.setTranmissionType(1);
//		tran.setTransportType("MOTORBIKE");
//		try {
//			dao.insertTransport(tran);
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
		
//		try {
//			tran.setId(3);
//			dao.deleteTransport(tran);
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
		try {
			List<Transport> trans = dao.search(1, 1000000, "Toyota", 4);
			System.out.println(trans);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
