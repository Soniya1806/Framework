package data;

import utilities.Xls_Reader;

public class DataFile {
	Xls_Reader r = new Xls_Reader("E:\\testing\\Login.xlsx");
	
	//login
	public String correctEmail = r.getCellData("Data1", 1, 2);
	public String wrongPassword = r.getCellData("Data1", 2, 2);
	public String wrongEmail = r.getCellData("Data1", 1, 3);
	public String passwordErrMsg = r.getCellData("Data1", 4, 2);
	public String emailErrMsg = r.getCellData("Data1", 3, 2);
}
