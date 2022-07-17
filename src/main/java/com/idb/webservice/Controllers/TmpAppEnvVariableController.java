// package com.idb.webservice.Controllers;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.MediaType;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.idb.webservice.Entities.AppEnvVariable;
// import com.idb.webservice.Entities.IdClasses.AppEnvVariableId;
// import com.idb.webservice.Services.AppEnvVariableService;

// @RestController
// @CrossOrigin("*")
// @RequestMapping("/api/v1/appEnvVariables")
// public class TmpAppEnvVariableController {
//     @Autowired
//     private AppEnvVariableService appEnvVariableService;

//     @GetMapping(
//         produces = MediaType.APPLICATION_JSON_VALUE
//     )
//     public ResponseEntity<Object> retrieveAll() {
//         ResponseEntity<Object> entity;

//         List<AppEnvVariable> appEnvVariables = appEnvVariableService.retrieveAll();

//         entity = new ResponseEntity<>(appEnvVariables, HttpStatus.OK);

//         return entity;
//     }

//     @GetMapping(
//         value = "/cat",
//         produces = MediaType.APPLICATION_JSON_VALUE
//     )
//     public ResponseEntity<Object> retrieveById() {
//         ResponseEntity<Object> entity;

//         AppEnvVariableId appEnvVariableId = new AppEnvVariableId("chiendich_count_data", "sp2", 1);

//         AppEnvVariable appEnvVariable = appEnvVariableService.retrieveById(appEnvVariableId);

//         entity = new ResponseEntity<>(appEnvVariable, HttpStatus.OK);

//         return entity;
//     }
// }
