package com.tuoyou.account.runner.service.impl;

import com.account.common.dict.EmployeeType;
import com.google.common.collect.Lists;
import com.tuoyou.account.runner.dao.SalaryStatementDao;
import com.tuoyou.account.runner.service.SalaryStatementDtlService;
import com.tuoyou.account.salary.domain.SalaryStatementRecord;
import com.tuoyou.account.salary.extractor.SalaryStatementDtlRecordExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by 刘悦之 on 2019/9/14.
 */
@Service
public class SalaryStatementDtlServiceImpl implements SalaryStatementDtlService {

    @Autowired
    SalaryStatementDao salaryStatementDao;

    @Deprecated
    private SalaryStatementRecord createSalaryStatementRecord(String[] info){
        SalaryStatementRecord record = new SalaryStatementRecord();
        record.setStaffType(info[0].equals("全职") ? EmployeeType.fullTime:EmployeeType.partTime);
        record.setName(info[2]);
        record.setTotalWages(new BigDecimal(info[3]));
        record.setEndowmentInsPers(new BigDecimal(info[4]));
        record.setUnemployInsPers(new BigDecimal(info[5]));
        record.setMedicalInsPers(new BigDecimal(info[6]));
        record.setHabitationInsPers(new BigDecimal(info[7]));
        record.setEndowmentInsCom(new BigDecimal(info[8]));
        record.setUnemployInsCom(new BigDecimal(info[9]));
        record.setMedicalInsCom(new BigDecimal(info[10]));
        record.setInjuryInsCom(new BigDecimal(info[11]));
        record.setBirthInsCom(new BigDecimal(info[12]));
        record.setHabitationInsCom(new BigDecimal(info[13]));
        record.setIndividualIncomeTax(new BigDecimal(info[14]));
        record.setNetWages(new BigDecimal(info[15]));
        record.setDepartment(info[16]);
        record.setAccountPeriod("201908");
        return record;
    }

    @Override
    public List<SalaryStatementRecord> getSalaryStatementDtl() {
        String[] info = new String[]{"全职","13012885819","高威","5000.00","400.00","25.00","100.00","350.00","1000.00","25.00","475.00","8.00","50.00","350.00","18.75","4106.25","360430199711090915"};
        SalaryStatementRecord record = createSalaryStatementRecord(info);
        List<SalaryStatementRecord> list = Lists.newArrayList();
        list.add(record);
        return list;
    }

    @Override
    public List<SalaryStatementRecord> getSalaryStatementDtl(String batchId) {
        return salaryStatementDao.getSalaryStatement(batchId);
    }

    @Override
    public void fillInExtractor(List<SalaryStatementRecord> records) {
        SalaryStatementDtlRecordExtractor.instance.fillIn(records);
    }
}
