##UIAutomator

***UIAutomator 工程创建流程：***

####环境必备条件：
1. JDK 1.6以上
2. android adt 
3. Eclipse（安装ADT插件）需要android api 16级以上
4. ANT（用于编译生成jar）

####步骤：
1. 创建java工程，`不是Android工程`
2. 右键项目名称，在build path中 ，导入android.jar 和uiautomator.jar包,在目录E:\android_sdk\adt-bundle-windows-x86_64-20131030\sdk\platforms\android-19 每个人的目录路径不一样，请执行修改。
3. 源代码部分看src文件
4. 完成java文件后，进入android adt的tools目录下
5. 执行命令：android create uitest-project -n UITest -t 1 -p D:\eclipseWorkSpace\UITest 生成build.xml文件
6. 如果无法执行上述命令请用 android list 命令查看你的api level 是否大于16级
7. 然后进入项目工程目录 再执行 ant build 我的目录是：D:\eclipseWorkSpace\UITest>ant build  就会自动生成 UITest.jar 文件
8. 仍在工程目录下，将jar文件push到手机上，使用命令：adb push D:\eclipseWorkSpace\UITest\bin\UITest.jar /data/local/tmp
9. 本Demo 操作的流程是先进入首页，在首页点击设置，因此在执行下面语句前要确保首页有设置按钮。
10. 然后执行shell命令 ：adb shell uiautomator runtest UITest.jar -c com.UIRunner 脚本就可以在手机上run起来了。

### And more?

Don't forget to check Preferences, lots of useful options are there.
Anyquestion to me[gigger_123@126.com]


