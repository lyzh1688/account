package com.tuoyou.account.runner.service;

import com.tuoyou.account.salary.domain.SalaryStatementRecord;

import java.util.List;

/**
 * Created by 刘悦之 on 2019/9/14.
 */
public interface SalaryStatementDtlService {
    List<SalaryStatementRecord> getSalaryStatementDtl();
    List<SalaryStatementRecord> getSalaryStatementDtl(String batchId);
    void fillInExtractor(List<SalaryStatementRecord> records);
}
