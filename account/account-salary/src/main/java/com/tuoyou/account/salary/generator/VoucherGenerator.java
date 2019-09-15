package com.tuoyou.account.salary.generator;

import com.tuoyou.account.common.model.Voucher;
import com.tuoyou.account.voucher.core.Extractor;

import java.util.List;

/**
 * Created by 刘悦之 on 2019/9/6.
 */
public interface VoucherGenerator<RECORD> {
    List<Voucher> generator(Extractor<RECORD> extractor) throws InterruptedException;
}
