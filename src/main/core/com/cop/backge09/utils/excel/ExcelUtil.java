/**
 *  Copyright (c) 2012-2014 http://www.eryansky.com
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.cop.backge09.utils.excel;

import com.cop.backge09.util.Utils;
import com.cop.backge09.utils.excel.annotation.Excel;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public final class ExcelUtil {

	private ExcelUtil() {
	}

	/** Excel 文件要存放的位置 */
	public static String outputFile = "d:excel_demo.xls";

	/**
	 * 标题列表
	 */
	private static String[] HEAD_LIST = { "序号", "名字", "年龄", "备注" };

	private static String[] VALUE_LIST = { "01", "张三", "20", "1986-04-03",
			"........." };

	/**
	 * 字段列表
	 */
	private static String[] FIELD_LIST = { "commodityName", "commodityCount", "specifications", "weight" };
	

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// ------------------------------------------------------------
		/* List<String[]> list = new ArrayList<String[]>();
		 list.add(VALUE_LIST);
		 list.add(VALUE_LIST);
		 list.add(VALUE_LIST);
		 new ExcelUtil().createExcel(outputFile, HEAD_LIST, list);*/

		// ------------------------------------------------------------
		 /*List<Map<String, Object>> dataList = new ArrayList<Map<String,
		 Object>>();
		 Map<String, Object> map = new HashMap<String, Object>();
		 map.put("index", "001");
		 map.put("name", "张三");
		 map.put("age", "22");
		 map.put("content", "大家好");
		 dataList.add(map);
		 dataList.add(map);
		 dataList.add(map);
		
		 createExcel(outputFile, HEAD_LIST, FIELD_LIST, dataList);*/
		new ExcelUtil().getDataList();
		// -------------------------------------------------------------
		 //readExcel(null);
		// --------------------------------------------------------------
		//new ExcelUtil().testCreateExcel();
		
	}

	/**
	 * 使用举例
	 * 
	 */
	public void testCreateExcel() {

		List<Map<String, Object>> dataList = getDataList();
		List<String> headList = getHeadList();
		List<String> fieldList = getFieldList();

		try {
			createExcel("D:/TEST01.xls", headList, fieldList, dataList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 使用举例
	 * 
	 * @throws Exception
	 * 
	 */
	@SuppressWarnings("static-access")
	public void testReadExcel() throws Exception {
		String excelUrl = "C:/javadeveloper/workspace/Mybatis_one/src/测试台账2003.xls";
		List<String[]> list = this.readExcel(excelUrl);
		for (String[] str : list) {
			for (String s : str) {
				//System.out.print(s + " | ");
			}
			//System.out.println("");
		}
	}

	/**
	 * 测试举例
	 * 
	 * @return
	 */
	private List<Map<String, Object>> getDataList() {
		/**
		 * 数据集合
		 */
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		// 单行数据
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		map.put("index", "001");
		map.put("name", "张三0");
		map.put("age", "22");
		map.put("content", "大家好0");
		map.put("date", new Date());
		map1.put("index", "001");
		map1.put("name", "张三1");
		map1.put("age", "22");
		map1.put("content", "大家好1");
		map1.put("date", new Date());
		map2.put("index", "001");
		map2.put("name", "张三2");
		map2.put("age", "22");
		map2.put("content", "大家好2");
		map2.put("date", new Date());
		dataList.add(map);
		dataList.add(map1);
		dataList.add(map2);

		return dataList;
	}

	/**
	 * 测试举例
	 * 
	 * @return
	 */
	private List<String> getHeadList() {
		List<String> headList = new ArrayList<String>();
		headList.add("序号");
		headList.add("名字");
		headList.add("年龄");
		headList.add("出生");
		headList.add("备注");

		return headList;
	}

	/**
	 * 测试举例
	 * 
	 * @return
	 */
	private List<String> getFieldList() {
		List<String> fieldList = new ArrayList<String>();
		fieldList.add("index");
		fieldList.add("name");
		fieldList.add("age");
		fieldList.add("date");
		fieldList.add("content");

		return fieldList;
	}

	/**
	 * @param excel_name
	 *            生成的Excel文件路径+名称
	 * @param headList
	 *            Excel文件Head标题集合
	 * @param fieldList
	 *            Excel文件Field标题集合
	 * @param dataList
	 *            Excel文件数据内容部分
	 * @throws Exception
	 */
	public static void createExcel(String excel_name, String[] headList,
			String[] fieldList, List<Map<String, Object>> dataList)
			throws Exception {
		// 创建新的Excel 工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();

		// 在Excel工作簿中建一工作表，其名为缺省值
		// 如要新建一名为"效益指标"的工作表，其语句为：
		// HSSFSheet sheet = workbook.createSheet("效益指标");
		HSSFSheet sheet = workbook.createSheet();
		// 在索引0的位置创建行（最顶端的行）
		HSSFRow row = sheet.createRow(0);
		// ===============================================================
		for (int i = 0; i < headList.length; i++) {

			// 在索引0的位置创建单元格（左上端）
			HSSFCell cell = row.createCell(i);
			// 定义单元格为字符串类型
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			// 在单元格中输入一些内容
			cell.setCellValue(headList[i]);
		}
		// ===============================================================

		for (int n = 0; n < dataList.size(); n++) {
			// 在索引1的位置创建行（最顶端的行）
			HSSFRow row_value = sheet.createRow(n + 1);
			Map<String, Object> dataMap = dataList.get(n);
			// ===============================================================
			for (int i = 0; i < fieldList.length; i++) {

				// 在索引0的位置创建单元格（左上端）
				HSSFCell cell = row_value.createCell(i);
				// 定义单元格为字符串类型
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				// 在单元格中输入一些内容
				cell.setCellValue(objToString(dataMap.get(fieldList[i])));
			}
			// ===============================================================
		}

		// 新建一输出文件流
		FileOutputStream fOut = new FileOutputStream(excel_name);
		// 把相应的Excel 工作簿存盘
		workbook.write(fOut);
		fOut.flush();
		// 操作结束，关闭文件
		fOut.close();
		//System.out.println("[" + excel_name + "]" + "文件生成...");
	}

	/**
	 * @param excel_name
	 *            生成的Excel文件路径+名称
	 * @param headList
	 *            Excel文件Head标题集合
	 * @param fieldList
	 *            Excel文件Field标题集合
	 * @param dataList
	 *            Excel文件数据内容部分
	 * @throws Exception
	 */
	public static void createExcel(String excel_name, List<String> headList,
			List<String> fieldList, List<Map<String, Object>> dataList)
			throws Exception {
		// 创建新的Excel 工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();

		// 在Excel工作簿中建一工作表，其名为缺省值
		// 如要新建一名为"效益指标"的工作表，其语句为：
		// HSSFSheet sheet = workbook.createSheet("效益指标");
		HSSFSheet sheet = workbook.createSheet();
		CellRangeAddress cra=new CellRangeAddress(1, 3, 1, 1); 
		CellRangeAddress cra1=new CellRangeAddress(1, 3, 4, 4); 
		sheet.addMergedRegion(cra);
		sheet.addMergedRegion(cra1);
		// 在索引0的位置创建行（最顶端的行）
		HSSFRow row = sheet.createRow(0);
		// ===============================================================
		for (int i = 0; i < headList.size(); i++) {

			// 在索引0的位置创建单元格（左上端）
			HSSFCell cell = row.createCell(i);
			// 定义单元格为字符串类型
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			// 在单元格中输入一些内容
			cell.setCellValue(headList.get(i));
		}
		// ===============================================================

		for (int n = 0; n < dataList.size(); n++) {
			// 在索引1的位置创建行（最顶端的行）
			HSSFRow row_value = sheet.createRow(n + 1);
			Map<String, Object> dataMap = dataList.get(n);
			// ===============================================================
			for (int i = 0; i < fieldList.size(); i++) {

				// 在索引0的位置创建单元格（左上端）
				HSSFCell cell = row_value.createCell(i);
				// 定义单元格为字符串类型
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				// 在单元格中输入一些内容
				cell.setCellValue(objToString(dataMap.get(fieldList.get(i))));
			}
			// ===============================================================
		}

		// 新建一输出文件流
		FileOutputStream fOut = new FileOutputStream(excel_name);
		// 把相应的Excel 工作簿存盘
		workbook.write(fOut);
		fOut.flush();
		// 操作结束，关闭文件
		fOut.close();
		//System.out.println("[" + excel_name + "]" + "文件生成...");
	}
	
	public static HSSFWorkbook getExcel(List<String> headList,
			List<String> fieldList, List<HashMap<String, Object>> dataList)
			throws Exception {
		// 创建新的Excel 工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();

		// 在Excel工作簿中建一工作表，其名为缺省值
		// 如要新建一名为"效益指标"的工作表，其语句为：
		// HSSFSheet sheet = workbook.createSheet("效益指标");
		HSSFSheet sheet = workbook.createSheet();
		
		HSSFCellStyle columnTopStyle = getColumnTopStyle(workbook);
		// 在索引0的位置创建行（最顶端的行）
		HSSFRow row = sheet.createRow(0);
		// ===============================================================
		for (int i = 0; i < headList.size(); i++) {

			// 在索引0的位置创建单元格（左上端）
			HSSFCell cell = row.createCell(i);
			// 定义单元格为字符串类型
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			// 在单元格中输入一些内容
			cell.setCellValue(headList.get(i));
			cell.setCellStyle(columnTopStyle);
		}
		// ===============================================================

		for (int n = 0; n < dataList.size(); n++) {
			// 在索引1的位置创建行（最顶端的行）
			HSSFRow row_value = sheet.createRow(n + 1);
			Map<String, Object> dataMap = dataList.get(n);
			// ===============================================================
			for (int i = 0; i < fieldList.size(); i++) {

				// 在索引0的位置创建单元格（左上端）
				HSSFCell cell = row_value.createCell(i);
				// 定义单元格为字符串类型
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				// 在单元格中输入一些内容
				cell.setCellValue(objToString(dataMap.get(fieldList.get(i))));
				if(i==fieldList.size()-1)
				{
					HSSFCellStyle setBorder = workbook.createCellStyle();
					setBorder.setWrapText(true);
					cell.setCellStyle(setBorder);
				}
			}
			// ===============================================================
		}
		
		for (int colNum = 0; colNum < headList.size(); colNum++) {
            sheet.setColumnWidth(colNum, 20 * 256);
        }
		return workbook;
	}
	
	public static HSSFWorkbook getExcelByMake(List<String> headList,
			List<String> fieldList, List<HashMap<String, Object>> dataList)
			throws Exception {
		// 创建新的Excel 工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();

		// 在Excel工作簿中建一工作表，其名为缺省值
		// 如要新建一名为"效益指标"的工作表，其语句为：
		// HSSFSheet sheet = workbook.createSheet("效益指标");
		HSSFSheet sheet = workbook.createSheet();
		
//		CellRangeAddress cra=new CellRangeAddress(1, 3, 1, 1); 
//		CellRangeAddress cra1=new CellRangeAddress(1, 3, 4, 4); 
//		sheet.addMergedRegion(cra);
//		sheet.addMergedRegion(cra1);
		
		HSSFCellStyle columnTopStyle = getColumnTopStyle(workbook);
		// 在索引0的位置创建行（最顶端的行）
		HSSFRow row = sheet.createRow(0);
		// ===============================================================
		for (int i = 0; i < headList.size(); i++) {

			// 在索引0的位置创建单元格（左上端）
			HSSFCell cell = row.createCell(i);
			// 定义单元格为字符串类型
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			// 在单元格中输入一些内容
			cell.setCellValue(headList.get(i));
			cell.setCellStyle(columnTopStyle);
		}
		// ===============================================================
		List<String> asList = Arrays.asList(FIELD_LIST);
		int rowc = 1;
		for (int n = 0; n < dataList.size(); n++) {
			// 在索引1的位置创建行（最顶端的行）
			HSSFRow row_value = sheet.createRow(rowc);
			Map<String, Object> dataMap = dataList.get(n);
			Object list = dataMap.get("commodityList");
			List<Object> clist = null;
			int currindex = rowc;
			if(list instanceof List)
			{
				clist = (ArrayList<Object>)list;
			}
			if(clist!=null)
			{
				int index = clist.size();
				rowc = rowc += index; 
			}
			
			// ===============================================================
			for (int i = 0; i < fieldList.size(); i++) {
				// 在索引0的位置创建单元格（左上端）
				HSSFCell cell = row_value.createCell(i);
				// 定义单元格为字符串类型
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				// 在单元格中输入一些内容
				String fiel = fieldList.get(i);
				
				if(asList.contains(fiel))
				{
					HashMap<String, Object> item = Utils.objectToMap(clist.get(0));
					cell.setCellValue(objToString(item.get(fiel)));
				}else
				{
					cell.setCellValue(objToString(dataMap.get(fiel)));
					CellRangeAddress cra=new CellRangeAddress(currindex, rowc-1, i, i); 
					sheet.addMergedRegion(cra);
				}
				HSSFCellStyle setBorder = workbook.createCellStyle();
				setBorder.setWrapText(true);
				//设置水平对齐的样式为居中对齐;  
				setBorder.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	    	    //设置垂直对齐的样式为居中对齐; 
				setBorder.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
				cell.setCellStyle(setBorder);
			}
			int rowindex = currindex+1;
			for (int j = 1; j < clist.size(); j++) {
				HSSFRow row_value1 = sheet.createRow(rowindex);
				HashMap<String, Object> item = Utils.objectToMap(clist.get(j));
				for (int i = 13; i < fieldList.size(); i++) {
					HSSFCell cell = row_value1.createCell(i);
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setCellValue(objToString(item.get(fieldList.get(i))));
					HSSFCellStyle setBorder = workbook.createCellStyle();
					setBorder.setWrapText(true);
					//设置水平对齐的样式为居中对齐;  
					setBorder.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		    	    //设置垂直对齐的样式为居中对齐; 
					setBorder.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
					cell.setCellStyle(setBorder);
				}
				rowindex = rowindex+1;
			}
			// ===============================================================
		}
		
		
		for (int colNum = 0; colNum < headList.size(); colNum++) {
            sheet.setColumnWidth(colNum, 20 * 256);
        }
		return workbook;
	}

	/**
	 * @param headList
	 *            Excel文件Head标题集合
	 * @param fieldList
	 *            Excel文件Field标题集合
	 * @param dataList
	 *            Excel文件数据内容部分
	 * @throws HSSFWorkbook
	 */
	public static HSSFWorkbook createExcel(List<String> headList,
			List<String> fieldList, List<Map<String, Object>> dataList)
			throws Exception {
		// 创建新的Excel 工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();

		// 在Excel工作簿中建一工作表，其名为缺省值
		// 如要新建一名为"效益指标"的工作表，其语句为：
		// HSSFSheet sheet = workbook.createSheet("效益指标");
		HSSFSheet sheet = workbook.createSheet();
		// 在索引0的位置创建行（最顶端的行）
		HSSFRow row = sheet.createRow(0);
		// ===============================================================
		for (int i = 0; i < headList.size(); i++) {

			// 在索引0的位置创建单元格（左上端）
			HSSFCell cell = row.createCell(i);
			// 定义单元格为字符串类型
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			// 在单元格中输入一些内容
			cell.setCellValue(headList.get(i));
		}
		// ===============================================================

		for (int n = 0; n < dataList.size(); n++) {
			// 在索引1的位置创建行（最顶端的行）
			HSSFRow row_value = sheet.createRow(n + 1);
			Map<String, Object> dataMap = dataList.get(n);
			// ===============================================================
			for (int i = 0; i < fieldList.size(); i++) {

				// 在索引0的位置创建单元格（左上端）
				HSSFCell cell = row_value.createCell(i);
				// 定义单元格为字符串类型
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				// 在单元格中输入一些内容
				cell.setCellValue(objToString(dataMap.get(fieldList.get(i))));
			}
			// ===============================================================
		}
		return workbook;
	}

	private static String objToString(Object obj) {
		if (obj == null) {
			return "";
		} else {
			if (obj instanceof String) {
				return (String) obj;
			} else if (obj instanceof Date) {
				return null;// DateUtil.dateToString((Date)
							// obj,DateUtil.DATESTYLE_SHORT_EX);
			} else {
				return obj.toString();
			}
		}
	}

	/**
	 * 
	 * @param excel_name
	 *            生成的Excel文件路径+名称
	 * @param headList
	 *            Excel文件Head标题部分
	 * @param valueList
	 *            Excel文件数据内容部分
	 * @throws Exception
	 */
	public static void bulidExcel(String excel_name, String[] headList,
			List<String[]> valueList) throws Exception {
		// 创建新的Excel 工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();

		// 在Excel工作簿中建一工作表，其名为缺省值
		// 如要新建一名为"效益指标"的工作表，其语句为：
		// HSSFSheet sheet = workbook.createSheet("效益指标");
		HSSFSheet sheet = workbook.createSheet();
		// 在索引0的位置创建行（最顶端的行）
		HSSFRow row = sheet.createRow(0);
		// ===============================================================
		for (int i = 0; i < headList.length; i++) {

			// 在索引0的位置创建单元格（左上端）
			HSSFCell cell = row.createCell(i);
			// 定义单元格为字符串类型
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			// 在单元格中输入一些内容
			cell.setCellValue(headList[i]);
		}
		// ===============================================================

		for (int n = 0; n < valueList.size(); n++) {
			// 在索引1的位置创建行（最顶端的行）
			HSSFRow row_value = sheet.createRow(n + 1);
			String[] valueArray = valueList.get(n);
			// ===============================================================
			for (int i = 0; i < valueArray.length; i++) {

				// 在索引0的位置创建单元格（左上端）
				HSSFCell cell = row_value.createCell(i);
				// 定义单元格为字符串类型
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				// 在单元格中输入一些内容
				cell.setCellValue(valueArray[i]);
			}
			// ===============================================================
		}

		// 新建一输出文件流
		FileOutputStream fOut = new FileOutputStream(excel_name);
		// 把相应的Excel 工作簿存盘
		workbook.write(fOut);
		fOut.flush();
		// 操作结束，关闭文件
		fOut.close();
		//System.out.println("[" + excel_name + "]" + "文件生成...");
	}

	/**
	 * 读取 Excel文件内容
	 * 
	 * @param excel_name
	 * @return
	 * @throws Exception
	 */
	public static List<String[]> readExcel(String excel_name) throws Exception {
		// 结果集
		List<String[]> list = new ArrayList<String[]>();

		HSSFWorkbook hssfworkbook = new HSSFWorkbook(new FileInputStream(
				excel_name));

		// 遍历该表格中所有的工作表，i表示工作表的数量 getNumberOfSheets表示工作表的总数
		HSSFSheet hssfsheet = hssfworkbook.getSheetAt(0);

		// 遍历该行所有的行,j表示行数 getPhysicalNumberOfRows行的总数
		for (int j = 0; j < hssfsheet.getPhysicalNumberOfRows(); j++) {
			HSSFRow hssfrow = hssfsheet.getRow(j);
			if(hssfrow!=null){
			int col = hssfrow.getPhysicalNumberOfCells();
			// 单行数据
			String[] arrayString = new String[col];
			for (int i = 0; i < col; i++) {
				HSSFCell cell = hssfrow.getCell(i);
				if (cell == null) {
					arrayString[i] = "";
				} else if (cell.getCellType() == 0) {
					// arrayString[i] = new Double(cell.getNumericCellValue()).toString();
					if (HSSFCell.CELL_TYPE_NUMERIC == cell.getCellType()) { 
						  if (HSSFDateUtil.isCellDateFormatted(cell)) {    
						    Date d = cell.getDateCellValue();    
//						    DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");    
						     DateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						    arrayString[i] = formater.format(d);   
						   } else {    
						       arrayString[i] = new BigDecimal(cell.getNumericCellValue()).longValue()+"";    
						}
					}
				} else {// 如果EXCEL表格中的数据类型为字符串型
					arrayString[i] = cell.getStringCellValue().trim();
				}
			}
			list.add(arrayString);
		}
		}
		return list;
	}

	/**
	 * 读取 Excel文件内容
	 * 
	 * @param excel_name
	 * @return
	 * @throws Exception
	 */
	public static List<List<Object>> readExcelByList(String excel_name)
			throws Exception {
		// 结果集
		List<List<Object>> list = new ArrayList<List<Object>>();

		HSSFWorkbook hssfworkbook = new HSSFWorkbook(new FileInputStream(
				excel_name));

		// 遍历该表格中所有的工作表，i表示工作表的数量 getNumberOfSheets表示工作表的总数
		HSSFSheet hssfsheet = hssfworkbook.getSheetAt(0);

		// 遍历该行所有的行,j表示行数 getPhysicalNumberOfRows行的总数
		for (int j = 0; j < hssfsheet.getPhysicalNumberOfRows(); j++) {
			HSSFRow hssfrow = hssfsheet.getRow(j);
			if (hssfrow != null) {
				int col = hssfrow.getPhysicalNumberOfCells();
				// 单行数据
				List<Object> arrayString = new ArrayList<Object>();
				for (int i = 0; i < col; i++) {
					HSSFCell cell = hssfrow.getCell(i);
					if (cell == null) {
						arrayString.add("");
					} else if (cell.getCellType() == 0) {
						arrayString.add(new Double(cell.getNumericCellValue())
								.toString());
					} else {// 如果EXCEL表格中的数据类型为字符串型
						arrayString.add(cell.getStringCellValue().trim());
					}
				}
				list.add(arrayString);
			}
		}
		return list;
	}

	/**
	 * 读取 Excel文件内容
	 * 
	 * @param inputstream
	 * @return
	 * @throws Exception
	 */
	public static List<List<Object>> readExcelByInputStream(
			InputStream inputstream) throws Exception {
		// 结果集
		List<List<Object>> list = new ArrayList<List<Object>>();

		HSSFWorkbook hssfworkbook = new HSSFWorkbook(inputstream);

		// 遍历该表格中所有的工作表，i表示工作表的数量 getNumberOfSheets表示工作表的总数
		HSSFSheet hssfsheet = hssfworkbook.getSheetAt(0);

		// 遍历该行所有的行,j表示行数 getPhysicalNumberOfRows行的总数

		// //System.out.println("excel行数： "+hssfsheet.getPhysicalNumberOfRows());
		for (int j = 0; j < hssfsheet.getPhysicalNumberOfRows(); j++) {
			HSSFRow hssfrow = hssfsheet.getRow(j);
			if (hssfrow != null) {
				int col = hssfrow.getPhysicalNumberOfCells();
				// 单行数据
				List<Object> arrayString = new ArrayList<Object>();
				for (int i = 0; i < col; i++) {
					HSSFCell cell = hssfrow.getCell(i);
					if (cell == null) {
						arrayString.add("");
					} else if (cell.getCellType() == 0) {
						arrayString.add(new Double(cell.getNumericCellValue())
								.toString());
					} else {// 如果EXCEL表格中的数据类型为字符串型
						arrayString.add(cell.getStringCellValue().trim());
					}
				}
				list.add(arrayString);
			}
		}
		return list;
	}

	/**
	 * 导入 excel
	 * 
	 * @param file : Excel文件
	 * @param pojoClass : 对应的导入对象 (每行记录)
	 * @return
	 */
	public static Collection importExcel(File file, Class pojoClass,Integer type) {
		try {
			// 将传入的File构造为FileInputStream;
			FileInputStream in = new FileInputStream(file);
			return importExcelByIs(in, pojoClass,type);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * 导入 excel
	 * 
	 * @param inputstream : 文件输入流
	 * @param pojoClass : 对应的导入对象 (每行记录)
	 * @param type: 1：xls  其他xlxs
	 * @return
	 */
	public static Collection importExcelByIs(InputStream inputstream, Class pojoClass,Integer type) {
		Collection dist = new ArrayList<Object>();
		try {
			// 得到目标目标类的所有的字段列表
			Field filed[] = pojoClass.getDeclaredFields();
			// 将所有标有Annotation的字段，也就是允许导入数据的字段,放入到一个map中
			Map<String, Method> fieldSetMap = new HashMap<String, Method>();
			Map<String, Method> fieldSetConvertMap = new HashMap<String, Method>();
			// 循环读取所有字段
			for (int i = 0; i < filed.length; i++) {
				Field f = filed[i];
				// 得到单个字段上的Annotation
				Excel excel = f.getAnnotation(Excel.class);
				// 如果标识了Annotationd的话
				if (excel != null) {
					// 构造设置了Annotation的字段的Setter方法
					String fieldname = f.getName();
					String setMethodName = "set" + fieldname.substring(0, 1).toUpperCase() + fieldname.substring(1);
					// 构造调用的method，
					Method setMethod = pojoClass.getMethod(setMethodName, new Class[] { f.getType() });
					// 将这个method以Annotaion的名字为key来存入。
					// 对于重名将导致 覆盖 失败，对于此处的限制需要
					fieldSetMap.put(excel.exportName(), setMethod);
					if (excel.importConvert() == true) {
						// 用get/setXxxxConvert方法名的话， 由于直接使用了数据库绑定的Entity对象，注入会有冲突
						StringBuffer setConvertMethodName = new StringBuffer("convertSet");
						setConvertMethodName.append(fieldname.substring(0, 1).toUpperCase());
						setConvertMethodName.append(fieldname.substring(1));
						Method getConvertMethod = pojoClass.getMethod(setConvertMethodName.toString(), new Class[] { String.class });
						fieldSetConvertMap.put(excel.exportName(), getConvertMethod);
					}
				}
			}
			
			Iterator<Row> row;
			// 将传入的File构造为FileInputStream;
			if(type==1)
			{
				// // 得到工作表
				HSSFWorkbook book = new HSSFWorkbook(inputstream);
				// // 得到第一页
				HSSFSheet sheet = book.getSheetAt(0);
				// // 得到第一面的所有行
				 row = sheet.rowIterator();
			}
			else
			{
				// // 得到工作表
				XSSFWorkbook book = new XSSFWorkbook(inputstream);
				// // 得到第一页
				XSSFSheet sheet = book.getSheetAt(0);
				// // 得到第一面的所有行
			    row = sheet.rowIterator();
			}

			// 得到第一行，也就是标题行
			Row title = row.next();
			// 得到第一行的所有列
			Iterator<Cell> cellTitle = title.cellIterator();
			// 将标题的文字内容放入到一个map中。
			Map titlemap = new HashMap();
			// 从标题第一列开始
			int i = 0;
			// 循环标题所有的列
			while (cellTitle.hasNext()) {
				Cell cell = cellTitle.next();
				String value = cell.getStringCellValue();
				titlemap.put(i, value);
				i = i + 1;
			}
			// 用来格式化日期的DateFormat
			// SimpleDateFormat sf;
			while (row.hasNext()) {
				// 标题下的第一行
				Row rown = row.next();
				// 行的所有列
				Iterator<Cell> cellbody = rown.cellIterator();
				// 得到传入类的实例
				Object tObject = pojoClass.newInstance();
				int k = 0;
				// 遍历一行的列
				while (cellbody.hasNext()) {
					Cell cell = cellbody.next();
					// 这里得到此列的对应的标题
					String titleString = (String) titlemap.get(k);
					// 如果这一列的标题和类中的某一列的Annotation相同，那么则调用此类的的set方法，进行设值
					if (fieldSetMap.containsKey(titleString)) {
						Method setMethod = (Method) fieldSetMap.get(titleString);
						// 得到setter方法的参数
						Type[] ts = setMethod.getGenericParameterTypes();
						// 只要一个参数
						String xclass = ts[0].toString();
						// 判断参数类型
						if (Cell.CELL_TYPE_STRING == cell.getCellType()
								&& fieldSetConvertMap.containsKey(titleString)) {
							// 目前只支持从String转换
							fieldSetConvertMap.get(titleString).invoke(tObject, cell.getStringCellValue());
						} else {
							if (xclass.equals("class java.lang.String")) {
								// 先设置Cell的类型，然后就可以把纯数字作为String类型读进来了：
								cell.setCellType(Cell.CELL_TYPE_STRING);
								setMethod.invoke(tObject, cell.getStringCellValue());
							} else if (xclass.equals("class java.util.Date")) {
								// update-start--Author:Quainty Date:20130523 for：日期类型数据导入不对(顺便扩大支持了Excel的数据类型)
								Date cellDate = null;
								if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
									// 日期格式
									cellDate = cell.getDateCellValue();
								} else {	// 全认为是  Cell.CELL_TYPE_STRING: 如果不是 yyyy-mm-dd hh:mm:ss 的格式就不对(wait to do:有局限性)
									cellDate = stringToDate(cell.getStringCellValue());
								}
			                    setMethod.invoke(tObject,cellDate);
								//// --------------------------------------------------------------------------------------------
								//String cellValue = cell.getStringCellValue();
								//Date theDate = stringToDate(cellValue);
								//setMethod.invoke(tObject, theDate);
								//// --------------------------------------------------------------------------------------------
							} else if (xclass.equals("class java.lang.Boolean")) {
								boolean valBool;
								if (Cell.CELL_TYPE_BOOLEAN == cell.getCellType()) {
									valBool = cell.getBooleanCellValue();
								} else {// 全认为是  Cell.CELL_TYPE_STRING
									valBool = cell.getStringCellValue().equalsIgnoreCase("true") 
											|| (!cell.getStringCellValue().equals("0"));
								}
								setMethod.invoke(tObject, valBool);
							} else if (xclass.equals("class java.lang.Integer")) {
								Integer valInt;
								if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
									valInt = (new Double(cell.getNumericCellValue())).intValue();
								} else {// 全认为是  Cell.CELL_TYPE_STRING
									valInt = new Integer(cell.getStringCellValue());
								}
								setMethod.invoke(tObject, valInt);
							} else if (xclass.equals("class java.lang.Long")) {
								Long valLong;
								if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
									valLong = (new Double(cell.getNumericCellValue())).longValue();
								} else {// 全认为是  Cell.CELL_TYPE_STRING
									valLong = new Long(cell.getStringCellValue());
								}
								setMethod.invoke(tObject, valLong);
							} else if (xclass.equals("class java.math.BigDecimal")) {
								BigDecimal valDecimal;
								if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
									valDecimal = new BigDecimal(cell.getNumericCellValue());
								} else {// 全认为是  Cell.CELL_TYPE_STRING
									valDecimal = new BigDecimal(cell.getStringCellValue());
								}
								setMethod.invoke(tObject, valDecimal);
							}
							else if (xclass.equals("class java.lang.Double")) {
								Double valDouble;
								if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
									valDouble = new Double(cell.getNumericCellValue());
								} else {// 全认为是  Cell.CELL_TYPE_STRING
									valDouble = new Double(cell.getNumericCellValue());
								}
								setMethod.invoke(tObject, valDouble);
							}
						}
					}
					// 下一列
					k = k + 1;
				}
				dist.add(tObject);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return dist;
	}

	/**
	 * 字符串转换为Date类型数据（限定格式      YYYY-MM-DD hh:mm:ss）或（YYYY/MM/DD hh:mm:ss）
	 * 
	 * @param cellValue : 字符串类型的日期数据
	 * @return
	 */
	private static Date stringToDate(String cellValue) {
		if (cellValue.length() > 19)
			cellValue = cellValue.substring(0, 19);
		Calendar calendar = Calendar.getInstance();
		String[] dateStr = cellValue.split(" ");
		String[] dateInfo = dateStr[0].split("-");
		if (dateInfo.length != 3) {
			dateInfo = dateStr[0].split("/");	// 让  yyyy/mm/dd 的格式也支持
		}
		if (dateInfo.length == 3) {
			int year = Integer.parseInt(dateInfo[0]);
			int month = Integer.parseInt(dateInfo[1])-1;	// 0~11
			int day = Integer.parseInt(dateInfo[2]);
			calendar.set(year, month, day);
		} else {
			return null;	// 格式不正确
		}
		if (dateStr.length > 1) {// 有时间（限定格式     hh:mm:ss）
			String[] timeStr = dateStr[1].split(":");
			if (timeStr.length == 3) {
				int hour = Integer.parseInt(timeStr[0]);
				int minute = Integer.parseInt(timeStr[1]);
				int second = Integer.parseInt(timeStr[2]);
				calendar.set(Calendar.HOUR_OF_DAY, hour);
				calendar.set(Calendar.MINUTE, minute);
				calendar.set(Calendar.SECOND, second);
			} else {
				return null;	// 格式不正确
			}
		}
		return calendar.getTime();
	}
	
	/* 
	 * 列头单元格样式
	 */    
  	private static HSSFCellStyle getColumnTopStyle(HSSFWorkbook workbook) {
  		
  		  // 设置字体
    	  HSSFFont font = workbook.createFont();
    	  //设置字体大小
    	  font.setFontHeightInPoints((short)11);
    	  //字体加粗
    	  font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
    	  //设置字体名字 
    	  font.setFontName("Courier New");
    	  //设置样式; 
    	  HSSFCellStyle style = workbook.createCellStyle();
    	  //设置底边框; 
    	  style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
    	  //设置底边框颜色;  
    	  style.setBottomBorderColor(HSSFColor.BLACK.index);
    	  //设置左边框;   
    	  style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
    	  //设置左边框颜色; 
    	  style.setLeftBorderColor(HSSFColor.BLACK.index);
    	  //设置右边框; 
    	  style.setBorderRight(HSSFCellStyle.BORDER_THIN);
    	  //设置右边框颜色; 
    	  style.setRightBorderColor(HSSFColor.BLACK.index);
    	  //设置顶边框; 
    	  style.setBorderTop(HSSFCellStyle.BORDER_THIN);
    	  //设置顶边框颜色;  
    	  style.setTopBorderColor(HSSFColor.BLACK.index);
    	  //设置底色
    	  style.setFillForegroundColor(HSSFColor.GREEN.index);
    	  style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
    	  
    	  //在样式用应用设置的字体;  
    	  style.setFont(font);
    	  //设置自动换行; 
    	  style.setWrapText(false);
    	  //设置水平对齐的样式为居中对齐;  
    	  style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
    	  //设置垂直对齐的样式为居中对齐; 
    	  style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
    	  
    	  return style;
    	  
  	}
}
