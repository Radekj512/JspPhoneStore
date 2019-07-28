package pl.sda.service;

import javax.servlet.http.HttpServletRequest;

public interface AuthenticationService {
    boolean authenticate(HttpServletRequest request);

    boolean isAuthenticated(HttpServletRequest req);
}
