package com.health.common.file.repository.impl;

import com.health.common.file.domain.MiniFile;
import com.health.common.file.repository.FileRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Create By yangwei
 * Create at 2020/10/21 17:23
 * Description:
 */

@Repository
public class FileRepositoryImpl implements FileRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    private static final String FILE_COLLECTION = "health_file";

    @Override
    public MiniFile save(MiniFile file) {
        return mongoTemplate.insert(file, FILE_COLLECTION);
    }

    @Override
    public MiniFile get(ObjectId id) {
        Query q = new Query();
        q.addCriteria(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(q, MiniFile.class);
    }

    @Override
    public List<MiniFile> saveBatch(List<MiniFile> files) {

        BulkOperations operations = mongoTemplate.bulkOps(BulkOperations.BulkMode.UNORDERED, FILE_COLLECTION);

        operations.insert(files);
        operations.execute();

        return null;
    }

    @Override
    public List<MiniFile> listByIds(List<ObjectId> ids) {
        Query q = new Query();
        q.addCriteria(Criteria.where("_id").in(ids));
        return mongoTemplate.find(q, MiniFile.class);
    }
}
