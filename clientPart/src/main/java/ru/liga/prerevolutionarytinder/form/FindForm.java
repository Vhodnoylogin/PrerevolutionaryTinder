package ru.liga.prerevolutionarytinder.form;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import ru.liga.prerevolutionarytinder.Global;

import java.util.Collections;

public class FindForm implements Forms {
    private static final int FIND_FORM = 3;
    @Override
    public SendMessage execute(Message message) {
        SendMessage sendMessageRequest = new SendMessage();
        if (message.hasText()) {
            if (message.getText().equals("Влево")) {
                sendMessageRequest.setText("отказать и перейти на следующую анкету");
            } else if (message.getText().equals("Вправо")) {
                sendMessageRequest.setText("лайк и перейти на следующую анкету");
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
        sendMessage.setText("Можно просмотреть анкеты людей, которые совпадают по обоюдному поисковому критерию");
        Global.STATE = FIND_FORM;//DatabaseManager.getInstance().insertState(message.getFrom().getId(), message.getChatId(), MAINMENU);
        return sendMessage;
    }

    @Override
    public ReplyKeyboardMarkup receiveKeyboard() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add("Влево");
        keyboardFirstRow.add("Вправо");
        keyboardFirstRow.add("Меню");

        replyKeyboardMarkup.setKeyboard(Collections.singletonList(keyboardFirstRow));

        return replyKeyboardMarkup;
    }
}
