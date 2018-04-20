package com.example.demo.dao;

import com.example.demo.entity.GoodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IGoodsRepository extends JpaRepository<GoodsEntity, Long> {
    @Query("select  goodsId, goodsNameEnglish as goodsName,goodsInfoEnglish as goodsInfo,goodsModelEnglish as goodsModel,goodsBrandEnglish as goodsBrand,goodsNumberEnglish as goodsNumber,goodsBulkEnglish as goodsBulk,goodsWeightEnglish as goodsWeight,goodsUrlEnglish as goodsUrl from GoodsEntity where categoryId=?1 order by sort asc")
    List<Object[]> findGoodsEnglish(Long categoryId);
    @Query("select  goodsId, goodsNameChinese as goodsName,goodsInfoChinese as goodsInfo,goodsModelChinese as goodsModel,goodsBrandChinese as goodsBrand,goodsNumberChinese as goodsNumber,goodsBulkChinese as goodsBulk,goodsWeightChinese as goodsWeight,goodsUrlChinese as goodsUrl from GoodsEntity where categoryId=?1 order by sort asc")
    List<Object[]> findGoodsChinese(Long categoryId);

    @Query(" from GoodsEntity  where (goodsModelChinese  like '%'||?1||'%' or  goodsModelEnglish  like '%'||?2||'%' ) ")
    List<GoodsEntity> findByGoodsModel(String goodsModelChinese,String goodsModelEnglish);
    @Query("select  goodsNameEnglish as goodsName,goodsInfoEnglish as goodsInfo,goodsModelEnglish as goodsModel,goodsBrandEnglish as goodsBrand,goodsNumberEnglish as goodsNumber,goodsBulkEnglish as goodsBulk,goodsWeightEnglish as goodsWeight,goodsUrlEnglish as goodsUrl from GoodsEntity where goodsId=?1 ")
    Object findGoodsByIdEnglish(Long goodsId);
    @Query("select  goodsNameChinese as goodsName,goodsInfoChinese as goodsInfo,goodsModelChinese as goodsModel,goodsBrandChinese as goodsBrand,goodsNumberChinese as goodsNumber,goodsBulkChinese as goodsBulk,goodsWeightChinese as goodsWeight,goodsUrlChinese as goodsUrl from GoodsEntity where goodsId=?1")
    Object findGoodsByIdChinese(Long goodsId);

    @Query("select  goodsId, goodsNameEnglish as goodsName,goodsInfoEnglish as goodsInfo,goodsModelEnglish as goodsModel,goodsBrandEnglish as goodsBrand,goodsNumberEnglish as goodsNumber,goodsBulkEnglish as goodsBulk,goodsWeightEnglish as goodsWeight,goodsUrlEnglish as goodsUrl from GoodsEntity  where ( goodsModelEnglish  like '%'||?1||'%' )  order by sort asc")
    List<Object[]> findByGoodsModelEnglish(String goodsModel);
    @Query("select  goodsId, goodsNameChinese as goodsName,goodsInfoChinese as goodsInfo,goodsModelChinese as goodsModel,goodsBrandChinese as goodsBrand,goodsNumberChinese as goodsNumber,goodsBulkChinese as goodsBulk,goodsWeightChinese as goodsWeight,goodsUrlChinese as goodsUrl from GoodsEntity  where (goodsModelChinese  like '%'||?1||'%'  )  order by sort asc")
    List<Object[]> findByGoodsModelChinese(String goodsModel);
}