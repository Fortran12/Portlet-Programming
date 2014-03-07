<%@ page session = "false" contentType = "text/html" %>
<%@ taglib uri = "http://java.sun.com/portlet" prefix = "portlet" %>
<portlet:defineObjects />
<b>Welcome to this simple JSP</b><br />
We did some snooping on you.<br />
This is what we learned about your browser:
<i><%= renderRequest.getProperty("user-agent") %></i><br />
And we know what language you speak, it's:
<i><%= renderRequest.getLocale( ).getDisplayLanguage( ) %></i>
