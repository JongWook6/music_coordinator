package com.grepp.mc.domain.coordinator;

import com.grepp.llm.ChatModel;
import com.grepp.llm.Response;
import com.grepp.llm.gemini.text.GeminiChatModel;
import com.grepp.llm.gemini.text.TextRequest;
import com.grepp.mc.domain.qrcode.QrCodeGenerator;
import com.grepp.mc.domain.song.Song;
import com.grepp.mc.domain.song.SongFormat;
import com.grepp.mc.infra.error.CommonException;


public class MusicCoordinator {

    public Song recommend(String msg) {
        Song song = null;

        try {
            msg += ". 지금의 기분에 어울리는 노래 1곡 추천해줘. 추천 이유도 알려줘";

            String apiKey = "AIzaSyAmsuVuvQQN8p_WPrVE6Llt-k3AWX4yAX4";

            ChatModel model = new GeminiChatModel("1.5", apiKey);
            Response response = model.invoke(new TextRequest<>(msg, SongFormat.format));

            song = response.response().stream().map(SongFormat::toVo).toList().getFirst();
            QrCodeGenerator qrCodeGenerator = new QrCodeGenerator();
            qrCodeGenerator.generate(song);

        } catch (CommonException e) {
            System.out.println(e.getMessage());
        }

        return song;
    }
}
