<?php
$name = $_POST["name"];
$msg = $_POST["message"];
$rem=$_POST["accept"];
$mf= $_POST["radio"];

$a=$_SERVER['REQUEST_URI'];
if($rem==1)
    $check='Запомнить меня';
$to= '...@gmail.com';
$subject = 'HoweWork';
$message = '
<table>
	<th>Вам пришло письмо с сайта '.$a.'</th>
	<tr>
		<td>Имя</td> <td>'.$name.'</td>
	</tr>
	<tr>
		<td>Сообщение</td> <td>'.$msg.'</td>
	</tr>
	<tr>
		<td>Пол</td> <td>'.$mf.'</td>
	</tr>
	<tr>
		<td>Состояние</td> <td>'.$check.'</dr>
	</tr>
 </table>
 ';

// Для отправки HTML-письма должен быть установлен заголовок Content-type
$headers  = 'MIME-Version: 1.0' . "\r\n";
$headers .= 'Content-type: text/html; charset=iso-8859-1' . "\r\n";

mail($to, $subject, $message, $headers);
?>

