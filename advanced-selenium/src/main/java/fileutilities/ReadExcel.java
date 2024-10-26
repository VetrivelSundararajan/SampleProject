package fileutilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel {
	
	FileInputStream fis;
	Workbook wb;
	
	public String fetchSingleData(String sheetname, int rowNum, int cellNum)
	{
		try {
			fis=new FileInputStream("./src/test/resources/SampleTestCase.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			wb=WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Sheet sheet=wb.getSheet(sheetname);
		String data=sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
		return data;
	}
	
	public void fetchmultipleData(String sheetname)
	{
		try {
			fis=new FileInputStream("./src/test/resources/SampleTestCase.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			wb=WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Sheet sheet=wb.getSheet(sheetname); 
		int rowCount=sheet.getPhysicalNumberOfRows();
		int cellCount=sheet.getRow(0).getPhysicalNumberOfCells();
		
		//Creating 2D array
		Object [][] data=new Object[rowCount-1][cellCount];
		
		for(int i=1; i<rowCount; i++)
		{
			for(int j=0; j<cellCount; j++)
			{
				data[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(data[i-1][j]);
			}
			
		}
	}
	
	
	public static void main(String[] args) {
		ReadExcel read = new ReadExcel();
		String data=read.fetchSingleData("TestData", 5, 1);
		System.out.println("Data printed from SingleFetch: "+ data);
		System.out.println("------Data printed from MultipleFetch------");
		read.fetchmultipleData("TestData");
	}
}
