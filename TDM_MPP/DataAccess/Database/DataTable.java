/**
 * 
 */
package Database;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 986338
 *
 */
public abstract class DataTable {

	protected static List<Transport> dataList;

	/**
	 * get all cars
	 * @return
	 */
	public static List<Transport> getAllCars() {
		return dataList;
	}
	
	/**
	 * get a car by id
	 * @param id
	 * @return
	 */
	public static Transport getCarById(String id) {
		for (Transport cd : dataList) {
			if(cd.getId().equals(id)) {
				return cd;
			}
		}
		return null;
	}
	
	/**
	 * search Cars by specific conditions
	 * @param name
	 * @param fromPrice
	 * @param toPrice
	 * @param brand
	 * @return
	 */
	public static List<Transport> search (String name, double fromPrice, double toPrice, String brand) {
		List<Transport> returnList = new ArrayList<>();
		boolean match = true;
		for (Transport cd : dataList) {
			match = true;
			if(name != null) {
				match = match && (cd.getName().indexOf(name) >= 0);
			}
			if(fromPrice > 0) {
				match = match && cd.getPrice() >= fromPrice;
			}
			if(toPrice < 0) {
				match = match && cd.getPrice() <= toPrice;
			}
			if(brand != null) {
				match = match && (cd.getBrand().indexOf(brand) >= 0);
			}
			if(match) {
				returnList.add(cd);
			}
		}
		return returnList;
	}
	
	/**
	 * update a car
	 * @param car
	 * @return
	 */
	public static List<Transport> update (Transport car) {
		for (Transport c : dataList) {
			if(c.getId().equals(car.getId())) {
				c = car;
				break;
			}
		}
		
		return dataList;			
	}
	
	/**
	 * remove a car by id;
	 * @param id
	 * @return
	 */
	public static List<Transport> delete (String id) {
		int index = -1;
		for (Transport c : dataList) {
			index++;
			if (c.getId().equals(id)) {
				break;
			}
		}
		if(index >= 0) {
			dataList.remove(index);
		}
		return dataList;
	}
	
}
