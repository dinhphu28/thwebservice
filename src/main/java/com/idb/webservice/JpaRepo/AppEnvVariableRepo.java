package com.idb.webservice.JpaRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idb.webservice.Entities.AppEnvVariable;
import com.idb.webservice.Entities.IdClasses.AppEnvVariableId;

@Repository
public interface AppEnvVariableRepo extends JpaRepository<AppEnvVariable, AppEnvVariableId> {
    
}
