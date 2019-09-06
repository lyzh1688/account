package com.tuoyou.account.salary.loader;

import com.account.common.dict.VoucherType;
import com.tuoyou.account.salary.transfer.accountcode.PayTaxCreditAccountCodeTransfer;
import com.tuoyou.account.salary.transfer.amount.PayTaxAmountTransfer;
import com.tuoyou.account.voucher.core.VoucherTransfer;

/**
 * Created by 刘悦之 on 2019/9/6.
 */
public class CompanyTaxLoader extends RowLoader {
    @Override
    protected VoucherTransfer initAccountCodeTransfer() {
        return new PayTaxCreditAccountCodeTransfer();
    }

    @Override
    protected VoucherTransfer initAmountTransfer() {
        return new PayTaxAmountTransfer();
    }

    @Override
    protected String getVoucherType() {
        return VoucherType.credit;
    }
}
