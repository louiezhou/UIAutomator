UIAutomator ���̴������̣�

�μ�����UITest



1. ����java���̣�����Android����

2. �Ҽ���Ŀ���ƣ���build path�� ������android.jar ��uiautomator.jar�� ��Ŀ¼E:\android_sdk\adt-bundle-windows-x86_64-20131030\sdk\platforms\android-19


3. ������src�½�����com
��com�½���class �ࣺ

package com;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

/**
* @author louiezhou
*
*/
public class UIRunner extends UiAutomatorTestCase {
     public void testSetting() throws UiObjectNotFoundException {
          getUiDevice().pressHome();
          // �������ò˵�
          UiObject settingApp = new UiObject(new UiSelector().text("����"));
          settingApp.click();
          // ����3��
          try {
               Thread.sleep(3000);
          } catch (InterruptedException e1) {
               e1.printStackTrace();
          }
          // �������Ժ����뷨����
          UiScrollable settingItems = new UiScrollable(new UiSelector().scrollable(true));
          UiObject languageAndInputItem = settingItems.getChildByText(new UiSelector().text("���Ժ�����"), "���Ժ�����", true);
          languageAndInputItem.clickAndWaitForNewWindow();

     }

}



4. ���java�ļ��󣬽���android adt��toolsĿ¼�£�ʹ��������ִ�У�

android create uitest-project -n UITest -t 1 -p D:\eclipseWorkSpace\UITest

E:\android_sdk\adt-bundle-windows-x86_64-20131030\sdk\tools>android create uitest-project -n UITest -t 1 -p D:\eclipseWo
rkSpace\UITest
Updated file D:\eclipseWorkSpace\UITest\build.xml

E:\android_sdk\adt-bundle-windows-x86_64-20131030\sdk\tools>

5. �����������ã� android list 

����Ƿ��� api level ����17
1 ����ǰ��android �豸id ��1 ��api level Ҫ����17����



�Զ�����build.xml �ļ�



6. Ȼ�������Ŀ����Ŀ¼ ��ִ�� ant build

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



�ͻ�����UITest.jar�ļ�


7. ��ɺ����dos����������ĿĿ¼��

��jar�ļ�push���ֻ���
adb push D:\eclipseWorkSpace\UITest\bin\UITest.jar /data/local/tmp

��Demo �������������Ƚ�����ҳ������ҳ������ã������ִ���������ǰҪȷ����ҳ�����ð�ť��



8. Ȼ��ִ��shell����
adb shell uiautomator runtest UITest.jar -c com.UIRunner


��ʵ�����Ҹ��˵��Ժ�android�ֻ��Ͽ����������С�

