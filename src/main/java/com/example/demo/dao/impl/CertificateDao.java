package com.example.demo.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.ICertificateDao;
import com.example.demo.dao.ICertificateRepository;
import com.example.demo.entity.BannerEn;
import com.example.demo.entity.CertificateEn;
/**
 * 
 * @author xwj
 * @date 2018年3月30日 下午1:48:59
 * @desc 资历证书
 */
@Repository
public class CertificateDao implements ICertificateDao{
	
	@Autowired
	private ICertificateRepository certificateRepository;
	
	@Override
	public List<CertificateEn> findAll() {
		List<Object[]> list = certificateRepository.findAllByZh();
		List<CertificateEn> certificateEns = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			CertificateEn certificateEn = new CertificateEn();
			Object[] obj = list.get(i);
			if (obj[0] != null) {
				certificateEn.setId(Long.valueOf(obj[0].toString()));
			}
			if (obj[1] != null) {
				certificateEn.setImageUrls(obj[1].toString());
			}
			if (obj[2] != null) {
				certificateEn.setContext(obj[2].toString());
			}
			
			certificateEns.add(certificateEn);
		}
		return certificateEns;
	}
}
