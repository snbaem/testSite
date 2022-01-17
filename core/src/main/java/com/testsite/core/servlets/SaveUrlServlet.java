package com.testsite.core.servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceDescription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet that converts desired page to pdf
 */
@Component(service = Servlet.class, property = { Constants.SERVICE_DESCRIPTION + "= Dynamic Drop Down",
                // "sling.servlet.resourceTypes=" + "/apps/dropDownLIsting"
                "sling.servlet.paths=" + "/bin/getpdf" })
@ServiceDescription("Simple Demo Servlet")
public class SaveUrlServlet extends SlingAllMethodsServlet {

        private static final long serialVersionUID = 1L;
        public final Logger LOG = LoggerFactory.getLogger(getClass());

        @Override
        protected void doGet(final SlingHttpServletRequest req, final SlingHttpServletResponse resp)
                        throws ServletException, IOException {

                try {
                        //URL url = new URL("https://commons.wikimedia.org/wiki/File:Sunflower_from_Silesia2.jpg");
                        String path = req.getParameter("url");
                        if (!StringUtils.endsWith(path, ".html") && !StringUtils.endsWith(path, ".jpg") && !StringUtils.endsWith(path, ".jpeg") && !StringUtils.endsWith(path, ".com")) {
                                path = path + ".html";
                        }
                        //String fileName = StringUtils.substring(path, path.lastIndexOf("/"));
                        URL url = new URL(path);
                        InputStream in = url.openStream();
                        FileOutputStream fos = new FileOutputStream(new File("test"+".html"));

                        int length = -1;
                        byte[] buffer = new byte[1024];// buffer for portion of data from connection
                        while ((length = in.read(buffer)) > -1) {
                                fos.write(buffer, 0, length);
                        }
                        fos.close();
                        in.close();
                        resp.getWriter().write("Content Saved. Saved in same folder as jar");
                } catch (Exception e) {
                        LOG.error("Exception occured", e);                }

        }

}
