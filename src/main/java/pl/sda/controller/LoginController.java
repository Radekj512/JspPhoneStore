package pl.sda.controller;

import com.sun.net.httpserver.HttpPrincipal;
import pl.sda.dao.UserDao;
import pl.sda.dao.UserDaoImpl;
import pl.sda.entity.UserEntity;
import pl.sda.model.User;
import pl.sda.service.AuthenticationService;
import pl.sda.service.AuthenticationServiceImpl;
import pl.sda.service.UserService;
import pl.sda.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    UserService userService = new UserServiceImpl();
    AuthenticationService authenticationService = new AuthenticationServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        boolean authenticated = authenticationService.authenticate(req);
        if(authenticated){
            String username = req.getParameter("username");
            String password = req.getParameter("pass");
            req.getSession().setAttribute("isLogin", true);
            resp.sendRedirect("/");
        }else{
            req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req,resp);
        }

    }
}
