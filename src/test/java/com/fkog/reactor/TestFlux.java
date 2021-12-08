package com.fkog.reactor;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;

public class TestFlux {

	@Test
	@Disabled
	public void test1() {
		Flux.just("Hello", "World").subscribe(System.out::println);
	}

	@Test
	@Disabled
	public void test2() {
		List<String> words = List.of("this", "is", "a", "list", "of", "words");

		Flux.just(words).subscribe(System.out::println);

		System.out.println("--------------");

		Flux.fromIterable(words).subscribe(System.out::println);

	}

	@Test
	@Disabled
	public void test3() throws Exception {
		List<String> words = List.of("this", "is", "a", "list", "of", "words");
		Flux.fromIterable(words).zipWith(Flux.range(1, 10), (f1, f2) -> f2 + ". " + f1).subscribe(System.out::println);
	}

	@Test
	@Disabled
	public void test4() throws Exception {
		List<String> words = List.of("this", "is", "a", "list", "of", "words");
		Flux.fromIterable(words).flatMap(w -> Flux.fromArray(w.split(""))).distinct().sort()
//		.log()
				.zipWith(Flux.range(1, 30), (f1, f2) -> f2 + ". " + f1).subscribe(System.out::println);
	}

	@Test
	public void test5() {
		Flux fastFlux = Flux.interval(Duration.ofSeconds(1)).map(tick -> "fast " + tick);
		Flux slowFlux = Flux.interval(Duration.ofSeconds(2)).map(tick -> "slow " + tick);

		Flux clock = Flux.merge(fastFlux.filter(tick -> isFastClock()), slowFlux.filter(tick -> isSlowClock()));

//		clock.subscribe(System.out::println);

		Flux feeds = Flux.interval(Duration.ofSeconds(1)).map(tick -> LocalTime.now());

		clock.withLatestFrom(feeds, (tick, feed) -> tick + " " + feed).subscribe(System.out::println);

	}

	private boolean isSlowClock() {
		return true;
	}

	private boolean isFastClock() {
		return true;
	}

	@AfterEach
	public void after() throws InterruptedException {
		TimeUnit.SECONDS.sleep(10);
	}

}
