package com.devilhan.easyexcel.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: hanyanjiao
 * @Date: 2022/4/9
 * @Description:
 */
@Data
@Builder
@EqualsAndHashCode
public class ExcelData {

    @ExcelProperty("用户ID")
    private Long uid;

    @ExcelProperty("用户名")
    private String userName;

    @ExcelProperty("手机号")
    private String mobile;
}
