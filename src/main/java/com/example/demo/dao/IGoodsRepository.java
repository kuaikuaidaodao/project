package com.example.demo.dao;

import com.example.demo.entity.GoodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IGoodsRepository extends JpaRepository<GoodsEntity, Long> {

    @Query("select  goodsId, goodsNameEnglish as goodsName,goodsInfoEnglish as goodsInfo,goodsInfoDetailEnglish as goodsInfoDetail,goodsUrlEnglish as goodsUrl from GoodsEntity where categoryId=?1 order by sort asc")
    List<Object[]> findGoodsEnglish(Long categoryId);
    @Query("select  goodsId, goodsNameChinese as goodsName,goodsInfoChinese as goodsInfo,goodsInfoDetailChinese as goodsInfoDetail,goodsUrlChinese as goodsUrl from GoodsEntity where categoryId=?1 order by sort asc")
    List<Object[]> findGoodsChinese(Long categoryId);
//    @Query(" from GoodsEntity where menuId=?1 order by sort asc")
//    List findAllByMenuId(Long menuId);
    @Query(" from GoodsEntity  where goodsNameChinese  like '%'||?1||'%' ")
    GoodsEntity findByGoodsName(String goodsName);
    @Query("select  goodsNameEnglish as goodsName,goodsInfoEnglish as goodsInfo,goodsInfoDetailEnglish as goodsInfoDetail,goodsUrlEnglish as goodsUrl from GoodsEntity where goodsId=?1 ")
    Object[] findGoodsByIdEnglish(Long goodsId);
    @Query("select  goodsNameChinese as goodsName,goodsInfoChinese as goodsInfo,goodsInfoDetailChinese as goodsInfoDetail,goodsUrlChinese as goodsUrl from GoodsEntity where goodsId=?1")
    Object[] findGoodsByIdChinese(Long goodsId);
}