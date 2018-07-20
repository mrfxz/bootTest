package com.boot.test.poi.util;

import com.boot.test.poi.vo.ExcelCol;
import org.apache.poi.hssf.usermodel.*;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Excel工具类
 * 主要提供简单的Excel导入与导出功能
 */
public abstract class ExcelUtil<T> {

    /**
     * 列设计
     * 1 是一个容器,可以由调用者确定大小
     * 2 可以直接设定列表列标题(也就是创建一行)
     * 3 必须在调用方法的时候就初始化列容器(所以用abstract不错)
     */
    //第一行描述信息,如姓名,年龄,序号,籍贯等
    protected List<ExcelCol> cols;
    //多种样式集合
    protected Map<String,HSSFCellStyle> styles;
     public ExcelUtil(){
         init();
     }

    /**
     * 初始化列信息方法
     */
    protected abstract void init();

    /**
     * 导出Excel
     * @param list
     * @param sheetName
     */
    public  HSSFWorkbook ExcelOut(List<T> list, String sheetName){
        //1 创建Excel文档
        HSSFWorkbook workbook = new HSSFWorkbook();
        //2 创建操作表
        HSSFSheet sheet = workbook.createSheet(sheetName);
        //3 设置格式
         setStyle(workbook);
         HSSFCellStyle dataStyle = styles.get("dataStyle");
        HSSFCellStyle titleStyle = styles.get("titleStyle");
        //4 循环List创建row
        if(list != null){
            HSSFRow firstRow = sheet.createRow(0);
            for(int i = 0; i < cols.size(); i++){
                createCel(firstRow,titleStyle,i).setCellValue(cols.get(i).getTitle());
            }
            int count = 1;
            for (T data:list) {
                createRowByData(sheet,dataStyle,data,count++);
            }
        }

        return workbook;
    }

    /**
     * 设置Excel通用格式
     * @param workbook
     */
    protected  Map<String,HSSFCellStyle> setStyle(HSSFWorkbook workbook){
        //数据格式
         HSSFCellStyle dataStyle = workbook.createCellStyle();
         styles = new HashMap<>();
        //设置底边框;
        dataStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //设置左边框;
        dataStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //设置右边框;
        dataStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        //设置顶边框;
        dataStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //设置自动换行;
        dataStyle.setWrapText(true);
        //设置水平对齐的样式为居中对齐;
        dataStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);


        //设置字体
        HSSFFont font = workbook.createFont();
        font.setFontName("宋体");
        font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);//正常显示
        font.setFontHeightInPoints((short)12);//字体大小
        dataStyle.setFont(font);

        styles.put("dataStyle",dataStyle);
        //标题样式
        HSSFCellStyle titleStyle = workbook.createCellStyle();
        //设置底边框;
        titleStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //设置左边框;
        titleStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //设置右边框;
        titleStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        //设置顶边框;
        titleStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //设置自动换行;
        titleStyle.setWrapText(true);
        //设置水平对齐的样式为居中对齐;
        titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);


        //设置字体
        HSSFFont titleFont = workbook.createFont();
        titleFont.setFontName("宋体");
        titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        titleFont.setFontHeightInPoints((short)12);//字体大小
        titleStyle.setFont(titleFont);

        styles.put("titleStyle",titleStyle);
        return styles;
    }

    /**
     * 设置单元格样式
     * @param row
     * @param style
     * @param index
     * @return
     */
    protected  HSSFCell createCel(HSSFRow row, HSSFCellStyle style, int index){
        HSSFCell cell = row.createCell(index);
        cell.setCellStyle(style);
        return cell;
    }

    /**
     * 创建一行数据
     * @param sheet
     * @param style
     * @param data
     * @param index
     * @return
     */
    protected  HSSFRow createRowByData(HSSFSheet sheet,HSSFCellStyle style, T data,int index){
        HSSFRow row = sheet.createRow(index);
        int count = 0;
        for(int i = 0; i < cols.size(); i++){
            HSSFCell cell = createCel(row,style,count++);
            try{
                //通过反射get方法获取指定属性的值
                String methodName = cols.get(i).getPropertyName();
                //拼写method
                methodName = "get" + methodName.substring(0,1).toUpperCase() + methodName.substring(1);
                Method method = data.getClass().getMethod(methodName,null);
                Object value = method.invoke(data);
                if(value != null && value !=""){
                    cell.setCellValue(new HSSFRichTextString(value.toString()));
                }
            }catch(Exception e){
                System.out.print("生成Excel异常!!!");
            }
        }
        return row;
    }
}
