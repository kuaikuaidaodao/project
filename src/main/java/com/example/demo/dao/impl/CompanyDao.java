package com.example.demo.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.ICompanyRepository;
import com.example.demo.dao.ICompanyDao;
import com.example.demo.entity.BannerEn;
import com.example.demo.entity.CompanyEn;

/**
 * 
 * @author xwj
 * @date 2018年3月28日 上午11:13:31
 * @desc 公司详情
 */
@Repository
public class CompanyDao implements ICompanyDao {
	@Autowired
	ICompanyRepository companyRepository;

	/**
	 * 查询英文版公司详情
	 */
	@Override
	public List<CompanyEn> findAll() {
		List<Object[]> list = companyRepository.findAllByZh();
		List<CompanyEn> companyEns = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			CompanyEn companyEn = new CompanyEn();
			Object[] obj = list.get(i);
			if (obj[0] != null) {
				companyEn.setId(Long.valueOf(obj[0].toString()));
			}
			if (obj[1] != null) {
				companyEn.setName(obj[1].toString());
			}
			if (obj[2] != null) {
				companyEn.setDesc(obj[2].toString());
			}
			if (obj[3] != null) {
				companyEn.setImgurl(obj[3].toString());
			}
			if (obj[4] != null) {
				companyEn.setAddress(obj[4].toString());
			}
			if (obj[5] != null) {
				companyEn.setPhone(obj[5].toString());
			}

			companyEns.add(companyEn);
		}
		return companyEns;
	}

}
