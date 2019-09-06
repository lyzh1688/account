package com.tuoyou.account.salary.transfer.amount;

import com.tuoyou.account.salary.domain.SalaryStatementRecord;
import com.tuoyou.account.salary.extractor.SalaryStatementDtlRecordExtractor;
import com.tuoyou.account.salary.transfer.SalaryStatementRecordHelper;
import com.tuoyou.account.voucher.core.Extractor;
import com.tuoyou.account.voucher.core.VoucherTransfer;

import java.math.BigDecimal;

/**
 * Created by 刘悦之 on 2019/9/6.
 * 贷方 sum(三险个人部分)
 *
 */
public class PayPersonalInsuranceAmountTransfer implements VoucherTransfer,SalaryStatementRecordHelper {
    @Override
    public String debitGenerator(Extractor extractor) throws Exception {
        return null;
    }

    @Override
    public String creditGenerator(Extractor extractor) throws Exception {
        if (extractor instanceof SalaryStatementDtlRecordExtractor) {
            SalaryStatementDtlRecordExtractor salaryStatementDtlRecordExtractor = (SalaryStatementDtlRecordExtractor) extractor;
            SalaryStatementRecord record = salaryStatementDtlRecordExtractor.extract();
            BigDecimal ret = this.sumPersonalInsurance(record);
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
