package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.CertificateEn;
/**
 * 
 * @author xwj
 * @date 2018年3月30日 下午1:41:53
 * @desc 资历证书
 */
public interface ICertificateDao {

	//查询英文版证书内容
	List<CertificateEn> findAll();
}
