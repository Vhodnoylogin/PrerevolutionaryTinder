package ru.liga.form;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

public interface Forms {

    SendMessage execute(Message message);
    SendMessage onChoose(Message message);
    ReplyKeyboardMarkup receiveKeyboard();

}
