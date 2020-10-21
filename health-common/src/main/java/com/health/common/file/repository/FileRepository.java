package com.health.common.file.repository;

import com.health.common.file.domain.MiniFile;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * Create By yangwei
 * Create at 2020/10/21 14:56
 * Description:
 */
public interface FileRepository {

    MiniFile save(MiniFile file);

    MiniFile get(ObjectId id);

    List<MiniFile> saveBatch(List<MiniFile> files);

    List<MiniFile> listByIds(List<ObjectId> ids);
}
