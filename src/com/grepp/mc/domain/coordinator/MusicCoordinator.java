package com.grepp.mc.domain.coordinator;

import com.grepp.mc.domain.qrcode.QrCodeGenerator;
import com.grepp.mc.domain.song.Song;
import com.grepp.mc.domain.song.SongFormat;
import com.grepp.mc.infra.llm.ChatModel;
import com.grepp.mc.infra.llm.Response;
import com.grepp.mc.infra.llm.gemini.text.GeminiChatModel;
import com.grepp.mc.infra.llm.gemini.text.TextRequest;

public class MusicCoordinator {

    public Song recommend(String msg) {
        msg += ". 지금의 기분에 어울리는 노래 1곡 추천해줘. 추천 이유도 알려줘";

        ChatModel model = new GeminiChatModel();
        Response response = model.invoke(new TextRequest<>(msg, SongFormat.format));

        Song song = response.response().stream().map(SongFormat::toVo).toList().getFirst();
        QrCodeGenerator qrCodeGenerator = new QrCodeGenerator();
        qrCodeGenerator.generate(song);

        return song;
    }
}
