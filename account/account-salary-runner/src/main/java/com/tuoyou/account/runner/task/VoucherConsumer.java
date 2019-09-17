package com.tuoyou.account.runner.task;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.tuoyou.account.common.model.Voucher;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 刘悦之 on 2019/9/17.
 */
@Component
public class VoucherConsumer implements InitializingBean{

    @Autowired
    EventBus eventBus;


    @Override
    public void afterPropertiesSet() throws Exception {
        this.eventBus.register(this);
    }

    @Subscribe
    public void listen(List<Voucher> vouchers) {
        vouchers.stream().forEach(i ->{
            System.out.println(i.toString());
        });
    }
}
