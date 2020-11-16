package com.noxus.draven.webflux.reactordemos;

import reactor.core.publisher.Flux;

/**
 * 〈功能概述〉<br>
 *
 * @className: FluxDemo
 * @package: com.noxus.draven.reactors.reactordemos
 * @author: draven
 * @date: 2020/11/12 14:07
 */

//@Slf4j
public class FluxDemo {


    public static void main(String[] args) throws InterruptedException {
        println("hello word");
        Flux<String> just = Flux.just("A", "B", "C");

        // Flux.just("A", "B", "C").subscribe(FluxDemo::println);
        Flux.just("A", "B", "C")
                //.publishOn(Schedulers.elastic())
                .map(value -> "h")
                .subscribe(
                        FluxDemo::println,
                        FluxDemo::println,
                        () -> println("over")
                );


        //Thread.sleep(1000L);
    }


    private static void println(Object obj) {
        Thread thread = Thread.currentThread();
        System.out.println("[ 线程 ]" + thread.getName() + "" + obj);

    }
}
