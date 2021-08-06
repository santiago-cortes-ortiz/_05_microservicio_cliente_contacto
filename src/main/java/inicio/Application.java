package inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate template(){
        BasicAuthenticationInterceptor interceptor;
        interceptor = new BasicAuthenticationInterceptor("admin","admin");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(interceptor);
        return restTemplate;
    }

}
