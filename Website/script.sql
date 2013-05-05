create table users(userid int not null, username varchar(30) not null, password varchar(30) not null, email varchar(70) not null,firstname varchar(30) not null, lastname varchar(30) not null,age varchar(10), avatar varchar(200), CONSTRAINT uc_userID unique (userid), CONSTRAINT uc_username unique (username))

insert into users values(1, 'admin', 'pass', 'noemail@nomail.no', 'vlad', 'otrocol')


	-- compile stuff

	"     javac -cp .;D:\Projects\website\Tomcat/lib/servlet-api.jar com/otrocol/app/*.java       " 

	-cp .;D:\Projects\website\Tomcat/lib/servlet-api.jar;D:\Projects\website\Tomcat\lib\jsp-api.jar;D:Projects\website\Tomcat\lib\commons-fileupload.jar;D:\Projects\website\Tomcat\lib\commons-io.jar com/otrocol/app/*.java
	-cp .;D:Projects\website\Tomcat\lib\commons-fileupload.jar;D:\Projects\website\Tomcat\lib\commons-io.jar com/otrocol/app/*.java


	D:\Projects\website\Website>javac -cp com/otrocol/app/jsp-api.jar;com/otrocol/app/servlet-api.jar;com/otrocol/app/commons-fileupload-1.3.jar;com/otrocol/app/commons-io-2.4.jar;com/otrocol/app/javax.mail.jar com/otrocol/app/*.java
