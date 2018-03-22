package com.example.demo.Controller;

import com.example.demo.biz.IPolicyService;
import com.example.demo.common.ExcelImportUtils;
import com.example.demo.entity.PolicyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author li
 * @create 2018-01-29 15:50
 * @desc 城市信息
 **/
@RestController
@RequestMapping("policy")
public class PolicyController {
    @Autowired
    IPolicyService iPolicyService;

    /*
     *查询分类
     */
    @RequestMapping("getPolicyByClassify")
    public List<PolicyEntity> getPolicyByClassify(String classify) {
        try {
            classify = new String(classify.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return iPolicyService.getPolicyByClassify(classify);
    }

    /*
     *查询全部
     */
    @RequestMapping("findAll")
    public List<PolicyEntity> findAll() {
        return iPolicyService.findAll();
    }

    /*
     * 删除
     */
    @RequestMapping("delete")
    public void delete(String ids) {
        iPolicyService.delete(ids);
    }

    /*
     * 修改 增加类型
     */
    @RequestMapping("saveAndflush")
    public void saveAndflush(@RequestBody PolicyEntity policyEntity) {
        System.out.println(policyEntity.getContent()+"----------------------");
        iPolicyService.saveAndflush(policyEntity);
    }

    /*
      三个条件
     */
    @RequestMapping("selectByim")
    public List<PolicyEntity> selectByim(String startDate, String endDate, String organization) {
        try {
            if (null != organization && !"".equals(organization)) {
                organization = new String(organization.getBytes("ISO-8859-1"), "UTF-8");
            }
            if (null != startDate && !"".equals(startDate)) {
                startDate = new String(startDate.getBytes("ISO-8859-1"), "UTF-8");
            }
            if (null != endDate && !"".equals(endDate)) {
                endDate = new String(endDate.getBytes("ISO-8859-1"), "UTF-8");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        List<PolicyEntity>  list= iPolicyService.selectByim(startDate, endDate, organization);
        return list;
    }

    @RequestMapping("/batchImportUserKnowledge")
    public String batchImportUserKnowledge(@RequestParam(value = "filename") MultipartFile file,
                                           HttpServletRequest request, HttpServletResponse response, HttpSession session
    ) throws IOException {

        //判断文件是否为空
        if (file == null) {
            session.setAttribute("msg", "文件不能为空！");
            return "redirect:toUserKnowledgeImport";
        }

        //获取文件名
        String fileName = file.getOriginalFilename();

        //验证文件名是否合格
        if (!ExcelImportUtils.validateExcel(fileName)) {
            session.setAttribute("msg", "文件必须是excel格式！");
            return "redirect:toUserKnowledgeImport";
        }

        //进一步判断文件内容是否为空（即判断其大小是否为0或其名称是否为null）
        long size = file.getSize();
        if (StringUtils.isEmpty(fileName) || size == 0) {
            session.setAttribute("msg", "文件不能为空！");
            return "redirect:toUserKnowledgeImport";
        }

        //批量导入
        String message = iPolicyService.batchImport(fileName, file);
        session.setAttribute("msg", message);
        return message;
    }

    /*
     *查询一条
     */
    @RequestMapping("findOne")
    public PolicyEntity findOne(String id) {
        return iPolicyService.findOne(id);
    }

}