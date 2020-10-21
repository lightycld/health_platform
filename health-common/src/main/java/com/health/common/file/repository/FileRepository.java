package com.health.common.file.repository;

import com.health.wechat.file.domain.File;
import org.bson.types.ObjectId;

/**
 * Create By yangwei
 * Create at 2020/10/21 14:56
 * Description:
 */
public interface FileRepository {

    ObjectId save(File file);

    ObjectId get(ObjectId id);
}
