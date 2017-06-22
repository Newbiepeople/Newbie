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
 * ����Excel���Ĺ�����
 */
public class ExcelReader {
	private POIFSFileSystem fs;
	private HSSFWorkbook wb;
	private HSSFSheet sheet;
	private HSSFRow row;
	
	
	//����Paper
	public static Set<Question> getAllByExcel(File file,Paper paper) {
		Set<Question> set = new HashSet<>();
		try {
			Workbook rwb = Workbook.getWorkbook(file);
			Sheet rs = rwb.getSheet(0);// ����rwb.getSheet(0)
			int clos = rs.getColumns();// �õ����е���
			int rows = rs.getRows();// �õ����е���

			System.out.println(clos + " rows:" + rows);
			for (int i = 1; i < rows; i++) {
				Question q = new Question();
				
				int j = 0;
				// ��һ�����������ڶ���������
				String type = rs.getCell(j++, i).getContents();// Ĭ������߱��Ҳ��һ��
																// ���������j++
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

	//����Student
	public static Set<Student> getStudentByExcel(File file) {
		Set<Student> set = new HashSet<>();
		try {
			Workbook rwb = Workbook.getWorkbook(file);
			Sheet rs = rwb.getSheet(0);// ����rwb.getSheet(0)
			int clos = rs.getColumns();// �õ����е���
			int rows = rs.getRows();// �õ����е���

			System.out.println(clos + " rows:" + rows);
			long id = Long.valueOf(DateUtil.getCurrentDateStr());
			for (int i = 1; i < rows; i++) {
				Student q = new Student();
				
				int j = 0;
				// ��һ�����������ڶ���������
																// Ĭ������߱��Ҳ��һ��
																// ���������j++
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
	 * ��ȡExcel����ͷ������
	 * 
	 * @param InputStream
	 * @return String ��ͷ���ݵ�����
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
		// ����������
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
	 * ��ȡExcel��������
	 * 
	 * @param InputStream
	 * @return Map ������Ԫ���������ݵ�Map����
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
		// �õ�������
		int rowNum = sheet.getLastRowNum();
		row = sheet.getRow(0);
		int colNum = row.getPhysicalNumberOfCells();
		// ��������Ӧ�ôӵڶ��п�ʼ,��һ��Ϊ��ͷ�ı���
		for (int i = 1; i <= rowNum; i++) {
			row = sheet.getRow(i);
			int j = 0;
			while (j < colNum) {
				// ÿ����Ԫ�������������"-"�ָ���Ժ���Ҫʱ��String���replace()������ԭ����
				// Ҳ���Խ�ÿ����Ԫ����������õ�һ��javabean�������У���ʱ��Ҫ�½�һ��javabean
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
	 * ��ȡ��Ԫ����������Ϊ�ַ������͵�����
	 * 
	 * @param cell
	 *            Excel��Ԫ��
	 * @return String ��Ԫ����������
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
	
	// д��excel�ļ�
		@SuppressWarnings("unchecked")
		public static boolean writeExcel(OutputStream os, List<Object> bookList){
			try {// ���ļ� (��д��ʽ���ļ�) û���򴴽�
				WritableWorkbook book = Workbook.createWorkbook(os);
				for (int i = 0; i < bookList.size(); i++) {
					List<Object> sheetList = (List<Object>) bookList.get(i);	//��������(��ȡ�ļ���֮�⹤����)
					String sheetName = sheetList.get(0).toString();	//��������(��ȡ��������)
					WritableSheet sheet = book.createSheet(sheetName, i-1);	//�����Ĺ�����
					for (int j = 1; j < sheetList.size(); j++) {
						List<String> rowList = (List<String>) sheetList.get(j);//��������(��ȡ��Ԫ��)
						for (int k = 0; k < rowList.size(); k++) {
							Label label = new Label(k ,j-1 , rowList.get(k)); 
							sheet.addCell(label);
						}
					}
				}
				// д�����ݲ��ر��ļ�
				book.write();
				book.close();
				return true;
			} catch (Exception e) {
				return false;
			} 
		}

	/**
	 * ��ȡ��Ԫ����������Ϊ�������͵�����
	 * 
	 * @param cell
	 *            Excel��Ԫ��
	 * @return String ��Ԫ����������
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
				result = date.replaceAll("[����]", "-").replace("��", "").trim();
			} else if (cellType == HSSFCell.CELL_TYPE_BLANK) {
				result = "";
			}
		} catch (Exception e) {
			System.out.println("���ڸ�ʽ����ȷ!");
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * ����HSSFCell������������
	 * 
	 * @param cell
	 * @return
	 */
	private String getCellFormatValue(HSSFCell cell) {
		String cellvalue = "";
		if (cell != null) {
			// �жϵ�ǰCell��Type
			switch (cell.getCellType()) {
			// �����ǰCell��TypeΪNUMERIC
			case HSSFCell.CELL_TYPE_NUMERIC:
			case HSSFCell.CELL_TYPE_FORMULA: {
				// �жϵ�ǰ��cell�Ƿ�ΪDate
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					// �����Date������ת��ΪData��ʽ

					// ����1�������ӵ�data��ʽ�Ǵ�ʱ����ģ�2011-10-12 0:00:00
					// cellvalue = cell.getDateCellValue().toLocaleString();

					// ����2�������ӵ�data��ʽ�ǲ�����ʱ����ģ�2011-10-12
					Date date = cell.getDateCellValue();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					cellvalue = sdf.format(date);

				}
				// ����Ǵ�����
				else {
					// ȡ�õ�ǰCell����ֵ
					cellvalue = String.valueOf(cell.getNumericCellValue());
				}
				break;
			}
				// �����ǰCell��TypeΪSTRIN
			case HSSFCell.CELL_TYPE_STRING:
				// ȡ�õ�ǰ��Cell�ַ���
				cellvalue = cell.getRichStringCellValue().getString();
				break;
			// Ĭ�ϵ�Cellֵ
			default:
				cellvalue = " ";
			}
		} else {
			cellvalue = "";
		}
		return cellvalue;

	}
	
	
	
}