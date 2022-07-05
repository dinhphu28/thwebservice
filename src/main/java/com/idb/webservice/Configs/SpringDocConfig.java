package com.idb.webservice.Configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info = @Info (
        title = "TH Milk Joget APIs Spec",
        description = "TH Milk Joget Wflow Plugin APIs",
        contact = @Contact(
            name = "Anthony",
            url = "https://idb.com.vn",
            email = "support@idb.com.vn"
        ),
        license = @License(
            name = "MIT license",
            url = "https://idb.com.vn/license"
        )
    ),
    servers = {
        @Server(
            url = "https://3cxcrm.thmilk.vn/ws",
            description = "Run on production"
        ),
        @Server(
        url = "http://localhost:8080",
        description = "Run on localhost"
        )
    }
)
public class SpringDocConfig {
    
}
