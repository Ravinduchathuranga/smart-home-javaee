/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import entity.User;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.HibernateUtil;
import model.Validations;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author rc007
 */
@MultipartConfig
@WebServlet(name = "SignUp", urlPatterns = {"/SignUp"})
public class SignUp extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        JsonObject responseJson = new JsonObject();
        responseJson.addProperty("success", false);

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (name.isEmpty()) {
            responseJson.addProperty("message", "Please fill the name");
        } else if (email.isEmpty() || !Validations.isEmailValid(email)) {
            responseJson.addProperty("message", "Invalid email address");
        } else if (password.isEmpty() || password.length() < 8) {
            responseJson.addProperty("message", "Password must be at least 8 characters");
        } else if (name.isEmpty()) {
            responseJson.addProperty("message", "Please fill the name");
        } else {
            Session session = HibernateUtil.getSessionFactory().openSession();
            try {
                Criteria criteria = session.createCriteria(User.class);
                criteria.add(Restrictions.eq("email", email).ignoreCase());

                if (!criteria.list().isEmpty()) {
                    responseJson.addProperty("message", "Email already registerd");                    
                } else {
                    User user = new User();
                    user.setEmail(email);
                    user.setPassword(password);
                    user.setName(name);
                    user.setDate_joined(new Date());
                    user.setStatus("Active");

                    session.save(user);
                    session.beginTransaction().commit();

                    responseJson.addProperty("success", true);
                    responseJson.addProperty("message", "Registration completed");
                }
            } catch (Exception e) {
                e.printStackTrace();
                session.getTransaction().rollback();
                responseJson.addProperty("message", "An error occurred. Please try again.");
                //logger
            } finally {
                session.close();
            }
        }

        resp.setContentType("application/json");
        resp.getWriter().write(gson.toJson(responseJson));
    }
}
