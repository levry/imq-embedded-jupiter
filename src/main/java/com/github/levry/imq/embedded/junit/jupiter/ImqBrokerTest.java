package com.github.levry.imq.embedded.junit.jupiter;

import com.github.levry.imq.embedded.EmbeddedBrokerBuilder;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.*;

/**
 * Enables extension {@link EmbeddedBrokerExtension}.
 * <p>
 * Allows to customize a embedded broker:
 * <ul>
 * <li>port number (default: 7676)</li>
 * </ul>
 *
 * @author levry
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(EmbeddedBrokerExtension.class)
public @interface ImqBrokerTest {

    /**
     * Port number of embedded broker
     * @return a port number (default is 7676)
     */
    int port() default EmbeddedBrokerBuilder.DEFAULT_BROKER_PORT;
}
