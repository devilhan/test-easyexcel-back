package com.devilhan.easyexcel.controller;

import com.alibaba.excel.EasyExcel;
import com.devilhan.easyexcel.listener.ExcelListener;
import com.devilhan.easyexcel.pojo.ExcelData;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

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

        ExcelData zs = new ExcelData();
        zs.setUid(1L);
        zs.setUserName("zs");
        zs.setMobile("100100");
        ExcelData ls = new ExcelData();
        ls.setUid(1L);
        ls.setUserName("ls");
        ls.setMobile("100100");
        ExcelData ww = new ExcelData();
        ww.setUid(1L);
        ww.setUserName("ww");
        ww.setMobile("100100");
        datas.add(zs);
        datas.add(ls);
        datas.add(ww);

        EasyExcel.write(response.getOutputStream(),ExcelData.class).sheet().doWrite(datas);
    }

    @PostMapping("/import")
    public void importExcel(@RequestParam("file") MultipartFile file) throws IOException {
        String test = "test";
        EasyExcel.read(
                file.getInputStream(), ExcelData.class, new ExcelListener(test))
            .sheet()
            .doRead();
    }

}
