package com.tuoyou.account.voucher.core;

import java.util.List;

/**
 * Created by 刘悦之 on 2019/8/28.
 */
public interface Extractor<R> {
    void take() throws InterruptedException;
    R extract() throws InterruptedException;
    void fillIn(List<R> records);
}
