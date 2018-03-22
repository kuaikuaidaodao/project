package com.example.demo.biz.impl;


import com.example.demo.biz.IPolicyService;
import com.example.demo.common.ExcelImportUtils;
import com.example.demo.dao.IPolicyDao;
import com.example.demo.dao.IPolicyRepository;
import com.example.demo.entity.PolicyEntity;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author li
 * @create 2018-01-29 15:51
 * @desc 城市信息
 **/
@Service
public class PolicyService  implements IPolicyService   {
   @Autowired
   IPolicyRepository iPolicyRepository;
    @Autowired
    IPolicyDao iPolicyDao;
    //这里的单引号不能少，否则会报错，被识别是一个对象;
    public static final String CACHE_KEY = "'demoInfo_policy'";

    public static final String DEMO_CACHE_NAME = "demo";


    @Override
    @Cacheable(value="demo",key=CACHE_KEY)
    public List<PolicyEntity> findAll() {
        return iPolicyRepository.findAll();
    }

    @Override
    @CacheEvict(value="demo" ,key=CACHE_KEY )
    public void delete(String ids) {
        String[] idss=ids.split(",");
        if (idss.length>0) {
            for (String id : idss)
                iPolicyRepository.delete(Long.valueOf(id));
        }
    }

    @Override
    @CacheEvict(value="demo" ,key=CACHE_KEY )
    public  void saveAndflush(PolicyEntity policyEntity) {
        iPolicyRepository.saveAndFlush(policyEntity);
    }

    @Override
    public List<PolicyEntity> selectByim(String startDate, String endDate, String organization) {
        StringBuffer sb=new StringBuffer("  from PolicyEntity u where 1=1 ");
        if (null!=startDate&&!"".equals(startDate)&&null!=endDate&&!"".equals(endDate)) {
            sb.append("and ( u.startDate BETWEEN '"+startDate +"'and'"+ endDate+"') and ( u.endDate BETWEEN '"+startDate +"' and '"+ endDate+"') ");
        }
        if (null!=organization&&!"".equals(organization)) {
            sb.append(" and u.organization=:organization");

        }
        System.out.println(sb.toString()+"--------------");
        return iPolicyDao.selectByim(sb.toString(),startDate,endDate,organization);
    }

    @Override
    public List<PolicyEntity> getPolicyByClassify(String classify) {
        return  iPolicyDao.getPolicyByClassify(classify);
    }

    @Override
    public PolicyEntity findOne(String id) {
        return iPolicyRepository.findOne(Long.valueOf(id));
    }

    @Override
    public String batchImport(String fileName,MultipartFile mfile){

        File uploadDir = new  File("D:\\fileupload");
        //创建一个目录 （它的路径名由当前 File 对象指定，包括任一必须的父路径。）
        if (!uploadDir.exists()) uploadDir.mkdirs();
        //新建一个文件
        File tempFile = new File("D:\\fileupload\\" + new Date().getTime() + ".xlsx");
        //初始化输入流
        InputStream is = null;
        try{
            //将上传的文件写入新建的文件中
            mfile.transferTo(tempFile);

            //根据新建的文件实例化输入流
            is = new FileInputStream(tempFile);

            //根据版本选择创建Workbook的方式
            Workbook wb = null;
            //根据文件名判断文件是2003版本还是2007版本
            if(ExcelImportUtils.isExcel2007(fileName)){
                wb = new XSSFWorkbook(is);
            }else{
                wb = new HSSFWorkbook(is);
            }
            //根据excel里面的内容读取知识库信息
            return readExcelValue(wb,tempFile);
        }catch(Exception e){
            e.printStackTrace();
        } finally{
            if(is !=null)
            {
                try{
                    is.close();
                }catch(IOException e){
                    is = null;
                    e.printStackTrace();
                }
            }
        }
        return "导入出错！请检查数据格式！";
    }


    /**
     * 解析Excel里面的数据
     * @param wb
     * @return
     */
    private String readExcelValue(Workbook wb,File tempFile){

        //错误信息接收器
        String errorMsg = "";
        //得到第一个shell
        Sheet sheet=wb.getSheetAt(0);
        //得到Excel的行数
        int totalRows=sheet.getPhysicalNumberOfRows();
        //总列数
        int totalCells = 0;
        //得到Excel的列数(前提是有行数)，从第二行算起
        if(totalRows>=2 && sheet.getRow(1) != null){
            totalCells=sheet.getRow(1).getPhysicalNumberOfCells();
        }
        List<PolicyEntity> userKnowledgeBaseList=new ArrayList<PolicyEntity>();
        PolicyEntity tempUserKB;

        String br = "<br/>";

        //循环Excel行数,从第二行开始。标题不入库
        for(int r=1;r<totalRows;r++){
            String rowMessage = "";
            Row row = sheet.getRow(r);
            if (row == null){
//                errorMsg += br+"第"+(r+1)+"行数据有问题，请仔细检查！";
                continue;
            }
            tempUserKB = new PolicyEntity();

            String title = "";
            String content = "";
            String classify = "";
            Date startDate =null;
            Date endDate =null;
            String organization = "";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            //循环Excel的列
            for(int c = 0; c <6; c++){
                Cell cell = row.getCell(c);
                if (null != cell){
                    if(c==0){
                        title = cell.getStringCellValue();
                        if(StringUtils.isEmpty(title)){
                            rowMessage += "问题不能为空；";
                        }
                        tempUserKB.setTitle(title);
                    }else if(c==1){
                        content = cell.getStringCellValue();
                        if(StringUtils.isEmpty(content)){
                            rowMessage += "答案不能为空；";
                        }
                        tempUserKB.setContent(content);
                    }
                   else  if(c==2){
                        classify = cell.getStringCellValue();
                        if(StringUtils.isEmpty(classify)){
                            rowMessage += "问题不能为空；";
                        }
                        tempUserKB.setClassify(classify);
                    }else if(c==3){
                        startDate = cell.getDateCellValue();
                        if(null!=startDate){
                            tempUserKB.setStartDate(sdf.format(startDate));
                        }

                    }
                    else if(c==4){
                        endDate = cell.getDateCellValue();
                        if(null!=endDate){
                            tempUserKB.setEndDate(sdf.format(endDate));
                        }

                    }else if(c==5){
                        organization = cell.getStringCellValue();
                        if(StringUtils.isEmpty(organization)){
                            rowMessage += "答案不能为空；";
                        }
                        tempUserKB.setOrganization(organization);
                    }
                }else{
                    rowMessage += "第"+(c+1)+"列数据有问题，请仔细检查；";
                }
            }
            //拼接每行的错误提示
            if(!StringUtils.isEmpty(rowMessage)){
                errorMsg += br+"第"+(r+1)+"行，"+rowMessage;
            }else{
                userKnowledgeBaseList.add(tempUserKB);
            }
        }

        //删除上传的临时文件
        if(tempFile.exists()){
            tempFile.delete();
        }

        //全部验证通过才导入到数据库
//        if(StringUtils.isEmpty(errorMsg)){
            for(PolicyEntity userKnowledgeBase : userKnowledgeBaseList){
              this.saveAndflush(userKnowledgeBase);
//            }
            errorMsg = "导入成功，共"+userKnowledgeBaseList.size()+"条数据！";
                System.out.println(errorMsg+"-------------");
        }
        return errorMsg;
    }
}
