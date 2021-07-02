<%@page pageEncoding="UTF-8" %>
<html>
<body>

<style>
    .box{
        height: 500px;
        width: 900px;
        border:1px solid black;
        background-color: white;
        padding: 5px;
        margin-bottom: 10px;
        box-sizing: content-box;/* 默认 */

    }
</style>
<div class="box">
    <h2>恢复证件号登录</h2>
    <hr>
    <p><strong>填写个人基本信息</strong></p>

    <h3>

        <label for="1">姓名：</label><input type="text" name="username" id="1">
    </h3>
    <h3>
        <label >证件类型：身份证</label>
    </h3>
    <h3>
        <label for="2">证件号码：</label><input type="text" name="username" id="2">
    </h3>
    <hr>
    <p><strong>填写账户信息</strong></p>

    <h3>
        <label for="3">银行账号：</label><input type="text" name="username" id="3">
    </h3>
    <h3>
        <label for="4">手机号：</label><input type="text" name="username" id="4">
    </h3>
    <h3>
        <label for="5">附加码：</label><input type="text" name="username" id="5">
    </h3>
    <h2>

        <input type="submit" value="下一步"> <input type="submit" value="关闭">
    </h2>


</div>
</body>
</html>
