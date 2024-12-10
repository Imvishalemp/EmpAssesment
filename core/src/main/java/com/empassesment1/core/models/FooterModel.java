package com.empassesment1.core.models;

import java.util.List;

import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.api.resource.Resource;


import lombok.Getter;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Getter
public class FooterModel {

    @ValueMapValue
    protected String fileReference;

    @ValueMapValue
    protected String richtext;

    @ValueMapValue
    protected String sectionheader;

    @ChildResource
    List<FooterChild> actions;

}
