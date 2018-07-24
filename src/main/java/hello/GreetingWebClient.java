package hello;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

public class GreetingWebClient {
	private WebClient client = WebClient.create("http://localhost:8080");

	private Mono<ClientResponse> result = client.get()
			.uri("/hello-spring")
			.accept(MediaType.TEXT_PLAIN)
			.exchange();
	
	private Mono<ClientResponse> result1 = client.get()
			.uri("/hello-world")
			.accept(MediaType.TEXT_PLAIN)
			.exchange();

	public String getResult() {
		return ">> result = " + result.flatMap(res -> res.bodyToMono(String.class)).block();
	}
	
	public String getResult1() {
		return ">> result = " + result1.flatMap(res -> res.bodyToMono(String.class)).block();
	}
}
