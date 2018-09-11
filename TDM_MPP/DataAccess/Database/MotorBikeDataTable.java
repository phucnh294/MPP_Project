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
public class MotorBikeDataTable extends DataTable {

	

	public MotorBikeDataTable() {
		dataList = new ArrayList<>();
		createInitialData();
	}	
	
	private void createInitialData(){
		MotorBike car1 = new MotorBike();
		car1.setBrand("Honda");
		car1.setDescription("");
		car1.setId("001");
		car1.setManufacturer("Honda");
		car1.setModel("2018");
		car1.setName("AirBlade");
		car1.setPrice(10000.00);
		car1.setTranmissionType(MotorBike.TRANMISSIONTYPE.MANUAL);;
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
