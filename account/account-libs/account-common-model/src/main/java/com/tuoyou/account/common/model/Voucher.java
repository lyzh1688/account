package com.tuoyou.account.common.model;

import java.time.LocalDate;

/**
 * Created by liuyuezhi on 2019/8/28.
 */
public class Voucher{

    LocalDate accountDate;

    String category;

    int attachmentCount;

    String remark;

    String account;
    //借贷类型
    String voucherType;

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

    public LocalDate getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(LocalDate accountDate) {
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

}
