package com.tuoyou.account.voucher.core;

/**
 * Created by 刘悦之 on 2019/8/28.
 */
public interface VoucherTransfer {
    String debitGenerator(Extractor extractor) throws Exception;
    String creditGenerator(Extractor extractor) throws Exception;
}
