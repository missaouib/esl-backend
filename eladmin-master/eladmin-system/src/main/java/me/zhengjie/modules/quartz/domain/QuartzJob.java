/*
 *  Copyright 2019-2020 Zheng Jie
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package me.zhengjie.modules.quartz.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import me.zhengjie.base.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

import static me.zhengjie.utils.JpaRepositoryUtil.SCHEMA_NAME_1;

/**
 * @author Zheng Jie
 * @date 2019-01-07
 */
@Getter
@Setter
@Entity
@Table(name = "sys_quartz_job", schema = SCHEMA_NAME_1)
public class QuartzJob extends BaseEntity implements Serializable {

    public static final String JOB_KEY = "JOB_KEY";

    @Id
    @Column(name = "job_id")
//    @NotNull(groups = {Update.class})
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", columnDefinition ="nvarchar(255)")
    @Transient
    @ApiModelProperty(value = "用于子任务唯一标识", hidden = true)
    private String uuid;

    @Column(columnDefinition ="nvarchar(255)")
    @ApiModelProperty(value = "定时器名称")
    private String jobName;

    @Column(columnDefinition ="nvarchar(255)")
    @NotBlank
    @ApiModelProperty(value = "Bean名称")
    private String beanName;

    @Column(columnDefinition ="nvarchar(255)")
    @NotBlank
    @ApiModelProperty(value = "方法名称")
    private String methodName;

    @Column(columnDefinition ="nvarchar(255)")
    @ApiModelProperty(value = "参数")
    private String params;

    @Column(columnDefinition ="nvarchar(255)")
    @NotBlank
    @ApiModelProperty(value = "cron表达式")
    private String cronExpression;

    @ApiModelProperty(value = "状态，暂时或启动")
    private Boolean isPause = false;

    @ApiModelProperty(value = "负责人")
    private String personInCharge;

    @ApiModelProperty(value = "报警邮箱")
    private String email;

    @Column(columnDefinition ="nvarchar(255)")
    @ApiModelProperty(value = "子任务")
    private String subTask;

    @ApiModelProperty(value = "失败后暂停")
    private Boolean pauseAfterFailure;

    @Column(columnDefinition ="nvarchar(255)")
    @NotBlank
    @ApiModelProperty(value = "备注")
    private String description;
}