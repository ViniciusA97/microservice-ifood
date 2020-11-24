package microservice.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@Slf4j
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);

	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		log.info("lb://CLIENT");
		return builder.routes()
				.route(r -> r.path("/discovery/**")
						.filters(f -> f.rewritePath("/discovery", ""))
						.uri("http://localhost:8081")
						.id("discovery-service"))
				.route(r -> r.path("/client/**")
						.filters(f -> f.rewritePath("/client", ""))
						.uri("http://localhost:8082")
						.id("client-service"))
				.build();
	}

}
