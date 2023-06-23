package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/cookies/CreateServlet")
public class CookiesCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // cookies
            Cookie cookie_first = new Cookie("firstName", "Yoju!");
            Cookie cookie_second = new Cookie("secondName", "Lab!");

            response.addCookie(cookie_first);
            response.addCookie(cookie_second);

            // display
            PrintWriter printWriter = response.getWriter();
            String content = "<div>CreateCookieServlets</div>";
            printWriter.println(content);
            printWriter.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
