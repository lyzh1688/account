package com.tuoyou.account.salary.transfer.amount;

import com.tuoyou.account.salary.domain.SalaryStatementRecord;
import com.tuoyou.account.salary.extractor.SalaryStatementDtlRecordExtractor;
import com.tuoyou.account.voucher.core.Extractor;
import com.tuoyou.account.voucher.core.VoucherTransfer;

import java.math.BigDecimal;

/**
 * Created by 刘悦之 on 2019/9/6.
 * 贷方 [实发工资]
 */
public class PaySalaryBranchAmountTransfer implements VoucherTransfer {
    @Override
    public String debitGenerator(Extractor extractor) throws Exception {
        return null;
    }

    @Override
    public String creditGenerator(Extractor extractor) throws Exception {
        if (extractor instanceof SalaryStatementDtlRecordExtractor) {
            SalaryStatementDtlRecordExtractor salaryStatementDtlRecordExtractor = (SalaryStatementDtlRecordExtractor) extractor;
            SalaryStatementRecord record = salaryStatementDtlRecordExtractor.extract();
            BigDecimal ret = BigDecimal.ZERO;
            ret = ret.add(record.getNetWages() != null ? record.getNetWages() : BigDecimal.ZERO);
            if(ret.compareTo(BigDecimal.ZERO) > 0){
                return ret.toPlainString();
            }
            else {
                return null;
            }

        } else
            throw new Exception("SalaryStatementDtlRecordExtractor required ");
    }
}
