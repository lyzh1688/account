package com.tuoyou.account.salary.transfer.accountcode;

import com.tuoyou.account.voucher.core.Extractor;
import com.tuoyou.account.voucher.core.VoucherTransfer;

/**
 * Created by liuyuezhi on 2019/8/29.
 *
 * 贷方科目代码生成规则
 */
public abstract class CreditAccountCodeTransfer implements VoucherTransfer {

//    protected final String paySalaryBranch = "paySalaryBranch";

    @Override
    public String debitGenerator(Extractor extractor) throws Exception {
        return null;
    }
}
