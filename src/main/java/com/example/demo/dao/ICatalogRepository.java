package com.example.demo.dao;

import com.example.demo.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICatalogRepository extends JpaRepository<MenuEntity, Long> {
    @Query("select  menuId, menuNameChinese as menuName,url from MenuEntity where parentId=?1 order by sort asc")
    List<Object[]> findAllByChinese(Long parentId);
    @Query("select  menuId, menuNameEnglish as menuName,url from MenuEntity where parentId=?1 order by sort asc")
    List<Object[]> findAllByEnglish(Long parentId);
    @Query(" from MenuEntity where parentId=?1 order by sort asc")
    List findAllByParentId(Long parentId);
    @Query(" select parentId from MenuEntity where menuId=?1 ")
    Long findParent(Long menuId);
    @Query(" select menuNameChinese,menuNameEnglish ,url from MenuEntity where menuId=?1 ")
    Object findmenuName(Long menuId);
//    子节点查询
    @Query(" select menuId from MenuEntity where parentId=?1 order by sort asc")
    List<Long> findAllByMenuId(Long parentId);


}