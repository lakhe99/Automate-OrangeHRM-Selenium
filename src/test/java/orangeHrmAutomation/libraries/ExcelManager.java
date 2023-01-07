package orangeHrmAutomation.libraries;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelManager {

	private static String filePath;
	private static Workbook wb;
	private static Sheet sh;

	/***
	 * This is the Constructor1 - reads sheet by String name
	 * 
	 * @param excelFile
	 * @param sheetName
	 */
	public ExcelManager(String excelFile, String sheetName) {
		try {
			File excelDataFile = new File(excelFile);
			filePath = excelDataFile.getAbsolutePath();
			System.out.println("Reading Excel file ---> " + filePath);

			FileInputStream fs = new FileInputStream(excelDataFile);
			wb = getWorkbook(fs, excelFile);
			sh = wb.getSheet(sheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/***
	 * This is the Constructor2 - reads sheet by index
	 * 
	 * @param excelFile
	 * @param sheetIndex
	 */
	public ExcelManager(String excelFile, int sheetIndex) {
		try {
			File excelDataFile = new File(excelFile);
			filePath = excelDataFile.getAbsolutePath();
			System.out.println("Reading Excel file ---> " + filePath);

			FileInputStream fs = new FileInputStream(excelDataFile);
			wb = getWorkbook(fs, excelFile);
			sh = wb.getSheetAt(sheetIndex);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String readExcelDataCell(int rowIndex, int colIndex) {
		String cellData = null;
		try {
			Row row = sh.getRow(rowIndex);
			if (row != null) {
				Cell cell = row.getCell(colIndex);
				cellData = formatDataCellToString(cell);
			}
		} catch (Exception e) {

		}
		return cellData;
	}

	public String[][] getExcelData() {
		String[][] arrayExcelData = null;
		try {
			Iterator<Row> iterator = sh.iterator();
			Row tempRow = sh.getRow(0);
			if (tempRow != null) {
				int totalCols = tempRow.getPhysicalNumberOfCells();
				int totalRows = sh.getPhysicalNumberOfRows();
				arrayExcelData = new String[totalRows- 1][totalCols];
				int iRowCount = 0;

				while (iterator.hasNext()) {
					Row row = iterator.next();
					// skipping row 1, because it's table header info
					if (iRowCount > 0) {
						Iterator<Cell> colIterator = row.iterator();
						int iColCount = 0;
						while (colIterator.hasNext()) {
							Cell cell = colIterator.next();
							// need to forma the cells before Read it as a string
							String data = formatDataCellToString(cell);
							arrayExcelData[iRowCount - 1][iColCount] = data;
							System.out.println("Row: " + iRowCount + ", Col: " + iColCount + ", Data: " + data);
							iColCount++;
						}
					}
					iRowCount++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayExcelData;
	}

	// --- these methods below are helper methods and declared in private -------
	// Method to identify the excel file version and returns the correct workbook
	// object
	private Workbook getWorkbook(FileInputStream fis, String excelFilePath) {
		Workbook workbook = null;
		try {
			if (excelFilePath.toLowerCase().endsWith(".xlsx")) {
				workbook = new XSSFWorkbook(fis);
			} else if (excelFilePath.toLowerCase().endsWith(".xls")) {
				workbook = new HSSFWorkbook(fis);
			} else {
				throw new IllegalArgumentException("The specified file is not an 'Excel' data file.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return workbook;
	}

	private String formatDataCellToString(Cell cell) {
		String cellString = null;
		try {
			DataFormatter formatter = new DataFormatter();
			cellString = formatter.formatCellValue(cell);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cellString;
	}

	/// testing this class using main method
	public static void main(String[] args) {
		try {
			String excelFile1 = "src/test/resources/testData/CalculaterTestData.xlsx";
			//String excelFile2 = "src/test/resources/testData/CalculaterTestData-old.xls";
			//String file3 = "C:/abc/r4/frank/myPet.txt";

			ExcelManager excel = new ExcelManager(excelFile1, 0);
			//ExcelManager excel = new ExcelManager(file3, 0);
			System.out.println("Excel data ---------");
			System.out.println(excel.getExcelData());
			String excelData = excel.readExcelDataCell(3, 10);
			System.out.println("exceldata: " + excelData);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
