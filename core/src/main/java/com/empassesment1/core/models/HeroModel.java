package com.empassesment1.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import lombok.Getter;



@Model(adaptables = SlingHttpServletRequest.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Getter
public class HeroModel {

     @ValueMapValue
 protected   String title;

    @ValueMapValue
    protected  String fileReference;

    
    @ValueMapValue
    protected   String description;


    @ValueMapValue
    protected  String lable;

    @ValueMapValue
    protected  String url;

}
