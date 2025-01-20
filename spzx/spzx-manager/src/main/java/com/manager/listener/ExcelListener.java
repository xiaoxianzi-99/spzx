package com.manager.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/18
 **/
public class ExcelListener<T> extends AnalysisEventListener<T> {
    List<T> dates =new ArrayList<>();
    public List<T> getDates(){
        return dates;
    }
    @Override
    public void invoke(T t, AnalysisContext analysisContext) {

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
