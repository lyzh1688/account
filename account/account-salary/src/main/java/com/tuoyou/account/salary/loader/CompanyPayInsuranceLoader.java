package com.tuoyou.account.salary.loader;

import com.account.common.dict.VoucherType;
import com.tuoyou.account.salary.transfer.accountcode.PayCompanyInsuranceCreditAccountCodeTransfer;
import com.tuoyou.account.salary.transfer.amount.PayCompanyInsuranceAmountTransfer;
import com.tuoyou.account.voucher.core.VoucherTransfer;

/**
 * Created by 刘悦之 on 2019/9/6.
 */
public class CompanyPayInsuranceLoader extends RowLoader {
    @Override
    protected VoucherTransfer initAccountCodeTransfer() {
        return new PayCompanyInsuranceCreditAccountCodeTransfer();
    }

    @Override
    protected VoucherTransfer initAmountTransfer() {
        return new PayCompanyInsuranceAmountTransfer();
    }

    @Override
    protected String getVoucherType() {
        return VoucherType.credit;
    }
}
