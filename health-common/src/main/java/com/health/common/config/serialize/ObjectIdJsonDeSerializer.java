package com.health.common.config.serialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;

import java.io.IOException;

/**
 * @Author:fengyuhao
 * @Email: fengyuhao@xdf.cn
 * @Version: 1.0
 * @Date: 2019/02/19 16:34
 * @Description: TODO
 **/
public class ObjectIdJsonDeSerializer extends JsonDeserializer<ObjectId> {

    @Override
    public ObjectId deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String id = p.getText();
        if(StringUtils.isBlank(id)){
            return null;
        }else if (!ObjectId.isValid(id)) {
            return null;
        }else {
            return new ObjectId(id);
        }
    }

}
