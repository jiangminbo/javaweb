<?php
//���ݿ������ļ�
$host='localhost';//���ݿ������
$user='root';//���ݿ��û���
$password='';//���ݿ�����
$database='login';//���ݿ���
$conn=@mysql_connect($host,$user,$password) or die('���ݿ�����ʧ�ܣ�');
@mysql_select_db($database) or die('û���ҵ����ݿ⣡');
mysql_query("set names 'gb2312'");
?>