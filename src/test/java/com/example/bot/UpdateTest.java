package com.example.bot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.Assertions;

@ExtendWith(MockitoExtension.class)
class UpdateTest {

    @Test
    void testStartMessageContent() {
        UpdateConsumer consumer = new UpdateConsumer(null);
        String result = consumer.StartMessage();

        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.contains("Добро пожаловать"));
        Assertions.assertTrue(result.contains("/start"));
        Assertions.assertTrue(result.contains("/help"));
    }

    @Test
    void testHelpMessageContent() {
        UpdateConsumer consumer = new UpdateConsumer(null);
        String result = consumer.HelpMessage();

        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.contains("Справка по работе"));
        Assertions.assertTrue(result.contains("привет"));
        Assertions.assertTrue(result.contains("/help"));
    }
}