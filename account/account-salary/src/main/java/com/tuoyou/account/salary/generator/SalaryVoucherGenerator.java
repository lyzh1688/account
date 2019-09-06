package com.tuoyou.account.salary.generator;

import com.google.common.collect.Lists;
import com.tuoyou.account.common.model.SalaryVoucher;
import com.tuoyou.account.common.model.Voucher;
import com.tuoyou.account.salary.domain.SalaryStatementRecord;
import com.tuoyou.account.salary.loader.*;
import com.tuoyou.account.voucher.core.Extractor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 刘悦之 on 2019/9/6.
 */
public class SalaryVoucherGenerator implements VoucherGenerator<SalaryStatementRecord> {

    List<RowLoader> loaderList = Lists.newArrayList();

    public SalaryVoucherGenerator() {
        RowLoader debitRowLoader = new DebitRowLoader();
        RowLoader companyTaxLoader = new CompanyTaxLoader();
        RowLoader companyPaySalaryLoader = new CompanyPaySalaryLoader();
        RowLoader companyPayInsuranceLoader = new CompanyPayInsuranceLoader();
        RowLoader companyPayHabitationLoader = new CompanyPayHabitationLoader();
        RowLoader personalHabitationLoader = new PersonalHabitationLoader();
        RowLoader personalPayInsuranceLoader = new PersonalPayInsuranceLoader();
        this.loaderList.add(debitRowLoader);
        this.loaderList.add(companyTaxLoader);
        this.loaderList.add(companyPaySalaryLoader);
        this.loaderList.add(companyPayInsuranceLoader);
        this.loaderList.add(companyPayHabitationLoader);
        this.loaderList.add(personalHabitationLoader);
        this.loaderList.add(personalPayInsuranceLoader);
    }

    @Override
    public List<Voucher> generator(Extractor extractor) {
        return this.loaderList.stream().map(i -> i.createVoucher(extractor)).collect(Collectors.toList());
    }
}
