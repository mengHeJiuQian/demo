package book1.spring5guanwang.ioc.clientDao;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: sheldon
 * @Create Date: 2019/11/11 17:51
 * @Update Date: 2019/11/11 17:51
 */
@Configuration
public class AppConfig {

    @Bean
    public ClientService clientService1() {
        ClientDao clientDao = clientDao();
        System.out.println("clientService1() -> clientDao = " + clientDao);
        ClientServiceImpl clientService = new ClientServiceImpl();
        clientService.setClientDao(clientDao);
        return clientService;
    }

    @Bean
    public ClientService clientService2() {
        ClientDao clientDao = clientDao();
        System.out.println("clientService2() -> clientDao = " + clientDao);
        ClientServiceImpl clientService = new ClientServiceImpl();
        clientService.setClientDao(clientDao);
        return clientService;
    }

    @Bean
    public ClientDao clientDao() {
        ClientDaoImpl clientDao = new ClientDaoImpl();
        System.out.println("clientDao()" + clientDao);
        return clientDao;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(AppConfig.class);
        ac.refresh();

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    }

}

interface ClientDao {

}
class ClientDaoImpl implements ClientDao {

}
interface ClientService {

}
class ClientServiceImpl implements ClientService {

    public void setClientDao(ClientDao clientDao) {
    }
}
