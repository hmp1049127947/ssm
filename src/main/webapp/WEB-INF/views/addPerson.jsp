<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
	<jsp:include page="../includes/easyui_head.jsp"/>
</head>

<body >

	<div class="easyui-panel" title="添加用户" style="width:99%;height: 95%">
	    <form id="ff"  class="easyui-form" data-options="novalidate:true" >
	    	<table cellpadding="5">
				<tr>
					<td style="width: 80px"></td>
					<td>账号:</td>
					<td><input class="easyui-textbox" type="text" id="number" name="number" data-options="required:true"></input></td>
					<td>用户名:</td>
					<td><input class="easyui-textbox" type="text" id="username" name="username" data-options="required:false"></input></td>
				</tr>
	    		<tr>
					<td style="width: 50px"></td>
	    			<td>密码:</td>
	    			<td><input id="password" class="easyui-textbox"  type="password" name="password" data-options="required:true"></input></td>
					<td>确认密码:</td>
					<td><input id="psw_again" class="easyui-textbox"  type="password" name="pws_again" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
					<td style="width: 50px"></td>
	    			<td>手机号:</td>
	    			<td><input class="easyui-textbox" type="text" id="phone" name="phone" data-options="required:true,validType:'phone'"></input></td>
					<td>备注:</td>
					<td><input class="easyui-textbox" name="remark" id="remark" data-options="multiline:true" style="height:45px"></input></td>
	    		</tr>
				<tr>
					<td style="width: 50px"></td>
					<td style="width: 50px"></td>
					<td style="text-align: center">
						<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width: 100px">确定</a>
						<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width: 100px">重置</a>
					</td>
				</tr>
	    	</table>
	    </form>
	    </div>
	<script>
        function submitForm(){
            var psw = $("#password").val();
            var psw_again = $("#psw_again").val();
            var number = $("#number").val();
            var phone = $("#phone").val();
            var username = $("#username").val();
            var remark = $("#remark").val();

            if (number == "" || number == "undefine" || number == null) {
                $.messager.alert('提示信息', '账号不能为空', 'error');
                return;
            }
            else if (psw == "" || psw == "undefine" || psw == null) {
                $.messager.alert('提示信息', '密码不能为空', 'error');
                return;
            }
            else if (psw_again == "" || psw_again == "undefine" || psw_again == null) {
                $.messager.alert('提示信息', '确认密码不能为空', 'error');
                return;
            }
            else if (phone == "" || phone == "undefine" || phone == null) {
                $.messager.alert('提示信息', '手机号不能为空', 'error');
                return;
            }
            if (psw == psw_again) {
                $.ajax({
                    url:"/user/add",
                    type: "POST",
                    data: {"number":number,"phone":phone,"username":username,"password":psw, "remark": remark},
                    dataType:"JSON",
                    success:function (data) {
                        if (data.status == 200) {
                            $.messager.alert('提示信息', data.message, 'info');
                        } else {
                            $.messager.alert('提示信息', data.message, 'error');
                        }
                    }

                });

            } else {
                $.messager.alert('操作错误', '两次密码不一致', 'error');
            }

        }
        function clearForm(){
            $('#ff').form('clear');
        }
	</script>
</body>
</html>