package com.empassesment1.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = SlingHttpServletRequest.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class HeroModel {

     @ValueMapValue
 protected   String title;

    @ValueMapValue
    protected  String fileReference;

    
    @ValueMapValue
    protected   String description;

    public String getTitle() {
        return title;
    }

    public String getFileReference() {
        return fileReference;
    }

    public String getDescription() {
        return description;
    }

    public String getLable() {
        return lable;
    }

    public String getUrl() {
        return url;
    }

    @ValueMapValue
    protected  String lable;

    @ValueMapValue
    protected  String url;

}
