package stuff;

import java.io.IOException;
import java.util.Enumeration;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class NumberGuesserPortlet extends GenericPortlet {

   @Override
   public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
         throws PortletException, IOException {

      String parameterName = "number";
      String parameterValue = actionRequest.getParameter(parameterName);

      actionResponse.setRenderParameter(parameterName, parameterValue);
   }

   @Override
   protected void doView(RenderRequest request, RenderResponse response)
         throws PortletException, IOException {

      PortletContext context = this.getPortletContext();
      PortletSession session = request.getPortletSession();

      if(session.getAttribute("magicNumber") == null) {
         // generate a magic number to start the game
         int magicNumber = (int) (System.currentTimeMillis() % 9) + 1;
         System.out.println("magicNumber = " + magicNumber);

         // populate the session with pertinent Java objects
         session.setAttribute("magicNumber", new Integer(magicNumber));
         session.setAttribute("guesses", "0");

         // place the message in the session
         session.setAttribute("message", "Guess the number!");
      }
      else {
         // get the magicNumber and number of guesses out of the session
         // NOTE: what will happen if the user didn't type anything in?
         Integer magicNumber = (Integer) session.getAttribute("magicNumber");
         String guesses = (String) session.getAttribute("guesses");

         // increment the number of guesses
         guesses = "" + (Integer.parseInt(guesses) + 1);
         session.setAttribute("guesses", guesses);

         // what did the user guess?
         Integer guess = new Integer(request.getParameter("number"));

         // figure out a message to return to the user
         if(guess.intValue() > magicNumber.intValue()) {
            session.setAttribute("message", "Guess lower");
         }
         else {
            session.setAttribute("message", "Guess higher");
         }

         if(guess.intValue() == magicNumber.intValue()) {
            String message = magicNumber + " is correct.  Play again!";
            session.setAttribute("message", message);

            // purge the session of unneeded data
            session.removeAttribute("magicNumber");
         }
      }

      String url = "/numberguesser.jsp";
      context.getRequestDispatcher(url).include(request, response);
   }
}
