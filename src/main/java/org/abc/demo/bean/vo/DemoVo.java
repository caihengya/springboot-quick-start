package org.abc.demo.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 结果返参
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DemoVo {

    private Integer id;
    private String demoName;
    private String demoPassword;
}