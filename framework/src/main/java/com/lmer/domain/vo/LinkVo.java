/**
 * @program: LBolg
 * @description:
 * @author: Lmer
 * @create: 2022-03-20 17:13
 **/
package com.lmer.domain.vo;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class LinkVo {

    private Long id;

    private String name;

    private String logo;

    private String description;
    /**
     * 网站地址
     */
    private String address;

}
