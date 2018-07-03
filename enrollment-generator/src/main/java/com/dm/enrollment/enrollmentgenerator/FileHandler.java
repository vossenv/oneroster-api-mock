/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dm.enrollment.enrollmentgenerator;

import com.dm.enrollment.enrollmentgenerator.data.Enrollment;
import com.dm.enrollment.enrollmentgenerator.data.SClass;
import com.dm.enrollment.enrollmentgenerator.data.User;
import com.dm.enrollment.enrollmentgenerator.exceptions.FileIOException;
import java.io.*;
import java.util.*;


public class FileHandler {

    private static final String DELIMITER = ",";            // Delimiter for reading and writing files
    private static final String DATEFORMAT = "yyyy-mm-dd hh:mm:ss";



    public List <Object> readDataFromFile(String filename, String dataType) throws FileIOException {
        Scanner scanner;
        List <Object> resultList = new ArrayList<>();

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(filename)));
        } catch (FileNotFoundException e) {
            throw new FileIOException("Could not open file.", e);
        }

        String currentline;
        String[] currentTokens;

        try {

            scanner.nextLine();
            while (scanner.hasNextLine()) {

                currentline = scanner.nextLine();
                try {
                    currentTokens = currentline.split(DELIMITER);

                    for (int i = 0; i < currentTokens.length; i++) {
                        currentTokens[i] = currentTokens[i].trim();
                    }
                    if (!currentTokens[0].startsWith("//")) {

                        switch (dataType){
                            case "user":
                                resultList.add(setUserProperies(currentTokens));
                                break;
                            case "class":
                                resultList.add(setClassProperies(currentTokens));
                                break;
                            case "enrollment":
                                resultList.add(setEnrollmentProperies(currentTokens));
                                break;
                        }

                    }
                } catch (Exception e) {
                    // Skips the line if there is a problem but continues reading file
                }

            }

        } catch (Exception e) {
            throw new FileIOException("Error reading file: empty or corrupt ", e);
        }

        if (resultList.isEmpty()) {
            throw new FileIOException("Error: no data found in "+ filename +". empty or corrupt");
        }

        scanner.close();
        return resultList;
    }

    private User setUserProperies(String [] line){
        User o = new User();
        o.setUserId(line[0]);
        o.setGrades(line[16]);
        o.setOrgId(line[8]);
        o.setRole(line[15]);
        return o;
    }

    private SClass setClassProperies(String [] line){
        SClass o = new SClass();

        o.setClassId(line[0]);
        o.setClassCode(line[6]);
        o.setOrgId(line[10]);
        o.setTerm(line[5]);
        return o;
    }

    private Enrollment setEnrollmentProperies(String [] line){

        Enrollment o = new Enrollment();

        o.setEnrollmentId(line[0]);
        o.setSourceId(line[1]);
        o.setStatus(line[2]);
        o.setDateLastModified(line[3]);

        return o;
    }


    public void writeAllEnrollments(List<Enrollment> enrollmentList, String filename) throws FileIOException {
        PrintWriter out = null;
        String header = "EnrollmentId,SourcedId,status,datLastModified,Metadata,UserId,ClassId,Primary,BeginDate,EndDate";

        try {
            out = new PrintWriter(new FileWriter(filename));
            out.write(header + "\n");
            for (Enrollment e : enrollmentList) {
                out.write(outputFormat(e));
            }
        } catch (IOException e) {
            throw new FileIOException("Error opening file.  Is it open"
                    + "\nin another application? ", e);
        } finally {

            if (out != null) {
                out.flush();
                out.close();
            }

        }

    }

    private String outputFormat(Enrollment e) {

       return (
                 e.getEnrollmentId() + DELIMITER
               + e.getSourceId() + DELIMITER
               + e.getStatus() + DELIMITER
               + e.getDateLastModified() + DELIMITER
               + e.getMetadata() + DELIMITER
               + e.getUserId() + DELIMITER
               + e.getClassId() + DELIMITER
               + e.getPrimary() + DELIMITER
               + e.getBegindate() + DELIMITER
               + e.getEnddate()
               + "\n");
    }


}