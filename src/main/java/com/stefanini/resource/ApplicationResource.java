package com.stefanini.resource;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;

import com.stefanini.resource.util.ObjectMapperContextResolver;


import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

@ApplicationPath("/api")
public class ApplicationResource extends Application{

	public ApplicationResource(@Context ServletConfig servletConfig) {
	    BeanConfig config = new BeanConfig();
	    config.setTitle("Rede Social API");
	    config.setDescription("Rede Social");
	    config.setVersion("1.0.0");
	    config.setHost("localhost:8080");
	    config.setBasePath("/treinamento/api");
	    config.setSchemes(new String[] { "http" });
	    config.setResourcePackage("com.stefanini.resource");
	    config.setScan(true);
	}
    
	@Override
	public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<Class<?>>();
        resources.add(ObjectMapperContextResolver.class);
        resources.add(PessoaResource.class);
        resources.add(EnderecoResource.class);
        //swagger
        resources.add(ApiListingResource.class);
        resources.add(SwaggerSerializers.class);
		return super.getClasses();
	}
	
}
