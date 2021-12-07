package com.fkog.reactor;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import reactor.core.publisher.Flux;

public class ExamplesFromSimonBasleVideo {
	public static void main(String[] args) throws InterruptedException {
		Flux<Long> coldFlux = Flux.interval(Duration.ofSeconds(1));
//		Thread.sleep(2000);
		coldFlux.subscribe(e -> System.out.println(e), err -> err.printStackTrace(),
				() -> System.out.println("completed"));
		TimeUnit.SECONDS.sleep(10);
		
	}
}
