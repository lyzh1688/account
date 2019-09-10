package com.tuoyou.account.voucher.core;

/**
 * Created by 刘悦之 on 2019/9/6.
 */
public interface Loader<R, V> {
    V createVoucher(Extractor<R> extractor) throws Exception;
}
