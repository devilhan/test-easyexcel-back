package com.devilhan.easyexcel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.devilhan.easyexcel.pojo.ExcelData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by hanyanjiao on 15:57
 */
public class ExcelListener extends AnalysisEventListener<ExcelData> {

  private String str;

  public ExcelListener(String str) {
    this.str = str;
  }
  List<Long> uids = new ArrayList<>();

  @Override
  public void invoke(ExcelData data, AnalysisContext context) {
    uids.add(data.getUid());
  }

  @Override
  public void doAfterAllAnalysed(AnalysisContext context) {
    System.out.println(str+uids);
  }

  @Override
  public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
    System.out.println(headMap);
  }
}
