package com.demkom58.spark.controller;

import com.demkom58.telegram.mvc.EventType;
import com.demkom58.telegram.mvc.annotations.BotController;
import com.demkom58.telegram.mvc.annotations.CommandMapping;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.List;

@BotController
public class StartController {
    private final ReplyKeyboardMarkup menuKeyboardMarkup = new ReplyKeyboardMarkup();

    public StartController() {
        final var read = new KeyboardRow();
        read.addAll(List.of("Группы", "Заявки"));
        final var write = new KeyboardRow();
        write.addAll(List.of("Отправить", "Управление"));
        final var other = new KeyboardRow();
        other.addAll(List.of("Донат"));

        menuKeyboardMarkup.setSelective(true);
        menuKeyboardMarkup.setResizeKeyboard(true);
        menuKeyboardMarkup.setOneTimeKeyboard(false);
        menuKeyboardMarkup.setKeyboard(List.of(read, write, other));
    }

    @CommandMapping(
            value = {"/start", "Start", "Старт", "/menu", "Menu", "Меню"},
            event = EventType.TEXT_MESSAGE
    )
    public SendMessage start(Update update) {
        final Message message = update.getMessage();
        final Long chatId = message.getChatId();

        return SendMessage.builder()
                .chatId(String.valueOf(chatId))
                .text("Отобразил тебе меню :)")
                .replyMarkup(menuKeyboardMarkup)
                .build();
    }

}

