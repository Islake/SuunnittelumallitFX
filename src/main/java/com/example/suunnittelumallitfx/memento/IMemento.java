package com.example.suunnittelumallitfx.memento;

import java.time.LocalDateTime;

public interface IMemento {
    LocalDateTime getTimestamp();
    String getDescription();
}