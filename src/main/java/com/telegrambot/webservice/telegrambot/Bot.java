package com.telegrambot.webservice.telegrambot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String textMessage = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();

            textMessage = textMessage.toLowerCase();
            ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/description/"
                    + textMessage, String.class);

            if (response.getStatusCodeValue() == 200) {
                if (response.hasBody()) {
                    textMessage = response.getBody();
                } else {
                    textMessage = "We have no city with name " + textMessage;
                }
            }

            SendMessage message = new SendMessage()
                    .setChatId(chat_id)
                    .setText(textMessage);
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "Cities_guide_bot";
    }

    @Override
    public String getBotToken() {
        return "748297697:AAHYgrfJnD6rFwtMr2zmZhF3AGLl8Orcs_M";
    }
}