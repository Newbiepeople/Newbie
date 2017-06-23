<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Enter first and last name</title>
<s:head theme="ajax" debug="false" />
<script type="text/javascript">
            function treeNodeSelected(arg) {
                alert(arg.source.title + ' selected');
            }
            dojo.addOnLoad(function() {                
                var s = dojo.widget.byId('root').selector;                
                //dojo.event.connect(s, 'select', 'treeNodeSelected');
            });
        </script>
<style type="text/css">
body,div {
	font-size: 12px;
}
</style>
</head>
<body>

<s:tree theme="ajax" id="root" label="中国" showGrid="true"
	showRootGrid="true" toggle="explode" treeSelectedTopic="test">
	<s:treenode theme="ajax" id="child1" label="<b>北京市</b>" />
	<s:treenode theme="ajax" id="child2" label="<i>上海市</i>" />
	<s:treenode theme="ajax" id="subchild1" label="山东省">
		<s:treenode theme="ajax" id="subchild2" label="济南市" />
		<s:treenode theme="ajax" id="subchild3" label="青岛市" />
		<s:treenode theme="ajax" id="subchild4" label="烟台市" />
	</s:treenode>
	<s:treenode theme="ajax" id="child3" label="浙江省">
		<s:treenode theme="ajax" id="subchild3_1" label="杭州市" />
		<s:treenode theme="ajax" id="subchild3_2" label="温州市" />
	</s:treenode>
</s:tree>

<hr />

<button onclick="test(); ">选中节点</button>
<button onclick="expand(); ">展开</button>
<button onclick="collapse(); ">合起</button>

<script type="text/javascript">

function test(){

	var node = dojo.widget.byId('root').selector.selectedNode;
	
	if(!node){
		alert('没有选中任何节点');
		return;
	}
	
	alert('选中了 "' + node.title + '", 父节点: "' + (node.parent.title ? node.parent.title : '') + '", 子节点 ' + (node.children ? node.children.length : 0) + ' 个. ');
	
	//var obj=node;var s='';for(var i in obj){try{s+='['+i+'] = ' + obj[i] + ' <br/><br/>\r\n\r\n';}catch(e){s+='<font color=red>Error while fetching ['+i+']. Msg: ' + e.message + '</font><br/>\r\n';}}var w=window.open();w.document.write(s);
}
function expand(){
	var node = dojo.widget.byId('root').selector.selectedNode;
	node.expand(); 
}
function collapse(){
	var node = dojo.widget.byId('root').selector.selectedNode;
	node.collapse(); 
}
</script>


</body>
</html>
