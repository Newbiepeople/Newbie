<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Enter first and last name</title>
<s:head theme="ajax" debug="false" />
</head>
<body>


<s:tabbedPanel id="test">

	<s:div id="one" label="第一个 TabItem" theme="ajax" labelposition="top"
		cssStyle="padding: 10px; ">
		第一个 TabItem <br />
		第一个 TabItem <br />
	</s:div>

	<s:div id="two" label="第二个 TabItem" theme="ajax"
		cssStyle="padding: 10px; ">
        第二个 TabItem <br />
        第二个 TabItem <br />
	</s:div>

	<s:url action="divNews" id="divNewsUrl"></s:url>
	<s:div id="three" label="新闻列表" theme="ajax" href="%{#divNewsUrl}">
	</s:div>

</s:tabbedPanel>

<br/>

<s:tabbedPanel id="test2" closeButton="tab">

	<s:div id="one2" label="第一个 TabItem" theme="ajax" labelposition="top"
		cssStyle="padding: 10px; ">
		第一个 TabItem <br />
		第一个 TabItem <br />
	</s:div>

	<s:div id="two2" label="第二个 TabItem" theme="ajax"
		cssStyle="padding: 10px; ">
        第二个 TabItem <br />
        第二个 TabItem <br />
	</s:div>

	<s:div id="three2" label="新闻列表" theme="ajax" href="%{#divNewsUrl}">
	</s:div>

</s:tabbedPanel>



</body>
</html>
