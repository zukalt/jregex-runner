<%@ page language="java" contentType="application/x-java-jnlp-file; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
%><%
	
	String jar = request.getRequestURI();
	jar = jar.substring(jar.lastIndexOf('/')) ;
	jar = jar.replaceAll("\\.jnlp$", ".jar");
%><?xml version="1.0" encoding="UTF-8"?>
<jnlp spec="1.0+" codebase="" href="">
    <information>
        <title>RegExp java evaluator</title>
        <vendor>DevToolkit.org</vendor>
    </information>
    <resources>
        <!-- Application Resources -->
        <j2se version="1.5+" href="http://java.sun.com/products/autodl/j2se"/>
        <jar href="<%= jar %>?nocache=<%= System.currentTimeMillis() %>" main="true" />
    </resources>
    <applet-desc 
         name="RegExp java evaluator"
         main-class="org.devtoolkit.regex.RegexInterpreter"
         width="1"
         height="1">
     </applet-desc>
     <update check="always"/>
</jnlp>
