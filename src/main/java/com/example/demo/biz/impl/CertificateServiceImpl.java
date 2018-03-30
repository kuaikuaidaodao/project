package com.example.demo.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.biz.ICertificateService;
import com.example.demo.dao.ICertificateDao;
import com.example.demo.entity.CertificateEn;
/**
 * 
 * @author xwj
 * @date 2018年3月30日 下午1:52:46
 * @desc 资历证书
 */
@Service
public class CertificateServiceImpl implements ICertificateService{

	@Autowired
	private ICertificateDao certificateDao;
	@Override
	public List<CertificateEn> findAll() {
		// TODO Auto-generated method stub
		return certificateDao.findAll();
	}

}
