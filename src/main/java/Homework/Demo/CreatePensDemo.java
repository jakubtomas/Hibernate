package Homework.Demo;

import Homework.entity.Pen;
import Homework.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreatePensDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Pen.class)
               // .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            // get the instructor from db
            int theId = 1;
            Student tempStudent = session.get(Student.class, theId);

            // create some courses
            Pen tempPen1 = new Pen("pero 22","DOng");
            Pen tempPen2 = new Pen("pero 23" , "dong");

            // add courses to instructor
            tempStudent.add(tempPen1);
            tempStudent.add(tempPen2);

            // save the courses
            session.save(tempPen1);
            session.save(tempPen2);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {

            // add clean up code
            session.close();

            factory.close();
        }
    }

}





