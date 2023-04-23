package ru.liga.form;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import ru.liga.Global;

import java.util.Collections;

public class MainMenu implements Forms {
    private static final int MAIN_MENU = 1;

    @Override
    public SendMessage execute(Message message) {
        SendMessage sendMessageRequest = new SendMessage();
        if (message.hasText()) {
            if (message.getText().equals("Анкета")) {
                sendMessageRequest = new QuestFrom().onChoose(message);
            } else if (message.getText().equals("Поиск")) {
                sendMessageRequest = new FindForm().onChoose(message);
            } else if (message.getText().equals("Любимцы")) {
                sendMessageRequest = new LikeForm().onChoose(message);
            }
        }
        return sendMessageRequest;
    }

    @Override
    public SendMessage onChoose(Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        ReplyKeyboardMarkup replyKeyboardMarkup = receiveKeyboard();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        sendMessage.setChatId(message.getChatId());
        sendMessage.setText("Меню");
        Global.STATE = MAIN_MENU;//DatabaseManager.getInstance().insertState(message.getFrom().getId(), message.getChatId(), MAINMENU);
        return sendMessage;
    }

    @Override
    public ReplyKeyboardMarkup receiveKeyboard() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add("Анкета");
        keyboardFirstRow.add("Поиск");
        keyboardFirstRow.add("Любимцы");

        replyKeyboardMarkup.setKeyboard(Collections.singletonList(keyboardFirstRow));

        return replyKeyboardMarkup;
    }
}
