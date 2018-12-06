package apps;

import org.springframework.boot.SpringApplication;

/**
 * @Description TODO
 * @Author shuyun
 * @Date 2018/11/30 18:01
 */
public class CommandLineRunnerApplication {

    public static void main(String[] args) {
        System.out.println("The service to start.");
        SpringApplication.run(CommandLineRunnerApplication.class, args);
        System.out.println("The service has started.");
    }

}
