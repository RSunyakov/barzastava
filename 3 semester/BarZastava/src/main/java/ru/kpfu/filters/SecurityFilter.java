package ru.kpfu.filters;

import ru.kpfu.services.SecurityService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter("/*")
public class SecurityFilter extends HttpFilter {
    protected final String[] protectedPaths = {"/profile", "/edit"};
    private SecurityService securityService;

    @Override
    public void init() throws ServletException {
        securityService = new SecurityService();
    }

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        boolean prot = false;
        for (String path : protectedPaths) {
            if (path.equals(req.getRequestURI().substring(req.getContextPath().length()))) {
                prot = true;
                break;
            }
        }
        if (prot && !securityService.isSigned(req)) {
            res.sendRedirect(req.getContextPath() + "/signin");
        }
        else {
            if (securityService.isSigned(req)) {
                req.setAttribute("user", securityService.getUser(req));
                req.setAttribute("roles", req.getSession().getAttribute("roles"));
            }
            chain.doFilter(req, res);
        }
    }
}
