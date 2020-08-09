package com.example.reactiver2dbademo;

import io.r2dbc.spi.Connection;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.r2dbc.core.DatabaseClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.function.Consumer;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2020/8/3
 */
@Slf4j
public class R2dbcApp {

    public static void main(String[] args) {

        ConnectionFactory connectionFactory = ConnectionFactories.get("r2dbc:h2:mem:///test?options=DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");

        DatabaseClient client = DatabaseClient.create(connectionFactory);

        Mono<Integer> affectedRows = client.execute("UPDATE person SET name = 'Joe'")
                .fetch()
                .rowsUpdated();

        Flux<Person> all = client.execute("SELECT id, name FROM person")
                .as(Person.class)
                .fetch()
                .all();
    }
}
