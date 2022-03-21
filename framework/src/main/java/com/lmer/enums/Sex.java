/**
 * @program: LBolg
 * @description:
 * @author: Lmer
 * @create: 2022-03-21 12:34
 **/
package com.lmer.enums;

public enum Sex {
    //
    man(0, "男"),
    woman(1, "女"),
    unkown(2, "未知");

    int code;
    String sex;

    Sex(int code, String sex) {
        this.code = code;
        this.sex = sex;
    }
}
