package pl.sda.controller;

import pl.sda.dao.UserDao;
import pl.sda.dao.UserDaoImpl;
import pl.sda.model.User;
import pl.sda.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/changePass")
public class ChangePasswordController extends HttpServlet {
    RegisterValidationService registerValidationService = new RegisterValidationServiceImpl();
    UserService userService = new UserServiceImpl();
    AuthenticationService authenticationService = new AuthenticationServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (authenticationService.isAuthenticated(req)) {
            req.getRequestDispatcher("/WEB-INF/view/changePass.jsp").forward(req, resp);
        }else {
            req.setAttribute("notLoggedIn", true);
            req.getRequestDispatcher("/WEB-INF/view/changePass.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (authenticationService.isAuthenticated(req)) {
            String oldPass = req.getParameter("oldPass");
            String newPass = req.getParameter("newPass");
            User user = userService.getUser((String) req.getSession().getAttribute("username"));
            String email = user.getEmail();
            if (oldPass.equalsIgnoreCase(newPass)) {
                req.setAttribute("samePass", true);
                req.getRequestDispatcher("/WEB-INF/view/changePass.jsp").forward(req, resp);
            } else if (!registerValidationService.validatePassword(newPass)) {
                req.setAttribute("wrongPass", true);
                req.getRequestDispatcher("/WEB-INF/view/changePass.jsp").forward(req, resp);
            } else if (!oldPass.equals(user.getPassword())) {
                req.setAttribute("badPass", true);
                req.getRequestDispatcher("/WEB-INF/view/changePass.jsp").forward(req, resp);
            }else{
                user.setPassword(newPass);
                userService.saveUser(user);
                req.setAttribute("passChanged", true);
                req.getRequestDispatcher("/WEB-INF/view/changePass.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("notLoggedIn", true);
            req.getRequestDispatcher("/WEB-INF/view/changePass.jsp").forward(req, resp);
        }
    }
}
