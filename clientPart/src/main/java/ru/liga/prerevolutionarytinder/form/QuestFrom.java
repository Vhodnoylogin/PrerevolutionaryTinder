package ru.liga.prerevolutionarytinder.form;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import ru.liga.prerevolutionarytinder.Global;

import java.util.Collections;

public class QuestFrom implements Forms {
    private static final int QUEST_FORM = 2;
    @Override
    public SendMessage execute(Message message) {
        SendMessage sendMessageRequest = new SendMessage();
        if (message.hasText()) {
            if (message.getText().equals("Сударь")) {
                sendMessageRequest.setText("Вы Сударь");
            } else if (message.getText().equals("Сударыня")) {
                sendMessageRequest.setText("Вы Сударыня");
            } else if (message.getText().equals("Меню")) {
                sendMessageRequest = new MainMenu().onChoose(message);
            }
        }
        sendMessageRequest.setChatId(message.getChatId());
        return sendMessageRequest;
    }

    @Override
    public SendMessage onChoose(Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        ReplyKeyboardMarkup replyKeyboardMarkup = receiveKeyboard();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setChatId(message.getChatId());
        sendMessage.setText("Текущая анкета, а если её нет, то надо заполнить");
        Global.STATE = QUEST_FORM;//DatabaseManager.getInstance().insertState(message.getFrom().getId(), message.getChatId(), MAINMENU);
        return sendMessage;
    }

    @Override
    public ReplyKeyboardMarkup receiveKeyboard() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add("Сударь");
        keyboardFirstRow.add("Сударыня");
        keyboardFirstRow.add("Меню");

        replyKeyboardMarkup.setKeyboard(Collections.singletonList(keyboardFirstRow));

        return replyKeyboardMarkup;
    }
}
