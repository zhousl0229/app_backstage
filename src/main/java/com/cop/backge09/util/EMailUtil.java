package com.cop.backge09.util;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.cop.backge09.utils.utils.mail.MailSender;
import com.cop.backge09.utils.utils.mail.model.MailSenderModel;

public class EMailUtil {
	private static String smtpHost = "smtp.mxhichina.com";
	private static String from = "bhope@boxingda.net";
	private static String fromUserPassword = "Bigou2017";
	private static String subject_cn = "[日历]邮箱验证";// 主题
	private static String subject_en = "[BHope]Mailbox Rerification";// 主题
	private static String username_cn = "必购商城管理员"; // 发件人邮箱登录名
	private static String username_en = "BHope Administrators"; // 发件人邮箱登录名
	private static String messageType = "text/html;charset=UTF-8";

	@SuppressWarnings("static-access")
	public static boolean sendMessage(String to, String verification_code, String lang) {
		boolean isSendEmailSuccess = false;
		String messageText_CN = "尊敬的用户，您好。欢迎使用日历。<br/>您本次邮箱验证验证码为：<h1>" + verification_code+"</h1><br/>请勿泄露给他人。";
		String messageText_EN = "Dear user, Welcome to use the calendar. <br/> your E-mail registration verification code is: <h1> "+ verification_code+" </h1><br/>please don't leak it to others.";
		try {
			// 第一步：配置javax.mail.Session对象
//			System.out.println("为" + smtpHost + "配置mail session对象");

			Properties props = new Properties();
			props.put("mail.smtp.host", smtpHost);
			props.put("mail.smtp.starttls.enable", "true");// 使用 STARTTLS安全连接
			// props.put("mail.smtp.port", "25"); //google使用465或587端口
			props.put("mail.smtp.auth", "true"); // 使用验证
			// props.put("mail.debug", "true");
			Session mailSession = Session.getInstance(props,
					new MyAuthenticator(from, fromUserPassword));

			// 第二步：编写消息
			System.out.println("编写消息from——to:" + from + "——" + to);

			InternetAddress fromAddress = new InternetAddress(from);
			InternetAddress toAddress = new InternetAddress(to);

			MimeMessage message = new MimeMessage(mailSession);

			if (lang.equals("zh_CN")) {
				fromAddress.setPersonal(username_cn, "UTF-8");
				message.setSubject(subject_cn);
				message.setContent(messageText_CN, messageType);
			} else {
				fromAddress.setPersonal(username_en, "UTF-8");
				message.setSubject(subject_en);
				message.setContent(messageText_EN, messageType);
			}
			message.setFrom(fromAddress);
			message.addRecipient(RecipientType.TO, toAddress);
			message.setSentDate(Calendar.getInstance().getTime());
			
			// 第三步：发送消息
			Transport transport = mailSession.getTransport("smtp");
			transport.connect(smtpHost, from, fromUserPassword);
			transport.send(message, message.getRecipients(RecipientType.TO));
			System.out.println("send email success");
			isSendEmailSuccess = true;
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			isSendEmailSuccess = false;
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			isSendEmailSuccess = false;
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			isSendEmailSuccess = false;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			isSendEmailSuccess = false;
		}
		
		return isSendEmailSuccess;
	}

	public static void main(String[] args) {
		MailSender  mailSender =new  MailSender();
		MailSenderModel MailSenderModel=new MailSenderModel("smtp.mxhichina.com","25","bhope@boxingda.net","103dwadwadawd4373339@qq.com","","","bhope@boxingda.net","Bigou2017",true,"t","ces",null);
		System.out.println(mailSender.sendTextMail(MailSenderModel));
	}
}

class MyAuthenticator extends Authenticator {
	String userName = "";
	String password = "";

	public MyAuthenticator() {

	}

	public MyAuthenticator(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(userName, password);
	}
}