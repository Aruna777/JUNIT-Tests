package com.example.Testing;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import reactor.test.publisher.TestPublisher;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReactiveTest {
    @Test
    void testFluxWithStepVerifier() {
        Flux<String> flux1 = Flux.just("Hello", "Reactive", "World");
        StepVerifier.create(flux1)
                .expectNext("Hello")
                .expectNext("Reactive")
                .expectNext("World")
                .verifyComplete();
    }

    @Test
    void testMonoWithError(){
        Mono<String> mono1 = Mono.error(new RuntimeException("Invalid input"));
        StepVerifier.create(mono1)
                .expectErrorMatches(throwable -> throwable instanceof RuntimeException
                        && throwable.getMessage().equals("Invalid input"))
                .verify();
    }

    @Test
    void testFluxConcatWithError() {
        Flux<Integer> flux = Flux.just(1, 2, 3).concatWith(Flux.error(new RuntimeException("Oops!")));
        StepVerifier.create(flux)
                .expectNext(1, 2, 3)
                .expectErrorMatches(throwable -> throwable instanceof RuntimeException
                        && throwable.getMessage().equals("Oops!"))
                .verify();
    }

    @Test
     void consumeNextWithTest() {
        StepVerifier.create(Flux.just("A", "B", "C"))
                .consumeNextWith(i -> assertEquals("A", i))
                .consumeNextWith(i -> assertEquals("B", i))
                .consumeNextWith(i -> assertEquals("C", i))
                .verifyComplete();
    }

    @Test
     void consumeErrorWithTest(){
        StepVerifier.create(Flux.error(new RuntimeException("Error")))
                .consumeErrorWith(error-> assertTrue(error.getMessage().contains("Error")))
                .verify();
    }

    @Test
    void VerifyErrorTest(){
        StepVerifier.create(Mono.error(new RuntimeException("Error")))
                .verifyError();
    }

    @Test
    void VerifyCompleteTest(){
        StepVerifier.create(Mono.empty())
                .verifyComplete();
    }

    @Test
    void thenCancelTest(){
        StepVerifier.create(Flux.interval(Duration.ofMillis(100)).take(5))
                .expectNext(0L, 1L)
                .thenCancel()
                .verify();
    }

    @Test
    public void thenConsumeWhileTest() {
        StepVerifier.create(Flux.range(1, 4))
                .thenConsumeWhile(n -> n < 5)
                .verifyComplete();
    }

    @Test
    void assertNextTest(){
        StepVerifier.create(Flux.just("apple", "banana", "cherry"))
                .assertNext(i-> assertTrue(i.startsWith("a")))
                .assertNext(value -> assertTrue(value.startsWith("b")))
                .expectNext( "cherry")
                .verifyComplete();
    }

    @Test
    void virtualTimeSchedulerTest(){
        StepVerifier.withVirtualTime(()-> Flux.interval(Duration.ofMillis(100)).take(3))
                .thenAwait(Duration.ofSeconds(3))
                .expectNext(0L, 1L, 2L)
                .verifyComplete();
    }

    @Test
    void scenarioNamingTest(){
        StepVerifier.create( Mono.just("Test"))
                .as("Basic Mono Test")
                .assertNext(i-> assertEquals("Test", i))
                .verifyComplete();
    }

    @Test
    void testPublisherTest() {
        TestPublisher<String> publisher = TestPublisher.create();
        StepVerifier.create(publisher.flux())
                .then(()-> publisher.emit("A","B", "C"))
                .expectNext("A","B", "C")
                .verifyComplete();
    }

    @Test
    void timeoutTest(){
        StepVerifier.create(Mono.delay(Duration.ofSeconds(1)))
                .expectTimeout(Duration.ofSeconds(1))
                .verify();
    }

    @Test
    void assertionPracticeTest(){
        StepVerifier.create(Mono.just(1))
                .assertNext(i-> assertEquals(1, i))
                .verifyComplete();

        StepVerifier.create(Mono.error(new RuntimeException("Error")))
                .verifyError();
    }
}
