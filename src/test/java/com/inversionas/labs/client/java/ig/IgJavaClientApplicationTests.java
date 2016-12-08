package com.inversionas.labs.client.java.ig;

import com.inversionas.labs.client.java.ig.autoconfigure.IGAutoConfiguration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {IGAutoConfiguration.class,
        SubscriptionsConfiguration.class})
@Slf4j
public class IgJavaClientApplicationTests {

    @Test
    public void contextLoads() {
        log.debug("Context loads ok");
    }

}
