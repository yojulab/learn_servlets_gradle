package com.example.study_servlets.controlls;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.study_servlets.daos.PollsDao;

@WebServlet(urlPatterns = "/poll/SurveyDone")
public class PollSurveyDone extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HashMap<String, Object> map = new HashMap<String, Object>();

            Enumeration<String> enumber = request.getParameterNames();

            // print params
            while (enumber.hasMoreElements()) {
                String key = enumber.nextElement().toString();
                String value = request.getParameter(key);
                System.out.println(key +", "+ value);
                map.put(key, value);
            }

            PollsDao pollsDao = new PollsDao();
            pollsDao.Insert(map);
            // 다음 파일 호출
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/simples.jsp");
            requestDispatcher.forward(request, response);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
