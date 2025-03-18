package com.grepp.mc;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.grepp.mc.domain.song.SongFormat;
import com.grepp.mc.infra.llm.ChatModel;
import com.grepp.mc.infra.llm.Response;
import com.grepp.mc.infra.llm.gemini.text.GeminiChatModel;
import com.grepp.mc.infra.llm.gemini.text.TextRequest;
import com.grepp.mc.infra.llm.gemini.text.vo.RequestDocument;
import java.util.List;
import java.util.Map;

public class Run {

    public static void main(String[] args) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String msg = "신나는 노래를 한 곡 추천해줘, 제목과 이유를 알려줘";

        ChatModel model = new GeminiChatModel();
        Response response = model.invoke(new TextRequest<>(msg, new SongFormat()));
        List<Map<String, Object>> data = (List<Map<String, Object>>) response.response().get("data");

        System.out.println(data);
    }

}
