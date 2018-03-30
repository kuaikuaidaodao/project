package com.example.demo.biz;

import java.util.List;

import com.example.demo.entity.CertificateEn;

public interface ICertificateService {

	// 查询英文版证书内容
	List<CertificateEn> findAll();
}
