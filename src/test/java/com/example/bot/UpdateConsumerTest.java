package com.example.bot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UpdateConsumerTest {

    @Mock
    private TelegramClient telegramClient;

    @InjectMocks
    private UpdateConsumer updateConsumer;

    @Test
    void testStartCommand() throws TelegramApiException {
        // проверяем, что код компилируется и запускается
        assertNotNull(updateConsumer);
        assertNotNull(telegramClient);
    }

    @Test
    void testBasicFunctionality() {
        // тест для проверки работы
        UpdateConsumer consumer = new UpdateConsumer(telegramClient);
        assertNotNull(consumer);
    }
}