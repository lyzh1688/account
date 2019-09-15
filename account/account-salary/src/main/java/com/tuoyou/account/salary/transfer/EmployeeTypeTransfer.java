package com.tuoyou.account.salary.transfer;

import com.account.common.dict.EmployeeType;
import com.tuoyou.account.salary.domain.SalaryStatementRecord;
import com.tuoyou.account.salary.extractor.SalaryStatementDtlRecordExtractor;
import com.tuoyou.account.voucher.core.Extractor;
import com.tuoyou.account.voucher.core.VoucherTransfer;

/**
 * Created by 刘悦之 on 2019/9/15.
 */
public class EmployeeTypeTransfer implements VoucherTransfer {

    private String getEmployeeType(Extractor extractor) throws Exception {
        if (extractor instanceof SalaryStatementDtlRecordExtractor) {
            SalaryStatementDtlRecordExtractor salaryStatementDtlRecordExtractor = (SalaryStatementDtlRecordExtractor) extractor;
            SalaryStatementRecord record = salaryStatementDtlRecordExtractor.extract();
            return EmployeeType.fullTime.equals(record.getStaffType()) ? EmployeeType.fullTimeShowName : EmployeeType.partTimeShowName;
        } else
            throw new Exception("SalaryStatementDtlRecordExtractor required ");
    }

    @Override
    public String debitGenerator(Extractor extractor) throws Exception {
        return this.getEmployeeType(extractor);
    }

    @Override
    public String creditGenerator(Extractor extractor) throws Exception {
        return this.getEmployeeType(extractor);
    }
}
