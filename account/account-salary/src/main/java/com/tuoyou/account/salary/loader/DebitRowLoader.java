package com.tuoyou.account.salary.loader;

import com.account.common.dict.VoucherType;
import com.tuoyou.account.salary.transfer.accountcode.DebitAccountCodeTransfer;
import com.tuoyou.account.salary.transfer.amount.DebitAmountTransfer;
import com.tuoyou.account.voucher.core.VoucherTransfer;

/**
 * Created by 刘悦之 on 2019/9/6.
 */
public class DebitRowLoader extends RowLoader {
    @Override
    protected VoucherTransfer initAccountCodeTransfer() {
        return new DebitAccountCodeTransfer();
    }

    @Override
    protected VoucherTransfer initAmountTransfer() {
        return new DebitAmountTransfer();
    }

    @Override
    protected String getVoucherType() {
        return VoucherType.debit;
    }
}
