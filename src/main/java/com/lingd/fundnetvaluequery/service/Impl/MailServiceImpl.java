package com.lingd.fundnetvaluequery.service.Impl;

import com.lingd.fundnetvaluequery.entity.FundInfo;
import com.lingd.fundnetvaluequery.service.MailService;
import com.lingd.fundnetvaluequery.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;
import java.util.List;

/**
 * @Auther: linguande
 * @Date: 2018/4/27 8:59
 * @Description: 邮件service
 */
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Value("${mail.fromMail.addr}")
    private String from;


    /**
     * @Description: 发送邮件
     * @param:
     */
    @Override
    public void sendMail(String to, String content) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject("今天升了吗");
            helper.setText(content, true);
            javaMailSender.send(message);
            LogUtils.info("邮件发送成功");
        } catch (Exception e) {
            LogUtils.error("邮件发送异常：" + e.getMessage());
        }
    }


    /**
     * @Description: 发送html邮件
     * @param:
     */
    @Override
    public void sendHtmlMail(List<FundInfo> list) {
        String string = "";
        for (FundInfo fundInfo : list) {
            string = string + "<tr><td>" + fundInfo.getFundcode() + "</td><td>" + fundInfo.getName() + "</td><td>" +
                    fundInfo
                            .getDwjz() + "</td><td>" + fundInfo.getGsz() + "</td><td>" + fundInfo.getGszzl() +
                    "</td></tr>\n";
        }
        String content = "<html>\n" +
                "<body>\n" +
                "<table><thead><tr><td>Code</td><td>名称</td><td>当前净值</td><td>估算净值</td><td>%</td></tr></thead>\n" +
                "<tbody>\n" +
                string + "\n" +
                "</tbody></table>\n" +
                "</body>\n" +
                "</html>";
        sendMail("296849680@qq.com", content);
    }

    /**
     * @Description: 发送模板邮件
     * @param:
     */
    @Override
    public void sendTemplateMail(List<FundInfo> list) {
        Context context = new Context();
        context.setVariable("lists", list);
        String emailContent = templateEngine.process("emailTemplate", context);
        sendMail("296849680@qq.com", emailContent);
    }
}
