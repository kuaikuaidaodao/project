package com.example.demo.dao;

import com.example.demo.entity.Category;
import com.example.demo.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {
//    类目查询  中文
    @Query("select  categoryId, categoryNameChinese as categoryName,url from CategoryEntity where parentId=?1 order by sort asc")
    List<Object[]> findAllByChinese(Long parentId);
//    类目查询 英文
    @Query("select  categoryId, categoryNameEnglish as categoryName,url from CategoryEntity where parentId=?1 order by sort asc")
    List<Object[]> findAllByEnglish(Long parentId);
//    类目查询  父级
    @Query(" from CategoryEntity where parentId=?1 order by sort asc")
    List findAllByParentId(Long parentId);

//    父id 查询
    @Query(" select parentId from CategoryEntity where categoryId=?1 ")
    Long findParent(Long categoryId);


    @Query(" select categoryNameChinese,categoryNameEnglish from CategoryEntity where categoryId=?1 ")
    Object findcategoryName(Long categoryId);
    //    单个类目  英文
    @Query(" select  categoryId,categoryNameChinese as categoryName from CategoryEntity where categoryId=?1 ")
    Object findOneByChinese(Long categoryId);
//    单个类目  英文
    @Query(" select  categoryId,categoryNameEnglish as categoryName from CategoryEntity where categoryId=?1 ")
    Object findOneByEnglish(Long categoryId);

    @Query("  from CategoryEntity where parentId=?1 order by sort  asc")
    List categoryfindAll(Long parentId);
}