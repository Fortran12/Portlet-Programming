package stuff;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class GettingHeadersPortlet extends GenericPortlet {
   protected void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.print("<b>These headers were sent:</b><br />");
    java.util.Enumeration enumeration = request.getPropertyNames();
    while(enumeration.hasMoreElements()) {
       String name = enumeration.nextElement().toString();
       String value = request.getProperty(name);
       out.print("<br />");
       out.print(name + ": " + value);
    }
   }
}
