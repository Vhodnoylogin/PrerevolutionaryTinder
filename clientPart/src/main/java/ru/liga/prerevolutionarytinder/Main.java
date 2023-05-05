package ru.liga.prerevolutionarytinder;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.liga.prerevolutionarytinder.updatehandler.TinderHandler;

public class Main {
    public static void main(String[] args) {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new TinderHandler());
        } catch (TelegramApiException e) {
            //logger.error(String.valueOf(e));
            throw new RuntimeException(e);
        }
    }
}
