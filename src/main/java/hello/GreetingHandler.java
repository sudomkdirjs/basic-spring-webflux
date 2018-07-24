package hello;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class GreetingHandler {

	public Mono<ServerResponse> hello(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
			.body(BodyInserters.fromObject("Hello, Spring!"));
	}
	
	public Mono<ServerResponse> hello1(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
			.body(BodyInserters.fromObject("Hello, World!"));
	}
	
	public Mono<ServerResponse> myName(ServerRequest request) {
		  String name = request.queryParam("name").get();
		  return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
		    .body(BodyInserters.fromObject("Hello, " + name + "!"));
		 }
}
