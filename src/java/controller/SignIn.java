package controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author rc007
 */
@WebServlet(name = "SignIn", urlPatterns = {"/SignIn"})
public class SignIn extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new Gson();
        JsonObject resoObject = new JsonObject();
        resoObject.addProperty("success", false);
        try {
            JsonObject jsonObject = gson.fromJson(request.getReader(), JsonObject.class);
            String email = jsonObject.get("email").getAsString();
            String password = jsonObject.get("password").getAsString();

            if (email.isEmpty()) {
                resoObject.addProperty("message", "Please insert your email");
            } else if (password.isEmpty()) {
                resoObject.addProperty("message", "Please insert your password");
            } else {
                Session session = HibernateUtil.getSessionFactory().openSession();
                Criteria criteria = session.createCriteria(User.class);

                criteria.add(Restrictions.eq("email", email));
                criteria.add(Restrictions.eq("password", password));

                if (!criteria.list().isEmpty()) {
                    User user = (User) criteria.uniqueResult();
                    resoObject.addProperty("success", true);
                    resoObject.addProperty("message", "welcome");
                    resoObject.add("user", gson.toJsonTree(user));
                } else {
                    resoObject.addProperty("message", "Incorrect password! Please try again");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.setContentType("application/json");
        response.getWriter().write(gson.toJson(resoObject));
    }

}
