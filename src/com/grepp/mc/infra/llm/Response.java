package com.grepp.mc.infra.llm;

import java.util.List;
import java.util.Map;

public interface Response {

    List<Map<String, Object>> response();

}
