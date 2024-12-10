package com.empassesment1.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.empassesment1.core.service.PageCreationService;

@Component(service = Servlet.class , property = {
    "sling.servlet.methods=GET",
    "sling.servlet.methods=POST",
    "sling.servlet.paths=/bin/assessment/createpage"  
} )
public class PageCreationServlet  extends SlingAllMethodsServlet{

    @Reference
    private PageCreationService pageCreationService;

    ResourceResolver resourecResolver;

      @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws  IOException {
        try{
        response.getWriter().write("GET method is called. Thank you .");
        }
        catch(Exception e)
        {
            response.getWriter().write("Error creating pages: " + e.getMessage());        }

    }

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        ResourceResolver resourceResolver = request.getResourceResolver();
        
        if (resourceResolver != null) {
            try {
                pageCreationService.createPage(resourceResolver, "page-1", "Page 1");
                pageCreationService.createPage(resourceResolver, "page-2", "Page 2");
                response.getWriter().write("Pages created successfully.");
            } catch (Exception e) {
                response.getWriter().write("Error creating pages: " + e.getMessage());
            }
        } else {
            response.getWriter().write("Failed to obtain ResourceResolver.");
        }
    }

}
