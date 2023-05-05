package ru.liga.prerevolutionarytinder.updatehandler;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.liga.prerevolutionarytinder.BotConfig;
import ru.liga.prerevolutionarytinder.Global;
import ru.liga.prerevolutionarytinder.form.*;

public class TinderHandler extends TelegramLongPollingBot {
    private static final int QUEST_FORM = 2;
    private static final int FIND_FORM = 3;
    private static final int LIKE_FORM = 4;

    @Override
    public void onUpdateReceived(Update update) {
        try {
            if (update.hasMessage()) {
                Message message = update.getMessage();
                if (message.hasText() || message.hasLocation()) {
                    handleIncomingMessage(message);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleIncomingMessage(Message message) {
        Integer state = Global.STATE;//DatabaseManager.getInstance().getState(message.getFrom().getId(), message.getChatId());
        Forms forms;
        switch (state) {
            case QUEST_FORM -> forms = new QuestFrom();
            case FIND_FORM -> forms = new FindForm();
            case LIKE_FORM -> forms = new LikeForm();
            default -> forms = new MainMenu();
        }
        try {
            if (state == 0) {
                execute(forms.onChoose(message));
            } else {
                execute(forms.execute(message));
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotToken() {
        return BotConfig.BOT_TOKEN;
    }

    @Override
    public String getBotUsername() {
        return BotConfig.BOT_NAME;
    }
}
