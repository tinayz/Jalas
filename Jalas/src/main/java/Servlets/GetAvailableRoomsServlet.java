package Servlets;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/rooms")
public class GetAvailableRoomsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        HttpURLConnection connection = null;
//        String startTime=req.getParameter("start");
//        String endTime = req.getParameter("end");
//        URL url = new URL("http://213.233.176.40/available_rooms");
//        Map<String, String> parameters = new HashMap<>();
//        parameters.put("start", startTime);
//        parameters.put("end",endTime);

        try {
//                connection = (HttpURLConnection) url.openConnection();
//                connection.setRequestMethod("GET");
//                connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//                connection.setRequestProperty("Content-Language", "en-US");
//                connection.setRequestProperty("User-Agent", "Mozilla/5.0");
//                connection.setUseCaches(false);
//                connection.setDoOutput(true);
//
//                //Send request
//                DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
//                wr.writeBytes(ParameterStringBuilder.getParamsString(parameters));
//                wr.close();

            String startTime=req.getParameter("start");
            String endTime = req.getParameter("end");

            URIBuilder builder = new URIBuilder();
            builder.setScheme("http").setHost("213.233.176.40").setPath("/rooms")
                    .setParameter("start", startTime)
                    .setParameter("end",endTime);
            URI uri = null;
            try {
                uri = builder.build();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
                HttpClient httpclient = HttpClients.createDefault();
                HttpGet httpget = new HttpGet(uri);


                HttpResponse response = httpclient.execute(httpget);
                HttpEntity entity = response.getEntity();
                String json = EntityUtils.toString(entity);
                System.out.println(json);
                resp.setContentType("application/json; charset=UTF-8;");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(json);

//                InputStream is;
//                if (connection.getResponseCode() >= 200 && connection.getResponseCode()<=400) {
//                    is = connection.getInputStream();
//                    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
//                    StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
//                    String line;
//                    while ((line = rd.readLine()) != null) {
//                        System.out.println(line);
//                        response.append(line);
//                        response.append('\r');
//                    }
//
//                    resp.setContentType("application/json; charset=UTF-8;");
//                    resp.setCharacterEncoding("UTF-8");
//                    resp.getWriter().write(response.toString());
//                    rd.close();
//                }
//                if (connection.getResponseCode() == 400) {
//                    /* error from server */
//                    String response = "invalid start or end parameters ";
//                    resp.setContentType("application/json; charset=UTF-8;");
//                    resp.setCharacterEncoding("UTF-8");
//                    resp.getWriter().write(response.toString());
//                }
//                if (connection.getResponseCode() == 500) {
//                    String response = "reservation system has been crashed";
//                    resp.setContentType("application/json; charset=UTF-8;");
//                    resp.setCharacterEncoding("UTF-8");
//                    resp.getWriter().write(response.toString());
//                }

            } catch(Exception e){
                e.printStackTrace();
            }
//        finally {
//            if (connection != null) {
//                connection.disconnect();
//            }
//        }
    }
}
