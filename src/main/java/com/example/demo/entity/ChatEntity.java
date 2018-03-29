package com.example.demo.entity;

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
    @Column(name = "sessionId")

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatEntity that = (ChatEntity) o;
        return Objects.equals(chatId, that.chatId) &&
                Objects.equals(chatName, that.chatName) &&
                Objects.equals(chatRole, that.chatRole) &&
                Objects.equals(chatText, that.chatText) &&
                Objects.equals(chatDate, that.chatDate) &&
                Objects.equals(sessionId, that.sessionId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(chatId, chatName, chatRole, chatText, chatDate, sessionId);
    }
}
