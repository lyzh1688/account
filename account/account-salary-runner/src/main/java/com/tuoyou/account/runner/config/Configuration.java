package com.tuoyou.account.runner.config;

import com.google.common.eventbus.EventBus;
import com.tuoyou.account.salary.domain.SalaryStatementRecord;
import com.tuoyou.account.salary.generator.SalaryVoucherGenerator;
import com.tuoyou.account.salary.generator.VoucherGenerator;
import org.springframework.context.annotation.Bean;

/**
 * Created by 刘悦之 on 2019/9/14.
 */
@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public VoucherGenerator<SalaryStatementRecord> salaryVoucherGenerator(){
        return new SalaryVoucherGenerator();
    }

    @Bean
    public EventBus eventBus(){
        return new EventBus();
    }
}
