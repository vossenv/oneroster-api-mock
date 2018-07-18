package com.dm.onerosterapi.utility;

public enum AllowedTypes {

    User("users"),
    Class("classes"),
    Course("courses"),
    School("schools"),
    Enrollment("enrollments"),
    Student("students"),
    Teacher("teachers");

    private final String objType;
    AllowedTypes(String objType) {this.objType = objType;}
    public String getObjType() {return objType;}
}
