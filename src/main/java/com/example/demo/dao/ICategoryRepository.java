package com.example.demo.dao;

import com.example.demo.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {
    @Query("select  categoryId, categoryNameChinese as categoryName from CategoryEntity where parentId=?1 order by sort asc")
    List<Object[]> findAllByChinese(Long parentId);
    @Query("select  categoryId, categoryNameEnglish as categoryName from CategoryEntity where parentId=?1 order by sort asc")
    List<Object[]> findAllByEnglish(Long parentId);
    @Query(" from CategoryEntity where parentId=?1 order by sort asc")
    List findAllByParentId(Long parentId);
    @Query(" select parentId from CategoryEntity where menuId=?1 ")
    Long findParent(Long categoryId);
    @Query(" select categoryNameChinese,categoryNameEnglish from CategoryEntity where categoryId=?1 ")
    Object findmenuName(Long menuId);

}