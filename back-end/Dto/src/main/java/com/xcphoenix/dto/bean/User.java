package com.xcphoenix.dto.bean;

import com.xcphoenix.dto.validator.ValidateGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;

/**
 * @author      xuanc
 * @date        2019/8/7 下午3:24
 * @version     1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    /**
     * 判断登录时第一个字符是否是数字，来确定是手机号登录还是用户名登录
     */

    private Integer userId;

    @Pattern(regexp = "^[a-zA-z][a-zA-Z0-9_]{2,15}$", message = "用户名格式错误")
    private String userName;

    private String userAvatar;

    @NotBlank(message = "手机号不能为空", groups = {ValidateGroup.addData.class})
    @Pattern(regexp = "^1([34578])\\d{9}$",message = "手机号码格式错误")
    private String userPhone;

    /**
     * TODO 加入验证码后移除验证
     */
    @NotBlank(message = "密码不能为空", groups = {ValidateGroup.addData.class})
    private String userPassword;
    private Boolean isSetPasswd;

    private String wechatOpenid;
    private int userSex;
    private int status;
    private Timestamp gmtCreate;

}
