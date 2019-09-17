package com.tuoyou.account.runner.dao.impl;

import com.tuoyou.account.runner.dao.SalaryStatementDao;
import com.tuoyou.account.salary.domain.SalaryStatementRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by 刘悦之 on 2019/9/15.
 */
@Repository
public class SalaryStatementDaoImpl implements SalaryStatementDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    String SALARY_STATEMENT_SQL = "select t.ACCOUNT_PERIOD,t1.DETAIL_ID, t1.FILE_ID, t1.STAFF_TYPE, t1.STAFF_ID, t1.NEED_ENDOWMENT_INS, t1.NEED_UNEMPLOY_INS,\n" +
            "    t1.NEED_MEDICAL_INS, t1.NEED_INJURY_INS, t1.NEED_BIRTH_INS, t1.NEED_HABITATION_INS, t1.HOUSEHOLD_TYPE,\n" +
            "    t1.BASE_SALARY, t1.POSITION_VALUE, t1.TRAVEL_ALLOWANCE, t1.BUSINESS_ALLOWANCE, t1.TELEPHONE_ALLOWANCE,\n" +
            "    t1.TAXI_ALLOWANCE,t1.LUNCH_ALLOWANCE, t1.AGE_ALLOWANCE, t1.OVERTIME_DAYS, t1.OVERTIME_PAY, t1.BONUS,\n" +
            "    t1.ABSENCE_DAYS, t1.ATTENDANCE_DEDUCT, t1.TOTAL_WAGES, t1.ALLOWANCE_BASE, t1.ENDOWMENT_INS_PERS,\n" +
            "    t1.UNEMPLOY_INS_PERS, t1.MEDICAL_INS_PERS,t1.HABITATION_INS_PERS, t1.ENDOWMENT_INS_COM, t1.UNEMPLOY_INS_COM,\n" +
            "    t1.MEDICAL_INS_COM, t1.INJURY_INS_COM, t1.BIRTH_INS_COM, t1.HABITATION_INS_COM, t1.INDIVIDUAL_INCOME_TAX,\n" +
            "    t1.NET_WAGES, t1.BANK_CARD,t1.NAME,t1.DEPARTMENT from ALR_SALARY_STATEMENT_RECORD t,ALR_SALARY_STATEMENT_DTL_RECORD t1 where t.file_id = t1.file_id and t.batch_id = ?";

    @Override
    public List<SalaryStatementRecord> getSalaryStatement(String batchId) {
        return this.jdbcTemplate.query(SALARY_STATEMENT_SQL, new Object[]{batchId}, (rs, i) -> {
            String accountPeriod = rs.getString("ACCOUNT_PERIOD");
            if (accountPeriod.length() > 8) {
                accountPeriod = accountPeriod.replace("-", "").substring(0,6);
            }
            String staffType = rs.getString("STAFF_TYPE");
            BigDecimal totalWages = rs.getBigDecimal("TOTAL_WAGES");
            BigDecimal endowmentInsPers = rs.getBigDecimal("ENDOWMENT_INS_PERS");
            BigDecimal unEmployInsPers = rs.getBigDecimal("UNEMPLOY_INS_PERS");
            BigDecimal medicalInsPers = rs.getBigDecimal("MEDICAL_INS_PERS");
            BigDecimal habitationInsPers = rs.getBigDecimal("HABITATION_INS_PERS");
            BigDecimal endowmentInsCom = rs.getBigDecimal("ENDOWMENT_INS_COM");
            BigDecimal unEmployInsCom = rs.getBigDecimal("UNEMPLOY_INS_COM");
            BigDecimal medicalInsCom = rs.getBigDecimal("MEDICAL_INS_COM");
            BigDecimal injuryInsCom = rs.getBigDecimal("INJURY_INS_COM");
            BigDecimal birthInsCom = rs.getBigDecimal("BIRTH_INS_COM");
            BigDecimal habitationInsCom = rs.getBigDecimal("HABITATION_INS_COM");
            BigDecimal indIncomeTax = rs.getBigDecimal("INDIVIDUAL_INCOME_TAX");
            BigDecimal netWages = rs.getBigDecimal("NET_WAGES");
            String name = rs.getString("NAME");
            String department = rs.getString("DEPARTMENT");
            SalaryStatementRecord record = new SalaryStatementRecord();
            record.setAccountPeriod(accountPeriod);
            record.setStaffType(staffType);
            record.setTotalWages(totalWages);
            record.setEndowmentInsPers(endowmentInsPers);
            record.setUnemployInsPers(unEmployInsPers);
            record.setMedicalInsPers(medicalInsPers);
            record.setHabitationInsPers(habitationInsPers);
            record.setEndowmentInsCom(endowmentInsCom);
            record.setUnemployInsCom(unEmployInsCom);
            record.setMedicalInsCom(medicalInsCom);
            record.setInjuryInsCom(injuryInsCom);
            record.setBirthInsCom(birthInsCom);
            record.setHabitationInsCom(habitationInsCom);
            record.setIndividualIncomeTax(indIncomeTax);
            record.setNetWages(netWages);
            record.setName(name);
            record.setDepartment(department);
            return record;
        });
    }
}
