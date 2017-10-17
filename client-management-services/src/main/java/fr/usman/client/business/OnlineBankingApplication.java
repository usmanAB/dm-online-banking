package fr.usman.client.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by Ance on 17/10/2017.
 */

@EnableAspectJAutoProxy(proxyTargetClass = true)
@SpringBootApplication
public class OnlineBankingApplication {

        public static void main(String[] args) {
            SpringApplication.run(OnlineBankingApplication.class, args);
        }


}
