package Servlets;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

@WebServlet("/reserve")
public class RoomReserveController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username  = (String)req.getAttribute("username");
        String startTime=(String)req.getAttribute("start");
        String endTime = (String)req.getAttribute("end");

        resp.setContentType("application/json; charset=UTF-8;");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(getJsonStr(username , startTime , endTime));

    }

    public String getJsonStr( String username , String start , String end ) throws IOException {
        String json ="";
        ArrayList<NameValuePair> postParameters;

        HttpPost httppost = new HttpPost("http://213.233.176.40/rooms/204/reserve");
        postParameters = new ArrayList<NameValuePair>();
        postParameters.add(new BasicNameValuePair("username", username));
        postParameters.add(new BasicNameValuePair("start", start));
        postParameters.add(new BasicNameValuePair("end",end));
        httppost.setHeader("Content-Type","application/json");
        httppost.setEntity(new UrlEncodedFormEntity(postParameters,"UTF-8"));

        HttpClient httpclient = HttpClients.createDefault();
        HttpResponse response = httpclient.execute(httppost);
        int statusCode = response.getStatusLine().getStatusCode();
        if(statusCode == 400){
            json = "Bad Request -- Invalid start or end date, Required values not provided";
        }
        if(statusCode == 404){
            json = "Not Found -- The specified room could not be found";
        }
        if(statusCode == 500){
            return getJsonStr( username , start , end);
        }
        else {
            System.out.println("yessssss");
            HttpEntity entity = response.getEntity();
            json = "Room 204 successfully reserved for:negin";
            sendEmailToUser(username);

        }
        return json;
    }

    private void sendEmailToUser(String username) {

            // Recipient's email ID needs to be mentioned.
            String to = "yazdizadeh.tina@gmail.com";

            // Sender's email ID needs to be mentioned
            String from ="info.jalass@gmail.com";

            // Assuming you are sending email from through gmails smtp
            String host = "smtp.gmail.com";

            // Get system properties
            Properties properties = System.getProperties();

            // Setup mail server
            properties.put("mail.smtp.host", host);
            properties.put("mail.smtp.port", "587");
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.connectiontimeout","5000");
        properties.put("mail.smtp.timeout","5000");
        properties.put("mail.smtp.writetimeout","5000");
        properties.put("mail.smtp.starttls.enable","true");
        

        // Get the Session object.// and pass username and password
            Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

                protected PasswordAuthentication getPasswordAuthentication() {

                    return new PasswordAuthentication("info.jalass@gmail.com", "negintinamahgol");

                }

            });

            // Used to debug SMTP issues
            session.setDebug(true);

            try {
                // Create a default MimeMessage object.
                MimeMessage message = new MimeMessage(session);

                // Set From: header field of the header.
                message.setFrom(new InternetAddress(from));

                // Set To: header field of the header.
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

                // Set Subject: header field
                message.setSubject("This is the Subject Line!");

                // Now set the actual message
                message.setText("This is actual message");

                System.out.println("sending...");
                // Send message
                Transport.send(message);
                System.out.println("Sent message successfully....");
            } catch (MessagingException mex) {
                mex.printStackTrace();
            }

    }

}
