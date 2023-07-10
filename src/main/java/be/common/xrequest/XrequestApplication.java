package be.common.xrequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan({
//        "be.common.xrequest.controller",
//        "be.common.xrequest.service",
//        "be.common.xrequest.repository",
//        "be.common.xrequest.domain",
//        "be.common.xrequest.mapper",
//})
//@EntityScan("com.common.xrequest.domain")
//@EnableJpaRepositories("be.common.xrequest.repository")
public class XrequestApplication {
    public static void main(String[] args) {
        SpringApplication.run(XrequestApplication.class, args);
    }
}
