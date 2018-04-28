package com.lingd.fundnetvaluequery.service;

import com.lingd.fundnetvaluequery.entity.FundInfo;

import java.util.List;

public interface MailService {

    void sendMail(String to, String content);

    void sendHtmlMail(List<FundInfo> list);

    void sendTemplateMail(List<FundInfo> list);
}
