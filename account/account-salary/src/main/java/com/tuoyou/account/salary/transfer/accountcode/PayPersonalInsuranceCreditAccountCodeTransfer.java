package com.tuoyou.account.salary.transfer.accountcode;

import com.account.common.dict.AccountCode;
import com.tuoyou.account.salary.domain.SalaryStatementRecord;
import com.tuoyou.account.salary.extractor.SalaryStatementDtlRecordExtractor;
import com.tuoyou.account.salary.transfer.SalaryStatementRecordHelper;
import com.tuoyou.account.voucher.core.Extractor;

import java.math.BigDecimal;

/**
 * Created by liuyuezhi on 2019/8/30.
 * 贷方科目代码生成规则[代扣代缴社保(个人部分)]
 */
public class PayPersonalInsuranceCreditAccountCodeTransfer extends CreditAccountCodeTransfer implements SalaryStatementRecordHelper{



    @Override
    public String creditGenerator(Extractor extractor) throws Exception {
        if (extractor instanceof SalaryStatementDtlRecordExtractor) {
            SalaryStatementDtlRecordExtractor salaryStatementDtlRecordExtractor = (SalaryStatementDtlRecordExtractor) extractor;
            SalaryStatementRecord record = salaryStatementDtlRecordExtractor.extract();
            BigDecimal sumRet = this.sumPersonalInsurance(record.getEndowmentInsPers(), record.getUnemployInsPers(), record.getMedicalInsPers());
            if (sumRet.compareTo(BigDecimal.ZERO) > 0) {
                return AccountCode.personalPayInsurance;
            } else
                return null;
        } else
            throw new Exception("SalaryStatementDtlRecordExtractor required ");
    }
}
