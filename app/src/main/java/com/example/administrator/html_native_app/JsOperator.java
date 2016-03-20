package com.example.administrator.html_native_app;


import org.json.JSONObject;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.JavascriptInterface;

public class JsOperator {

    private Context context;

    public JsOperator(Context context) {
        this.context = context;
    }

    /**
     * 弹出消息对话框
     *
     *  @JavascriptInterface
     * JsOperator提供了两个方法，
     * 一个方法用来弹出对话框，
     * 另一个方法则是返回一个登录信息的JSON字符串，
     * 而且这两个方法都打上了标签@JavascriptInterface，
     * 这是比较重要的，
     * 因为在较低的版本中如果不声明它是JavaScript可调用的方法，
     * JS将无法调用。
     */
    @JavascriptInterface
    public void showDialog(String message) {

        AlertDialog.Builder builder = new Builder(context);
        builder.setMessage(message);
        builder.setTitle("提示");
        builder.setPositiveButton("确认", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("取消", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    /**
     * 获取登录的用户名和密码
     * @return JSON格式的字符串
     */
    @JavascriptInterface
    public String getLoginInfo(){
        try{
            JSONObject login = new JSONObject();
            login.put("Username", "YLD");
            login.put("Password", "111");

            return login.toString();
        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
