Run("C:\Program Files (x86)\Microsoft Office\Office14\OUTLOOK.EXE /recycle")
Sleep(10000)
WinWaitActive("�ռ��� - PANGBAIMEI128@pingan.com.cn - Microsoft Outlook")
Send("^n")
WinWaitActive("δ���� - �ʼ� (HTML) ")
ControlSend("δ���� - �ʼ� (HTML) ","","RichEdit20WPT1","ZHANGMIN475@pingan.com.cn;LIANGXUQING353@pingan.com.cn;WANDING286@pingan.com.cn;LUOJINGJING888@pingan.com.cn;PANGBAIMEI128@pingan.com.cn","1")
Sleep(2000)
ControlSend("δ���� - �ʼ� (HTML) ","","RichEdit20WPT4","Web�Զ������Ա���","1")
Sleep(2000)
$content = "����ִ�У���ϸִ�������http://JKQSH-L0056:8080/jenkins/userContent/yztRegister-reporter/test-reporter/report.html"
ControlFocus("δ���� - �ʼ� (HTML) ","","_WwG1")
ControlSend("δ���� - �ʼ� (HTML) ","","_WwG1",$content,"1")
Sleep(2000)
ControlFocus("δ���� - �ʼ� (HTML) ","����(&S)","Button1")
ControlClick("δ���� - �ʼ� (HTML) ","����(&S)","Button1")