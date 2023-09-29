package com.aemsite.demo.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import javax.inject.Inject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.api.resource.Resource;
@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Contact {
    @ValueMapValue
    private String contactName;
    @ValueMapValue
    private String contactEmail;
    public String getContactName() {
        return contactName;
    }
    public String getContactEmail() {
        return contactEmail;
    }
}