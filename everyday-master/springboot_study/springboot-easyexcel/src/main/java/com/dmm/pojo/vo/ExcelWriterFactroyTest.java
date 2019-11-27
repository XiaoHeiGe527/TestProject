package com.dmm.pojo.vo;

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

public class ExcelWriterFactroyTest extends ExcelWriter {

    private OutputStream outputStream;
    private int sheetNo = 1;
    private int startRow2=0;

    public ExcelWriterFactroyTest(OutputStream outputStream, ExcelTypeEnum typeEnum) {
        super(outputStream, typeEnum);
        this.outputStream = outputStream;
    }

    public ExcelWriterFactroyTest write(List<? extends BaseRowModel> list, BaseRowModel object,int startRow) {
        //this.sheetNo++;
        startRow2+=startRow;
        try {
            Sheet sheet = new Sheet(sheetNo, 0, object.getClass());
            //sheet.setSheetName(sheetName);
            System.out.println("startRow2"+startRow2+"startRow2");
            sheet.setStartRow(startRow2);

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

