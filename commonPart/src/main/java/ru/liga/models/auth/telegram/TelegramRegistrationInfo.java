package ru.liga.models.auth.telegram;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.liga.models.auth.AuthPrincipleInfo;

@Data
@EqualsAndHashCode(callSuper = true)
public class TelegramRegistrationInfo extends AuthPrincipleInfo {
    private Integer userId;
}
