/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.72
 * Generated at: 2022-03-14 15:52:45 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ex02_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/views/header.jsp", Long.valueOf(1640567709263L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1638276055364L));
    _jspx_dependants.put("jar:file:/D:/취업반_스프링%20프레임워크/workspace_spring/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/day13(2)/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar;

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
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
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

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style>\r\n");
      out.write("	body {\r\n");
      out.write("		margin: 0;\r\n");
      out.write("		padding: 0;\r\n");
      out.write("		width: 100%;\r\n");
      out.write("		overflow-x: hidden;\r\n");
      out.write("	}\r\n");
      out.write("	header {\r\n");
      out.write("		position: sticky;	/* 상위 요소에 overflow 속성을 지정했다면 각 요소의 높이를 %아닌 방법으로 지정 */\r\n");
      out.write("		width: 100%;\r\n");
      out.write("		top: 0;\r\n");
      out.write("		left: 20px;\r\n");
      out.write("		padding: 10px;\r\n");
      out.write("		background-color: white;\r\n");
      out.write("		z-index: 1;\r\n");
      out.write("	}\r\n");
      out.write("	h1 {\r\n");
      out.write("		padding-left: 20px;\r\n");
      out.write("	}\r\n");
      out.write("	header + * {		/* 형제 노드를 찾을 때 사용하는 선택자, 지정한 요소 바로 다음 요소 */\r\n");
      out.write("	\r\n");
      out.write("	}\r\n");
      out.write("	.item {\r\n");
      out.write("		width: 700px;\r\n");
      out.write("		padding: 10px;\r\n");
      out.write("		margin: 10px auto;\r\n");
      out.write("		box-sizing: border-box;\r\n");
      out.write("		font-weight: bold;\r\n");
      out.write("		border: 1px solid black;\r\n");
      out.write("	}\r\n");
      out.write("	.item:nth-child(2n) {\r\n");
      out.write("		background-color: pink;\r\n");
      out.write("	}\r\n");
      out.write("	.item:nth-child(2n - 1) {\r\n");
      out.write("		background-color: skyblue;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<script>\r\n");
      out.write("	const cpath = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cpath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'\r\n");
      out.write("</script>\r\n");
      out.write("<header>\r\n");
      out.write("	<h1><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cpath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">ajax fetch</a></h1>\r\n");
      out.write("	<hr>\r\n");
      out.write("</header>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("	function submitHandler(event) {\r\n");
      out.write("		event.preventDefault()\r\n");
      out.write("		console.log(event.target)\r\n");
      out.write("		console.log('submitHandler 호출')\r\n");
      out.write("		\r\n");
      out.write("		// 1) 입력값을 자바스크립트 객체형태로 준비하기\r\n");
      out.write("		const ob = {}	// const는 값이 안바뀌는것이 아니고, 대상이 바뀌지 않는 것이다\r\n");
      out.write("		const formData = new FormData(event.target)\r\n");
      out.write("		console.log(formData.keys())\r\n");
      out.write("		for(key of formData.keys()) {\r\n");
      out.write("// 			console.log(key,': ',formData.get(key))\r\n");
      out.write("			ob[key] = formData.get(key)\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		// 2) POST 형식에 맞춰서 서버에 전송하기 (POST요청은 body를 가진다)\r\n");
      out.write("		const url = cpath + '/postBoardData'\r\n");
      out.write("		const opt = {\r\n");
      out.write("			method: 'POST',\r\n");
      out.write("			body: JSON.stringify(ob),\r\n");
      out.write("			headers: {\r\n");
      out.write("				'Content-Type': 'application/json; charset=utf-8'\r\n");
      out.write("			}\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		// 3) 전송 후 받은 응답에 따라 이후 처리 진행\r\n");
      out.write("		fetch(url, opt)\r\n");
      out.write("		.then(resp => resp.text())\r\n");
      out.write("		.then(text => {\r\n");
      out.write("			if(text == 1) {\r\n");
      out.write("				alert('작성 성공')\r\n");
      out.write("				location.href = cpath + '/ex01'\r\n");
      out.write("			}\r\n");
      out.write("			else {\r\n");
      out.write("				alert('작성 실패')\r\n");
      out.write("				event.target.reset()	// form 내부의 값을 초기화한다\r\n");
      out.write("			}\r\n");
      out.write("		})\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("	}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<h2>ajax 로 POST 형식으로 데이터 전송하기</h2>\r\n");
      out.write("\r\n");
      out.write("<div>\r\n");
      out.write("	<form>\r\n");
      out.write("		<p><input name=\"title\" placeholder=\"제목\" required autofocus></p>\r\n");
      out.write("		<p><input name=\"writer\" placeholder=\"작성자\" required></p>\r\n");
      out.write("		<p><textarea name=\"content\" placeholder=\"내용\" required></textarea></p>\r\n");
      out.write("		<input type=\"hidden\" name=\"ipaddr\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.remoteAddr }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("		<p><button>작성</button></p>\r\n");
      out.write("	</form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("	const form = document.forms[0]\r\n");
      out.write("	form.onsubmit = submitHandler\r\n");
      out.write("</script>\r\n");
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

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    boolean _jspx_th_c_005fset_005f0_reused = false;
    try {
      _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fset_005f0.setParent(null);
      // /WEB-INF/views/header.jsp(4,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setVar("cpath");
      int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
      if (_jspx_eval_c_005fset_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_c_005fset_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = org.apache.jasper.runtime.JspRuntimeLibrary.startBufferedBody(_jspx_page_context, _jspx_th_c_005fset_005f0);
        }
        do {
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          int evalDoAfterBody = _jspx_th_c_005fset_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_c_005fset_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
        }
      }
      if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar.reuse(_jspx_th_c_005fset_005f0);
      _jspx_th_c_005fset_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fset_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fset_005f0_reused);
    }
    return false;
  }
}
