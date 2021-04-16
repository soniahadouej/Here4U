package tn.g3.spring.service;
import java.io.File;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.*;
import javax.mail.internet.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Service
public class SendEmailService {
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendEmail(String to, String topic,String motif,String name ,String date,File file) throws MessagingException
	{
		
		/*System.out.println("sending email");
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom("sonia.hadouej@esprit.tn");
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(topic);
		 simpleMailMessage.setTex t(body,true);
		simpleMailMessage.setSentDate(new Date());
		javaMailSender.send(simpleMailMessage);
		System.out.println("sent email"); */
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
		
		mimeMessageHelper.setFrom("sonia.hadouej@esprit.tn");
		mimeMessageHelper.setTo(to);
		mimeMessageHelper.setSubject(topic);
		//mimeMessageHelper.setText(body,true);
		  MimeMultipart multipart = new MimeMultipart("related");
          MimeBodyPart messageBodyPart = new MimeBodyPart();
          messageBodyPart.setContent("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                  "\n" +
                  "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:v=\"urn:schemas-microsoft-com:vml\">\n" +
                  "<head>\n" +
                  "<!--[if gte mso 9]><xml><o:OfficeDocumentSettings><o:AllowPNG/><o:PixelsPerInch>96</o:PixelsPerInch></o:OfficeDocumentSettings></xml><![endif]-->\n" +
                  "<meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\"/>\n" +
                  "<meta content=\"width=device-width\" name=\"viewport\"/>\n" +
                  "<!--[if !mso]><!-->\n" +
                  "<meta content=\"IE=edge\" http-equiv=\"X-UA-Compatible\"/>\n" +
                  "<!--<![endif]-->\n" +
                  "<title></title>\n" +
                  "<!--[if !mso]><!-->\n" +
                  "<!--<![endif]-->\n" +
                  "<style type=\"text/css\">\n" +
                  "\t\tbody {\n" +
                  "\t\t\tmargin: 0;\n" +
                  "\t\t\tpadding: 0;\n" +
                  "\t\t}\n" +
                  "\t\ttable,\n" +
                  "\t\ttd,\n" +
                  "\t\ttr {\n" +
                  "\t\t\tvertical-align: top;\n" +
                  "\t\t\tborder-collapse: collapse;\n" +
                  "\t\t}\n" +
                  "\n" +
                  "\t\t* {\n" +
                  "\t\t\tline-height: inherit;\n" +
                  "\t\t}\n" +
                  "\n" +
                  "\t\ta[x-apple-data-detectors=true] {\n" +
                  "\t\t\tcolor: inherit !important;\n" +
                  "\t\t\ttext-decoration: none !important;\n" +
                  "\t\t}\n" +
                  "\t</style>\n" +
                  "<style id=\"media-query\" type=\"text/css\">\n" +
                  "\t\t@media (max-width: 660px) {\n" +
                  "\n" +
                  "\t\t\t.block-grid,\n" +
                  "\t\t\t.col {\n" +
                  "\t\t\t\tmin-width: 320px !important;\n" +
                  "\t\t\t\tmax-width: 100% !important;\n" +
                  "\t\t\t\tdisplay: block !important;\n" +
                  "\t\t\t}\n" +
                  "\n" +
                  "\t\t\t.block-grid {\n" +
                  "\t\t\t\twidth: 100% !important;\n" +
                  "\t\t\t}\n" +
                  "\n" +
                  "\t\t\t.col {\n" +
                  "\t\t\t\twidth: 100% !important;\n" +
                  "\t\t\t}\n" +
                  "\n" +
                  "\t\t\t.col>div {\n" +
                  "\t\t\t\tmargin: 0 auto;\n" +
                  "\t\t\t}\n" +
                  "\n" +
                  "\t\t\timg.fullwidth,\n" +
                  "\t\t\timg.fullwidthOnMobile {\n" +
                  "\t\t\t\tmax-width: 100% !important;\n" +
                  "\t\t\t}\n" +
                  "\n" +
                  "\t\t\t.no-stack .col {\n" +
                  "\t\t\t\tmin-width: 0 !important;\n" +
                  "\t\t\t\tdisplay: table-cell !important;\n" +
                  "\t\t\t}\n" +
                  "\n" +
                  "\t\t\t.no-stack.two-up .col {\n" +
                  "\t\t\t\twidth: 50% !important;\n" +
                  "\t\t\t}\n" +
                  "\n" +
                  "\t\t\t.no-stack .col.num4 {\n" +
                  "\t\t\t\twidth: 33% !important;\n" +
                  "\t\t\t}\n" +
                  "\n" +
                  "\t\t\t.no-stack .col.num8 {\n" +
                  "\t\t\t\twidth: 66% !important;\n" +
                  "\t\t\t}\n" +
                  "\n" +
                  "\t\t\t.no-stack .col.num4 {\n" +
                  "\t\t\t\twidth: 33% !important;\n" +
                  "\t\t\t}\n" +
                  "\n" +
                  "\t\t\t.no-stack .col.num3 {\n" +
                  "\t\t\t\twidth: 25% !important;\n" +
                  "\t\t\t}\n" +
                  "\n" +
                  "\t\t\t.no-stack .col.num6 {\n" +
                  "\t\t\t\twidth: 50% !important;\n" +
                  "\t\t\t}\n" +
                  "\n" +
                  "\t\t\t.no-stack .col.num9 {\n" +
                  "\t\t\t\twidth: 75% !important;\n" +
                  "\t\t\t}\n" +
                  "\n" +
                  "\t\t\t.video-block {\n" +
                  "\t\t\t\tmax-width: none !important;\n" +
                  "\t\t\t}\n" +
                  "\n" +
                  "\t\t\t.mobile_hide {\n" +
                  "\t\t\t\tmin-height: 0px;\n" +
                  "\t\t\t\tmax-height: 0px;\n" +
                  "\t\t\t\tmax-width: 0px;\n" +
                  "\t\t\t\tdisplay: none;\n" +
                  "\t\t\t\toverflow: hidden;\n" +
                  "\t\t\t\tfont-size: 0px;\n" +
                  "\t\t\t}\n" +
                  "\n" +
                  "\t\t\t.desktop_hide {\n" +
                  "\t\t\t\tdisplay: block !important;\n" +
                  "\t\t\t\tmax-height: none !important;\n" +
                  "\t\t\t}\n" +
                  "\t\t}\n" +
                  "\t</style>\n" +
                  "</head>\n" +
                  "<body class=\"clean-body\" style=\"margin: 0; padding: 0; -webkit-text-size-adjust: 100%; background-color: #f3f2f3;\">\n" +
                  "<!--[if IE]><div class=\"ie-browser\"><![endif]-->\n" +
                  "<table bgcolor=\"#f3f2f3\" cellpadding=\"0\" cellspacing=\"0\" class=\"nl-container\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; min-width: 320px; Margin: 0 auto; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #f3f2f3; width: 100%;\" valign=\"top\" width=\"100%\">\n" +
                  "<tbody>\n" +
                  "<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                  "<td style=\"word-break: break-word; vertical-align: top;\" valign=\"top\">\n" +
                  "<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color:#f3f2f3\"><![endif]-->\n" +
                  "<div style=\"background-color:transparent;\">\n" +
                  "<div class=\"block-grid\" style=\"Margin: 0 auto; min-width: 320px; max-width: 640px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #ffffff;\">\n" +
                  "<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#ffffff;\">\n" +
                  "<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:640px\"><tr class=\"layout-full-width\" style=\"background-color:#ffffff\"><![endif]-->\n" +
                  "<!--[if (mso)|(IE)]><td align=\"center\" width=\"640\" style=\"background-color:#ffffff;width:640px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:0px;\"><![endif]-->\n" +
                  "<div class=\"col num12\" style=\"min-width: 320px; max-width: 640px; display: table-cell; vertical-align: top; width: 640px;\">\n" +
                  "<div style=\"width:100% !important;\">\n" +
                  "<!--[if (!mso)&(!IE)]><!-->\n" +
                  "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\n" +
                  "<!--<![endif]-->\n" +
                  "<div class=\"mobile_hide\">\n" +
                  "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\" width=\"100%\">\n" +
                  "<tbody>\n" +
                  "<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                  "<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px;\" valign=\"top\">\n" +
                  "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider_content\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 30px solid #F3F2F3; width: 100%;\" valign=\"top\" width=\"100%\">\n" +
                  "<tbody>\n" +
                  "<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                  "<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n" +
                  "</tr>\n" +
                  "</tbody>\n" +
                  "</table>\n" +
                  "</td>\n" +
                  "</tr>\n" +
                  "</tbody>\n" +
                  "</table>\n" +
                  "</div>\n" +
                  "<!--[if (!mso)&(!IE)]><!-->\n" +
                  "</div>\n" +
                  "<!--<![endif]-->\n" +
                  "</div>\n" +
                  "</div>\n" +
                  "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                  "<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                  "</div>\n" +
                  "</div>\n" +
                  "</div>\n" +
                  "<div style=\"background-color:transparent;\">\n" +
                  "<div class=\"block-grid three-up\" style=\"Margin: 0 auto; min-width: 320px; max-width: 640px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #0f66dd;\">\n" +
                  "<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#0f66dd;\">\n" +
                  "<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:640px\"><tr class=\"layout-full-width\" style=\"background-color:#0f66dd\"><![endif]-->\n" +
                  "<!--[if (mso)|(IE)]><td align=\"center\" width=\"213\" style=\"background-color:#0f66dd;width:213px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 48px; padding-top:8px; padding-bottom:0px;\"><![endif]-->\n" +
                  "<div class=\"col num4\" style=\"max-width: 320px; min-width: 213px; display: table-cell; vertical-align: top; width: 213px;\">\n" +
                  "<div style=\"width:100% !important;\">\n" +
                  "<!--[if (!mso)&(!IE)]><!-->\n" +
                  "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:8px; padding-bottom:0px; padding-right: 0px; padding-left: 48px;\">\n" +
                  "<!--<![endif]-->\n" +
                  "<div></div>\n" +
                  "<!--[if (!mso)&(!IE)]><!-->\n" +
                  "</div>\n" +
                  "<!--<![endif]-->\n" +
                  "</div>\n" +
                  "</div>\n" +
                  "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                  "<!--[if (mso)|(IE)]></td><td align=\"center\" width=\"213\" style=\"background-color:#0f66dd;width:213px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:0px;\"><![endif]-->\n" +
                  "<div class=\"col num4\" style=\"max-width: 320px; min-width: 213px; display: table-cell; vertical-align: top; width: 213px;\">\n" +
                  "<div style=\"width:100% !important;\">\n" +
                  "<!--[if (!mso)&(!IE)]><!-->\n" +
                  "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\n" +
                  "<!--<![endif]-->\n" +
                  "<div align=\"center\" class=\"img-container center autowidth\" style=\"padding-right: 0px;padding-left: 0px;\">\n" +
                  "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]-->\n" +
                  "<!--[if mso]></td></tr></table><![endif]-->\n" +
                  "</div>\n" +
                  "<!--[if (!mso)&(!IE)]><!-->\n" +
                  "</div>\n" +
                  "<!--<![endif]-->\n" +
                  "</div>\n" +
                  "</div>\n" +
                  "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                  "<!--[if (mso)|(IE)]></td><td align=\"center\" width=\"213\" style=\"background-color:#0f66dd;width:213px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 48px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
                  "<div class=\"col num4\" style=\"max-width: 320px; min-width: 213px; display: table-cell; vertical-align: top; width: 213px;\">\n" +
                  "<div style=\"width:100% !important;\">\n" +
                  "<!--[if (!mso)&(!IE)]><!-->\n" +
                  "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 48px;\">\n" +
                  "<!--<![endif]-->\n" +
                  "<div class=\"mobile_hide\">\n" +
                  "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\" width=\"100%\">\n" +
                  "<tbody>\n" +
                  "<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                  "<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 30px; padding-right: 10px; padding-bottom: 0px; padding-left: 10px;\" valign=\"top\">\n" +
                  "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider_content\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid #BBBBBB; width: 100%;\" valign=\"top\" width=\"100%\">\n" +
                  "<tbody>\n" +
                  "<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                  "<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n" +
                  "</tr>\n" +
                  "</tbody>\n" +
                  "</table>\n" +
                  "</td>\n" +
                  "</tr>\n" +
                  "</tbody>\n" +
                  "</table>\n" +
                  "</div>\n" +
                  "<!--[if (!mso)&(!IE)]><!-->\n" +
                  "</div>\n" +
                  "<!--<![endif]-->\n" +
                  "</div>\n" +
                  "</div>\n" +
                  "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                  "<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                  "</div>\n" +
                  "</div>\n" +
                  "</div>\n" +
                  "<div style=\"background-color:transparent;\">\n" +
                  "<div class=\"block-grid\" style=\"Margin: 0 auto; min-width: 320px; max-width: 640px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #f3f2f3;\">\n" +
                  "<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#f3f2f3;\">\n" +
                  "<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:640px\"><tr class=\"layout-full-width\" style=\"background-color:#f3f2f3\"><![endif]-->\n" +
                  "<!--[if (mso)|(IE)]><td align=\"center\" width=\"640\" style=\"background-color:#f3f2f3;width:640px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:0px;\"><![endif]-->\n" +
                  "<div class=\"col num12\" style=\"min-width: 320px; max-width: 640px; display: table-cell; vertical-align: top; width: 640px;\">\n" +
                  "<div style=\"width:100% !important;\">\n" +
                  "<!--[if (!mso)&(!IE)]><!-->\n" +
                  "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\n" +
                  "<!--<![endif]-->\n" +
                  "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\" width=\"100%\">\n" +
                  "<tbody>\n" +
                  "<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                  "<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px;\" valign=\"top\">\n" +
                  "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider_content\" height=\"1\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 1px solid transparent; height: 1px; width: 100%;\" valign=\"top\" width=\"100%\">\n" +
                  "<tbody>\n" +
                  "<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                  "<td height=\"1\" style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n" +
                  "</tr>\n" +
                  "</tbody>\n" +
                  "</table>\n" +
                  "</td>\n" +
                  "</tr>\n" +
                  "</tbody>\n" +
                  "</table>\n" +
                  "<!--[if (!mso)&(!IE)]><!-->\n" +
                  "</div>\n" +
                  "<!--<![endif]-->\n" +
                  "</div>\n" +
                  "</div>\n" +
                  "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                  "<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                  "</div>\n" +
                  "</div>\n" +
                  "</div>\n" +
                  "<div style=\"background-color:transparent;\">\n" +
                  "<div class=\"block-grid\" style=\"Margin: 0 auto; min-width: 320px; max-width: 640px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #ffffff;\">\n" +
                  "<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#ffffff;background-image:url('images/bg-shade.jpg');background-position:center top;background-repeat:repeat\">\n" +
                  "<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:640px\"><tr class=\"layout-full-width\" style=\"background-color:#ffffff\"><![endif]-->\n" +
                  "<!--[if (mso)|(IE)]><td align=\"center\" width=\"640\" style=\"background-color:#ffffff;width:640px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:60px; padding-bottom:0px;\"><![endif]-->\n" +
                  "<div class=\"col num12\" style=\"min-width: 320px; max-width: 640px; display: table-cell; vertical-align: top; width: 640px;\">\n" +
                  "<div style=\"width:100% !important;\">\n" +
                  "<!--[if (!mso)&(!IE)]><!-->\n" +
                  "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:60px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\n" +
                  "<!--<![endif]-->\n" +
                  "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 38px; padding-left: 38px; padding-top: 20px; padding-bottom: 15px; font-family: Arial, sans-serif\"><![endif]-->\n" +
                  "<div style=\"color:#555555;font-family:Helvetica Neue, Helvetica, Arial, sans-serif;line-height:1.2;padding-top:20px;padding-right:38px;padding-bottom:15px;padding-left:38px;\">\n" +
                  "<div style=\"line-height: 1.2; font-size: 12px; font-family: Helvetica Neue, Helvetica, Arial, sans-serif; color: #555555; mso-line-height-alt: 14px;\">\n" +
                  "<p style=\"font-size: 42px; line-height: 1.2; word-break: break-word; text-align: center; font-family: inherit; mso-line-height-alt: 50px; margin: 0;\"><span style=\"font-size: 42px; color: #2a272b;\"><strong> Cher Cleint Mr/Mme " + name + "</strong></span></p>\n" +
                  "</div>\n" +
                  "</div>\n" +
                  "<!--[if mso]></td></tr></table><![endif]-->\n" +
                  "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 38px; padding-left: 38px; padding-top: 10px; padding-bottom: 10px; font-family: Arial, sans-serif\"><![endif]-->\n" +
                  "<div style=\"color:#555555;font-family:Helvetica Neue, Helvetica, Arial, sans-serif;line-height:1.5;padding-top:10px;padding-right:38px;padding-bottom:10px;padding-left:38px;\">\n" +
                  "<div style=\"line-height: 1.5; font-size: 12px; font-family: Helvetica Neue, Helvetica, Arial, sans-serif; color: #555555; mso-line-height-alt: 18px;\">\n" +
                  "<p style=\"line-height: 1.5; word-break: break-word; text-align: center; font-family: inherit; mso-line-height-alt: NaNpx; margin: 0;\"><span style=\"color: #2a272b;\"><span style=\"font-size: 16px;\"><strong>On vous informe que votre demande de remboursement de sinistre, envoyée à la date :"+ date +" a été rejetée car cette demande " + motif + ".<br> Merci pour votre compréhension.<br> Vous pouvez visiter ce site pour plus d'informations. </strong></span></span></p>\n" +

                  "<p style=\"line-height: 1.5; word-break: break-word; font-family: inherit; mso-line-height-alt: NaNpx; margin: 0;\"> </p>\n" +
                  "</div>\n" +
                  "</div>\n" +
                  "<!--[if mso]></td></tr></table><![endif]-->\n" +
                  "<div align=\"center\" class=\"button-container\" style=\"padding-top:0px;padding-right:0px;padding-bottom:0px;padding-left:0px;\">\n" +
                  "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-spacing: 0; border-collapse: collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"><tr><td style=\"padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px\" align=\"center\"><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" href=\"\" style=\"height:45pt; width:199.5pt; v-text-anchor:middle;\" arcsize=\"100%\" stroke=\"false\" fillcolor=\"#004afd\"><w:anchorlock/><v:textbox inset=\"0,0,0,0\"><center style=\"color:#ffffff; font-family:Arial, sans-serif; font-size:16px\"><![endif]-->\n" +
                  "<a href=\"#\">\n" +
                  "<br>\n" +
                  "<br>\n" +
                  "<br>\n" +
                  "<br>\n" +
                  "<div align=\"center\" class=\"button-container\" style=\"padding-top:0px;padding-right:0px;padding-bottom:0px;padding-left:0px;\">\n" +
                  "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-spacing: 0; border-collapse: collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"><tr><td style=\"padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px\" align=\"center\"><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" href=\"\" style=\"height:45pt; width:203.25pt; v-text-anchor:middle;\" arcsize=\"100%\" stroke=\"false\" fillcolor=\"#004afd\"><w:anchorlock/><v:textbox inset=\"0,0,0,0\"><center style=\"color:#ffffff; font-family:Arial, sans-serif; font-size:16px\"><![endif]-->\n" +
                  "<a href=\"#\">\n" +
                  "<div style=\"text-decoration:none;display:inline-block;color:#ffffff;background-color:#004afd;border-radius:60px;-webkit-border-radius:60px;-moz-border-radius:60px;width:auto; width:auto;;border-top:1px solid #004afd;border-right:1px solid #004afd;border-bottom:1px solid #004afd;border-left:1px solid #004afd;padding-top:12px;padding-bottom:16px;font-family:Helvetica Neue, Helvetica, Arial, sans-serif;text-align:center;mso-border-alt:none;word-break:keep-all;\"><a href=\"https://www.comar.tn/node/7\"><span style=\"padding-left:57px;padding-right:57px;font-size:16px;display:inline-block;\"><span style=\"font-size: 16px; margin: 0; line-height: 2; word-break: break-word; mso-line-height-alt: 32px;\"><strong><p style='color:#FFFFFF';>Visiter le Site</p></strong></span></span></a></div>\n" +
                  "</a>\n" +
                  "<!--[if mso]></center></v:textbox></v:roundrect></td></tr></table><![endif]-->\n" +
                  "</div>\n" +
                  "<div class=\"mobile_hide\">\n" +
                  "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\" width=\"100%\">\n" +
                  "<tbody>\n" +
                  "<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                  "<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 50px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px;\" valign=\"top\">\n" +
                  "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider_content\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid #BBBBBB; width: 100%;\" valign=\"top\" width=\"100%\">\n" +
                  "<tbody>\n" +
                  "<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                  "<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n" +
                  "</tr>\n" +
                  "</tbody>\n" +
                  "</table>\n" +
                  "</td>\n" +
                  "</tr>\n" +
                  "</tbody>\n" +
                  "</table>\n" +
                  "</div>\n" +
                  "<div align=\"center\" class=\"img-container center autowidth\" style=\"padding-right: 0px;padding-left: 0px;\">\n" +
                  "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]-->\n" +
                  "<!--[if mso]></td></tr></table><![endif]-->\n" +
                  "</div>\n" +
                  "<!--[if (!mso)&(!IE)]><!-->\n" +
                  "</div>\n" +
                  "<!--<![endif]-->\n" +
                  "</div>\n" +
                  "</div>\n" +
                  "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                  "<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                  "</div>\n" +
                  "</div>\n" +
                  "</div>\n" +
                  "<div style=\"background-color:transparent;\">\n" +
                  "<div class=\"block-grid\" style=\"Margin: 0 auto; min-width: 320px; max-width: 640px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #f3f2f3;\">\n" +
                  "<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#f3f2f3;\">\n" +
                  "<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:640px\"><tr class=\"layout-full-width\" style=\"background-color:#f3f2f3\"><![endif]-->\n" +
                  "<!--[if (mso)|(IE)]><td align=\"center\" width=\"640\" style=\"background-color:#f3f2f3;width:640px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:0px;\"><![endif]-->\n" +
                  "<div class=\"col num12\" style=\"min-width: 320px; max-width: 640px; display: table-cell; vertical-align: top; width: 640px;\">\n" +
                  "<div style=\"width:100% !important;\">\n" +
                  "<!--[if (!mso)&(!IE)]><!-->\n" +
                  "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\n" +
                  "<!--<![endif]-->\n" +
                  "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\" width=\"100%\">\n" +
                  "<tbody>\n" +
                  "<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                  "<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px;\" valign=\"top\">\n" +
                  "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider_content\" height=\"1\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 1px solid transparent; height: 1px; width: 100%;\" valign=\"top\" width=\"100%\">\n" +
                  "<tbody>\n" +
                  "<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                  "<td height=\"1\" style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n" +
                  "</tr>\n" +
                  "</tbody>\n" +
                  "</table>\n" +
                  "</td>\n" +
                  "</tr>\n" +
                  "</tbody>\n" +
                  "</table>\n" +
                  "<!--[if (!mso)&(!IE)]><!-->\n" +
                  "</div>\n" +
                  "<!--<![endif]-->\n" +
                  "</div>\n" +
                  "</div>\n" +
                  "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                  "<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                  "</div>\n" +
                  "</div>\n" +
                  "</div>\n" +
                  "<div style=\"background-color:transparent;\">\n" +
                  "<div class=\"block-grid three-up\" style=\"Margin: 0 auto; min-width: 320px; max-width: 640px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #111c22;\">\n" +
                  "<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#111c22;\">\n" +
                  "<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:640px\"><tr class=\"layout-full-width\" style=\"background-color:#111c22\"><![endif]-->\n" +
                  "<!--[if (mso)|(IE)]><td align=\"center\" width=\"213\" style=\"background-color:#111c22;width:213px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 48px; padding-top:3px; padding-bottom:0px;\"><![endif]-->\n" +
                  "<div class=\"col num4\" style=\"max-width: 320px; min-width: 213px; display: table-cell; vertical-align: top; width: 213px;\">\n" +
                  "<div style=\"width:100% !important;\">\n" +
                  "<!--[if (!mso)&(!IE)]><!-->\n" +
                  "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:3px; padding-bottom:0px; padding-right: 0px; padding-left: 48px;\">\n" +
                  "<!--<![endif]-->\n" +
                  "<div align=\"left\" class=\"img-container left autowidth\" style=\"padding-right: 0px;padding-left: 0px;\">\n" +
                  "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"left\"><![endif]-->\n" +
                  "<!--[if mso]></td></tr></table><![endif]-->\n" +
                  "</div>\n" +
                  "<!--[if (!mso)&(!IE)]><!-->\n" +
                  "</div>\n" +
                  "<!--<![endif]-->\n" +
                  "</div>\n" +
                  "</div>\n" +
                  "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                  "<!--[if (mso)|(IE)]></td><td align=\"center\" width=\"213\" style=\"background-color:#111c22;width:213px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:0px;\"><![endif]-->\n" +
                  "<div class=\"col num4\" style=\"max-width: 320px; min-width: 213px; display: table-cell; vertical-align: top; width: 213px;\">\n" +
                  "<div style=\"width:100% !important;\">\n" +
                  "<!--[if (!mso)&(!IE)]><!-->\n" +
                  "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\n" +
                  "<!--<![endif]-->\n" +
                  "<div></div>\n" +
                  "<!--[if (!mso)&(!IE)]><!-->\n" +
                  "</div>\n" +
                  "<!--<![endif]-->\n" +
                  "</div>\n" +
                  "</div>\n" +
                  "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                  "<!--[if (mso)|(IE)]></td><td align=\"center\" width=\"213\" style=\"background-color:#111c22;width:213px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 48px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
                  "<div class=\"col num4\" style=\"max-width: 320px; min-width: 213px; display: table-cell; vertical-align: top; width: 213px;\">\n" +
                  "<div style=\"width:100% !important;\">\n" +
                  "<!--[if (!mso)&(!IE)]><!-->\n" +
                  "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 48px;\">\n" +
                  "<!--<![endif]-->\n" +
                  "<div class=\"mobile_hide\">\n" +
                  "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\" width=\"100%\">\n" +
                  "<tbody>\n" +
                  "<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                  "<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 30px; padding-right: 10px; padding-bottom: 0px; padding-left: 10px;\" valign=\"top\">\n" +
                  "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider_content\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid #BBBBBB; width: 100%;\" valign=\"top\" width=\"100%\">\n" +
                  "<tbody>\n" +
                  "<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                  "<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n" +
                  "</tr>\n" +
                  "</tbody>\n" +
                  "</table>\n" +
                  "</td>\n" +
                  "</tr>\n" +
                  "</tbody>\n" +
                  "</table>\n" +
                  "</div>\n" +
                  "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 48px; padding-left: 0px; padding-top: 0px; padding-bottom: 28px; font-family: Arial, sans-serif\"><![endif]-->\n" +
                  "<div style=\"color:#c9c9c9;font-family:Helvetica Neue, Helvetica, Arial, sans-serif;line-height:1.5;padding-top:0px;padding-right:48px;padding-bottom:28px;padding-left:0px;\">\n" +
                  "<div style=\"line-height: 1.5; font-size: 12px; font-family: Helvetica Neue, Helvetica, Arial, sans-serif; color: #c9c9c9; mso-line-height-alt: 18px;\">\n" +
                  "<p style=\"font-size: 14px; line-height: 1.5; word-break: break-word; text-align: left; font-family: inherit; mso-line-height-alt: 21px; margin: 0;\">Copyright © 2020</p>\n" +
                  "</div>\n" +
                  "</div>\n" +
                  "<!--[if mso]></td></tr></table><![endif]-->\n" +
                  "<!--[if (!mso)&(!IE)]><!-->\n" +
                  "</div>\n" +
                  "<!--<![endif]-->\n" +
                  "</div>\n" +
                  "</div>\n" +
                  "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                  "<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                  "</div>\n" +
                  "</div>\n" +
                  "</div>\n" +
                  "<div style=\"background-color:transparent;\">\n" +
                  "<div class=\"block-grid\" style=\"Margin: 0 auto; min-width: 320px; max-width: 640px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #f3f2f3;\">\n" +
                  "<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#f3f2f3;\">\n" +
                  "<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:640px\"><tr class=\"layout-full-width\" style=\"background-color:#f3f2f3\"><![endif]-->\n" +
                  "<!--[if (mso)|(IE)]><td align=\"center\" width=\"640\" style=\"background-color:#f3f2f3;width:640px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:0px;\"><![endif]-->\n" +
                  "<div class=\"col num12\" style=\"min-width: 320px; max-width: 640px; display: table-cell; vertical-align: top; width: 640px;\">\n" +
                  "<div style=\"width:100% !important;\">\n" +
                  "<!--[if (!mso)&(!IE)]><!-->\n" +
                  "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\n" +
                  "<!--<![endif]-->\n" +
                  "<div class=\"mobile_hide\">\n" +
                  "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\" width=\"100%\">\n" +
                  "<tbody>\n" +
                  "<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                  "<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 15px; padding-right: 15px; padding-bottom: 15px; padding-left: 15px;\" valign=\"top\">\n" +
                  "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider_content\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid #BBBBBB; width: 100%;\" valign=\"top\" width=\"100%\">\n" +
                  "<tbody>\n" +
                  "<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                  "<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n" +
                  "</tr>\n" +
                  "</tbody>\n" +
                  "</table>\n" +
                  "</td>\n" +
                  "</tr>\n" +
                  "</tbody>\n" +
                  "</table>\n" +
                  "</div>\n" +
                  "<!--[if (!mso)&(!IE)]><!-->\n" +
                  "</div>\n" +
                  "<!--<![endif]-->\n" +
                  "</div>\n" +
                  "</div>\n" +
                  "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                  "<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                  "</div>\n" +
                  "</div>\n" +
                  "</div>\n" +
                  "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                  "</td>\n" +
                  "</tr>\n" +
                  "</tbody>\n" +
                  "</table>\n" +
                  "<!--[if (IE)]></div><![endif]-->\n" +
                  "</body>\n" +
                  "</html>", "text/html");
          
          multipart.addBodyPart(messageBodyPart);
          mimeMessage.setContent(multipart);
		
		mimeMessageHelper.setSentDate(new Date());
		mimeMessageHelper.addAttachment(file.getName(), file);
		javaMailSender.send(mimeMessage);
		System.out.println("sent email"); 




	}
	
	
}
