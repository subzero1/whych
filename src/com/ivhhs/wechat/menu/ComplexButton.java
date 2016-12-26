package com.ivhhs.wechat.menu;

import java.util.ArrayList;
import java.util.List;

/**
 * ∏¥‘”∞¥≈•£®∏∏∞¥≈•£©
 * 
 * @author ivhhs
 * @date 2014.10.16
 */
//public class ComplexButton extends Button {
//	private Button[] sub_button;
//
//	public Button[] getSub_button() {
//		return sub_button;
//	}
//
//	public void setSub_button(Button[] sub_button) {
//		this.sub_button = sub_button;
//	}
//}
public class ComplexButton extends Button {
	private List<Button> sub_button=new ArrayList<Button>();
	public void add(Button btn) {
		this.sub_button.add(btn);
	}
}