package com.tuoyou.account.salary.transfer.accountcode;

import com.account.common.dict.AccountCode;
import com.tuoyou.account.salary.domain.SalaryStatementRecord;
import com.tuoyou.account.salary.extractor.SalaryStatementDtlRecordExtractor;
import com.tuoyou.account.salary.transfer.SalaryStatementRecordHelper;
import com.tuoyou.account.voucher.core.Extractor;

import java.math.BigDecimal;

/**
 * Created by liuyuezhi on 2019/8/30.
 *
 * 贷方科目代码生成规则[应付社会保险费]
 */
public class PayCompanyInsuranceCreditAccountCodeTransfer extends CreditAccountCodeTransfer implements SalaryStatementRecordHelper {

    @Override
    public String creditGenerator(Extractor extractor) throws Exception {
        if (extractor instanceof SalaryStatementDtlRecordExtractor) {
            SalaryStatementDtlRecordExtractor salaryStatementDtlRecordExtractor = (SalaryStatementDtlRecordExtractor) extractor;
            SalaryStatementRecord record = salaryStatementDtlRecordExtractor.extract();
            BigDecimal sumRet = this.sumCompanyInsurance(record.getEndowmentInsCom(), record.getUnemployInsCom(), record.getMedicalInsCom(), record.getInjuryInsCom(), record.getBirthInsCom());
            if (sumRet.compareTo(BigDecimal.ZERO) > 0) {
                return AccountCode.companyPayInsurance;
            } else
                return null;
        } else
            throw new Exception("SalaryStatementDtlRecordExtractor required ");
    }
}
