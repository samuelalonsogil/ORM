package test;

import daoModel.DepartamentoDAO;
import voModel.Departamento;

import java.util.Iterator;

public class Query04 {

    DepartamentoDAO departamentoDAO = new DepartamentoDAO();

    public void query04(){
        Iterator iterator = departamentoDAO.listarDatosDepartamentos();
        while (iterator.hasNext()){
            Object[]row = (Object[]) iterator.next();
            System.out.println("nombre_departamento : " + row[0] + "\nnum_trabajadores : " + row[1] +
                    "\nmedia_salario: " + row[2] +"\nmax_salario: " + row[3] + "\nmin_salario: " + row[4] +
                    "\navg_comisiones: " + row[5] +
                    "\n----------------------------------------------------------------");
        }
    }

    public static void main(String[] args) {
        Query04 query04 = new Query04();
        query04.query04();
    }
}
