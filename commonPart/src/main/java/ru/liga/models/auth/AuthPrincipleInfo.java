package ru.liga.models.auth;

import lombok.Data;

@Data
public abstract class AuthPrincipleInfo {
    private SourceType sourceType;
}
