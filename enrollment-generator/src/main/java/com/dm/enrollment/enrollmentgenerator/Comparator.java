package com.dm.enrollment.enrollmentgenerator;

import com.dm.enrollment.enrollmentgenerator.data.SClass;
import com.dm.enrollment.enrollmentgenerator.data.Enrollment;
import com.dm.enrollment.enrollmentgenerator.data.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Comparator {

    List<User> masterUserList;
    List<SClass> masterClassList;

    @SuppressWarnings("unchecked")
    public void compare() throws Exception{

        FileHandler f = new FileHandler();
        List<Enrollment> enrollmentList = new ArrayList<>();

        List<User> userList = (List<User>)(List<?>) f.readDataFromFile("./Users.csv", "user");
        List<SClass> classList = (List<SClass>)(List<?>) f.readDataFromFile("./Classes.csv", "class");
        List<Enrollment> enrollmentPool = (List<Enrollment>)(List<?>) f.readDataFromFile("./Enrollments_Template.csv", "enrollment");

        for (SClass c : classList){

            String level = "06";

            if (c.getClassCode().contains("III")) {
                level = "08";
            } else if (c.getClassCode().contains("II")) {
                level = "07";
            }

            for (User u : userList) {

                if ((
                        u.getGrades().equals(level)
                        && u.getOrgId().equals(c.getOrgId()))
                        || u.getGrades().equals("UG")){

                    String courseName = c.getClassCode().split(" ")[0];

                    if (c.getTerm().equals("Fall")){
                        if (u.getFallMap().get(courseName)){

                            Enrollment e = enrollmentPool.remove(0);
                            e.setClassId(c.getClassId());
                            e.setUserId(u.getUserId());
                            e.setBegindate("2018-09-01 00:00");
                            e.setEnddate("2019-01-01 00:00");

                            if(u.getRole().equals("teacher")){
                                e.setPrimary("1");
                            }

                            u.getEnrollmentList().add(e);
                            u.getFallMap().put(courseName,false);
                        }
                    } else {
                        if (u.getSpringMap().get(courseName)){

                            Enrollment e = enrollmentPool.remove(0);
                            e.setClassId(c.getClassId());
                            e.setUserId(u.getUserId());
                            e.setBegindate("2019-01-15 00:00");
                            e.setEnddate("2019-06-30 00:00");

                            if(u.getRole().equals("teacher")){
                                e.setPrimary("1");
                            }

                            u.getEnrollmentList().add(e);
                            u.getSpringMap().put(courseName,false);
                        }
                    }
                }
            }
        }

        this.masterClassList = classList;
        this.masterUserList = userList;

    }

    public void writeCSV() throws Exception{

        List<Enrollment> enrollmentList = new ArrayList<>();
        for (User u : this.masterUserList){
            enrollmentList.addAll(u.getEnrollmentList());
        }

        FileHandler f = new FileHandler();
        f.writeAllEnrollments(enrollmentList,"Enrollments_out.csv");

    }


}
