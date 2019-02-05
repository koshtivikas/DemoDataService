package com.demo.empldata.Service.DemoDataService;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.empldata.Service.model.EmployeeAddress;
import com.demo.empldata.Service.model.EmployeeAddresses;
import com.demo.empldata.Service.model.EmployeeName;
import com.demo.empldata.Service.model.EmployeeNames;
import com.demo.empldata.Service.model.EmployeePhone;

@SpringBootApplication
public class DemoDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoDataServiceApplication.class, args);
	}

}

@RestController
class EmployeeDataController 
{
	private static Logger log = LoggerFactory.getLogger(EmployeeDataController.class);

	@RequestMapping(value = "/addresses", method = RequestMethod.GET)
	public EmployeeAddresses getAddresses() 
	{
		log.info("get addresses Start");

		EmployeeAddresses employeeAddressesList = new EmployeeAddresses();

		EmployeeAddress employeeAddress1 = new EmployeeAddress();
		EmployeeAddress employeeAddress2 = new EmployeeAddress();
		
		List<EmployeeAddress> addressList = new ArrayList<EmployeeAddress>();
		
		{
			employeeAddress1.setHouseNo("H2");
			employeeAddress1.setStreetNo("South Street");
			employeeAddress1.setZipCode("60012");
			
			employeeAddress2.setHouseNo("H3");
			employeeAddress2.setStreetNo("North Street");
			employeeAddress2.setZipCode("60013");
			
			addressList.add(employeeAddress1);
			addressList.add(employeeAddress2);
			
			employeeAddressesList.setEmployeeAddressList(addressList);
		}

		return employeeAddressesList;
	}

	@RequestMapping(value = "/phones", method = RequestMethod.GET)
	public EmployeePhone getPhoneNumbers() 
	{
		log.info("get phones Start");

		EmployeePhone employeePhone = new EmployeePhone();
		{
			ArrayList<String> phoneNumberList = new ArrayList<String>();
			
			phoneNumberList.add("9090912323");
			phoneNumberList.add("8090912325");
			
			employeePhone.setPhoneNumbers(phoneNumberList);
		}

		return employeePhone;
	}

	@RequestMapping(value = "/names", method = RequestMethod.GET)
	public EmployeeNames getEmployeeName() 
	{
		log.info("get names Start");

		EmployeeNames employeeNamesList = new EmployeeNames();

		EmployeeName employeeName1 = new EmployeeName();
		EmployeeName employeeName2 = new EmployeeName();
		
		List<EmployeeName> employeeList = new ArrayList<EmployeeName>();
		{
			employeeName1.setFirstName("Jon");
			employeeName1.setLastName("Cina");
		}
		{
			employeeName2.setFirstName("Rojer");
			employeeName2.setLastName("Fedrer");
		}

		employeeList.add(employeeName1);
		employeeList.add(employeeName2);

		employeeNamesList.setEmployeeNameList(employeeList);

		return employeeNamesList;
	}
}