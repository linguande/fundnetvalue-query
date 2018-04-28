package com.lingd.fundnetvaluequery.job;

import com.alibaba.fastjson.JSON;
import com.lingd.fundnetvaluequery.entity.FundInfo;
import com.lingd.fundnetvaluequery.service.MailService;
import com.lingd.fundnetvaluequery.utils.Global;
import com.lingd.fundnetvaluequery.utils.HttpUtils;
import com.lingd.fundnetvaluequery.utils.RegularUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FundQueryJob {

    @Autowired
    private MailService mailService;

    @Scheduled(cron = "0 5 15 ? * MON-FRI")// 周一到周五 每天15点05分执行一次
    public void fundQuery() {
        List<FundInfo> resultList = new ArrayList<FundInfo>();
        List<String> urlList = Global.getFundUrl();
        FundInfo fundInfo = null;
        for (String str : urlList) {
            fundInfo = fundResultDeal(str);
            if (fundInfo != null) {
                resultList.add(fundInfo);
            }
        }
        //System.out.println(resultList);
        //String content = mailService.createContent(resultList);
        //mailService.sendMail("296849680@qq.com", content);
        mailService.sendTemplateMail(resultList);
    }

    private static FundInfo fundResultDeal(String url) {
        FundInfo fundInfo = null;
        try {
            String result = HttpUtils.sendGet(url);
            result = RegularUtils.getFundResult(result);
            fundInfo = JSON.parseObject(result, FundInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fundInfo;
    }

    public static void main(String[] args) {

    }

}
