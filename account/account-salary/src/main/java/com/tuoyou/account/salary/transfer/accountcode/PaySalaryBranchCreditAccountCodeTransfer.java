package com.tuoyou.account.salary.transfer.accountcode;

import com.account.common.dict.AccountCode;
import com.tuoyou.account.salary.domain.SalaryStatementRecord;
import com.tuoyou.account.salary.extractor.SalaryStatementDtlRecordExtractor;
import com.tuoyou.account.voucher.core.Extractor;

import java.math.BigDecimal;


/**
 * Created by liuyuezhi on 2019/8/30.
 * <p>
 * 贷方科目代码生成规则[实发工资分路]
 */
public class PaySalaryBranchCreditAccountCodeTransfer extends CreditAccountCodeTransfer {
    @Override
    public String creditGenerator(Extractor extractor) throws Exception {
        if (extractor instanceof SalaryStatementDtlRecordExtractor) {
            SalaryStatementDtlRecordExtractor salaryStatementDtlRecordExtractor = (SalaryStatementDtlRecordExtractor) extractor;
            SalaryStatementRecord record = salaryStatementDtlRecordExtractor.extract();
            if (record.getTotalWages() != null && record.getTotalWages().compareTo(BigDecimal.ZERO) > 0) {
                return AccountCode.companyPaySalary;
            } else {
                return null;
            }
        } else
            throw new Exception("SalaryStatementDtlRecordExtractor required ");
    }
}
