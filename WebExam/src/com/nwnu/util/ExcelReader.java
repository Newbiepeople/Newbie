package com.nwnu.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.nwnu.model.Paper;
import com.nwnu.model.Question;
import com.nwnu.model.Student;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * 操作Excel表格的功能类
 */
public class ExcelReader {
	private POIFSFileSystem fs;
	private HSSFWorkbook wb;
	private HSSFSheet sheet;
	private HSSFRow row;
	
	
	//导入Paper
	public static Set<Question> getAllByExcel(File file,Paper paper) {
		Set<Question> set = new HashSet<>();
		try {
			Workbook rwb = Workbook.getWorkbook(file);
			Sheet rs = rwb.getSheet(0);// 或者rwb.getSheet(0)
			int clos = rs.getColumns();// 得到所有的列
			int rows = rs.getRows();// 得到所有的行

			System.out.println(clos + " rows:" + rows);
			for (int i = 1; i < rows; i++) {
				Question q = new Question();
				
				int j = 0;
				// 第一个是列数，第二个是行数
				String type = rs.getCell(j++, i).getContents();// 默认最左边编号也算一列
																// 所以这里得j++
				String subject = rs.getCell(j++, i).getContents();
				String optionA = rs.getCell(j++, i).getContents();
				String optionB = rs.getCell(j++, i).getContents();
				String optionC = rs.getCell(j++, i).getContents();
				String optionD = rs.getCell(j++, i).getContents();
				String answer = rs.getCell(j++, i).getContents();
				q.setJoinTime(new Date());
				q.setOptionA(optionA);
				q.setOptionB(optionB);
				q.setAnswer(answer);
				q.setOptionC(optionC);
				q.setOptionD(optionD);
				q.setSubject(subject);
				q.setType(type);
				q.setPaper(paper);
				set.add(q);
				System.out.println(q.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return set;
	}

	//导入Student
	public static Set<Student> getStudentByExcel(File file) {
		Set<Student> set = new HashSet<>();
		try {
			Workbook rwb = Workbook.getWorkbook(file);
			Sheet rs = rwb.getSheet(0);// 或者rwb.getSheet(0)
			int clos = rs.getColumns();// 得到所有的列
			int rows = rs.getRows();// 得到所有的行

			System.out.println(clos + " rows:" + rows);
			long id = Long.valueOf(DateUtil.getCurrentDateStr());
			for (int i = 1; i < rows; i++) {
				Student q = new Student();
				
				int j = 0;
				// 第一个是列数，第二个是行数
																// 默认最左边编号也算一列
																// 所以这里得j++
				String cardid = rs.getCell(j++, i).getContents();
				String name = rs.getCell(j++, i).getContents();
				String password = rs.getCell(j++, i).getContents();
				String prefession = rs.getCell(j++, i).getContents();
				String gender = rs.getCell(j++, i).getContents();
				q.setId("JS"+ id++);
				q.setCardNo(cardid);
				q.setName(name);
				q.setPassword(password);
				q.setPrefession(prefession);
				q.setSex(gender);
				set.add(q);
				System.out.println(q.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return set;
	}
	/**
	 * 读取Excel表格表头的内容
	 * 
	 * @param InputStream
	 * @return String 表头内容的数组
	 */
	public String[] readExcelTitle(InputStream is) {
		try {
			fs = new POIFSFileSystem(is);
			wb = new HSSFWorkbook(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = wb.getSheetAt(0);
		row = sheet.getRow(0);
		// 标题总列数
		int colNum = row.getPhysicalNumberOfCells();
		System.out.println("colNum:" + colNum);
		String[] title = new String[colNum];
		for (int i = 0; i < colNum; i++) {
			// title[i] = getStringCellValue(row.getCell((short) i));
			title[i] = getCellFormatValue(row.getCell((short) i));
		}
		return title;
	}

	/**
	 * 读取Excel数据内容
	 * 
	 * @param InputStream
	 * @return Map 包含单元格数据内容的Map对象
	 */
	public Map<Integer, String> readExcelContent(InputStream is) {
		Map<Integer, String> content = new HashMap<Integer, String>();
		String str = "";
		try {
			fs = new POIFSFileSystem(is);
			wb = new HSSFWorkbook(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = wb.getSheetAt(0);
		// 得到总行数
		int rowNum = sheet.getLastRowNum();
		row = sheet.getRow(0);
		int colNum = row.getPhysicalNumberOfCells();
		// 正文内容应该从第二行开始,第一行为表头的标题
		for (int i = 1; i <= rowNum; i++) {
			row = sheet.getRow(i);
			int j = 0;
			while (j < colNum) {
				// 每个单元格的数据内容用"-"分割开，以后需要时用String类的replace()方法还原数据
				// 也可以将每个单元格的数据设置到一个javabean的属性中，此时需要新建一个javabean
				// str += getStringCellValue(row.getCell((short) j)).trim() +
				// "-";
				str += getCellFormatValue(row.getCell((short) j)).trim() + "    ";
				j++;
			}
			content.put(i, str);
			str = "";
		}
		return content;
	}

	/**
	 * 获取单元格数据内容为字符串类型的数据
	 * 
	 * @param cell
	 *            Excel单元格
	 * @return String 单元格数据内容
	 */
	private String getStringCellValue(HSSFCell cell) {
		String strCell = "";
		switch (cell.getCellType()) {
		case HSSFCell.CELL_TYPE_STRING:
			strCell = cell.getStringCellValue();
			break;
		case HSSFCell.CELL_TYPE_NUMERIC:
			strCell = String.valueOf(cell.getNumericCellValue());
			break;
		case HSSFCell.CELL_TYPE_BOOLEAN:
			strCell = String.valueOf(cell.getBooleanCellValue());
			break;
		case HSSFCell.CELL_TYPE_BLANK:
			strCell = "";
			break;
		default:
			strCell = "";
			break;
		}
		if (strCell.equals("") || strCell == null) {
			return "";
		}
		if (cell == null) {
			return "";
		}
		return strCell;
	}
	
	// 写入excel文件
		@SuppressWarnings("unchecked")
		public static boolean writeExcel(OutputStream os, List<Object> bookList){
			try {// 打开文件 (可写方式打开文件) 没有则创建
				WritableWorkbook book = Workbook.createWorkbook(os);
				for (int i = 0; i < bookList.size(); i++) {
					List<Object> sheetList = (List<Object>) bookList.get(i);	//解析参数(获取文件名之外工作表)
					String sheetName = sheetList.get(0).toString();	//解析参数(获取工作表名)
					WritableSheet sheet = book.createSheet(sheetName, i-1);	//创建的工作表
					for (int j = 1; j < sheetList.size(); j++) {
						List<String> rowList = (List<String>) sheetList.get(j);//解析参数(获取单元格)
						for (int k = 0; k < rowList.size(); k++) {
							Label label = new Label(k ,j-1 , rowList.get(k)); 
							sheet.addCell(label);
						}
					}
				}
				// 写入数据并关闭文件
				book.write();
				book.close();
				return true;
			} catch (Exception e) {
				return false;
			} 
		}

	/**
	 * 获取单元格数据内容为日期类型的数据
	 * 
	 * @param cell
	 *            Excel单元格
	 * @return String 单元格数据内容
	 */
	private String getDateCellValue(HSSFCell cell) {
		String result = "";
		try {
			int cellType = cell.getCellType();
			if (cellType == HSSFCell.CELL_TYPE_NUMERIC) {
				Date date = cell.getDateCellValue();
				result = (date.getYear() + 1900) + "-" + (date.getMonth() + 1) + "-" + date.getDate();
			} else if (cellType == HSSFCell.CELL_TYPE_STRING) {
				String date = getStringCellValue(cell);
				result = date.replaceAll("[年月]", "-").replace("日", "").trim();
			} else if (cellType == HSSFCell.CELL_TYPE_BLANK) {
				result = "";
			}
		} catch (Exception e) {
			System.out.println("日期格式不正确!");
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 根据HSSFCell类型设置数据
	 * 
	 * @param cell
	 * @return
	 */
	private String getCellFormatValue(HSSFCell cell) {
		String cellvalue = "";
		if (cell != null) {
			// 判断当前Cell的Type
			switch (cell.getCellType()) {
			// 如果当前Cell的Type为NUMERIC
			case HSSFCell.CELL_TYPE_NUMERIC:
			case HSSFCell.CELL_TYPE_FORMULA: {
				// 判断当前的cell是否为Date
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					// 如果是Date类型则，转化为Data格式

					// 方法1：这样子的data格式是带时分秒的：2011-10-12 0:00:00
					// cellvalue = cell.getDateCellValue().toLocaleString();

					// 方法2：这样子的data格式是不带带时分秒的：2011-10-12
					Date date = cell.getDateCellValue();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					cellvalue = sdf.format(date);

				}
				// 如果是纯数字
				else {
					// 取得当前Cell的数值
					cellvalue = String.valueOf(cell.getNumericCellValue());
				}
				break;
			}
				// 如果当前Cell的Type为STRIN
			case HSSFCell.CELL_TYPE_STRING:
				// 取得当前的Cell字符串
				cellvalue = cell.getRichStringCellValue().getString();
				break;
			// 默认的Cell值
			default:
				cellvalue = " ";
			}
		} else {
			cellvalue = "";
		}
		return cellvalue;

	}
	
	
	
}