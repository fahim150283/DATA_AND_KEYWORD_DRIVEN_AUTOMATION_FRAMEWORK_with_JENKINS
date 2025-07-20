package Utilities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static Base.TestBase.getHostAddress;

public class EmailConfigReader {

    private static final String CONFIG_PATH = "src/test/resources/Properties/EmailCredentials.json";

    private static String mailServer;
    private static String from;
    private static String password;
    private static String body;
    private static String subject;
    private static String[] to;

    static {
        try (FileReader reader = new FileReader(CONFIG_PATH)) {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONObject emailObj = (JSONObject) jsonObject.get("email");


            LocalDateTime dateObj = LocalDateTime.now();


            mailServer = (String) emailObj.get("mailServer");
            from = (String) emailObj.get("from");
            password = (String) emailObj.get("password");
            body = "<!DOCTYPE html>\n<html>\n<head>\n  <meta charset='UTF-8'>\n  <style>\n    body { font-family: 'Segoe UI', sans-serif; background-color: #f9f9f9; color: #333; padding: 20px; }\n    .container { background: #fff; border-radius: 8px; padding: 20px; box-shadow: 0 2px 5px rgba(0,0,0,0.1); }\n    h1 { color: #0078D4; }\n    p { font-size: 16px; line-height: 1.5; }\n    .footer { font-size: 13px; color: #888; margin-top: 30px; }\n  </style>\n</head>\n<body>\n  <div class='container'>\n    <h1>Hello,</h1>\n    <p>Hope this automated email finds you well.<br>This email contains the automation test report. <br>Please click the link to view the report : <a href='"+getHostAddress()+"'>View Report Here</a>.</p>\n   <p>Thank you.</p>\n   <br> <p><b>** Please do not reply to this email **</b></p>\n  <div class='footer'>\n      <p>Best regards,<br>Automation Team</p>   </div>\n  </div>\n</body>\n</html>";
            subject = "Automation Test Report of : "+dateObj.toLocalDate().format(java.time.format.DateTimeFormatter.ofPattern(" dd MMM yyyy"))+" - "+dateObj.toLocalTime().format(java.time.format.DateTimeFormatter.ofPattern("hh:mm a"));

            JSONArray toArray = (JSONArray) emailObj.get("to");
            to = new String[toArray.size()];
            for (int i = 0; i < toArray.size(); i++) {
                to[i] = (String) toArray.get(i);
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to read email configuration", e);
        }
    }

    // Getters
    public static String getMailServer() {
        return mailServer;
    }

    public static String getFrom() {
        return from;
    }

    public static String getPassword() {
        return password;
    }

    public static String[] getTo() {
        return to;
    }

    public static String getBody() {
        return body;
    }

    public static String getSubject() {
        return subject;
    }

    // Test main method
    public static void main(String[] args) {
        System.out.println("Mail Server: " + getMailServer());
        System.out.println("From: " + getFrom());
        System.out.println("Password: " + getPassword());
        System.out.println("Body: " + body);
        System.out.println("Subject: " + subject);
        for (String recipient : getTo()) {
            System.out.println("Recipient: " + recipient);
        }
    }
}
