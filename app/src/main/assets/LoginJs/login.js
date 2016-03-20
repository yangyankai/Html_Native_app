/**
在login.js的setLoginInfo里使用JsInteraction.getLoginInfo()调用android提供的接口，
并获取登录信息并将登录信息填充到用户输入框中，
login方法则是调用了JsInteraction.showDialog("Login start...")
来调用android端提供的弹出对话框的接口。
*/
var Login = (function(){
	function Login(){ }

	Login.prototype.login = function(){
		JsInteraction.showDialog("Login start...");
	}

	Login.prototype.setLoginInfo = function(){
		var logininfoJson = JsInteraction.getLoginInfo();
		//解析json字符串
		var logininfo = eval("("+logininfoJson+")");
		document.getElementById("txtUsername").value = logininfo.Username;
		document.getElementById("txtPassword").value = logininfo.Password;
	}
	return Login; })();

   var loginObj = new Login();

   window.onload=function(){
	loginObj.setLoginInfo();
	}