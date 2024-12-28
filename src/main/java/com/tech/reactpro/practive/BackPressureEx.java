package com.tech.reactpro.practive;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;


import java.time.Duration;

public class BackPressureEx {

    public static void main(String[] args) throws InterruptedException {

        // Simulating a high volume data stream
        Flux<Long> numbers = Flux.interval(Duration.ofMillis(100)).take(100).publishOn(Schedulers.parallel());

        numbers.doOnNext(num->System.out.println("Received: "+num))
                .buffer(10)
                .subscribe(
                    list -> System.out.println("Processed "+list),
                        error -> System.out.println("Error = " + error),
                        ()-> System.out.println("Stream Completed")
                );
        Thread.sleep(2000);
    }
}
