package com.dmm.util;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 *
 * @author DMM
 * @create 2019/11/5
 */

public class ExcelWriterFactory extends ExcelWriter {

    //写入流
    private OutputStream outputStream;
    //起始工作表
    private int sheetNo = 1;
    //
    private int startRow=0;



    /**
     * 构造方法
     * @param outputStream
     * @param typeEnum
     */
    public ExcelWriterFactory(OutputStream outputStream, ExcelTypeEnum typeEnum) {
        super(outputStream, typeEnum);
        this.outputStream = outputStream;
    }

    /**
     * 多sheet写入
     * @param list
     * @param sheetName
     * @param object
     * @return
     */
    public ExcelWriterFactory writeSheets(List<? extends BaseRowModel> list, String sheetName, BaseRowModel object) {
        this.sheetNo++;
        try {
            Sheet sheet = new Sheet(sheetNo, 0, object.getClass());

            System.out.println("startRow"+sheet.getStartRow());

            sheet.setSheetName(sheetName);
            this.write(list, sheet);
        } catch (Exception ex) {
            ex.printStackTrace();
            try {
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    /**
     * 单sheet 大数据量
     * @param list
     * @param number
     * @param object
     * @return
     */
    public ExcelWriterFactory writeSheetPage(List<? extends BaseRowModel> list, int number, BaseRowModel object) {
        this.startRow+=number;
        try {
            Sheet sheet = new Sheet(sheetNo, 0, object.getClass());
            System.out.println("writeSheetPage"+startRow);
            sheet.setStartRow(startRow);
            this.write(list, sheet);
        } catch (Exception ex) {
            ex.printStackTrace();
            try {
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    /**
     * 流的写出
     */
    @Override
    public void finish() {
        super.finish();
        try {
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

