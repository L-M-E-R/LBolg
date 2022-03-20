/**
 * @program: LBolg
 * @description: CategoryVo
 * @author: Lmer
 * @create: 2022-03-20 13:52
 **/
package com.lmer.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryVo {
    private Long id;
    /**
     * 分类名
     */
    private String name;
}
