package Rough;

import Base.TestBase;
import Utilities.MonitoringMail;
import org.testng.annotations.Test;

import java.util.Arrays;

import static Utilities.EmailConfigReader.*;

public class SendMailsRough extends Base.TestBase {

    @Test (dataProviderClass = TestBase.class, dataProvider = "dp")
    public void sendMails(String to) {
        String body = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "  <head>\n" +
                "    <meta charset=\"UTF-8\" />\n" +
                "    <style>\n" +
                "      body {\n" +
                "        font-family: Arial, sans-serif;\n" +
                "        font-size: 15px;\n" +
                "        line-height: 1.6;\n" +
                "        color: #333333;\n" +
                "      }\n" +
                "      .signature {\n" +
                "        margin-top: 20px;\n" +
                "      }\n" +
                "      a {\n" +
                "        color: #1a0dab;\n" +
                "        text-decoration: none;\n" +
                "      }\n" +
                "    </style>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <p>Dear Hiring Team,</p>\n" +
                "\n" +
                "    <p>I hope this message finds you well.</p>\n" +
                "\n" +
                "    <p>\n" +
                "      I am writing to express my interest in <strong>QA opportunities</strong> within your organization. I bring <strong>2 years of hands-on experience</strong> in manual and automation testing, with a strong foundation in <strong>Selenium, JMeter, Postman, TestNG, Git, Jenkins,</strong> and <strong>API testing</strong> across web and mobile platforms.\n" +
                "    </p>\n" +
                "\n" +
                "    <p>\n" +
                "      In addition to my practical experience, I hold both <strong>professional SQA certifications</strong> and multiple Udemy certifications focused on automation frameworks, performance testing, and testing best practices. I am also pursuing a <strong>Master’s in Software Engineering</strong>, complementing my <strong>Bachelor’s in Computer Science</strong>.\n" +
                "    </p>\n" +
                "\n" +
                "    <p>\n" +
                "      I am now looking for a role in the <strong>UAE</strong> that offers growth, challenge, and opportunities to further develop my technical and team collaboration skills. I’m confident that I can contribute effectively to your QA efforts and support high-quality software delivery.\n" +
                "    </p>\n" +
                "\n" +
                "    <p>\n" +
                "      My CV is attached for your review. I would greatly appreciate the opportunity to connect regarding any relevant openings.\n" +
                "    </p>\n" +
                "\n" +
                "    <p>Thank you for your time and consideration.</p>\n" +
                "\n" +
                "    <div class=\"signature\">\n" +
                "      Best regards,<br /><br />\n" +
                "      <strong>Abul Hossain Chowdhury</strong><br />\n" +
                "      +8801737785220<br />\n" +
                "      <a href=\"mailto:ahchowdhury.off@gmail.com\">ahchowdhury.off@gmail.com</a><br />\n" +
                "      <a href=\"https://www.linkedin.com/in/abulhossainfahim\" target=\"_blank\">LinkedIn Profile</a>\n" +
                "    </div>\n" +
                "  </body>\n" +
                "</html>\n";


        String To[] = new String[]{to};

        MonitoringMail.sendMail(getMailServer(), getFrom(), getPassword(), To, "Application for Software QA Engineer Role – Abul Hossain Chowdhury", body, new String[]{"C:\\Users\\TechTeam-08\\Downloads\\CV_Abul Hossain Chowdhury.docx.pdf"});
    }
}
