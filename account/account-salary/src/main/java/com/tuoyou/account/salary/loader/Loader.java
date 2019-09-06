package com.tuoyou.account.salary.loader;

import com.tuoyou.account.common.model.Voucher;
import com.tuoyou.account.voucher.core.Extractor;

/**
 * Created by 刘悦之 on 2019/9/6.
 */
public interface Loader<R> {
    Voucher createVoucher(Extractor<R> extractor);
}
