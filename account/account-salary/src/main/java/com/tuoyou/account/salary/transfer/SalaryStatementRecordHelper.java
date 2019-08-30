package com.tuoyou.account.salary.transfer;

import com.tuoyou.account.salary.domain.SalaryStatementRecord;

import java.math.BigDecimal;

/**
 * Created by liuyuezhi on 2019/8/30.
 */
public interface SalaryStatementRecordHelper {


    default BigDecimal sumPersonalInsurance(SalaryStatementRecord record){
        BigDecimal sumRet = this.sumPersonalInsurance(record.getEndowmentInsPers(), record.getUnemployInsPers(), record.getMedicalInsPers());
        return sumRet;
    }

    default BigDecimal sumPersonalInsurance(BigDecimal endowmentInsCom,
                                            BigDecimal unemployInsCom,
                                            BigDecimal medicalInsCom) {
        BigDecimal ret = BigDecimal.ZERO;
        ret = ret.add(endowmentInsCom != null ? endowmentInsCom : BigDecimal.ZERO);
        ret = ret.add(unemployInsCom != null ? unemployInsCom : BigDecimal.ZERO);
        ret = ret.add(medicalInsCom != null ? medicalInsCom : BigDecimal.ZERO);
        return ret;
    }


    default BigDecimal sumCompanyInsurance(SalaryStatementRecord record){
        BigDecimal sumRet = this.sumCompanyInsurance(record.getEndowmentInsCom(), record.getUnemployInsCom(), record.getMedicalInsCom(), record.getInjuryInsCom(), record.getBirthInsCom());
        return sumRet;
    }

    default BigDecimal sumCompanyInsurance(BigDecimal endowmentInsCom,
                                           BigDecimal unemployInsCom,
                                           BigDecimal medicalInsCom,
                                           BigDecimal injuryInsCom,
                                           BigDecimal birthInsCom) {
        BigDecimal ret = BigDecimal.ZERO;
        ret = ret.add(endowmentInsCom != null ? endowmentInsCom : BigDecimal.ZERO);
        ret = ret.add(unemployInsCom != null ? unemployInsCom : BigDecimal.ZERO);
        ret = ret.add(medicalInsCom != null ? medicalInsCom : BigDecimal.ZERO);
        ret = ret.add(injuryInsCom != null ? injuryInsCom : BigDecimal.ZERO);
        ret = ret.add(birthInsCom != null ? birthInsCom : BigDecimal.ZERO);
        return ret;
    }
}
