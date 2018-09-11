package com.teamdev.app.config;

import java.net.UnknownHostException;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.teamdev.app.web.rest.CountryResource;
import com.teamdev.app.web.rest.PersonneResource;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

@Configuration
public class JerseyConfiguration extends ResourceConfig {

    @Autowired
    public JerseyConfiguration() throws UnknownHostException {
    	this.register(PersonneResource.class);
        this.register(CountryResource.class);
        this.configureSwagger();
        property(ServletProperties.FILTER_FORWARD_ON_404, true);
    }

    public void configureSwagger() {
        this.register(ApiListingResource.class);
        this.register(SwaggerSerializers.class);
        BeanConfig config = new BeanConfig();
        config.setConfigId("SpringJerseySwagger");
        config.setTitle("Spring, Jersey, and Swagger");
        config.setVersion("1.0.0");
        config.setBasePath("/");
        config.setResourcePackage("com.teamdev.app.web.rest");
        config.setScan(true);
    }
}
