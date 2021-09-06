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
package me.zhengjie.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

import static me.zhengjie.utils.JpaRepositoryUtil.SCHEMA_NAME_1;

/**
 * @author Zheng Jie
 * @date 2018-11-24
 */
@Entity
@Getter
@Setter
@Table(name = "sys_log", schema = SCHEMA_NAME_1)
@NoArgsConstructor
public class Log  implements Serializable {

    @Id
    @Column(name = "log_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition ="nvarchar(255)")
    /** 操作用户 */
    private String username;

    @Column(columnDefinition ="nvarchar(255)")
    /** 描述 */
    private String description;

    @Column(columnDefinition ="nvarchar(255)")
    /** 方法名 */
    private String method;

    @Column(columnDefinition ="nvarchar(255)")
    /** 参数 */
    private String params;

    @Column(columnDefinition ="nvarchar(255)")
    /** 日志类型 */
    private String logType;

    @Column(columnDefinition ="nvarchar(255)")
    /** 请求ip */
    private String requestIp;

    @Column(columnDefinition ="nvarchar(255)")
    /** 地址 */
    private String address;

    @Column(columnDefinition ="nvarchar(255)")
    /** 浏览器  */
    private String browser;

    /** 请求耗时 */
    private Long time;

    /** 异常详细  */
    private byte[] exceptionDetail;

    /** 创建日期 */
    @CreationTimestamp
    private Timestamp createTime;

    public Log(String logType, Long time) {
        this.logType = logType;
        this.time = time;
    }
}
