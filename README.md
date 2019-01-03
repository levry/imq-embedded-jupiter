# Embedded openMQ broker jupiter extension
[![Build Status](https://travis-ci.org/levry/imq-embedded-jupiter.svg?branch=master)](https://travis-ci.org/levry/imq-embedded-jupiter)
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=github.levry.imq.embedded.jupiter&metric=alert_status)](https://sonarcloud.io/dashboard?id=github.levry.imq.embedded.jupiter)
[![MIT License](https://img.shields.io/badge/license-MIT-blue.svg)](//github.com/levry/imq-embedded-jupiter/blob/master/LICENSE)

A [JUnit 5 extension](https://junit.org/junit5/docs/current/user-guide/#extensions) for testing a jms interaction with openMQ broker.

````java
@ImqBrokerTest
class YourTest {

    @ImqConnection
    private ConnectionFactory connectionFactory;

    @Test
    void testJms() throws Exception {
        try (Connection conn = connectionFactory.createConnection()) {
            // Do stuff
        }
    }

}
````