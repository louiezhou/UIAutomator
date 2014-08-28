/**
 * 
 */
package com;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

/**
 * @author HP
 * 
 */
public class UIRunner extends UiAutomatorTestCase {
	public void testSetting() throws UiObjectNotFoundException {
		getUiDevice().pressHome();
		// 进入设置菜单
		UiObject settingApp = new UiObject(new UiSelector().text("设置"));
		settingApp.click();
		// 休眠3秒
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		// 进入语言和输入法设置
		UiScrollable settingItems = new UiScrollable(new UiSelector().scrollable(true));
		UiObject languageAndInputItem = settingItems.getChildByText(new UiSelector().text("语言和输入"), "语言和输入", true);
		languageAndInputItem.clickAndWaitForNewWindow();

	}

}
