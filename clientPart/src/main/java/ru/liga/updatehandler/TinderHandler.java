package ru.liga.updatehandler;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.liga.BotConfig;

import java.util.Collections;

public class TinderHandler extends TelegramLongPollingBot {
    private static int STATE = 0;
    private static final int START_STATE = 0;
    private static final int MAIN_MENU = 1;
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
        final int state = STATE;//DatabaseManager.getInstance().getState(message.getFrom().getId(), message.getChatId());
        SendMessage sendMessageRequest = switch (state) {
            case MAIN_MENU -> messageOnMainMenu(message);
            case QUEST_FORM -> messageOnQuestForm(message);
            case FIND_FORM -> messageOnFindForm(message);
            case LIKE_FORM -> messageOnLikeForm(message);
            default -> sendMessageDefault(message);
        };
        try {
            execute(sendMessageRequest);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private SendMessage sendMessageDefault(Message message) {
        ReplyKeyboardMarkup replyKeyboardMarkup = getMainMenuKeyboard();
        STATE = MAIN_MENU;//DatabaseManager.getInstance().insertState(message.getFrom().getId(), message.getChatId(), MAINMENU);
        return sendHelpMessage(message.getChatId(), message.getMessageId(), replyKeyboardMarkup);
    }

    private SendMessage messageOnMainMenu(Message message) {
        SendMessage sendMessageRequest = new SendMessage();
        if (message.hasText()) {
            if (message.getText().equals("Анкета")) {
                sendMessageRequest = onQuestFormChoose(message);
            } else if (message.getText().equals("Поиск")) {
                sendMessageRequest = onFindFormChoose(message);
            } else if (message.getText().equals("Любимцы")) {
                sendMessageRequest = onLikeFormChoose(message);
            }
        }
        return sendMessageRequest;
    }

    private SendMessage onLikeFormChoose(Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        ReplyKeyboardMarkup replyKeyboardMarkup = getLikeFormKeyboard();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setChatId(message.getChatId());
        sendMessage.setText("Можно просмотреть анкеты людей, которые нравились вам, выбрали вас или был взаимный выбор.");
        STATE = LIKE_FORM;//DatabaseManager.getInstance().insertState(message.getFrom().getId(), message.getChatId(), MAINMENU);
        return sendMessage;
    }

    private SendMessage onFindFormChoose(Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        ReplyKeyboardMarkup replyKeyboardMarkup = getFindFormKeyboard();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setChatId(message.getChatId());
        sendMessage.setText("Можно просмотреть анкеты людей, которые совпадают по обоюдному поисковому критерию");
        STATE = FIND_FORM;//DatabaseManager.getInstance().insertState(message.getFrom().getId(), message.getChatId(), MAINMENU);
        return sendMessage;
    }

    private SendMessage onQuestFormChoose(Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        ReplyKeyboardMarkup replyKeyboardMarkup = getQuestFormKeyboard();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setChatId(message.getChatId());
        sendMessage.setText("Текущая анкета, а если её нет, то надо заполнить");
        STATE = QUEST_FORM;//DatabaseManager.getInstance().insertState(message.getFrom().getId(), message.getChatId(), MAINMENU);
        return sendMessage;
    }

    private SendMessage messageOnLikeForm(Message message) {
        SendMessage sendMessageRequest = new SendMessage();
        if (message.hasText()) {
            if (message.getText().equals("Влево")) {
                sendMessageRequest.setText("предыдущая анкета");
            } else if (message.getText().equals("Вправо")) {
                sendMessageRequest.setText("следующая анкета");
            } else if (message.getText().equals("Меню")) {
                sendMessageRequest = sendMessageDefault(message);
            }
        }
        sendMessageRequest.setChatId(message.getChatId());
        return sendMessageRequest;
    }

    private SendMessage messageOnFindForm(Message message) {
        SendMessage sendMessageRequest = new SendMessage();
        if (message.hasText()) {
            if (message.getText().equals("Влево")) {
                sendMessageRequest.setText("отказать и перейти на следующую анкету");
            } else if (message.getText().equals("Вправо")) {
                sendMessageRequest.setText("лайк и перейти на следующую анкету");
            } else if (message.getText().equals("Меню")) {
                sendMessageRequest = sendMessageDefault(message);
            }
        }
        sendMessageRequest.setChatId(message.getChatId());
        return sendMessageRequest;
    }

    private SendMessage messageOnQuestForm(Message message) {
        SendMessage sendMessageRequest = new SendMessage();
        if (message.hasText()) {
            if (message.getText().equals("Сударь")) {
                sendMessageRequest.setText("Вы Сударь");
            } else if (message.getText().equals("Сударыня")) {
                sendMessageRequest.setText("Вы Сударыня");
            } else if (message.getText().equals("Меню")) {
                sendMessageRequest = sendMessageDefault(message);
            }
        }
        sendMessageRequest.setChatId(message.getChatId());
        return sendMessageRequest;
    }

    @Override
    public String getBotToken() {
        return BotConfig.BOT_TOKEN;
    }

    @Override
    public String getBotUsername() {
        return BotConfig.BOT_NAME;
    }



    private ReplyKeyboardMarkup getMainMenuKeyboard() {
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

    private ReplyKeyboardMarkup getQuestFormKeyboard() {
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

    private ReplyKeyboardMarkup getFindFormKeyboard() {
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

    private ReplyKeyboardMarkup getLikeFormKeyboard() {
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

    private static SendMessage sendHelpMessage(Long chatId, Integer messageId, ReplyKeyboardMarkup replyKeyboardMarkup) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        if (replyKeyboardMarkup != null) {
            sendMessage.setReplyMarkup(replyKeyboardMarkup);
        }
        sendMessage.setText("Меню");
        return sendMessage;
    }
}
