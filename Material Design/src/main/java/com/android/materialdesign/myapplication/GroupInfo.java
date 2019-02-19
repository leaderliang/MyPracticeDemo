package com.android.materialdesign.myapplication;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by liangyuanyuan on 2017/4/26.
 */
public class GroupInfo implements Serializable {

    /**
     * 网易云 id
     */
    @SerializedName("id")
    public String id;
    /**
     * 昵称
     */
    @SerializedName("name")
    public String nickName;
    /**
     * 用户类型
     * 0：主讲老师 1：辅导老师 2：班主任 -1:学员
     */
    @SerializedName("type")
    public String userType;
    /**
     * 头像地址
     */
    @SerializedName("pic")
    public String avatarUrl;

}
