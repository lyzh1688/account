package com.tuoyou.account.runner.endpoint;

import com.tuoyou.account.runner.service.SalaryStatementDtlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 刘悦之 on 2019/9/14.
 */
@RestController
public class TestEndpoint {

    @Autowired
    SalaryStatementDtlService salaryStatementDtlService;

    @RequestMapping("/test")
    public void test(){
        salaryStatementDtlService.fillInExtractor(salaryStatementDtlService.getSalaryStatementDtl("5gpr5pvl6qg0000"));
    }
}
