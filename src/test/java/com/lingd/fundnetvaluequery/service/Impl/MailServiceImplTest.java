package com.lingd.fundnetvaluequery.service.Impl;

import com.lingd.fundnetvaluequery.job.FundQueryJob;
import com.lingd.fundnetvaluequery.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceImplTest {

    @Autowired
    private MailService mailService;

    @Autowired
    private FundQueryJob fundQueryJob;

    @Test
    public void sendMail() {
        //mailService.sendMail("296849680@qq.com","");
        fundQueryJob.fundQuery();

    }
}