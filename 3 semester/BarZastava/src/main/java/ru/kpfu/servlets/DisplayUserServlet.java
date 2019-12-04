package ru.kpfu.servlets;

import ru.kpfu.models.UserForHw;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class DisplayUserServlet extends HttpServlet {
    private List<UserForHw> userForHwList;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Scanner sc = new Scanner(new File("C:\\Code\\TomCat\\bin\\data.csv"));
        List<String> data = new ArrayList<>();
        userForHwList = new ArrayList<>();
        int i = 0;
        while (sc.hasNextLine()) {
            data.add(sc.nextLine());
            String[] userData = data.get(i).split(",");
            userForHwList.add(new UserForHw(userData[0], userData[1], userData[2], userData[3], userData[4], userData[5], userData[6]));
            i++;
        }
        /*Cookie[] cookies = req.getCookies();
        Cookie sortCookie = null;
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("sort")) {
                    sortCookie = c;
                    break;
                }
            }
        }*/
        HttpSession session = req.getSession();
        String sort = (String) session.getAttribute("sort");
        /*if (sortCookie != null && sortCookie.getValue().equals("name")) {
            userList.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        }
        if (sortCookie != null && sortCookie.getValue().equals("country")) {
            userList.sort((o1, o2) -> o1.getCountry().compareTo(o2.getCountry()));
        }*/
        if (sort != null && sort.equals("name")) {
            userForHwList.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
            session.setAttribute("sort", "name");
        }
        if (sort != null && sort.equals("country")) {
            userForHwList.sort((o1, o2) -> o1.getCountry().compareTo(o2.getCountry()));
            session.setAttribute("sort", "country");
        }
        req.setAttribute("userList", userForHwList);
        RequestDispatcher view=req.getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
        view.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
       /* Cookie sortCookie = new Cookie("sort", "");*/
        if (req.getParameter("nameButton") != null) {
           /*sortCookie.setValue("name");*/
            session.setAttribute("sort", "name");
        }
        if (req.getParameter("countryButton") != null) {
          /*  sortCookie.setValue("country");*/
            session.setAttribute("sort", "country");
        }
        req.setAttribute("userList", userForHwList);
       /* resp.addCookie(sortCookie);*/
        resp.sendRedirect("display");
    }
}
