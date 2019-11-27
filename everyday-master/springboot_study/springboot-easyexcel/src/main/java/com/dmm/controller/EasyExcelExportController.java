//package com.dmm.controller;
//
//import com.alibaba.excel.ExcelWriter;
//import com.alibaba.excel.metadata.Sheet;
//import com.alibaba.excel.support.ExcelTypeEnum;
//import com.dmm.pojo.CreateData;
//import com.dmm.pojo.Student;
//import com.dmm.pojo.vo.ExcelUtil;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.OutputStream;
//
///**
// * @author Mr. Du
// * @explain
// * @createTime 2019/11/7 16:44
// * @motto The more learn, the more found his ignorance.
// */
//@Controller
//@RequestMapping("/easy/excel")
//public class EasyExcelExportController {
//
//    @RequestMapping("/export/sheet")
//    public void oneSheetExport(HttpServletResponse response) throws IOException {
//
//        response.setHeader("Content-Disposition", "filename=filename.xlsx" );
//
//        OutputStream outputStream=response.getOutputStream();
//        //new ExcelWriter(outputStream,ExcelTypeEnum.XLSX);
//        ExcelWriter excelWriter=new ExcelWriter(outputStream,ExcelTypeEnum.XLSX);
//                //Factory.getWriter(outputStream,ExcelTypeEnum.XLSX,true);
//        Sheet sheet=new Sheet(1,0, new Student().getClass());
//        sheet.setSheetName("dmm");
////        excelWriter.
//        excelWriter.write(CreateData.createStudentList1(),sheet);
//
//        excelWriter.finish();
//        //outputStream.flush();
//        //outputStream.close();
//
//    }
//
////    @RequestMapping("/export/sheet2")
////    public void oneSheetExport2(HttpServletResponse response) throws IOException {
////
////        response.setHeader("Content-Disposition", "filename=filename.xlsx" );
////
////        WriteSheet writeSheet = new WriteSheet();
////        writeSheet.setSheetNo(1);
////        writeSheet.setSheetName("dmm");
////        writeSheet.setClazz(Student.class);
////        writeSheet.setNeedHead(true);
////
////        OutputStream outputStream=response.getOutputStream();
////
////        ExcelWriter excelWriter= EasyExcel.write(outputStream).build();
////
////        excelWriter.write(CreateData.createStudentList1(),writeSheet);
////
////        excelWriter.finish();
////        outputStream.flush();
////        outputStream.close();
////
////    }
//
//
//    @RequestMapping("/export/sheet3")
//    public void oneSheetExport3(HttpServletResponse response) {
//
//        ExcelUtil.writeExcelWithSheets(response,CreateData.createStudentList1(),"测试","目录1",new Student()).
//                write(CreateData.createStudentList2(),"目录2",new Student()).finish();
//        //ExcelUtil.writeExcelWithSheets(1,response,CreateData.createStudentList2(),"测试","目录2",new Student());
//
//    }
//
//    @RequestMapping("/export/sheet4")
//    public void oneSheetExport4(HttpServletResponse response) {
//
//        ExcelUtil.writeExcel(response,CreateData.createStudentList1(),"测试","目录1",new Student());
//        //ExcelUtil.writeExcelWithSheets(1,response,CreateData.createStudentList2(),"测试","目录2",new Student());
//
//    }
//
//
//
//
//}
//
