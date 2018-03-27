package com.example.demo.dao;

import com.example.demo.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICatalogRepository extends JpaRepository<MenuEntity, Long> {
    @Query("select  menuId, menuNameChinese as menuName from MenuEntity where parentId=?1 order by sort asc")
    List<Object[]> findAllByChinese(Long parentId);
    @Query("select  menuId, menuNameEnglish as menuName from MenuEntity where parentId=?1 order by sort asc")
    List<Object[]> findAllByEnglish(Long parentId);
    @Query(" from MenuEntity where parentId=?1 order by sort asc")
    List findAllByParentId(Long parentId);
}