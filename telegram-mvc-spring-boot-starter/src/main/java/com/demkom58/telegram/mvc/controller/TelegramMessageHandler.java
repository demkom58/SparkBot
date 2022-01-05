package com.demkom58.telegram.mvc.controller;

import com.demkom58.telegram.mvc.message.TelegramMessage;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.bots.AbsSender;

public interface TelegramMessageHandler {
    @Nullable
    Object invoke(TelegramMessage message, AbsSender bot, Object... providedArgs) throws Exception;

    HandlerMapping getMapping();
}
