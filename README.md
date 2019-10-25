# Using hystrix circuit breaker with rest-template

## Demonstrate rest-template with client slide load balancing

We are using rest-template for inter-microservice call. Quote service is calling catalog-service while adding quotes. 

Inject the bean in QuoteServiceApplication

```
@Bean
@LoadBalanced
RestTemplate restTemplate() {
	return new RestTemplate();
}
```

Calling service using rest-template.

```
ResponseEntity<List<CatalogDto>> response = restTemplate.exchange(
				  "http://CATALOG-SERVICE/catalog-api/catalogs",
				  HttpMethod.GET,
				  null,
				  new ParameterizedTypeReference<List<CatalogDto>>(){});

```

### Client side vs server side load balancing:
--1. Server side load balancing is distributing the incoming requests towards multiple instances of the service.
--2. Client side load balancing is distributing the outgoing request from the client itself.

- Spring RestTemplate can be used for client side load balancing.
- Spring Netflix Eureka has a built-in client side load balancer called Ribbon.
- Ribbon can automatically be configured by registering RestTemplate as a bean and annotating it with **@LoadBalanced**.
- **@LoadBalanced**  - when added to rest template, we can access a service by its name, otherwise the hostname and port is required to call the service.




----------------------------------------------------------------------------------------------------------------------------------------

## Using hystrix as circuit breaker


- dependency required for spring-boot 2.1.4.RELEASE

```
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
		</dependency>

Added following dependency for dashboard(optional):
		
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-hystrix-dashboard</artifactId>
			<version>1.1.5.RELEASE</version>
		</dependency>
```
- annotate application class with following to enable circuit-breaker:

```
@EnableCircuitBreaker
@EnableHystrixDashboard
public class QuoteServiceApplication
```

- annotate service method to configure fallback method:

```
@HystrixCommand(fallbackMethod = "addQuotesFallback")
	public List<QuoteDto> addQuotes(List<QuoteDto> quotes) {
```

- define a fallback method with same signature.

```
public List<QuoteDto> addQuotesFallback(List<QuoteDto> quotes){
		return  new ArrayList();
	}
```


### configuring circuit breaker properties:

```
# In this window if a certain percent of failures(say 50%) happen for a threshold of 
# requests(say 20 in 10 seconds) then the circuit is broken
hystrix.command.default.metrics.rollingStats.timeInMilliseconds=10000
hystrix.command.default.circuitBreaker.requestVolumeThreshold=20
hystrix.command.default.circuitBreaker.errorThresholdPercentage=60

# Once a circuit is broken, it stays that way for a time set the following way, 5 seconds in this instance:
hystrix.command.default.circuitBreaker.sleepWindowInMilliseconds=5000

```
