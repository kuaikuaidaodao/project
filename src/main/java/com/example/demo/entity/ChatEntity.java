package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @author li
 * @create 2018-03-28 11:25
 * @desc 聊天实体类
 **/
@Entity
@Table(name = "chat")
public class ChatEntity {
    /**
     * 聊天id
     */
    private Long chatId;

    /**
     * 聊天姓名
     */
    private String chatName;

    /**
     * 聊天角色
     */
    private String chatRole;

    /**
     * 聊天内容
     */
    private String chatText;

    /**
     * 聊天时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd hh:mm:ss")
    private Date chatDate;
    /**
     * sessionId 唯一标识
     */
    private String sessionId;


    public ChatEntity() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "persistenceGenerator", strategy = "increment")
    @Column(name = "chat_id", nullable = false, precision = 0 )
    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }
    @Basic
    @Column(name = "chat_name")
    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }
    @Basic
    @Column(name = "chat_role")
    public String getChatRole() {
        return chatRole;
    }

    public void setChatRole(String chatRole) {
        this.chatRole = chatRole;
    }
    @Basic
    @Column(name = "chat_text")
    public String getChatText() {
        return chatText;
    }

    public void setChatText(String chatText) {
        this.chatText = chatText;
    }
    @Basic
    @Column(name = "chat_date")
    public Date getChatDate() {
        return chatDate;
    }

    public void setChatDate(Date chatDate) {
        this.chatDate = chatDate;
    }
    @Basic
    @Column(name = "session_Id")

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

}
