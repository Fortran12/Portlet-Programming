package stuff;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class CountrySnooperPortlet extends GenericPortlet {
   public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
      // figure out the user's preferred language
      String language = request.getLocale().getDisplayLanguage();

      // always set the content type before generating output
      response.setContentType("text/html");

      // use the PortletResponse to generate output
      response.getWriter().print("We love people who speak ");
      response.getWriter().print(language);
      response.getWriter().print("!");
   }
}
