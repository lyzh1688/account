package com.tuoyou.account.salary.loader;

import com.account.common.dict.VoucherType;
import com.tuoyou.account.salary.transfer.accountcode.PayPersonalHabitationInsCreditAccountCodeTransfer;
import com.tuoyou.account.salary.transfer.amount.PayPersonalInsuranceAmountTransfer;
import com.tuoyou.account.voucher.core.VoucherTransfer;

/**
 * Created by 刘悦之 on 2019/9/6.
 */
public class PersonalPayInsuranceLoader extends RowLoader {
    @Override
    protected VoucherTransfer initAccountCodeTransfer() {
        return new PayPersonalHabitationInsCreditAccountCodeTransfer();
    }

    @Override
    protected VoucherTransfer initAmountTransfer() {
        return new PayPersonalInsuranceAmountTransfer();
    }

    @Override
    protected String getVoucherType() {
        return VoucherType.credit;
    }
}
