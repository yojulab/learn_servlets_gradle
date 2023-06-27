package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/session/DeleteJSPServlet")
public class SessionDeleteJSPServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // expired session
            HttpSession httpSession = request.getSession();
            httpSession.invalidate();   // Server side

            // delete cookies
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                String value = cookie.getValue();
                if (name.equals("JSESSIONID")) { // 쿠키 삭제 - Client side
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }            

            // 다음 파일 호출
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/hellowordJSP.jsp");
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
