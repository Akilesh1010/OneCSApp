set FilePath=/Users/priyankaingale/Documents/GitHub/OneCSBS-Demo/target/cucumber-reports/Spark/index.html
set SUBFILENAME=date /t

for /F "tokens=2" %%i in ('date /t') do set mydate=%%i
set mytime=%time%
echo Current time is %date%:%mytime%
set sysDate=%date:/=-%
set sysTime=%time::=-%
set sysTime=%sysTime: =%
echo date format is %sysDate%
set NewFilePath=/Users/priyankaingale/Documents/GitHub/OneCSBS-Demo/target/cucumber-reports/Spark/AutomationReport_%sysDate%-%sysTime%.html

::
:: Nothing below this line should need to be changed
::
:: Upload the funding curve data
::
 echo File to copy %FilePath%
 echo New FIle %NewFilePath%
 sleep 5
 copy  %FilePath% %NewFilePath%
 
 sleep 5
 curl -D- -u "akilesh.shankar@charles-stanley.co.uk:h0kSseulQwKglqZWFq6n5920" -X PUT -H "X-Atlassian-Token: nocheck" -F "file=@%NewFilePath%" -F 'minorEdit="true"' -F 'comment="Example attachment comment"' https://charlesstanley.atlassian.net/wiki/rest/api/content/678888196/child/attachment