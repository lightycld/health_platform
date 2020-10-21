package com.health.common.file.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.health.common.config.serialize.ObjectIdJsonSerializer;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Create By yangwei
 * Create at 2020/10/21 14:50
 * Description:
 */

@Data
public class MiniFile {

    @Id
    @Field("_id")
    @JsonSerialize(using = ObjectIdJsonSerializer.class)
    private ObjectId id;

    @Field("create_time")
    private Long createTime;

    @Field("create_user")
    private String createUser;

    @Field("file_type")
    private FileType fileType;

    @Field("data")
    byte[] data;

    @Field("size")
    private Integer size;

    public void setData(byte[] data) {
        this.data = data;
        if(data != null) {
            this.size = data.length;
        }
    }

    public enum FileType {

        PDF,

        IMG
    }

}
