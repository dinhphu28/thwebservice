package com.idb.webservice.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.idb.webservice.Entities.IdClasses.AppEnvVariableId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "app_env_variable")
@IdClass(AppEnvVariableId.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppEnvVariable {

    @Id
    @Column(name = "id")
    private String id;

    @Id
    @Column(name = "appid")
    private String appId;

    @Id
    @Column(name = "appversion")
    private Integer appVersion;

    @Column(name = "value")
    private String value;

    @Column(name = "remarks")
    private String remarks;
}
