package com.devilhan.easyexcel.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

/**
 * @Author: hanyanjiao
 * @Date: 2022/4/9
 * @Description:
 */
@Data
public class ExcelData {

    @ExcelProperty(value = "用户ID",index = 0)
    private Long uid;

    @ExcelProperty(value = "用户名",index = 1)
    private String userName;

    @ExcelProperty(value = "手机号",index = 2)
    private String mobile;
}
