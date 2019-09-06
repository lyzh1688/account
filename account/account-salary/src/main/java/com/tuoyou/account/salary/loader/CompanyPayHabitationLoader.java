package com.tuoyou.account.salary.loader;

import com.account.common.dict.VoucherType;
import com.tuoyou.account.salary.transfer.accountcode.PayCompanyHabitationInsCreditAccountCodeTransfer;
import com.tuoyou.account.salary.transfer.amount.PayCompanyHabitationInsAmountTransfer;
import com.tuoyou.account.voucher.core.VoucherTransfer;

/**
 * Created by 刘悦之 on 2019/9/6.
 */
public class CompanyPayHabitationLoader extends RowLoader {

    @Override
    protected VoucherTransfer initAccountCodeTransfer() {
        return new PayCompanyHabitationInsCreditAccountCodeTransfer();
    }

    @Override
    protected VoucherTransfer initAmountTransfer() {
        return new PayCompanyHabitationInsAmountTransfer();
    }

    @Override
    protected String getVoucherType() {
        return VoucherType.credit;
    }
}
