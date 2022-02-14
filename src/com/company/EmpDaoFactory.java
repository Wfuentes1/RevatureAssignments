package com.company;

public class EmpDaoFactory {

    private static EmployeeDao dao;

    private EmpDaoFactory(){

    }

    public static EmployeeDao getEmployeeDao(){
        if(dao==null){
            dao = new EmployeeDaoImpl() {
            };
        }
        return dao;
    }
}
