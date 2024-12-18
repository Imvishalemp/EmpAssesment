package com.empassesment1.core.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.apache.sling.api.resource.ResourceResolverFactory;

import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.model.WorkflowModel;
import com.day.cq.workflow.WorkflowService;
import com.empassesment1.core.service.PageCreationService;

@Component(service = Servlet.class, property = {
    "sling.servlet.methods=GET",
    "sling.servlet.methods=POST",
    "sling.servlet.paths=/bin/assessment/createpage"
})
public class PageCreationServlet extends SlingAllMethodsServlet {

    @Reference
    private PageCreationService pageCreationService;

    @Reference
    private ResourceResolverFactory resolverFactory;

    @Reference
    private WorkflowService workflowService; // WorkflowService reference

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        try {
            response.getWriter().write("GET method is called. Thank you.");
        } catch (Exception e) {
            response.getWriter().write("Error creating pages: " + e.getMessage());
        }
    }

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        // Map<String, Object> authInfo = new HashMap<>();
        // authInfo.put(ResourceResolverFactory.SUBSERVICE, "vishal");
        ResourceResolver resourceResolver = null;
        
            resourceResolver = request.getResourceResolver();
        
        
        if (resourceResolver != null) {
            try {
                // Create pages using PageCreationService
                pageCreationService.createPage(resourceResolver, "page-1", "Page 1");
                pageCreationService.createPage(resourceResolver, "page-2", "Page 2");
                response.getWriter().write("Pages created successfully.");



                // Trigger Workflow for created pages
                String playLoad1="/content/empassesment1/lan/en_ie/page-1";
                String playLoad2="/content/empassesment1/lan/en_ie/page-2";

                try{
                   WorkflowSession workflowSession=resourceResolver.adaptTo(WorkflowSession.class);
                   WorkflowModel workflowModel=workflowSession.getModel("/var/workflow/models/wfmodel");
                   WorkflowData workflowData1=workflowSession.newWorkflowData("JCR_PATH", playLoad1);
                   WorkflowData workflowData2=workflowSession.newWorkflowData("JCR_PATH", playLoad2);
                   workflowSession.startWorkflow(workflowModel, workflowData1);
                   workflowSession.startWorkflow(workflowModel, workflowData2);
                }
                catch(Exception e){
                    response.getWriter().write("unable to do that please");

                }
               

            } catch (Exception e) {
                response.getWriter().write("Error creating pages: " + e.getMessage());
            }
        } else {
            response.getWriter().write("Failed to obtain ResourceResolver.");
        }
    }

   
}
