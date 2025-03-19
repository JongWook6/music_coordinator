package com.grepp.mc.infra.llm.gemini.text;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.grepp.mc.infra.llm.Response;
import com.grepp.mc.infra.llm.gemini.text.vo.RequestDocument;
import com.grepp.mc.infra.llm.gemini.text.vo.ResponseDocument;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TextResponse implements Response {

    private final String responseTxt;

    public TextResponse(String responseTxt) {
        this.responseTxt = responseTxt;
    }

    @Override
    public List<Map<String, Object>> response() {

        Gson gson = new GsonBuilder()
            .serializeNulls()
            .setPrettyPrinting()
            .create();

        ResponseDocument responseDoc = gson.fromJson(responseTxt, ResponseDocument.class);
        String partText = responseDoc
            .candidates().getFirst()
            .content()
            .parts().getFirst()
            .text();

        TypeToken<List<Map<String, Object>>> listType = new TypeToken<>() {};
        return gson.fromJson(partText, listType.getType());
    }
}
