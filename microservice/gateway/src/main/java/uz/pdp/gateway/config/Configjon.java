package uz.pdp.gateway.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configjon {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route( r -> r.path("/api/v1/first/**")
                        .uri("lb://FIRST-SERVICE"))
                .route( r -> r.path("/api/v1/second/**")
                        .uri("lb://SECOND-SERVICE")).
                route( r -> r.path("/api/v1/third/**")
                        .uri("lb://THIRD-SERVICE"))
                .build();
    }

}
