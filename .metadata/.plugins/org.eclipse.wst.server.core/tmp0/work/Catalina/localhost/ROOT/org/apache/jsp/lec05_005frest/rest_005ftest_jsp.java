/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.86
 * Generated at: 2024-06-17 03:50:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.lec05_005frest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class rest_005ftest_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("jar:file:/C:/IT/S3917_J11/workspace_sts3/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/spring3_prj/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("jar:file:/C:/IT/S3917_J11/workspace_sts3/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/spring3_prj/WEB-INF/lib/jstl-1.2.jar!/META-INF/fn.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1718068926195L));
    _jspx_dependants.put("jar:file:/C:/IT/S3917_J11/workspace_sts3/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/spring3_prj/WEB-INF/lib/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153352682000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write(" \r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("REST Test : \r\n");
      out.write("<input type=\"text\" name=\"ename\" id=\"ename\">\r\n");
      out.write("<hr>\r\n");
      out.write("\r\n");
      out.write("1. String -- String <br>\r\n");
      out.write("<input type=\"button\" id=\"str-str\" value=\"str-str\"><hr>\r\n");
      out.write("\r\n");
      out.write("2. JSON -- String <br>\r\n");
      out.write("<input type=\"button\" id=\"json-str\" value=\"json-str\"><hr>\r\n");
      out.write("\r\n");
      out.write("3. String -- JSON <br>\r\n");
      out.write("<input type=\"button\" id=\"str-json\" value=\"str-json\"><hr>\r\n");
      out.write("\r\n");
      out.write("4. JSON -- JSON <br>\r\n");
      out.write("<input type=\"button\" id=\"json-json\" value=\"json-json\"><hr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"resultDIV\"></div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.7.1.js\"></script>\r\n");
      out.write("<script> \r\n");
      out.write("$(function() { \r\n");
      out.write("	//-------------- 공통 : 테이블 그리기 -----------------------\r\n");
      out.write("	function makeTable(myval) {\r\n");
      out.write("			var htmlStr = \"<table border=1 width=50%><tr><th>제목</th><th>글쓴이</th></tr>\";\r\n");
      out.write("			$.map( myval, function( MYval, MYidx ) {\r\n");
      out.write("				htmlStr += \"<tr><td>\" +MYval[\"title\"] + \"</td><td>\"+MYval[\"regid\"] +\"</td></tr>\"\r\n");
      out.write("				//console.log(MYval[\"title\"] + \",\" + MYval[\"regid\"] + \",\" + MYidx);\r\n");
      out.write("			});\r\n");
      out.write("			htmlStr += \"</table>\";\r\n");
      out.write("			$(\"#resultDIV\").empty();\r\n");
      out.write("			\r\n");
      out.write("			//$(\"#resultDIV\").html(myval[0][\"title\"]);\r\n");
      out.write("			$(\"#resultDIV\").html(htmlStr);\r\n");
      out.write("		}\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	$(\"#str-str\").click(  function(){\r\n");
      out.write("		//alert(\"초간단AJAX\");\r\n");
      out.write("		var ename_val = $(\"#ename\").val();\r\n");
      out.write("		$.ajax({\r\n");
      out.write("			method      : \"GET\",\r\n");
      out.write("	        url         : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/RestServletTest\",\r\n");
      out.write("	        data 		: \"ename=\"+ename_val,\r\n");
      out.write("	  		error 	    : function(myval){ console.log(\"에러:\" + myval);   },\r\n");
      out.write("	  		success     : function(myval){ \r\n");
      out.write("								  			console.log(\"변환전:\" + myval);   \r\n");
      out.write("											myval = JSON.parse(myval);\r\n");
      out.write("											console.log(\"변환후:\" + myval);\r\n");
      out.write("	  										makeTable(myval);			\r\n");
      out.write("	  									 }\r\n");
      out.write("		});\r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	$(\"#json-str\").click(  function(){\r\n");
      out.write("		var objData = {\"title\":\"aaaaatitle\",\"regid\":\"hong\"};\r\n");
      out.write("		$.ajax({\r\n");
      out.write("			method      : \"POST\",\r\n");
      out.write("	        url         : \"");
      out.print(request.getContextPath());
      out.write("/RestServletTest\",\r\n");
      out.write("	        contentType : \"application/json; charset=UTF-8\",\r\n");
      out.write("	        data 		: JSON.stringify(objData),   \r\n");
      out.write("	  		error 	    : function(myval){ console.log(\"에러:\" + myval);   },\r\n");
      out.write("	  		success     : function(myval){ \r\n");
      out.write("								  			console.log(\"변환전:\" + myval);   \r\n");
      out.write("											myval = JSON.parse(myval);\r\n");
      out.write("											console.log(\"변환후:\" + myval);\r\n");
      out.write("	  										//makeTable(myval);\r\n");
      out.write("	  										console.log(myval[\"title\"]);\r\n");
      out.write("	  									 }\r\n");
      out.write("		});\r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	$(\"#str-json\").click(  function(){\r\n");
      out.write("		var ename_val = $(\"#ename\").val();\r\n");
      out.write("		$.ajax({\r\n");
      out.write("			method      : \"POST\",\r\n");
      out.write("	        url         : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/RestServletTest\",\r\n");
      out.write("	        data 		: \"ename=\"+ename_val,\r\n");
      out.write("	        //dataType	: \"json\",\r\n");
      out.write("	  		error 	    : function(myval){ console.log(\"에러:\" + myval);   },\r\n");
      out.write("	  		success     : function(myval){ \r\n");
      out.write("	  										console.log(myval);		\r\n");
      out.write("	  										makeTable(myval);\r\n");
      out.write("	  									 }\r\n");
      out.write("		});\r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	$(\"#json-json\").click(  function(){\r\n");
      out.write("		var objData = {\"title\":\"aaaaatitle\",\"regid\":\"hong\"};\r\n");
      out.write("		$.ajax({\r\n");
      out.write("			method      : \"POST\",\r\n");
      out.write("	        url         : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/RestServletTest\",\r\n");
      out.write("	        data 		: JSON.stringify(objData),  \r\n");
      out.write("	        //dataType	: \"json\",\r\n");
      out.write("	  		error 	    : function(myval){ console.log(\"에러:\" + myval);   },\r\n");
      out.write("	  		success     : function(myval){ \r\n");
      out.write("	  										console.log(myval);		\r\n");
      out.write("	  										makeTable(myval);\r\n");
      out.write("	  									 }\r\n");
      out.write("		});\r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("}); </script>		\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
