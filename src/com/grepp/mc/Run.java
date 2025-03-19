package com.grepp.mc;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.grepp.llm.ChatModel;
import com.grepp.llm.Response;
import com.grepp.llm.gemini.text.GeminiChatModel;
import com.grepp.llm.gemini.text.TextRequest;
import com.grepp.mc.domain.song.Song;
import com.grepp.mc.domain.song.SongFormat;
import com.grepp.mc.presentation.Index;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
public class Run {

    public static void main(String[] args) {

//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        String msg = "신나는 노래를 한 곡 추천해줘, 이유를 함께 알려줘";
//
//        ChatModel model = new GeminiChatModel();
//        Response response = model.invoke(new TextRequest<>(msg, SongFormat.format));
//        List<Map<String, Object>> data = response.response();
//
//        List<Song> songs = data.stream().map(SongFormat::toVo).toList();
//        System.out.println(songs);

        new Index().index();
    }

}
