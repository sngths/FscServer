package com.tianxing.database.dao.result;

import org.apache.ibatis.type.Alias;

/**
 * Created by tianxing on 17/1/6.
 * 数据库查询得到的单条用户信息
 */
@Alias("userInfo")
public class UserInfo {
    Long id;
    String username;
    String password;
    String salt;
    String userType;
    Long modificationTimestamp;
    Long creationTimestamp;
    String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Long getModificationTimestamp() {
        return modificationTimestamp;
    }

    public void setModificationTimestamp(Long modificationTimestamp) {
        this.modificationTimestamp = modificationTimestamp;
    }

    public Long getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(Long creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
