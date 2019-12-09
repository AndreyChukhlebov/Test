Service is implemented only for positive cases.
ivoke 
./gradlew test or ./gradlew test --debug-jvm for debug in 5005 port

«Develop a configurable HTTP service emulator. The service must accept an HTTP request and return a configurable response.
The solution must be implemented in Java.
Assume that only XML or JSON data can be in request and response. The response can depend on data in the POST body, HTTP headers, and query string.
Include sample configuration for two services:
- Weather service. Returns weather information by city code. Accept parameter in a query string.
- Geo-location service. One of the available functions – returning time zone by ZIP. Accept request in POST body.
(Nice to have): add emulation of network issues.
(Nice to have): add logging of requests and responses»
