<?
$name = $_POST["name"];
$msg = $_POST["message"];
$rem=$_POST["accept"];
$mf= $_POST["radio"];

$a=$_SERVER['REQUEST_URI'];
if($rem==1)
    $check='Запомнить меня';

 $msg1 = 'Имя: ' . $name .' '.' Сообщение: ' . $msg .' ;Пол: ' . $mf .' ;'.  $check;
mail("1good771@gmail.com", "Вам пришло письмо с сайта $a", $msg1, "From: bright.instant@yandex.ru");
?>
