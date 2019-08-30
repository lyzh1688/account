package com.tuoyou.account.salary.transfer.accountcode;

import com.account.common.dict.AccountCode;
import com.account.common.dict.DepartmentDict;
import com.tuoyou.account.salary.domain.SalaryStatementRecord;
import com.tuoyou.account.salary.extractor.SalaryStatementDtlRecordExtractor;
import com.tuoyou.account.voucher.core.Extractor;
import com.tuoyou.account.voucher.core.VoucherTransfer;

/**
 * Created by liuyuezhi on 2019/8/29.
 *
 * 借方科目代码生成规则
 */
public class DebitAccountCodeTransfer implements VoucherTransfer {

    @Override
    public String debitGenerator(Extractor extractor) throws Exception {
        if(extractor instanceof SalaryStatementDtlRecordExtractor){
            SalaryStatementDtlRecordExtractor salaryStatementDtlRecordExtractor = (SalaryStatementDtlRecordExtractor)extractor;
            SalaryStatementRecord record = salaryStatementDtlRecordExtractor.extract();
            if(DepartmentDict.developDepartment.equals(record.getDepartment())){
                return AccountCode.researchFee;
            }
            else if(DepartmentDict.salesDepartment.equals(record.getDepartment())){
                return AccountCode.staffSalary;
            }
            else {
                return AccountCode.staffSalary2;
            }
        }
        else
            throw new Exception("SalaryStatementDtlRecordExtractor required ");
    }

    @Override
    public String creditGenerator(Extractor extractor) throws Exception {
        return null;
    }
}
