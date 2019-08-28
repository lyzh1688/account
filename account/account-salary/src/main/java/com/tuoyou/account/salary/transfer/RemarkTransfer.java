package com.tuoyou.account.salary.transfer;

import com.tuoyou.account.salary.domain.SalaryStatementRecord;
import com.tuoyou.account.salary.extractor.SalaryStatementDtlRecordExtractor;
import com.tuoyou.account.voucher.core.Extractor;
import com.tuoyou.account.voucher.core.VoucherTransfer;

/**
 * Created by 刘悦之 on 2019/8/28.
 *
 * 摘要生成规则
 */
public class RemarkTransfer implements VoucherTransfer {

    final String schema = "计提%s%s年%s月工资";

    @Override
    public String debitGenerator(Extractor extractor) throws Exception {
        if(extractor instanceof SalaryStatementDtlRecordExtractor){
            SalaryStatementDtlRecordExtractor salaryStatementDtlRecordExtractor = (SalaryStatementDtlRecordExtractor)extractor;
            SalaryStatementRecord record = salaryStatementDtlRecordExtractor.extract();
            return String.format(this.schema,record.getName(),record.getAccountPeriod().substring(0,4),record.getAccountPeriod().substring(4));
        }
        throw new Exception("SalaryStatementDtlRecordExtractor expected ");
    }

    @Override
    public String creditGenerator(Extractor extractor) throws Exception {
        throw new Exception("SalaryStatementDtlRecordExtractor expected ");
    }
}
