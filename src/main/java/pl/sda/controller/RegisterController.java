package pl.sda.controller;

import pl.sda.dao.UserDao;
import pl.sda.dao.UserDaoImpl;
import pl.sda.entity.UserEntity;
import pl.sda.service.RegisterValidationService;
import pl.sda.service.RegisterValidationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterController extends HttpServlet {

    RegisterValidationService registerValidationService = new RegisterValidationServiceImpl();
    UserDao userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/registerForm.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        if (registerValidationService.validateNewUser(firstName, lastName,email,login,password)){
            UserEntity newUser = UserEntity.builder()
                    .email(email)
                    .login(login)
                    .name(firstName)
                    .password(password)
                    .surname(lastName)
                    .build();
            userDao.saveUser(newUser);
            req.getRequestDispatcher("/WEB-INF/view/registerSuccess.jsp").forward(req,resp);
        }
        else {
            req.getRequestDispatcher("/WEB-INF/view/registerFail.jsp").forward(req,resp);
        }


    }
}
