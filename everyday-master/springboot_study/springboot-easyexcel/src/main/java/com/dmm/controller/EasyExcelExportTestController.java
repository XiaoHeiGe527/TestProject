package com.dmm.controller;

import com.dmm.entry.TTempTest;
import com.dmm.pojo.vo.ExcelUtil;
import com.dmm.pojo.vo.ExcelWriterFactroyTest;
import com.dmm.service.TTempTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2019/11/8 10:44
 * @motto The more learn, the more found his ignorance.
 */
@Controller
@RequestMapping("/easy/excel/big")
public class EasyExcelExportTestController {

    @Autowired
    private TTempTestService tTempTestService;

    //单sheet
    @RequestMapping("/export/sheet")
    public void oneSheetExport(HttpServletResponse response) {

        String fileName="测试";

        String sheetName="目录";

        ExcelWriterFactroyTest excelWriterFactroyTest= ExcelUtil.writeExcelWithSheets2(response,null,fileName,sheetName,new TTempTest());

        long count=tTempTestService.getCount();

        System.out.println(count);

        int offset=0;
        int limit=10000;

        if(count>60000L){

            while (count>0){

                List<TTempTest> list= tTempTestService.getPage(offset,limit);

                excelWriterFactroyTest.write(list,new TTempTest(),list.size());

                offset+=limit;
                count-=limit;

            }

            excelWriterFactroyTest.finish();

        }
    }

    @RequestMapping("/export/sheet2")
    public void oneSheetExport2(HttpServletResponse response) {

        int offset=0;
        int limit=10000;

        String fileName="测试导出";

        String sheetName="工作表";

        long count=tTempTestService.getCount();

        System.out.println(count);

        long sheetCount=60000L;

        int a=0,b=0;

        while (count>0){

            com.dmm.util.ExcelWriterFactory excelWriterFactory= com.dmm.util.ExcelUtil.writeExcelWithSheetS(response,null,fileName,sheetName,new TTempTest());

            if(count>sheetCount){

                long c=count%sheetCount==0?(count/sheetCount):(count/sheetCount)+1;

                long d=sheetCount%limit==0?(sheetCount/limit):(sheetCount%limit)+1;

                while (c>0){

                    //创建一sheet
                    excelWriterFactory.writeSheets(null,sheetName+a,new TTempTest());


                    while (d>0){

                        if(count-limit<0){
                            List<TTempTest> list=tTempTestService.getPage(offset,limit);
                            excelWriterFactory.writeSheetPage(list,list.size(),new TTempTest());
                            break;
                        }else {
                            List<TTempTest> list=tTempTestService.getPage(offset,limit);
                            excelWriterFactory.writeSheetPage(list,list.size(),new TTempTest());
                        }

                        count -= limit;
                        offset += limit;
                        System.out.println(count+"------------------------");
                        d--;
                    }

                    a++;
                    c--;
                    d=sheetCount%limit==0?(sheetCount/limit):(sheetCount%limit)+1;
                }


            }else{


            }
            excelWriterFactory.finish();
            return;
        }

    }

    @RequestMapping("/export/sheet3")
    public void oneSheetExport4(HttpServletResponse response) {

        int offset=0;
        int limit=10000;

        String fileName="测试导出";

        String sheetName="工作表";

        //1.首先构建这个对象,写入第一批数据 空的
        com.dmm.util.ExcelWriterFactory excelWriterFactory= com.dmm.util.ExcelUtil.writeExcelWithSheetS(response,null,fileName,sheetName,new TTempTest());

        long count=tTempTestService.getCount();

        System.out.println(count);

        long sheetCount=100000L;

        int a=0,b=0;

        //2.判断是否大于一个sheet的数量
        while (count>sheetCount){

            //计算出sheetNoCount
            long sheetNoCount=count%sheetCount==0?(count/sheetCount):(count/sheetCount)+1;
            System.out.println(sheetCount);
            while (sheetNoCount>0){





                if(sheetNoCount==0){

                }

                List<TTempTest> list=tTempTestService.getPage(offset,limit);
//
//                excelWriterFactory.writeSheetPage(list,0,new TTempTest());



//                a++;
//                excelWriterFactory.writeSheets(null,sheetName+a,new TTempTest());

                sheetNoCount--;
                count-=sheetCount;
            }

        }
        excelWriterFactory.finish();

    }
}

