package com.tech.reactpro.practive;

import reactor.core.publisher.Flux;

public class ReactiveEx {


    public static void main(String[] args) {

        Flux<String> stockPrices = Flux.just("10000","20000","30000","40000","50000");

        stockPrices.subscribe(
                data-> System.out.println("Received = " + data),   // onNext
                error-> System.out.println("Error = " + error),  // onError
                ()->System.out.println("Stream Completed")   //onComplete
        );

    }
}
