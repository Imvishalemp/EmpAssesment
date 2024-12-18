package com.empassesment1.core.service.impl;

import org.apache.sling.api.resource.ResourceResolver;
import org.osgi.service.component.annotations.Component;


import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.WCMException;
import com.empassesment1.core.service.PageCreationService;

@Component(service = PageCreationService.class, immediate = true)
public class PageCreationsServiceImpl  implements PageCreationService {

     @Override
     public Page createPage(ResourceResolver resourceResolver, String pageName, String title) {
        String parentPath = "/content/empassesment1/lan/en_ie";
        String templatePath = "/conf/empassesment1/settings/wcm/templates/article3";

        Page page = null;
            PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
            if (pageManager != null) {
                try {
                    page = pageManager.create(parentPath, pageName, templatePath, title);
                } catch (WCMException e) {
                    e.printStackTrace();
                }
            }

        return page;
    }
}
