# Demonstrate zuul as a secure api gateway

Idea is to put zuul as an api gateway. Any request to the underlying microservices has to pass through the api gateway. 
ZuulGateway uses spring security to secure the endpoints. 

At gateway we have mapped two urls: 
- One for auth-service: http://localhost:9092/auth
 As per the security mappings any request to /auth/** does not need to be authenticated but instead uses the user name and password passed as payload to
generate a jwt if the credentials are correct. The below payload will add a jwt in response header.

```
{
	"username":"admin",
	"password":"12345"
}

```


- Other for catalog-service: http://localhost:9092/catalog/catalog-api/catalogs
Any request to /catalog/** needs to be authenticated and user role should be admin to successfully serve the request, else will return unauthorized response.
To authenticate add the jwt from above response to any request at catalog-api.

----------------------------------------------------------------------------------------------------------------------------------------
## Working

### Auth-service:

Uses authentication filter to filter the request and if username and password is found, delegate the details to auth manager to authenticate.
Auth manger uses UserDetailsServiceImpl to authenticate the request and after successful authentication a jwt is generated and attached to header.

### ZuulGateway:

As any request arrives, the gateway authentication filter checks for jwt in header, if no header is present the request is passed to other filter in the 
filter chain and is served as per mappings provided in SecurityTokenConfig.
On the other hand if jwt token is present, it is verified and user is authenticated and the authention details is added to SecurityContextHolder.
Again the further request processing is done as per mappings provided in SecurityTokenConfig.

