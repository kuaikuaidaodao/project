package com.example.demo.common;

import org.apache.poi.hssf.usermodel.HSSFCell;

public class IncrementUtil {
	 public static String getCellValue(HSSFCell cell){   
	        String value = null;   
	        //简单的查检列类型   
	        switch(cell.getCellType())   
	        {   
	            case HSSFCell.CELL_TYPE_STRING://字符串   
	                value = cell.getRichStringCellValue().getString();   
	                break;   
	            case HSSFCell.CELL_TYPE_NUMERIC://数字   
	                long dd = (long)cell.getNumericCellValue();   
	                value = dd+"";   
	                break;   
	            case HSSFCell.CELL_TYPE_BLANK:   
	                value = "";   
	                break;      
	            case HSSFCell.CELL_TYPE_FORMULA:   
	                value = String.valueOf(cell.getCellFormula());   
	                break;   
	            case HSSFCell.CELL_TYPE_BOOLEAN://boolean型值   
	                value = String.valueOf(cell.getBooleanCellValue());   
	                break;   
	            case HSSFCell.CELL_TYPE_ERROR:   
	                value = String.valueOf(cell.getErrorCellValue());   
	                break;   
	            default:   
	                break;   
	        }   
	        return value;   
	    } 
	 
}
