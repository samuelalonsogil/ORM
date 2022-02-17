package test;

import daoModel.InquilinoDAO;

import java.util.Iterator;

public class DivideNameAndLastName {

    InquilinoDAO inquilinoDAO = new InquilinoDAO();

    public void query06(){
        Iterator iterator = inquilinoDAO.divideNames();
        while (iterator.hasNext()){
            Object[]row = (Object[]) iterator.next();
            System.out.println(row[0] + "" + row[1] + "" + row[2] + "" + row[3] );
        }
    }

    public static void main(String[] args) {
        DivideNameAndLastName divide = new DivideNameAndLastName();
        divide.query06();
    }
}
