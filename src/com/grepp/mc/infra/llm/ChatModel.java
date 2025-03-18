package com.grepp.mc.infra.llm;

public interface ChatModel {

    Response invoke(Request request);

}
