Java Student@STUDENT6-PC C:\Users\Java Student\Documents\test_app
> jar -cvf app.jar out
added manifest
adding: out/(in = 0) (out= 0)(stored 0%)
adding: out/empty(in = 0) (out= 0)(stored 0%)
adding: out/jelementary/(in = 0) (out= 0)(stored 0%)
adding: out/jelementary/Group.class(in = 1107) (out= 656)(deflated 40%)
adding: out/jelementary/people/(in = 0) (out= 0)(stored 0%)
adding: out/jelementary/people/Student.class(in = 676) (out= 421)(deflated 37%)
adding: out/jelementary/School.class(in = 1048) (out= 634)(deflated 39%)
adding: out/Main.class(in = 1050) (out= 643)(deflated 38%)

Java Student@STUDENT6-PC C:\Users\Java Student\Documents\test_app
> jar -cvf app.jar -C out .
added manifest
adding: empty(in = 0) (out= 0)(stored 0%)
adding: jelementary/(in = 0) (out= 0)(stored 0%)
adding: jelementary/Group.class(in = 1107) (out= 656)(deflated 40%)
adding: jelementary/people/(in = 0) (out= 0)(stored 0%)
adding: jelementary/people/Student.class(in = 676) (out= 421)(deflated 37%)
adding: jelementary/School.class(in = 1048) (out= 634)(deflated 39%)
adding: Main.class(in = 1050) (out= 643)(deflated 38%)

Java Student@STUDENT6-PC C:\Users\Java Student\Documents\test_app
> java -jar app.jar
no main manifest attribute, in app.jar

Java Student@STUDENT6-PC C:\Users\Java Student\Documents\test_app
> touch manifest.txt
"touch" не является внутренней или внешней
командой, исполняемой программой или пакетным файлом.

Java Student@Student6-PC MINGW64 ~/Documents/test_app (master)
$ cat manifest.txt
Main-Class: Main


Java Student@STUDENT6-PC C:\Users\Java Student\Documents\test_app
> jar -cvfm app.jar manifest.txt -C out .
added manifest
adding: empty(in = 0) (out= 0)(stored 0%)
adding: jelementary/(in = 0) (out= 0)(stored 0%)
adding: jelementary/Group.class(in = 1107) (out= 656)(deflated 40%)
adding: jelementary/people/(in = 0) (out= 0)(stored 0%)
adding: jelementary/people/Student.class(in = 676) (out= 421)(deflated 37%)
adding: jelementary/School.class(in = 1048) (out= 634)(deflated 39%)
adding: Main.class(in = 1050) (out= 643)(deflated 38%)

Java Student@STUDENT6-PC C:\Users\Java Student\Documents\test_app
> java -jar app.jar
SCHOOL: IT School Hillel, Address: Kanatnaya str, 22, Groups:
         GROUP: JElementary, No. 1, Students:
                -> John Doe, 24 years old, rating: 1
                -> Jane Roe, 20 years old, rating: 1
         GROUP: English Classes, No. 2, Students:
                -> John Doe, 24 years old, rating: 1
                -> Jane Roe, 20 years old, rating: 1
                -> John Smith, 34 years old, rating: 1
