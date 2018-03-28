package com.example.demo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.dao.ILinkDao;
import com.example.demo.dao.ILinkRepository;
import com.example.demo.entity.LinkEn;
/**
 * 
 * @author xwj
 * @date 2018年3月28日 上午10:16:24
 * @desc 友情链接
 */
@Repository
public class LinkDao implements ILinkDao{
	@Autowired
	ILinkRepository linkRepository;

	/**
	 * 查询英文版友情链接
	 */
	@Override
	public List<LinkEn> findAll() {
		List<Object[]> list = linkRepository.findAllByZh();
		List<LinkEn> link = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			LinkEn linkEn = new LinkEn();
			Object[] obj = list.get(i);
			if (obj[0] != null) {
				linkEn.setId(Long.valueOf(obj[0].toString()));
			}
			if (obj[1] != null) {
				linkEn.setUrl(obj[1].toString());
			}
			if (obj[2] != null) {
				linkEn.setName(obj[2].toString());
			}
			link.add(linkEn);
		}
		return link;
	}

}
