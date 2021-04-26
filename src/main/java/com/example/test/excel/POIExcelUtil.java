package com.example.test.excel;


import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static org.apache.poi.ss.usermodel.CellType.*;

/**
 * @program: BladeX-Biz->POIExcelUtil
 * @description:
 * @create: 2019-12-25 14:53
 **/
public class POIExcelUtil {

    private static Logger logger = LoggerFactory.getLogger(POIExcelUtil.class);

    private final static String XLS = "xls";
    private final static String XLSX = "xlsx";

    public static List<String[]> readExcel(File file) throws IOException {
        // 检查文件
        checkFile(file);
        Workbook workBook = getWorkBook(file);
        // 返回对象,每行作为一个数组，放在集合返回
        ArrayList<String[]> rowList = new ArrayList<>();
        if (null != workBook) {
            for (int sheetNum = 0; sheetNum < workBook.getNumberOfSheets(); sheetNum++) {
                // 获得当前sheet工作表
                Sheet sheet = workBook.getSheetAt(sheetNum);
                if (sheet == null) {
                    continue;
                }
                // 获得当前sheet的开始行
                int firstRowNum = sheet.getFirstRowNum();
                // 获得当前sheet的结束行
                int lastRowNum = sheet.getLastRowNum();
                // 循环所有行(第一行为标题)
                for (int rowNum = firstRowNum; rowNum < lastRowNum; rowNum++) {
                    // 获得当前行
                    Row row = sheet.getRow(rowNum);
                    if (row == null) {
                        continue;
                    }
                    // 获得当前行开始的列
                    short firstCellNum = row.getFirstCellNum();
                    // 获得当前行的列数
                    int lastCellNum = row.getPhysicalNumberOfCells();
                    String[] cells = new String[row.getPhysicalNumberOfCells()];
                    // 循环当前行
                    for (int cellNum = firstCellNum; cellNum < lastCellNum; cellNum++) {
                        Cell cell = row.getCell(cellNum);
                        cells[cellNum] = getCellValue(cell);
                    }
                    rowList.add(cells);
                }
            }
        }
        return rowList;
    }

    /**
     * 取单元格的值
     */
    public static String getCellValue(Cell cell) {
        String cellValue = "";
        if (cellValue == null) {
            return cellValue;
        }
        // 把数字当成String来读，防止1读成1.0
        if (cell.getCellType() == NUMERIC) {
            cell.setCellType(STRING);
        }
        // 判断数据的类型
        switch (cell.getCellType()) {
            // 数字
            case NUMERIC:
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            // 字符串
            case STRING:
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            // 布尔
            case BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            // 公式
            case FORMULA:
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            // 空
            case BLANK:
                cellValue = "";
                break;
            // 错误
            case ERROR:
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        return cellValue;
    }

    /**
     * 获得工作簿对象
     */
    public static Workbook getWorkBook(File file) {
        String filename = file.getName();
        Workbook workbook = null;
        try {
            InputStream is = new FileInputStream(file);
            if (filename.endsWith(XLS)) {
                // 2003
                workbook = new HSSFWorkbook(is);
            } else if (filename.endsWith(XLSX)) {
                // 2007
                workbook = new XSSFWorkbook(is);
            }
        } catch (IOException e) {
        }
        return workbook;
    }

    /**
     * 检查文件
     */
    public static void checkFile(File file) throws IOException {
        if (null == file) {
            logger.error("文件不存在");
            throw new FileNotFoundException("文件不存在！");
        }
        // 获取文件名
        String filename = file.getName();
        // 判断是否为excel文件
        if (!filename.endsWith(XLS) && !filename.endsWith(XLSX)) {
            logger.error(filename + "不是excel文件");
            throw new IOException(filename + "不是excel文件");
        }
    }

    /**
     * 创建表格标题
     *
     * @param wb
     *            Excel文档对象
     * @param sheet
     *            工作表对象
     * @param headString
     *            标题名称
     * @param col
     *            标题占用列数
     */
    public static void createHeadTittle(HSSFWorkbook wb, HSSFSheet sheet, String headString, int col) {
        HSSFRow row = sheet.createRow(0); // 创建Excel工作表的行
        HSSFCell cell = row.createCell(0); // 创建Excel工作表指定行的单元格
        row.setHeight((short) 1000); // 设置高度
        cell.setCellType(CellType.STRING); // 定义单元格为字符串类型
        cell.setCellValue(new HSSFRichTextString(headString));
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, col)); // 指定标题合并区域
        // 定义单元格格式，添加单元格表样式，并添加到工作簿
        HSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER); // 指定单元格水平居中对齐
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER); // 指定单元格垂直居中个对齐
        cellStyle.setWrapText(true); // 指定单元格自动换行
        // 设置单元格字体
        HSSFFont font = wb.createFont();
        font.setBold(true);//设置字体为粗体
        font.setFontName("微软雅黑");
        font.setColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        font.setFontHeightInPoints((short) 16); // 字体大小
        cellStyle.setFont(font);
        cell.setCellStyle(cellStyle);
    }

    /**
     * 创建表头
     *
     * @param wb
     *            Excel文档对象
     * @param sheet
     *            工作表对象
     * @param thead
     *            表头内容
     * @param sheetWidth
     *            每一列宽度
     */
    public static void createThead(HSSFWorkbook wb, HSSFSheet sheet, String[] thead, int[] sheetWidth) {
        HSSFRow row1 = sheet.createRow(1);
        row1.setHeight((short) 600);
        // 定义单元格格式，添加单元格表样式，并添加到工作簿
        HSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);//水平居中对齐
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中对齐
        cellStyle.setWrapText(true);
        //设置背景色灰色25%
        cellStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.GREY_25_PERCENT.getIndex()); // 设置背景色
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderRight(BorderStyle.THIN); // 设置右边框类型
        cellStyle.setRightBorderColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex()); // 设置右边框颜色
        // 设置单元格字体
        HSSFFont font = wb.createFont();
        font.setBold(true);//设置字体为粗体
        font.setFontName("宋体");
        font.setFontHeightInPoints((short) 10);
        cellStyle.setFont(font);
        // 设置表头内容
        for (int i = 0; i < thead.length; i++) {
            HSSFCell cell1 = row1.createCell(i);
            cell1.setCellType(CellType.STRING);//定义单元格为字符串类型
            cell1.setCellValue(new HSSFRichTextString(thead[i]));
            cell1.setCellStyle(cellStyle);
        }
        // 设置每一列宽度
        for (int i = 0; i < sheetWidth.length; i++) {
            sheet.setColumnWidth(i, sheetWidth[i]);
        }
    }

    /**
     * 填入数据
     *
     * @param wb
     *            // Excel文档对象
     * @param sheet
     *            // 工作表对象
     * @param result
     *            // 表数据
     */
    public static void createTable(HSSFWorkbook wb, HSSFSheet sheet, List<LinkedHashMap<String, String>> result) {
        // 定义单元格格式，添加单元格表样式，并添加到工作薄
        HSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setWrapText(true);
        // 单元格字体
        HSSFFont font = wb.createFont();
        font.setFontName("宋体");
        font.setFontHeightInPoints((short) 10);
        cellStyle.setFont(font);
        cellStyle.setAlignment(HorizontalAlignment.CENTER); // 居中
        // 循环插入数据
        for (int i = 0; i < result.size(); i++) {
            HSSFRow row = sheet.createRow(i + 2);
            row.setHeight((short) 400); // 设置高度
            HSSFCell cell = null;
            int j = 0;
            for (String key : (result.get(i).keySet())) {
                cell = row.createCell(j);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(new HSSFRichTextString(result.get(i).get(key)));
                j++;
            }
        }
    }



}
