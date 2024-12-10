package com.empassesment1.core.service;

import org.apache.sling.api.resource.ResourceResolver;


import com.day.cq.wcm.api.Page;


public interface PageCreationService {
    
    Page createPage(ResourceResolver resourceResolver,String pageName, String title);
}
