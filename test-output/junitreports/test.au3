Run("C:\Program Files\Microsoft Office\Office14\OUTLOOK.EXE /recycle")
WinWaitActive("�ռ��� - PANGBAIMEI128@pingan.com.cn - Microsoft Outlook")
Send("^n")
WinWaitActive("δ���� - �ʼ� (HTML) ")
ControlSend("δ���� - �ʼ� (HTML) ","","RichEdit20WPT1","PANGBAIMEI128@pingan.com.cn","1")
Sleep(2000)
ControlSend("δ���� - �ʼ� (HTML) ","","RichEdit20WPT4","test","1")
Sleep(2000)
$content = Readtxt()
ControlFocus("δ���� - �ʼ� (HTML) ","","_WwG1")
ControlSend("δ���� - �ʼ� (HTML) ","","_WwG1",$content,"1")
Sleep(2000)
ControlFocus("δ���� - �ʼ� (HTML) ","����(&S)","Button1")
ControlClick("δ���� - �ʼ� (HTML) ","����(&S)","Button1")

Func  Readtxt()
   Dim $file,$line
   $file = FileOpen("report.html",0)
   If $file = -1 Then
	  Exit
   EndIf
   $line = FileRead($file)
   Return $line
EndFunc