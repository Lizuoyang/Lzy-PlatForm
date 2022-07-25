package com.lzy.platform.domain;

import lombok.Data;

/**
 * 图片验证码实体
 *
 * @author 2428
 * @date 2022/07/25
 */
@Data
public class ImageCaptcha {

    private String captchaKey;

    private String captchaImage;
}
