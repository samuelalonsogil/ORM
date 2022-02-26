package daoModel;

import connection.Connection;
import utilities.Utilities;
import voModel.Departamento;
import voModel.Empleado;

import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.Iterator;

public class DepartamentoDAO {
    public Utilities utilities = new Utilities();
    public Departamento departamento;
    public Connection myConnection = new Connection();

    /*ejercicio 4*/
    public Iterator listarDatosDepartamentos(){
        String hql = "SELECT em.departamento.nombre,COUNT(em.nombre), AVG(em.salario), MAX(em.salario), MIN(em.salario), AVG(em.comision) " +
                "FROM Empleado em GROUP BY em.departamento.nombre ";
        return utilities.stablishConnectionIterator(hql);
    }

    /*ejercicio 08*/
    public void deleteDepartamento(String nombre){
        String hql = "DELETE FROM Departamento de WHERE de.nombre = :nombre";

        try{
            myConnection.getConnection().getTransaction().begin();

            Query query01 = myConnection.getConnection().createQuery(hql);
            query01.setParameter("nombre", nombre).executeUpdate();
            myConnection.getConnection().getTransaction().commit();

        }catch (PersistenceException pe){
            pe.printStackTrace();
            myConnection.getConnection().getTransaction().rollback();

        }
        myConnection.disconnect();
    }

    /*ejercicio 09*/
    public void incrementarSueldosEmpleados(String departamento, int incremento) {
        String hql = "UPDATE Empleado em SET em.salario = em.salario + :incremento WHERE em.departamento.nombre= :departamento";

        try{
            myConnection.getConnection().getTransaction().begin();

            Query query01 = myConnection.getConnection().createQuery(hql);
            query01.setParameter("departamento", departamento).setParameter("departamento", departamento);
            query01.setParameter("incremento", incremento).setParameter("incremento", incremento);
            query01.executeUpdate();
            myConnection.getConnection().getTransaction().commit();

        }catch (PersistenceException pe){
            pe.printStackTrace();
            myConnection.getConnection().getTransaction().rollback();

        }
        myConnection.disconnect();
    }

    /*ej 7*/
    public Departamento findDepartamento(int codDep){
        return myConnection.getConnection().find(Departamento.class,codDep);
    }

    public void newDepartamento(Departamento departamento){
        utilities.connectionTransactions(departamento);

    }
}
