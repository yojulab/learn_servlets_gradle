package com.example.study_servlets.daos;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.study_servlets.commons.Commons;

public class PollsDao {
    public ArrayList SelectWithSearch(String search) {
        ArrayList InforList = new ArrayList<>();
        try {
            Commons commons = new Commons();
            Statement statement = commons.getStatement(); // Editor in Workbanch
            String query = "SELECT T_QC.QUESTIONS_ID, T_QC.CHOICE_ID, T_Q.QUESTIONS, T_C.CHOICE \n" + //
                    "FROM question_choice as T_QC\n" + //
                    "\tinner join questions as T_Q\n" + //
                    "    on T_QC.QUESTIONS_ID = T_Q.QUESTIONS_ID\n" + //
                    "    inner join choice as T_C\n" + //
                    "    on T_QC.CHOICE_ID = T_C.CHOICE_ID\n" + //
                    "order by T_QC.QUESTIONS_ID, T_QC.CHOICE_ID    \n" + //
                    ";";
            ResultSet resultSet = statement.executeQuery(query);

            HashMap InforRecord = new HashMap<>();
            while (resultSet.next()) {
                InforRecord = new HashMap<>();
                InforRecord.put("QUESTIONS_ID", resultSet.getString("QUESTIONS_ID"));
                InforRecord.put("CHOICE_ID", resultSet.getString("CHOICE_ID"));
                InforRecord.put("QUESTIONS", resultSet.getString("QUESTIONS"));
                InforRecord.put("CHOICE", resultSet.getString("CHOICE"));

                InforList.add(InforRecord);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return InforList;
    }    
}
