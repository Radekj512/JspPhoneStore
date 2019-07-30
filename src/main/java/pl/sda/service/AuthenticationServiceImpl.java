package pl.sda.service;

import pl.sda.model.User;

import javax.servlet.http.HttpServletRequest;

public class AuthenticationServiceImpl implements AuthenticationService {
    UserService userService = new UserServiceImpl();


    @Override
    public boolean authenticate(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("pass");
        User user = userService.getUser(username);
        if (user != null && user.getPassword().equals(password)) {
            request.getSession().setAttribute("isAuthenticated", true);
            return true;
        }
        request.getSession().setAttribute("isAuthenticated", false);
        return false;
    }

    @Override
    public boolean isAuthenticated(HttpServletRequest req) {
        if (req.getSession().getAttribute("isAuthenticated") != null) {
            return (boolean) req.getSession().getAttribute("isAuthenticated");
        }
        return false;
    }
}
