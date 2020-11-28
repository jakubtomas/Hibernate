package Homework.Demo;

import Homework.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
*/

public class CreateStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                //.addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Student.class)
                //.addAnnotatedClass(InstructorDetail.class)
                //.addAnnotatedClass(Course.class)
                .addAnnotatedClass(Pen.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // create the objects
/*
            Instructor tempInstructor =
                    new Instructor("Susan", "Public", "susan.public@luv2code.com");
*/

            Student tempStudent = new Student("Jacob", "second", "0000000");

/*
            InstructorDetail tempInstructorDetail =
                    new InstructorDetail(
                            "http://www.youtube.com",
                            "Video Games");

            // associate the objects
            tempInstructor.setInstructorDetail(tempInstructorDetail);
*/

            // start a transaction
            session.beginTransaction();

            // save the instructor
            //
            // Note: this will ALSO save the details object
            // because of CascadeType.ALL
            //
            System.out.println("Saving Student: " + tempStudent);
            session.save(tempStudent);

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





