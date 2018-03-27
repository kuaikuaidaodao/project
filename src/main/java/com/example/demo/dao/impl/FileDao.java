package com.example.demo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.IFileDao;
import com.example.demo.dao.IFileRepository;
import com.example.demo.entity.FileEn;
import com.example.demo.entity.FileEntity;

@Repository
public class FileDao implements IFileDao {
	
	@PersistenceContext
    private EntityManager entityManager;
	@Autowired
	IFileRepository fileRepository;

	
	@Override
	public List<FileEn> findAll() {
		/*TypedQuery<FileEn> query = this.entityManager.createQuery(" select u.fileEnName from  FileEn u where 1=1  ",FileEn.class);
        List<FileEn>  list =query.getResultList();
        return list;*/
		List<Object[]> list=fileRepository.findAllByZh();
	    List<FileEn> menu=new ArrayList<>();
	    for (int i=0;i<list.size();i++) {
	    	FileEn fileEn=new FileEn();
	        Object[] obj=list.get(i);
	        if (obj[0] != null) {
	        	fileEn.setId(Long.valueOf(obj[0].toString()));
	        }
	        if (obj[1] != null) {
	        	fileEn.setFileEnName(obj[1].toString());
	        }
	        if (obj[2] != null) {
				fileEn.setFileUrl(obj[2].toString());
			}
	        if (obj[3] != null) {
				fileEn.setImgUrl(obj[3].toString());
			}
	        menu.add(fileEn);
	    }
	    return menu;
	}
	



	@Override
	public FileEn findById(Long id) {
		TypedQuery<FileEn> query = this.entityManager.createQuery(" select u.fileEnName from  FileEn u where u.id=:id  ",FileEn.class);
        query.setParameter("second_id",id);
        FileEn  list =query.getSingleResult();
        return list;
    }

}
