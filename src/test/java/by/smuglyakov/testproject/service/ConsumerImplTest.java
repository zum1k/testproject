package by.smuglyakov.testproject.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConsumerImplTest {
    private final ConsumerImpl consumer = new ConsumerImpl();

    @Test
    void consumerTest() throws InterruptedException {

        consumer.accept(1);
        consumer.accept(1);
        consumer.accept(1);

        Thread.sleep(310000);

        consumer.accept(2);
        consumer.accept(2);
        consumer.accept(2);


        Double result = consumer.mean();
        Assertions.assertEquals(2, result);
    }

}
