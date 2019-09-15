package com.tuoyou.account.common.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by liuyuezhi on 2019/8/28.
 */
public class Voucher{

    String accountDate;

    String category;

    int attachmentCount;

    String remark;

    //借贷类型
    String voucherType;

    String accountCode;

    BigDecimal amount;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getVoucherType() {
        return voucherType;
    }

    public void setVoucherType(String voucherType) {
        this.voucherType = voucherType;
    }

    public String getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(String accountDate) {
        this.accountDate = accountDate;
    }

    public int getAttachmentCount() {
        return attachmentCount;
    }

    public void setAttachmentCount(int attachmentCount) {
        this.attachmentCount = attachmentCount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "accountDate='" + accountDate + '\'' +
                ", category='" + category + '\'' +
                ", attachmentCount=" + attachmentCount +
                ", remark='" + remark + '\'' +
                ", voucherType='" + voucherType + '\'' +
                ", accountCode='" + accountCode + '\'' +
                ", amount=" + amount ;
    }
}
