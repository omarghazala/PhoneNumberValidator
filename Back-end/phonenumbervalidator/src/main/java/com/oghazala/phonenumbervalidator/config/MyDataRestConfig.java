package com.oghazala.phonenumbervalidator.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;

    public  MyDataRestConfig(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);

        exposeIds(config);
    }

    private void exposeIds(RepositoryRestConfiguration config) {
        // get list of all entities
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        // create an array of  all entity types
        List<Class> entityCLasses = new ArrayList<>();

        // get the entity types  for the entities
        for(EntityType tempEntityType: entities ){
            entityCLasses.add(tempEntityType.getJavaType());
        }

        // expose the ids
        Class[] domianTypes= entityCLasses.toArray(new Class[0]);
        config.exposeIdsFor(domianTypes);

    }
}
