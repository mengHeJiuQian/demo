//package tools.mail;
//
//import com.metlife.wechat.common.utils.StringTool;
//import com.metlife.wechat.modules.constants.WeChatConstants;
//import com.metlife.wechat.modules.desensitize.DesensitizeUtil;
//import com.metlife.wechat.modules.model.contract.ContractSendProps;
//import com.metlife.wechat.modules.model.email.BaseSendMailProps;
//import com.metlife.wechat.modules.model.email.MailCopyer;
//import com.metlife.wechat.modules.model.email.MailReceiver;
//import lombok.Cleanup;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.util.CollectionUtils;
//import tools.excel.ExportExcelTool;
//
//import javax.activation.DataHandler;
//import javax.activation.DataSource;
//import javax.mail.Address;
//import javax.mail.Message;
//import javax.mail.Multipart;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeBodyPart;
//import javax.mail.internet.MimeMessage;
//import javax.mail.internet.MimeMultipart;
//import javax.mail.internet.MimeUtility;
//import javax.mail.util.ByteArrayDataSource;
//import java.io.ByteArrayInputStream;
//import java.io.InputStream;
//import java.nio.charset.StandardCharsets;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.Date;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Properties;
//
//
//*
// * 发送邮件工具类.
// *
// * @author FangSo
//
//
//@Slf4j
//public final class SendMailTool {
//
//*
//     * MIME邮件对象.
//
//
//    private MimeMessage mimeMsg;
//
//*
//     * 系统属性.
//
//
//    private Properties props;
//
//*
//     * Session.
//
//
//    private Session session;
//
//*
//     * smtp认证用户名.
//
//
//    private String username;
//
//*
//     * smtp认证密码.
//
//
//    private String password;
//
//*
//     * Multipart对象,邮件内容,标题,附件等内容均添加到其中后再生成MimeMessage对象.
//
//
//    private Multipart multipart;
//
//*
//     * 构造器.
//     *
//     * @param smtp 协议
//
//
//    private SendMailTool(String smtp, Integer port) {
//        setSmtpHost(smtp, port);
//        createMimeMessage();
//    }
//
//*
//     * 设置邮件发送服务器.
//     *
//     * @param hostName 主机
//
//
//    private void setSmtpHost(String hostName, Integer port) {
//        if (props == null) {
//            props = System.getProperties();
//        }
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.host", hostName);
//        props.put("mail.smtp.port", port);
//        props.put("mail.mime.splitlongparameters", false);
//    }
//
//*
//     * 创建MIME邮件对象.
//     *
//     * @return
//
//
//    private void createMimeMessage() {
//        try {
//            session = Session.getInstance(props);
//            mimeMsg = new MimeMessage(session);
//            multipart = new MimeMultipart();
//        } catch (Exception e) {
//            log.error("【创建MIME邮件对象异常】：{}", e);
//        }
//    }
//
//*
//     * 设置用户名和密码.
//     *
//     * @param name 用户名
//     * @param pass 密码
//
//
//    private void setNamePass(String name, String pass) {
//        username = name;
//        password = pass;
//    }
//
//*
//     * 设置邮件主题.
//     *
//     * @param mailSubject 邮件主题
//     * @return
//
//
//    private boolean setSubject(String mailSubject) {
//        try {
//            mimeMsg.setSubject(mailSubject);
//            return true;
//        } catch (Exception e) {
//            log.error("【设置邮件主题异常】：{}", e);
//            return false;
//        }
//    }
//
//*
//     * 设置邮件正文.
//     *
//     * @param mailBody 邮件正文
//     * @return
//
//
//    private boolean setBody(String mailBody) {
//        try {
//            MimeBodyPart contentPart = new MimeBodyPart();
//            contentPart.setContent(mailBody, "text/html;charset=UTF-8");
//            multipart.addBodyPart(contentPart);
//            return true;
//        } catch (Exception e) {
//            log.error("【设置邮件正文异常】：{}", e);
//            return false;
//        }
//    }
//
//*
//     * 添加附件.
//     *
//     * @param affixInputStream 附件流
//     * @return
//
//
//    private boolean addFileAffix(String affixName, InputStream affixInputStream) {
//        try {
//            if (null != affixInputStream) {
//                MimeBodyPart contentPart = new MimeBodyPart();
//                DataSource dataSource = new ByteArrayDataSource(affixInputStream, "application/excel");
//                DataHandler dataHandler = new DataHandler(dataSource);
//                contentPart.setDataHandler(dataHandler);
//                if (StringUtils.isNotBlank(affixName)) {
//                    contentPart.setFileName(MimeUtility.encodeText(affixName));
//                }
//                multipart.addBodyPart(contentPart);
//                return true;
//            }
//            log.info("【设置邮件附件发生异常，附件内容为空】");
//        } catch (Exception e) {
//            log.error("【设置邮件附件发生异常：】{}", e);
//        }
//        return false;
//    }
//
//*
//     * 设置发信人.
//     *
//     * @param from 来源邮箱
//     * @return
//
//
//    private boolean setFrom(String from, String nickname) {
//        try {
//            //查看email地址是否符合规范
////            boolean mailValid = StringTool.mailValid(from);
//            boolean mailValid = true;
//            if (mailValid) {
//                if (StringUtils.isNotBlank(nickname)) {
//                    //设置昵称
//                    mimeMsg.setFrom(new InternetAddress(from, nickname, "UTF-8"));
//                } else {
//                    mimeMsg.setFrom(new InternetAddress(from));
//                }
//                return true;
//            } else {
//                log.info("【当前发件人邮箱地址不是一个合法地址】：{}", from);
//                return false;
//            }
//        } catch (Exception e) {
//            log.error("【设置邮件发件人异常】：{}", e);
//            return false;
//        }
//    }
//
//*
//     * 设置收信人.
//     *
//     * @param mailToAddress 发送邮箱
//     * @return
//
//
//    private boolean setTo(List<MailReceiver> mailToAddress) {
//        if (CollectionUtils.isEmpty(mailToAddress)) {
//            return false;
//        }
//        try {
//            int len = mailToAddress.size();
//            Address[] addresses = new InternetAddress[len];
//            for (int i = 0; i < len; i++) {
//                //昵称
//                String nickname = mailToAddress.get(i).getReceiverNickname();
//                //邮箱地址
//                String address = mailToAddress.get(i).getReceiverAddress();
//                //验证邮箱地址
//                boolean mailValid = StringTool.mailValid(address);
//                if (mailValid) {
//                    if (StringUtils.isNotBlank(nickname)) {
//                        //设置昵称
//                        addresses[i] = new InternetAddress(address, nickname, WeChatConstants.ENCODING_MODE);
//                    } else {
//                        addresses[i] = new InternetAddress(address);
//                    }
//                } else {
//                    log.info("【当前收信人邮箱地址不是一个合法地址】：{}", DesensitizeUtil.desensitizeEmail(address));
//                    //当前有且仅有一个邮箱的时候还是不合法的地址
//                    if (len == 1) {
//                        return false;
//                    }
//                }
//            }
//            mimeMsg.setRecipients(Message.RecipientType.TO, addresses);
//            return true;
//        } catch (Exception e) {
//            log.error("【设置邮件收信人异常】：{}", e);
//            return false;
//        }
//    }
//
//*
//     * 设置抄送人.
//     *
//     * @param mailCopyerList 抄送人邮箱
//     * @return
//
//
//    private boolean setCopyTo(List<MailCopyer> mailCopyerList) {
//        if (CollectionUtils.isEmpty(mailCopyerList)) {
//            return false;
//        }
//        try {
//            int len = mailCopyerList.size();
//            Address[] addresses = new InternetAddress[len];
//            for (int i = 0; i < len; i++) {
//                //昵称
//                String nickname = mailCopyerList.get(i).getCopyerNickname();
//                //邮箱地址
//                String address = mailCopyerList.get(i).getCopyerAddress();
//                //验证邮箱地址
//                boolean mailValid = StringTool.mailValid(address);
//                if (mailValid) {
//                    if (StringUtils.isNotBlank(nickname)) {
//                        //设置昵称
//                        addresses[i] = new InternetAddress(address, nickname, WeChatConstants.ENCODING_MODE);
//                    } else {
//                        addresses[i] = new InternetAddress(address);
//                    }
//                } else {
//                    log.info("【当前抄送人邮箱地址不是一个合法地址】：{}", DesensitizeUtil.desensitizeEmail(address));
//                    //当前有且仅有一个邮箱的时候还是不合法的地址
//                    if (len == 1) {
//                        return false;
//                    }
//                }
//            }
//            mimeMsg.setRecipients(Message.RecipientType.CC, addresses);
//            return true;
//        } catch (Exception e) {
//            log.error("【设置邮件抄送人异常】：{}", e);
//            return false;
//        }
//    }
//
//*
//     * 发送邮件.
//     *
//     * @return
//
//
//    private boolean sendOut() {
//        try {
//            mimeMsg.setContent(multipart);
//            mimeMsg.saveChanges();
//            log.info("====== 开始发送邮件 ======");
//
//            @Cleanup Transport transport = session.getTransport("smtp");
//            transport.connect((String) props.get("mail.smtp.host"),
//                    (int) props.get("mail.smtp.port"), username, password);
//            transport.sendMessage(mimeMsg, mimeMsg.getAllRecipients());
//            log.info("====== 结束发送邮件 ======");
//            return true;
//        } catch (Exception e) {
//            log.error("【邮件发送失败！】：{}", e);
//            return false;
//        }
//    }
//
//*
//     * 设置参数属性.
//     *
//     * @param sendMailTool      发送邮件攻击类
//     * @param baseSendMailProps 基本发送邮件属性
//     * @return
//
//
//    private static boolean setField(SendMailTool sendMailTool, BaseSendMailProps baseSendMailProps) {
//        if (!sendMailTool.setSubject(baseSendMailProps.getSubject())
//                || !sendMailTool.setBody(baseSendMailProps.getContent())
//                || !sendMailTool.setTo(baseSendMailProps.getMailReceiverList())
//                || !sendMailTool.setFrom(baseSendMailProps.getFromAddress(), baseSendMailProps.getFromNickname())) {
//            return false;
//        }
//        if (!CollectionUtils.isEmpty(baseSendMailProps.getMailCopyerList())) {
//            if (!sendMailTool.setCopyTo(baseSendMailProps.getMailCopyerList())) {
//                return false;
//            }
//        }
//        if (null != baseSendMailProps.getAffixInputStream()) {
//            if (!sendMailTool.addFileAffix(baseSendMailProps.getAffixName(), baseSendMailProps.getAffixInputStream())) {
//                return false;
//            }
//        }
//        sendMailTool.setNamePass(baseSendMailProps.getUsername(), baseSendMailProps.getPassword());
//        return true;
//    }
//
//*
//     * 邮件发送 - 【支持群发，抄送，附件】  无相关属性置为空即可.
//     *
//     * @param baseSendMailProps 基本邮件属性
//     * @return
//
//
//    public static boolean send(BaseSendMailProps baseSendMailProps) {
//        SendMailTool sendMailTool = new SendMailTool(
//                baseSendMailProps.getSmtpServerAddress(), baseSendMailProps.getSmtpServerport());
//        if (!setField(sendMailTool, baseSendMailProps)) {
//            return false;
//        }
//        return sendMailTool.sendOut();
//    }
//
//*
//     * 测试.
//     *
//     * @param args 参数
//
//
//    public static void main(String[] args) {
//        BaseSendMailProps baseSendMailProps = new BaseSendMailProps();
//        baseSendMailProps.setSmtpServerAddress("smtp.263xmail.com");
//        baseSendMailProps.setSmtpServerport(25);
//        baseSendMailProps.setFromAddress("helpdesksptu@metlife.com.cn");
//        baseSendMailProps.setFromNickname("It Zhichi");
//        List<MailReceiver> mailReceivers = Collections.singletonList(
//                new MailReceiver("Somnus", "somnus.fang@capgemini.com"));
//        baseSendMailProps.setMailReceiverList(mailReceivers);
//        List<MailCopyer> mailCopyerList = Collections.singletonList(
//                new MailCopyer("Somnus", "somnus.fang@capgemini.com"));
//        baseSendMailProps.setMailCopyerList(mailCopyerList);
//        baseSendMailProps.setSubject("电子合同");
//        baseSendMailProps.setContent("电子合同申请状态为【申请延迟】或【失败】的数据集参照附件，请知晓！");
//        baseSendMailProps.setUsername("helpdesksptu@metlife.com.cn");
//        baseSendMailProps.setPassword("test01");
//
//        //添加附件
//        List<ContractSendProps> contractSendPropsList = Arrays.asList(
//                new ContractSendProps("00000000", "03", "SH", "天空一号", new Date(), new Date(), 4, "失败"),
//                new ContractSendProps("11111111", "05", "BJ", "飞鸟一号", new Date(), new Date(), 5, "申请延迟"));
//        String sheetName = "电子合同.xls";
//        LinkedHashMap<String, String> title = new LinkedHashMap<>();
//        title.put("policyNo", "保单号");
//        title.put("company", "公司编码");
//        title.put("branch", "分支机构");
//        title.put("product", "主险名称");
//        title.put("requestTime", "合同请求时间");
//        title.put("receiveTime", "合同接收时间");
//        title.put("statusDes", "合同状态");
//
//        ByteArrayInputStream byteArrayInputStream = ExportExcelTool.list2EcelStream(
//                contractSendPropsList, sheetName, title);
//        baseSendMailProps.setAffixInputStream(byteArrayInputStream);
//        baseSendMailProps.setAffixName("电子合同.xls");
//        boolean sendSuccess = send(baseSendMailProps);
//        if (sendSuccess) {
//            System.out.println("发送邮件成功");
//        }
//        System.exit(0);
//    }
//}
