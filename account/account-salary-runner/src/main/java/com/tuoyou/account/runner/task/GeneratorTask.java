package com.tuoyou.account.runner.task;

import com.tuoyou.account.common.model.SalaryVoucher;
import com.tuoyou.account.common.model.Voucher;
import com.tuoyou.account.salary.domain.SalaryStatementRecord;
import com.tuoyou.account.salary.extractor.SalaryStatementDtlRecordExtractor;
import com.tuoyou.account.salary.generator.VoucherGenerator;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 刘悦之 on 2019/9/14.
 */
@Component
public class GeneratorTask implements InitializingBean{

    private ExecutorService executorService = Executors.newFixedThreadPool(1);

    @Autowired
    VoucherGenerator<SalaryStatementRecord> generator;

    public void start() {
        executorService.submit(() -> {
            while (true) {
                List<Voucher> voucherList = generator.generator(SalaryStatementDtlRecordExtractor.instance);
                voucherList.stream().forEach(i -> {
                    System.out.println(i.toString());
                });
                Thread.sleep(1000 * 10);
            }
        });
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.start();
    }
}
