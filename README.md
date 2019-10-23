# Demonstrate rest-template with client slide load balancing

We are using rest-template for inter-microservice call. Quote service is calling catalog-service while adding quotes. 

Inject the bean QuoteServiceApplication

```
@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
```

Calling service using rest-template.

```
ResponseEntity<List<CatalogDto>> response = restTemplate.exchange("http://CATALOG-SERVICE/catalog-api/catalogs",
				  HttpMethod.GET,
				  null,
				  new ParameterizedTypeReference<List<CatalogDto>>(){});

```

## Client side vs server side load balancing:
1. Server side load balancing is distributing the incoming requests towards multiple instances of the service.
2. Client side load balancing is distributing the outgoing request from the client itself.

- Spring RestTemplate can be used for client side load balancing.


Spring Netflix Eureka has a built-in client side load balancer called Ribbon.
* Ribbon can automatically be configured by registering RestTemplate as a bean and annotating it with **@LoadBalanced**.
* **@LoadBalanced**  - when added to rest template, we can access a service by its name, otherwise the hostname and port is required to call the service.




----------------------------------------------------------------------------------------------------------------------------------------

