package com.tuoyou.account.salary.transfer;

import com.tuoyou.account.voucher.core.Extractor;
import com.tuoyou.account.voucher.core.VoucherTransfer;

/**
 * Created by liuyuezhi on 2019/8/29.
 */
public class AttachmentCounterTransfer implements VoucherTransfer {
    @Override
    public String debitGenerator(Extractor extractor) throws Exception {
        return String.valueOf(1);
    }

    @Override
    public String creditGenerator(Extractor extractor) throws Exception {
        return String.valueOf(1);
    }
}
