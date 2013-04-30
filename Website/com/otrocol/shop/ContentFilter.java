package filters;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

/** This is a content negotiation filter, which can be applied to all .html and
* .jsp pages on a web site.  It assumes that all pages are written in UTF-8 (or
* plain text), and meet the XHTML standard, plus the HTML compatibility
* conventions.  They should omit the XML header, and begin with the XHTML
* doctype.  This filter will arrange for pages to be delivered with character
* encoding UTF-8 by default.  If the browser supports XHTML, the content type
* will be "application/xhtml+xml", otherwise the content type will be
* "text/html".  JSP pages can be used to deliver non-html files by setting the
* content type explicitly to something other than "text/html".
**/

public class ContentFilter implements Filter
{
    // Use a pool of reusable wrappers, one per (server) thread, to save space.
    private ThreadLocal<Wrapper> pool = new ThreadLocal<Wrapper>();

    /** Called by the server to start the filter. **/
    public void init(FilterConfig filterConfig) throws ServletException
    {
    }

    /** Called by the server to stop the filter. **/
    public void destroy()
    {
    }

    // Implementation Note: if a response header is altered before the call to
    // chain.doFilter, subsequent normal processing of the page may alter it.
    // If it is altered after the call, normal page processing may already have
    // sent the headers to the browser because of the buffer filling up.  Thus
    // a wrapper has to be provided.

    /** Called by the server to process a request. **/
    public void doFilter
    (ServletRequest req, ServletResponse res, FilterChain chain)
    throws IOException, ServletException
    {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        // Wrap the response object
        Wrapper wrapper = pool.get();
        if (wrapper == null)
        {
            wrapper = new Wrapper(response);
            pool.set(wrapper);
        }
        else wrapper.setResponse(response);

        response.setCharacterEncoding("UTF-8");
        String accept = request.getHeader("Accept");
        if (accept != null && accept.indexOf("application/xhtml+xml") >= 0)
        {
            response.setContentType("application/xhtml+xml");
        }
        else response.setContentType("text/html");

        chain.doFilter(req, wrapper);
    }

    // Provide a wrapped response object.  This prevents normal page processing
    // from setting the content type to text/html.

    private static class Wrapper extends HttpServletResponseWrapper
    {
        public Wrapper(HttpServletResponse response)
        {
            super(response);
        }

        public void setContentType(String value)
        {
            if (value.equals("text/html")) return;
            super.setContentType(value);
        }
    }
}
