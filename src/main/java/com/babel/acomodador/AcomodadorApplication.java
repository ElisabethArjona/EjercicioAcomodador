package com.babel.acomodador;

import com.babel.acomodador.configuration.AppConfig;
import com.babel.acomodador.controller.AcomodadorApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class AcomodadorApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        AcomodadorApp acomodadorApp = context.getBean(AcomodadorApp.class);

        acomodadorApp.run();;
    }

}
