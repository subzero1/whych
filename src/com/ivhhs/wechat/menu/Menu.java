package com.ivhhs.wechat.menu;

import java.util.ArrayList;
import java.util.List;

/**
 * �Զ���˵�
 * 
 * @author ivhhs
 * @date 2014.10.16
 */
//public class Menu {
//	private Button[] button;
//
//	public Button[] getButton() {
//		return button;
//	}
//
//	public void setButton(Button[] button) {
//		this.button = button;
//	}
//}


public class Menu {
	private List<Button> button=new ArrayList<Button>() ;
	public void add(Button btn) {
		if (button.size()<3) {
		   this.button.add(btn);
		}
	}
	
}