package com.health.wechat.file.domain;

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
public class File {

    @Id
    @Field("_id")
    private ObjectId id;

    @Field("create_time")
    private Long createTime;

    @Field("create_user")
    private String createUser;

    @Field("file_type")
    private FileType fileType;

    @Field("data")
    byte[] data;

    enum FileType{

        PDF,

        IMG
    }

}
