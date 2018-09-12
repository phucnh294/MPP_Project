/**
 * 
 */
package Database;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author 986338
 *
 */
public class CarDataTable extends DataTable {

	

	public CarDataTable() {
		dataList = new ArrayList<>();
		createInitialData();
	}	
	
	private void createInitialData(){
		Car car1 = new Car();
		car1.setBrand("Toyota");
		car1.setDescription("");
		car1.setFuelType(Car.FUELTYPE.ONE);
		car1.setId("001");
		car1.setManufacturer("Toyota");
		car1.setModel("2018");
		car1.setName("Camry");
		car1.setPrice(30000.00);
		car1.setSeatCapacity(4);
		car1.setTramissionType(Car.TRANMISSIONTYPE.AUTO);
		car1.setDateCreated(LocalDate.now());
		dataList.add(car1);
		
		Car car2 = new Car();
		car2.setBrand("Toyota");
		car2.setDescription("");
		car2.setFuelType(Car.FUELTYPE.ONE);
		car2.setId("001");
		car2.setManufacturer("Toyota");
		car2.setModel("2018");
		car2.setName("Fortunate");
		car2.setPrice(35000.00);
		car2.setSeatCapacity(7);
		car2.setTramissionType(Car.TRANMISSIONTYPE.AUTO);
		car2.setDateCreated(LocalDate.now());
		dataList.add(car2);
		
		Car car3 = new Car();
		car3.setBrand("Toyota");
		car3.setDescription("");
		car3.setFuelType(Car.FUELTYPE.ONE);
		car3.setId("001");
		car3.setManufacturer("Toyota");
		car3.setModel("2018");
		car3.setName("Innova");
		car3.setPrice(35000.00);
		car3.setSeatCapacity(7);
		car3.setTramissionType(Car.TRANMISSIONTYPE.AUTO);
		car3.setDateCreated(LocalDate.now());
		dataList.add(car3);
		
		
		
	}


}
