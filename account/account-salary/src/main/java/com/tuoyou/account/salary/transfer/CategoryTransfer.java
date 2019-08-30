package com.tuoyou.account.salary.transfer;

import com.account.common.dict.VoucherCategory;
import com.tuoyou.account.voucher.core.Extractor;
import com.tuoyou.account.voucher.core.VoucherTransfer;

/**
 * Created by liuyuezhi on 2019/8/29.
 */
public class CategoryTransfer implements VoucherTransfer {
    @Override
    public String debitGenerator(Extractor extractor) throws Exception {
        return VoucherCategory.transfer;
    }

    @Override
    public String creditGenerator(Extractor extractor) throws Exception {
        return VoucherCategory.transfer;
    }
}
