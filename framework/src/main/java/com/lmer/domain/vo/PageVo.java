/**
 * @program: LBolg
 * @description: 所有的分页
 * @author: Lmer
 * @create: 2022-03-20 15:03
 **/
package com.lmer.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageVo {
    private List rows;
    private Long total;
}
