package com.health.common.file;

import com.health.common.file.domain.MiniFile;
import com.health.common.file.exception.FileStoreException;
import com.health.common.file.repository.FileRepository;
import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create By yangwei
 * Create at 2020/10/21 17:41
 * Description:
 */

@Component
public class FileHelper {

    @Autowired
    private FileRepository fileRepository;


    public static void validate(MiniFile file) {

        if (file.getData() == null) {
            throw new FileStoreException("File data can not be null.");
        }
        //TODO 验证文件大小
        if (file.getFileType() == MiniFile.FileType.IMG) {
            //TODO 图片验证尺寸

        } else {
            //TODO PDF验证啥
        }

    }


    /**
     * 保存图片
     *
     * @param file
     * @return
     */
    public ObjectId save(MiniFile file) {
        validate(file);
        return fileRepository.save(file).getId();
    }

    /**
     * 查询图片
     *
     * @param id
     * @return
     */
    public MiniFile get(String id) {
        if (StringUtils.isBlank(id)) {
            throw new FileStoreException("Id can not be null.");
        }
        return fileRepository.get(new ObjectId(id));
    }

    /**
     * 通过id批量查询图片
     * @param ids
     * @return
     */
    public List<MiniFile> findByIds(List<String> ids) {
        if(CollectionUtils.isEmpty(ids)) {
            return new ArrayList<>();
        }
        List<ObjectId> objIds = ids.stream().map(ObjectId::new).collect(Collectors.toList());
        return fileRepository.listByIds(objIds);
    }


}
