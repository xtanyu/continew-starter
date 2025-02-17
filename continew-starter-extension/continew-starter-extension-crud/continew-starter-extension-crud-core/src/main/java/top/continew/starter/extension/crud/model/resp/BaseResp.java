/*
 * Copyright (c) 2022-present Charles7c Authors. All Rights Reserved.
 * <p>
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE 3.0;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/lgpl.html
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package top.continew.starter.extension.crud.model.resp;

import cn.crane4j.annotation.Assemble;
import cn.crane4j.annotation.Mapping;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import top.continew.starter.extension.crud.constant.ContainerPool;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 响应参数基类
 *
 * @author Charles7c
 * @since 1.0.0
 */
public class BaseResp implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @Schema(description = "ID", example = "1")
    @ExcelProperty(value = "ID", order = 1)
    private Long id;

    /**
     * 创建人
     */
    @JsonIgnore
    @Assemble(container = ContainerPool.USER_NICKNAME, props = @Mapping(ref = "createUserString"))
    private Long createUser;

    /**
     * 创建人
     */
    @Schema(description = "创建人", example = "超级管理员")
    @ExcelProperty(value = "创建人", order = Integer.MAX_VALUE - 4)
    private String createUserString;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间", example = "2023-08-08 08:08:08", type = "string")
    @ExcelProperty(value = "创建时间", order = Integer.MAX_VALUE - 3)
    private LocalDateTime createTime;

    /**
     * 是否禁用修改
     */
    @Schema(description = "是否禁用修改", example = "true")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean disabled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public String getCreateUserString() {
        return createUserString;
    }

    public void setCreateUserString(String createUserString) {
        this.createUserString = createUserString;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }
}
