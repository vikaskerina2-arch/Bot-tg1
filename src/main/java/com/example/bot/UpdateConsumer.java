package com.example.bot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

@Component
public class UpdateConsumer implements LongPollingSingleThreadUpdateConsumer {

    private final TelegramClient telegramClient;

    public UpdateConsumer(TelegramClient telegramClient) {
        this.telegramClient = telegramClient;
    }

    @Override
    public void consume(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String text_user = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();

            System.out.println("сообщение: "+ text_user+" от: "+ chatId);
            String output_text;

            if("/start".equals(text_user)){
                output_text=StartMessage();
            }
            else if("/help".equals(text_user)){
                output_text=HelpMessage();
            }
            else{
                output_text="Вы ввели: " + text_user;
            }
            try{
                sendMessage(chatId,output_text);
            } catch (Exception e) {
                System.err.println("Ошибка при отправке сообщения: " + e.getMessage());
                e.printStackTrace();
            }

        }
    }
    private String StartMessage(){
        return " Добро пожаловать в наш первый телеграм бот)\n" +
                "Он умеет возращать текст, который вы ему напишите.\n" +
                "Просто отправьте ему текстовое сообщение, и он ответит вам.\n" +
                "Его команды:\n" +
                "/start - начать работу\n"+
                "/help - показать, как я работаю\n";
    }
    private String HelpMessage(){
        return " Справка по работе:\n" +
                "Бот умеет возращать текст, который вы ему напишите.\n" +
                "Например: вы пишите \"привет\", он ответит:\n" +
                "Вы ввели: \"привет\"\n" +
                "/start - начать работу\n"+
                "/help - показать, как я работаю\n"+
                "Попробуйте мне написать!";
    }
    private void sendMessage(long chatId, String text) throws TelegramApiException {
        SendMessage message = SendMessage.builder()
                .chatId(chatId)
                .text(text)
                .build();
        try {
            telegramClient.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}
