package com.karani.cruddemo;

import com.karani.cruddemo.dao.AppDAO;
import com.karani.cruddemo.entity.Instructor;
import com.karani.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
            createInstructor(appDAO);
        };
    }

    private void createInstructor(AppDAO appDAO) {
        /*
        Instructor tempInstructor = new Instructor("Timothy", "Karani", "timothy@karani.com");

        InstructorDetail tempInstructorDetail =
                new InstructorDetail(
                        "http://www.karani.com/youtube",
                        "Luv 2 Code!!!");
        */

        Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@patel.com");

        InstructorDetail tempInstructorDetail =
                new InstructorDetail(
                        "http://www.karani.com/youtube",
                        "Guitar");

        // associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // save the instructor
        //
        // NOTE: this will ALSO save the details object
        // because of CascadeType.ALL
        //
        System.out.println("Saving instructor: " + tempInstructor);
        appDAO.save(tempInstructor);

        System.out.println("Done!");
    }
}
