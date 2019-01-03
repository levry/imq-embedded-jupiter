package com.github.levry.imq.embedded.junit.jupiter;

import org.junit.jupiter.api.Test;
import com.github.levry.imq.embedded.support.JmsHelper;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.TextMessage;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author levry
 */
@ImqBrokerTest
class EmbeddedBrokerExtensionTest {

    @ImqConnection
    private ConnectionFactory connectionFactory;

    @Test
    void initConnectionFactory() {
        assertThat(connectionFactory).isNotNull();
    }

    @Test
    void sendMessage() throws JMSException {
        TextMessage message = sendAndBrowse("Hello, Broker!!", connectionFactory);

        assertThat(message.getText()).isEqualTo("Hello, Broker!!");
    }

    private TextMessage sendAndBrowse(String text, ConnectionFactory connectionFactory) {
        JmsHelper jms = new JmsHelper(connectionFactory);
        jms.sendText(text, "testQueue");
        return jms.browseFirst("testQueue");
    }

}