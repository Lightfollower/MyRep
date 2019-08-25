<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Паролегенератор</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="content">
<?php
include "Menu.php"
?>
<script>

    function generatePassword() {
        var length = document.getElementById("length").value;
        var result           = '';
        var characters       = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
        var charactersLength = characters.length;
        for ( var i = 0; i < length; i++ ) {
            result += characters.charAt(Math.floor(Math.random() * charactersLength));
        }

        document.getElementById("password").innerHTML = result;
    }
</script>
<form method="get">
    <p>Какой длинны пароль желаете?</p>
    <input type="text" id = "length">
    <a href="#" onclick="generatePassword();">Ответить</a>
    <p >
        Ваш пароль:
        <text id = "password"></text>
    </p>

</form>
    <div class="footer">
        Copyright &copy; <?php echo date ("Y");?> Crab Pincersky
        <div>

        </div>
</body>
</html>