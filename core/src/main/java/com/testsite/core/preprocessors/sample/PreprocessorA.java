package com.testsite.core.preprocessors.sample;

import com.day.cq.replication.Preprocessor;
import com.day.cq.replication.ReplicationAction;
import com.day.cq.replication.ReplicationActionType;
import com.day.cq.replication.ReplicationException;
import com.day.cq.replication.ReplicationOptions;

import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
        immediate = true
)
public class PreprocessorA implements Preprocessor {
    private static final Logger log = LoggerFactory.getLogger(PreprocessorA.class);

    @Reference
    private ResourceResolverFactory resourceResolverFactory;


    @Override
    public void preprocess(final ReplicationAction replicationAction,
                           final ReplicationOptions replicationOptions) throws ReplicationException {

        if (replicationAction == null || !ReplicationActionType.ACTIVATE.equals(replicationAction.getType())) {
            // Do nothing..
            return;
        }
        
        log.info(getClass().getName()+ " called...");

        // Get the path of the replication payload
        final String path = replicationAction.getPath();
        log.info(getClass().getName()+ " called... for path: " + path);

        //ResourceResolver resourceResolver = null;

        /* try {
            Map<String, Object> param = new HashMap<String, Object>();
            param.put(ResourceResolverFactory.SUBSERVICE, "jqom");
              
                         
                //Invoke the getServiceResourceResolver method to create a Session instance
                resourceResolver = resourceResolverFactory.getServiceResourceResolver(param);
            // Get the payload as a resource; In this case getting the jcr:content node since we'll
            // be writing a custom value to it (this will fail if writing to cq:Page resource)
            final Resource resource = resourceResolver.getResource(path).getChild("jcr:content");

            if (resource == null) {
                // Remember; ALL replications go through this; so check to make sure that what
                // you're doing is Universal OR put your checks in early.
                log.warn("Could not find jcr:content node for resource to apply checksum!");
                return;
            }



            if (resourceResolver.hasChanges()) {
                resourceResolver.commit();
            }
           
        } catch (LoginException e) {
            // To prevent Replication from happening, throw a ReplicationException
            throw new ReplicationException(e);
        } catch (PersistenceException e) {
            // To prevent Replication from happening, throw a ReplicationException
            throw new ReplicationException(e);
        } finally {
                if (resourceResolver != null && resourceResolver.isLive()) {
                // Always close resource resolver you open
                resourceResolver.close();
            }
        }
    } */

}
}

