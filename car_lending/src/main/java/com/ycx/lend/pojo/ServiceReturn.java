package com.ycx.lend.pojo;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author ycx
 * @Date 2022/1/22 15:23
 * @Description
 */

@Data
@ToString
@Entity
@Table(name = "service_return")
public class ServiceReturn {

    @Id
    private Integer returnNum;

    private String returnName;

    private Integer returnCode;
}
