package functions;

import java.util.ArrayList;

public class CommonMethods {

	/**
	* Read the test data from excel file
	*
	* @param data The TestData data object
	*/

	public void readExcelData (TestData data) {
	       ArrayList<String> userName = new ArrayList<String>();
	       ArrayList<String> password = new ArrayList<String>();
	       ArrayList<String> location = new ArrayList<String>();
	       ArrayList<String> radioButtonNumLocation = new ArrayList<String>();
	       ArrayList<String> firstName = new ArrayList<String>();
	       ArrayList<String> lastName = new ArrayList<String>();
	       ArrayList<String> address = new ArrayList<String>();
	       ArrayList<String> ccNumber = new ArrayList<String>();
	       ArrayList<String> ccType = new ArrayList<String>();
	       ArrayList<String> ccExpMonth = new ArrayList<String>();
	       ArrayList<String> ccExpYear = new ArrayList<String>();
	       ArrayList<String> cccVvNum = new ArrayList<String>();
	 
	       // Get the data from excel file
	       for (int rowCnt = 1; rowCnt < ExcelReader.RowCount(); rowCnt++) {
	       userName.add(ExcelReader.ReadCell(ExcelReader.GetCell("User ID"), rowCnt));
	       password.add(ExcelReader.ReadCell(ExcelReader.GetCell("Password"), rowCnt));
	       location.add(ExcelReader.ReadCell(ExcelReader.GetCell("Location"), rowCnt));
	       radioButtonNumLocation.add(ExcelReader.ReadCell(ExcelReader.GetCell("RadioButton Num Location"), rowCnt));
	       firstName.add(ExcelReader.ReadCell(ExcelReader.GetCell("First Name"), rowCnt));
	       lastName.add(ExcelReader.ReadCell(ExcelReader.GetCell("Last Name"), rowCnt));
	       address.add(ExcelReader.ReadCell(ExcelReader.GetCell("Address"), rowCnt));
	       ccNumber.add(ExcelReader.ReadCell(ExcelReader.GetCell("CCNumber"), rowCnt));
	       ccType.add(ExcelReader.ReadCell(ExcelReader.GetCell("CCType"), rowCnt));
	       ccExpMonth.add(ExcelReader.ReadCell(ExcelReader.GetCell("CCExpMonth"), rowCnt));
	       ccExpYear.add(ExcelReader.ReadCell(ExcelReader.GetCell("CCExpYear"), rowCnt));
	       cccVvNum.add(ExcelReader.ReadCell(ExcelReader.GetCell("CCCvv Num"), rowCnt));
	       }
	       data.setUserName(userName);
	       data.setPassword(password);
	       data.setLocation(location);
	       data.setRadioButtonNumLocation(radioButtonNumLocation);
	       data.setFirstName(firstName);
	       data.setLastName(lastName);
	       data.setAddress(address);
	       data.setCcNumber(ccNumber);
	       data.setCcType(ccType);
	       data.setCcExpMonth(ccExpMonth);
	       data.setCcExpYear(ccExpYear);
	       data.setCccVvNum(cccVvNum);
	       }

	
	
	
}
