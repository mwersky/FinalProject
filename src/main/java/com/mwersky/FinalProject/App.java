package com.mwersky.FinalProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.mwersky.FinalProject")
@SpringBootApplication
public class App //Annotations provide metadata to our application to help with behind the scene configuration. in this case it'll look for all the components and sub components from the mvnProject API
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
