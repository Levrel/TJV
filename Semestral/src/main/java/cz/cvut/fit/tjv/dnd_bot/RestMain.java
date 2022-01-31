package cz.cvut.fit.tjv.dnd_bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/*@ComponentScan//Finds and uses components
@EnableAutoConfiguration//Which server to deploy and use
@SpringBootConfiguration//Tests and such*/
@SpringBootApplication
public class RestMain {
    public static void main(String[] args){
        SpringApplication.run(RestMain.class, args);//Runs webserver
    }
}
