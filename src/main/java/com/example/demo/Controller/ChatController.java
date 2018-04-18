package com.example.demo.Controller;

import com.example.demo.dao.IChatRepository;
import com.example.demo.entity.ChatEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author li
 * @create 2018-03-28 10:20
 * @desc 聊天
 **/
@RestController
@RequestMapping("chat")
public class ChatController {
    @Autowired
    IChatRepository iChatRepository;
    /**
     * 信息查询
     */
    @RequestMapping("chat_find")
    @ResponseBody
    public List chat_find(String sessionId){
        System.out.println(sessionId);
       return iChatRepository.findBySessionId(sessionId);

    }
    /**
     * 信息查询
     */
    @RequestMapping("findAll")
    @ResponseBody
    public List findAll(){
        List all=new ArrayList();
       List<Object[]> list=iChatRepository.findSessionIdAndChatName();
       if (list.size()>0){
           for (Object[] s:list){
               Map map=new HashMap();
               map.put("sessionId",s[0].toString());
               map.put("chatName",s[1].toString());
               all.add(map);
           }
       }
        return all;

    }
    /**
     * 信息增加
     */
    @RequestMapping("saveAndflush")
    public void saveAndflush(ChatEntity chatEntity,HttpServletRequest request){
        try {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date now =new Date();
            String nowTime=sdf.format(now);
            chatEntity.setChatDate(sdf.parse(nowTime));
            iChatRepository.saveAndFlush(chatEntity);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    /**
     * 信息删除
     */
    @RequestMapping("deleteBySessionId")
    public void deleteBySessionId(String sessionId){
        System.out.println(sessionId);
        iChatRepository.deleteBySessionId(sessionId);

    }
    /**
     * 随机生成英文昵称
     */
    @RequestMapping("chatName")
    public Map chatName(){
        String a = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String sessionId= UUID.randomUUID().toString();
        StringBuffer sb=new StringBuffer();
        char[] rands = new char[8];
        for (int i = 0; i < rands.length; i++)
        {
            int rand = (int) (Math.random() * a.length());
            rands[i] = a.charAt(rand);
        }

        for(int i=0;i<rands.length;i++){
            sb.append(rands[i]);
        }
        Map map=new HashMap();
        map.put("chatName",sb.toString());
        map.put("sessionId",sessionId);
        return  map;
    }
    /**
     * 轮询后台 是否有信息进来
     */
    @RequestMapping("lx")
    public int lx(){
        int list=iChatRepository.lx();
        return list;
    }
}
