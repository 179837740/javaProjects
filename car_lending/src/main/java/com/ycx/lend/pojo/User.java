package com.ycx.lend.pojo;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@Entity
@Table(name = "user")
public class User implements Serializable {
  @Id
  private String userId;

  private String userName;

  private String password;

  private String realName;

  private String idNumber;

  private String emil;

  private String phoneNum;

  private Date loginTime;

}
