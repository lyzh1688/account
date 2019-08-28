package com.tuoyou.account.common.model;

import java.time.LocalDate;

/**
 * Created by liuyuezhi on 2019/8/28.
 */
public class Voucher {

    LocalDate accountDate;
    String category;
    int attachmentCount;
    String remark;
    String account;

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
