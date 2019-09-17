package com.tuoyou.account.runner.task;

import com.google.common.eventbus.EventBus;
import com.tuoyou.account.common.model.Voucher;
import com.tuoyou.account.salary.domain.SalaryStatementRecord;
import com.tuoyou.account.salary.extractor.SalaryStatementDtlRecordExtractor;
import com.tuoyou.account.salary.generator.VoucherGenerator;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 刘悦之 on 2019/9/14.
 */
@Component
public class GeneratorTask implements InitializingBean {

    private ExecutorService executorService = Executors.newFixedThreadPool(1);

    @Autowired
    VoucherGenerator<SalaryStatementRecord> generator;

    @Autowired
    EventBus eventBus;

    public void start() {
        executorService.submit(() -> {
            while (true) {
                List<Voucher> voucherList = generator.generator(SalaryStatementDtlRecordExtractor.instance);
                eventBus.post(voucherList);
                if(SalaryStatementDtlRecordExtractor.instance.getBufferCount() == 0){
                    Thread.sleep(1000 * 10);
                }
            }
        });
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.start();
    }
}
