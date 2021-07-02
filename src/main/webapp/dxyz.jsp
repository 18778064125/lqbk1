<%@page pageEncoding="UTF-8" %>
<html>
<body>

<style>
    .box{
        height: 300px;
        width: 900px;
        border:1px solid black;
        background-color: white;
        padding: 5px;
        margin-bottom: 10px;
        box-sizing: content-box;/* 默认 */

    }
</style>
<div class="box">

    <h4>为让您更安全地使用网上银行，现对您当前使用的设备进行安全认证；</h4>
    <hr/>
    <h4>请输入短信验证码</h4>
    <hr/>
    <label for="username">短信动态口令：</label><input type="text" name="username" id="username">
    我行已向您的手机发送短信动态口令，请及时输入。如未收到动态口令，请点击重新获取。
    <h2>

        <input type="submit" value="确认"> <input type="submit" value="返回登录页">
    </h2>
    <hr/>
    <h4>
        温馨提示：
        为保证您的交易安全，本次登录需要安全验证。
    </h4>
</div>
</body>
</html>
