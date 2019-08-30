package com.tuoyou.account.salary.transfer;

import com.tuoyou.account.common.utils.DateUtils;
import com.tuoyou.account.salary.domain.SalaryStatementRecord;
import com.tuoyou.account.salary.extractor.SalaryStatementDtlRecordExtractor;
import com.tuoyou.account.voucher.core.Extractor;
import com.tuoyou.account.voucher.core.VoucherTransfer;

import java.time.LocalDate;

/**
 * Created by liuyuezhi on 2019/8/29.
 */
public class AccountDateTransfer implements VoucherTransfer {

    private String getLastDayOfMonth(String accountMonth){
        LocalDate localDate = DateUtils.parseDate(accountMonth + "01",DateUtils.SIMPLE_8_FORMATTER);
        LocalDate lastDayOfMonth = localDate.plusMonths(1).minusDays(1);
        return DateUtils.formatDate(lastDayOfMonth,DateUtils.SIMPLE_8_FORMATTER);
    }

    @Override
    public String debitGenerator(Extractor extractor) throws Exception {
        if(extractor instanceof SalaryStatementDtlRecordExtractor){
            SalaryStatementDtlRecordExtractor salaryStatementDtlRecordExtractor = (SalaryStatementDtlRecordExtractor)extractor;
            SalaryStatementRecord record = salaryStatementDtlRecordExtractor.extract();
            return getLastDayOfMonth(record.getAccountPeriod());
        }
        else
            throw new Exception("SalaryStatementDtlRecordExtractor required ");
    }

    @Override
    public String creditGenerator(Extractor extractor) throws Exception {
        if(extractor instanceof SalaryStatementDtlRecordExtractor){
            SalaryStatementDtlRecordExtractor salaryStatementDtlRecordExtractor = (SalaryStatementDtlRecordExtractor)extractor;
            SalaryStatementRecord record = salaryStatementDtlRecordExtractor.extract();
            return getLastDayOfMonth(record.getAccountPeriod());
        }
        else
            throw new Exception("SalaryStatementDtlRecordExtractor required ");
    }
}
