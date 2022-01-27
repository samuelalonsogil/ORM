package tests;

import model.Proyecto;
import model.Trabajador;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Test01 {
    public static EntityManagerFactory emf;
    public static EntityManager em;

    public static void insertData(){
        emf = Persistence.createEntityManagerFactory("HibernateEjemplo1");
        em = emf.createEntityManager();

        Proyecto proyecto01 = new Proyecto("Luna");
        Proyecto proyecto02 = new Proyecto("Sol");
        Proyecto proyecto03 = new Proyecto("Estrella");
        Proyecto proyecto04 = new Proyecto("Planeta");

        em.getTransaction().begin();
        em.persist(proyecto01);
        em.persist(proyecto02);
        em.persist(proyecto03);
        em.persist(proyecto04);


        /*crear lista de proyectos que le voy a asignar a cada trabajador*/
        List<Proyecto> proyectos01 = new ArrayList<Proyecto>();
        proyectos01.add(proyecto01);
        proyectos01.add(proyecto02);

        List<Proyecto> proyectos02 = new ArrayList<Proyecto>();
        proyectos02.add(proyecto03);
        proyectos02.add(proyecto04);

        /*crear trabajador*/
        Trabajador trabajador01 = new Trabajador("Samuel",2500, proyectos01);
        em.persist(trabajador01);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public static void main(String[] args) {
        insertData();
    }
}
