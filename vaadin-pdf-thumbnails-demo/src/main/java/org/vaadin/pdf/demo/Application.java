package org.vaadin.pdf.demo;


import com.vaadin.spring.annotation.EnableVaadin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableVaadin
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run((Application.class), args);
    }
}

