package com.grepp.mc.infra.llm.gemini.text.vo.generation;

// ENUM 타입일 경우 GSON 이 ENUM 타입 이름 또는 순번을 그대로 변환하기 때문에 사용 못함
public class PropertyType {

    public static final PropertyType BOOLEAN = new PropertyType("boolean");
    public static final PropertyType STRING = new PropertyType("string");
    public static final PropertyType NUMBER = new PropertyType("number");
    public static final PropertyType ARRAY = new PropertyType("array");
    public static final PropertyType OBJECT = new PropertyType("object");

    private final String type;

    private PropertyType(String type) {
        this.type = type;
    }

}
