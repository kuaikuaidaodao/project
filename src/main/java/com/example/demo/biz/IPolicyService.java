package com.example.demo.biz;

import com.example.demo.entity.PolicyEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author li
 * @create 2018-01-29 15:52
 * @desc 城市信息
 **/
public interface IPolicyService {

    //查询全部
    List<PolicyEntity> findAll();


    //删除
    void delete(String ids);


    //保存
    void saveAndflush(PolicyEntity policyEntity);

    List<PolicyEntity> selectByim(String startDate, String endDate, String organization);


    List<PolicyEntity>  getPolicyByClassify(String classify);
//一个
    PolicyEntity findOne(String id);

    String batchImport(String fileName,MultipartFile mfile);
}
