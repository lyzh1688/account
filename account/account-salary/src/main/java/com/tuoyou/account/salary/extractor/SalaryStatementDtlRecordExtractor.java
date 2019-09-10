package com.tuoyou.account.salary.extractor;

import com.tuoyou.account.salary.domain.SalaryStatementRecord;
import com.tuoyou.account.voucher.core.Extractor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by 刘悦之 on 2019/8/28.
 */
public class SalaryStatementDtlRecordExtractor implements Extractor<SalaryStatementRecord> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public static final SalaryStatementDtlRecordExtractor instance = new SalaryStatementDtlRecordExtractor();

    private SalaryStatementDtlRecordExtractor(){}

    BlockingQueue<SalaryStatementRecord> recordsBuffer = new ArrayBlockingQueue(2000);

    @Override
    public SalaryStatementRecord extract() throws InterruptedException {
        return recordsBuffer.take();
    }

    @Override
    public void fillIn(List<SalaryStatementRecord> records) {
        records.stream().forEach(i -> {
            try {
                recordsBuffer.put(i);
            } catch (InterruptedException e) {
                logger.error(e.getMessage());
            }
        });
    }
}
