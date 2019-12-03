package Servlets;

import Models.Vote;
import com.google.gson.Gson;
import org.omg.CORBA.UserException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/vote")
public class VoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String employeeJsonString = new Gson().toJson(Vote.getVote());

        out.print(employeeJsonString);
        out.flush();
        //String projectId = request.getParameter("id");
//        try {
//            ProjectManager.addBidToProject(bidAmount, currentUser.getId(), projectId);
//            messageWithStatusCode.setStatusCode(200);
//            messageWithStatusCode.setMessage("Bid is submitted successfully.");
//        } catch (UserException | ProjectException e){
//            response.setStatus(404);
//            messageWithStatusCode.setStatusCode(404);
//            messageWithStatusCode.setMessage(e.getMessage());
//        } catch (BidException e) {
//            response.setStatus(400);
//            messageWithStatusCode.setStatusCode(400);
//            messageWithStatusCode.setMessage(e.getMessage());
//        }

    }
}
