<?php

?>
<html>
<head>
    <link href="style.css" rel="stylesheet">
    <link href="assets/css/normalize.css" rel="stylesheet">
</head>
<body>
<form method="POST" action="post.php" >
    <p>
        <label>Name</label>
    <input type="text" name="name" placeholder="Ivan">
    </p>
    <p>
        <label>Message</label>
    <textarea rows="7" cols="20" name="message" placeholder="Message" id="msg" ></textarea>
</p>
    <label>Пол</label>
    <input type="radio" value="мужской" checked name="radio">М
    <input type="radio" value="женский" name="radio">Ж
    <p>
        <input type="hidden" name="accept" value="0">
    <input type="checkbox" name="accept" value="1">Remember me<br>
    </p>

    <input type="submit">
</form>
</body>
</html>


