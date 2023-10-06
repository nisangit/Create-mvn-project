package com.aemsite.demo.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(
        service = Servlet.class,
        property = {
                "sling.servlet.paths=/bin/fetchTitle",
                "sling.servlet.methods=GET"
        }
)
public class fetchNameServlet extends SlingSafeMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        String componentPath = "/apps/aemsite/components/content/Mytitle";
        ResourceResolver resolver = request.getResourceResolver();
        Resource resource = resolver.getResource(componentPath);

        if (resource != null) {
            ValueMap properties = resource.adaptTo(ValueMap.class);
            String title = properties.get("jcr:title", String.class);

            response.getWriter().write(title);
        } else {
            response.getWriter().write("Component not found");
        }
    }
}
