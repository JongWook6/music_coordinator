package com.grepp.mc.infra.llm.gemini.text.vo;

public record Candidate(
    Content content,
    String finishReason,
    Double avgLogprobs
) {

}
