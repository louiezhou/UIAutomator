UIAutomator
===========
UIAutomator 工程创建流程：

参见工程UITest

环境必备条件：
1. JDK 1.6以上 

2. android adt 

3. Eclipse（安装ADT插件）

4. ANT（用于编译生成jar）


==================================
1. 创建java工程，不是Android工程

2. 右键项目名称，在build path中 ，导入android.jar 和uiautomator.jar包

在目录E:\android_sdk\adt-bundle-windows-x86_64-20131030\sdk\platforms\android-19


3. 代码部分看src 文件

4. 完成java文件后，进入android adt的tools目录下，使用命令行执行：

android create uitest-project -n UITest -t 1 -p D:\eclipseWorkSpace\UITest

E:\android_sdk\adt-bundle-windows-x86_64-20131030\sdk\tools>android create uitest-project -n UITest -t 1 -p

D:\eclipseWorkSpace\UITest

Updated file D:\eclipseWorkSpace\UITest\build.xml

E:\android_sdk\adt-bundle-windows-x86_64-20131030\sdk\tools>


5. 在命令行中用： android list 

检查是否是 api level 大于17

其中的 1 代表当前的android 设备id 是1 且api level 要大于17以上

自动生成build.xml 文件

6. 然后进入项目工程目录 再执行 ant build

D:\eclipseWorkSpace\UITest>ant build

Buildfile: D:\eclipseWorkSpace\UITest\build.xml

-check-env:

[checkenv] Android SDK Tools Revision 22.3.0

[checkenv] Installed at E:\android_sdk\adt-bundle-windows-x86_64-20131030\sdk

-build-setup:

[getbuildtools] Using latest Build Tools: 19.0.0

     [echo] Resolving Build Target for UITest...
     
[getuitarget] Project Target:   Android 4.4

[getuitarget] API level:        19

     [echo] ----------
     
     [echo] Creating output directories if needed...

-pre-compile:

compile:

    [javac] Compiling 1 source file to D:\eclipseWorkSpace\UITest\bin\classes

-post-compile:

-dex:

      [dex] input: D:\eclipseWorkSpace\UITest\bin\classes
      
      [dex] Found Deleted Target File
      
      [dex] Converting compiled files and external libraries into D:\eclipseWorkSpace\UITest\bin\classes.dex...

-post-dex:

-jar:
      [jar] Building jar: D:\eclipseWorkSpace\UITest\bin\UITest.jar

-post-jar:

build:

BUILD SUCCESSFUL

Total time: 2 seconds

D:\eclipseWorkSpace\UITest>

7. 完成后进入dos环境进入项目目录下

将jar文件push到手机中

adb push D:\eclipseWorkSpace\UITest\bin\UITest.jar /data/local/tmp

本Demo 操作的流程是先进入首页，在首页点击设置，因此在执行下面语句前要确保首页有设置按钮。



8. 然后执行shell命令

adb shell uiautomator runtest UITest.jar -c com.UIRunner


本实例在windows平台上和android api 大于16级以上可以正常运行。

