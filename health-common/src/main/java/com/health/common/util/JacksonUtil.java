package com.health.common.util;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * Create By yangwei
 * Create at 2019/08/05 14:52
 * Description:
 */
@Slf4j
public class JacksonUtil {

    private static ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().build();

    public static <T> String toString(T t) {
        try {
            return t instanceof String ? (String) t : objectMapper.writeValueAsString(t);
        } catch (Exception e) {
            log.info("An error occurred during parse json : {}", t.toString(), e);
            return null;
        }
    }

    public static <T> T parse(String str, Class<T> c) {
        if (StringUtils.isEmpty(str) || c == null) {
            return null;
        }
        try {
            return c == String.class ? (T) str : objectMapper.readValue(str, c);
        } catch (Exception e) {
            log.info("An error occurred during parse text to json : {}", str);
            return null;
        }
    }
}
