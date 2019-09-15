package com.tuoyou.account.common.model;

/**
 * Created by liuyuezhi on 2019/8/28.
 */
public class SalaryVoucher extends Voucher{

    //制单
    String creator;
    //员工性质(票号)
    String employeeType;
    //交易对手方(姓名)
    String counterParty;

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCounterParty() {
        return counterParty;
    }

    public void setCounterParty(String counterParty) {
        this.counterParty = counterParty;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    @Override
    public String toString() {
        return super.toString() + '\'' +
                "creator='" + creator + '\'' +
                ", employeeType='" + employeeType + '\'' +
                ", counterParty='" + counterParty + '\'';
    }
}
