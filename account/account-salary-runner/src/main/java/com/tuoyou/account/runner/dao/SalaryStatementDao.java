package com.tuoyou.account.runner.dao;

import com.tuoyou.account.salary.domain.SalaryStatementRecord;

import java.util.List;

/**
 * Created by 刘悦之 on 2019/9/15.
 */
public interface SalaryStatementDao {
    public List<SalaryStatementRecord> getSalaryStatement(String batchId);
}
