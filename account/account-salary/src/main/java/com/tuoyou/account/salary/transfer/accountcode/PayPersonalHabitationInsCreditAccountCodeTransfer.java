package com.tuoyou.account.salary.transfer.accountcode;

import com.account.common.dict.AccountCode;
import com.tuoyou.account.salary.domain.SalaryStatementRecord;
import com.tuoyou.account.salary.extractor.SalaryStatementDtlRecordExtractor;
import com.tuoyou.account.voucher.core.Extractor;

import java.math.BigDecimal;

/**
 * Created by liuyuezhi on 2019/8/30.
 * 贷方科目代码生成规则[代扣代缴公积金(个人部分)]
 */
public class PayPersonalHabitationInsCreditAccountCodeTransfer extends CreditAccountCodeTransfer {
    @Override
    public String creditGenerator(Extractor extractor) throws Exception {
        if (extractor instanceof SalaryStatementDtlRecordExtractor) {
            SalaryStatementDtlRecordExtractor salaryStatementDtlRecordExtractor = (SalaryStatementDtlRecordExtractor) extractor;
            SalaryStatementRecord record = salaryStatementDtlRecordExtractor.extract();
            if (record.getHabitationInsPers() != null && record.getHabitationInsPers().compareTo(BigDecimal.ZERO) > 0) {
                return AccountCode.personalHabitation;
            } else {
                return null;
            }
        } else
            throw new Exception("SalaryStatementDtlRecordExtractor required ");
    }
}
