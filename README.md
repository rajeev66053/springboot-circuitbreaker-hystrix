# Springboot circuit breaker-hystrix

* Cascading failure at one service results in failure to the calling service and this failure goes on to the application
  who made the initial call.
* Different circuit breaker pattern providers are:
    1. Hystrix -provided by netflix
    2. Spring Retry
    3. Resilence4j

* Hystrix is a latency and fault tolerance library designed to isolated points of access of remote systems.services and
  3rd party libraries.
* Hystrix will stop cascading failure.
* Hystrix enabled resiliencey in complex distributed systems where failure is inevitable.