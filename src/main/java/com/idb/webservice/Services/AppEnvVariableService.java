package com.idb.webservice.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idb.webservice.Entities.AppEnvVariable;
import com.idb.webservice.Entities.IdClasses.AppEnvVariableId;
import com.idb.webservice.JpaRepo.AppEnvVariableRepo;

@Service
public class AppEnvVariableService {
    @Autowired
    private AppEnvVariableRepo repo;

    public List<AppEnvVariable> retrieveAll() {
        return repo.findAll();
    }

    public AppEnvVariable retrieveById(AppEnvVariableId appEnvVariableId) {
        AppEnvVariable tmp = null;

        try {
            tmp = repo.findById(appEnvVariableId).get();
        } catch (Exception e) {
            //TODO: handle exception
        }

        return tmp;
    }

    public AppEnvVariable updateOne(AppEnvVariable appEnvVariable) {
        AppEnvVariableId appEnvVariableId = new AppEnvVariableId(appEnvVariable.getId(), appEnvVariable.getAppId(), appEnvVariable.getAppVersion());

        AppEnvVariable tmpSaved = null;

        try {
            repo.findById(appEnvVariableId).get();

            tmpSaved = repo.save(appEnvVariable);
        } catch (Exception e) {
            //TODO: handle exception
        }

        return tmpSaved;
    }
}
