package com.grepp.mc.domain.song;

import com.grepp.mc.infra.llm.gemini.text.vo.generation.PropertyType;

public record SongFormat(
    PropertyType title,
    PropertyType reason
) {
    public SongFormat() {
        this(PropertyType.STRING, PropertyType.STRING);
    }
}
