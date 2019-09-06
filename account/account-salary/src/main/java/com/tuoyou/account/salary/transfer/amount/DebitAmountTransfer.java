package com.tuoyou.account.salary.transfer.amount;

import com.account.common.dict.AccountCode;
import com.tuoyou.account.salary.domain.SalaryStatementRecord;
import com.tuoyou.account.salary.extractor.SalaryStatementDtlRecordExtractor;
import com.tuoyou.account.salary.transfer.SalaryStatementRecordHelper;
import com.tuoyou.account.voucher.core.Extractor;
import com.tuoyou.account.voucher.core.VoucherTransfer;

import java.math.BigDecimal;

/**
 * Created by liuyuezhi on 2019/8/30.
 * 借方 [工资总额 + sum(五险一金公司部分)]
 */
public class DebitAmountTransfer implements VoucherTransfer,SalaryStatementRecordHelper {
    @Override
    public String debitGenerator(Extractor extractor) throws Exception {
        if (extractor instanceof SalaryStatementDtlRecordExtractor) {
            SalaryStatementDtlRecordExtractor salaryStatementDtlRecordExtractor = (SalaryStatementDtlRecordExtractor) extractor;
            SalaryStatementRecord record = salaryStatementDtlRecordExtractor.extract();
            BigDecimal ret = BigDecimal.ZERO;
            ret = ret.add(this.sumCompanyInsurance(record));
            ret = ret.add(record.getTotalWages() != null ? record.getTotalWages() : BigDecimal.ZERO);
            if(ret.compareTo(BigDecimal.ZERO) > 0){
                return ret.toPlainString();
            }
            else {
                return null;
            }

        } else
            throw new Exception("SalaryStatementDtlRecordExtractor required ");
    }

    @Override
    public String creditGenerator(Extractor extractor) throws Exception {
        return null;
    }
}
