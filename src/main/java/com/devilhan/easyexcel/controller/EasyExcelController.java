package com.devilhan.easyexcel.controller;

import com.alibaba.excel.EasyExcel;
import com.devilhan.easyexcel.pojo.ExcelData;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: hanyanjiao
 * @Date: 2022/4/9
 * @Description:
 */
@RestController
public class EasyExcelController {
    private static final String FILE_NAME = "easyExcel-test" + new Date().getTime() + ".xlsx";

    @GetMapping("/export/excel")
    @CrossOrigin
    public void exportData() throws IOException {

        ServletRequestAttributes servletRequestAttributes
                = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        String fileName = "exportExcel_test.xlsx";
        response.setHeader("Content-Disposition", "attachment;filename="+  URLEncoder.encode(fileName, "UTF-8"));
        response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
        List<ExcelData> datas = new ArrayList<>();

        ExcelData zs = ExcelData.builder().uid(1L).userName("zs").mobile("100100").build();
        ExcelData ls = ExcelData.builder().uid(2L).userName("ls").mobile("200200").build();
        ExcelData ww = ExcelData.builder().uid(3L).userName("ww").mobile("300300").build();
        datas.add(zs);
        datas.add(ls);
        datas.add(ww);

        EasyExcel.write(response.getOutputStream(),ExcelData.class).sheet().doWrite(datas);
    }

}
