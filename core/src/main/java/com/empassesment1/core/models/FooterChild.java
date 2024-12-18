package com.empassesment1.core.models;

import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.api.resource.Resource;
import lombok.Getter;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Getter
public class FooterChild {

     @ValueMapValue
    protected String label;

    @ValueMapValue
    protected String pathLink;

}
