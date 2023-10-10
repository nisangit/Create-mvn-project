package com.aemsite.demo.core.servlets;

import com.aemsite.demo.core.services.SampleNodeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.aemsite.demo.core.services.SampleNodeService;

import javax.jcr.*;

import io.wcm.testing.mock.aem.junit5.AemContext;
import org.apache.sling.api.resource.ResourceResolver;

class NodeTest {
    private AemContext aemContext = new AemContext();

    private Session session;

    private Repository repository;

    private SampleNodeService sampleNodeService;

    private Node rootNode;

    private Property property;

    @BeforeEach
    public void setUp() throws RepositoryException
    {
        ResourceResolver resolver = aemContext.resourceResolver();
        session = mock(Session.class);
        repository = mock(Repository.class);
        rootNode = mock(Node.class);
        property = mock(Property.class);
        //when(resolver.adaptTo(Session.class)).thenReturn(session);
        sampleNodeService = new SampleNodeServiceImpl();

    }

    @Test
    void createNode() throws RepositoryException
    {
        String parentPath="/content/aemsite";
        String nodeName = "testServiceNode";
        String type="nt:unstructured";
        String expectedRes="A new node with name "+nodeName+" was created aty the path "+parentPath;
        when(session.getNode(anyString())).thenReturn(rootNode);
        when(rootNode.addNode(anyString(),anyString())).thenReturn(rootNode);
        when(rootNode.setProperty(anyString(),anyString())).thenReturn(property);
        when(rootNode.isNew()).thenReturn(true);
        String node = sampleNodeService.createNode(session, parentPath, nodeName, type);
        assertNotNull(node);
        assertEquals(expectedRes,sampleNodeService.createNode(session,parentPath,nodeName,type));
    }
}









