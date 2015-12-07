$info = Readtxt()
MsgBox(0,"≤‚ ‘",$info)

Func  Readtxt()
   Dim $file,$line
   $file = FileOpen("report.txt",0)
   If $file = -1 Then
	  Exit
   EndIf
   $line = FileRead($file)
   Return $line
EndFunc