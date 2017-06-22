<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function checkForm() {
		var file = $("#file").val();

		if (file == null || file == "") {
			$("#error").html("文件不能为空！");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<div class="data_list">
		<div class="data_info">
			<p>${title }</p>
		</div>

		<div class="data_content">
			<form action="student!excelStudent" method="post"
				enctype="multipart/form-data" onsubmit="return checkForm()">
				<table width="80%" align="center">
					<tr>
	 					<font color="gray" >* 导入文件只支持模版格式文件, 请点击
						<a href="student!getstudentModel.action">下载模版</a></font>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td colspan="2"><input type="file" id="file" name="file" /></td>
					</tr>

					<tr>
						<td>&nbsp;</td>
						<td>
							<button class="btn btn-primary" type="submit">导入</button>
						</td>
						<td>
							<button class="btn btn-primary" type="button"
								onclick="javascript:history.back()">返回</button> &nbsp;&nbsp;<font
							id="error" color="red">${error }</font>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>