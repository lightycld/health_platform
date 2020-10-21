package com.health.common.config.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.bson.types.ObjectId;

import java.io.IOException;

/**
 * @Author:chenjian
 * @Email: chenjian12@xdf.cn
 * @Version 1.0
 * @Date 2018/7/13 17:54
 * @Description TODO
 */
public class ObjectIdJsonSerializer extends JsonSerializer<ObjectId> {
    @Override
    public void serialize(ObjectId o, JsonGenerator j, SerializerProvider s) throws IOException, JsonProcessingException {
        if(o == null) {
            j.writeNull();
        } else {
            j.writeString(o.toString());
        }
    }
}
