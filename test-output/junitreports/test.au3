Run("C:\Program Files\Microsoft Office\Office14\OUTLOOK.EXE /recycle")
WinWaitActive("收件箱 - PANGBAIMEI128@pingan.com.cn - Microsoft Outlook")
Send("^n")
WinWaitActive("未命名 - 邮件 (HTML) ")
ControlSend("未命名 - 邮件 (HTML) ","","RichEdit20WPT1","PANGBAIMEI128@pingan.com.cn","1")
Sleep(2000)
ControlSend("未命名 - 邮件 (HTML) ","","RichEdit20WPT4","test","1")
Sleep(2000)
$content = Readtxt()
ControlFocus("未命名 - 邮件 (HTML) ","","_WwG1")
ControlSend("未命名 - 邮件 (HTML) ","","_WwG1",$content,"1")
Sleep(2000)
ControlFocus("未命名 - 邮件 (HTML) ","发送(&S)","Button1")
ControlClick("未命名 - 邮件 (HTML) ","发送(&S)","Button1")

Func  Readtxt()
   Dim $file,$line
   $file = FileOpen("report.html",0)
   If $file = -1 Then
	  Exit
   EndIf
   $line = FileRead($file)
   Return $line
EndFunc