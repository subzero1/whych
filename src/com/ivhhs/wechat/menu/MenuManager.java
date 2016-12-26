package com.ivhhs.wechat.menu;

/**
 * 自定义菜单管理器类 
 * 
 * @author ivhhs
 * @date 2014.10.16
 */
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.base.dao.JdbcDao;
import com.google.gson.Gson;
import com.ivhhs.wechat.ParamesAPI.AccessToken;
import com.ivhhs.wechat.ParamesAPI.WeixinUtil;
import com.ivhhs.wechat.ParamesAPI.ParamesAPI;
import com.ivhhs.wechat.model.WcMenu;

public class MenuManager {

	public static void main(String[] args) {
		// // 企业Id
		// String CorpID = "wx05da0973faea6eb2";
		// // 管理组的凭证密钥，每个secret代表了对应用、通讯录、接口的不同权限；不同的管理组拥有不同的secret
		// String Secret =
		// "8GODzZowOmSfp45f6OH0o5CLwm9-R1NaUH-bJ_Ys5eLztgqGM4vhM1fFFKjZaopt";
		//
		// // 调用接口获取access_token
		// AccessToken at = WeixinUtil.getAccessToken(CorpID, Secret);
		//
		// if (null != at) {
		// // 调用接口创建菜单
		// int result = WeixinUtil.createMenu(getMenu(), at.getToken());
		//
		// // 判断菜单创建结果
		// if (0 == result) {
		// System.out.println("菜单创建成功！");
		// } else
		// System.out.println("菜单创建失败！");
		// }

		System.out.println(new Gson().toJson(getMenu()));
	}

	public static String CreateMenu() {
		String Result = "";
		// 调用接口获取access_token
		AccessToken at = WeixinUtil.getAccessToken(ParamesAPI.corpId,
				ParamesAPI.secret);

		if (null != at) {
			// 调用接口创建菜单
			int result = WeixinUtil.createMenu(getMenu(), at.getToken());

			// 判断菜单创建结果
			if (0 == result) {
				System.out.println("菜单创建成功！");
				Result = "成功";
			} else
				System.out.println("菜单创建失败！");
			Result = "失败";
		}
		return Result;
	}

	/**
	 * 组装菜单数据
	 * 
	 * @return
	 */
	@Test
	public static Menu getMenu() {
		// CommonButton btn11 = new CommonButton();
		// btn11.setName("学霸天气11");
		// btn11.setType("click");
		// btn11.setKey("11");
		//
		// CommonButton btn12 = new CommonButton();
		// btn12.setName("学霸公交");
		// btn12.setType("click");
		// btn12.setKey("12");
		//
		// CommonButton btn13 = new CommonButton();
		// btn13.setName("学霸周边");
		// btn13.setType("click");
		// btn13.setKey("13");
		//
		// CommonButton btn14 = new CommonButton();
		// btn14.setName("学霸火车");
		// btn14.setType("click");
		// btn14.setKey("14");
		//
		// CommonButton btn15 = new CommonButton();
		// btn15.setName("历史今天");
		// btn15.setType("click");
		// btn15.setKey("15");
		//
		// CommonButton btn21 = new CommonButton();
		// btn21.setName("学霸点播");
		// btn21.setType("click");
		// btn21.setKey("21");
		//
		// CommonButton btn22 = new CommonButton();
		// btn22.setName("学霸游戏");
		// btn22.setType("click");
		// btn22.setKey("22");
		//
		// CommonButton btn23 = new CommonButton();
		// btn23.setName("学霸翻译");
		// btn23.setType("click");
		// btn23.setKey("23");
		//
		// CommonButton btn24 = new CommonButton();
		// btn24.setName("人脸检测");
		// btn24.setType("click");
		// btn24.setKey("24");
		//
		// CommonButton btn25 = new CommonButton();
		// btn25.setName("学霸唠嗑");
		// btn25.setType("click");
		// btn25.setKey("25");
		//
		// // CommonButton btn31 = new CommonButton();
		// // btn31.setName("授权测试");
		// // btn31.setType("click");
		// // btn31.setKey("31");
		//
		// ViewButton btn31 = new ViewButton();
		// btn31.setName("学霸授权");
		// btn31.setType("view");
		// btn31.setUrl("http://112.124.111.3/jialian/");
		//
		// CommonButton btn32 = new CommonButton();
		// btn32.setName("学霸快递");
		// btn32.setType("click");
		// btn32.setKey("32");
		//
		// CommonButton btn33 = new CommonButton();
		// btn33.setName("学霸笑话");
		// btn33.setType("click");
		// btn33.setKey("33");
		//
		// ViewButton btn34 = new ViewButton();
		// btn34.setName("学霸微网");
		// btn34.setType("view");
		// btn34.setUrl("http://112.124.111.3/jialian/");
		//
		// CommonButton btn35 = new CommonButton();
		// btn35.setName("图片测试");
		// btn35.setType("click");
		// btn35.setKey("35");
		//
		// ComplexButton mainBtn1 = new ComplexButton();
		// mainBtn1.setName("学霸生活");
		// mainBtn1.setSub_button(new Button[] { btn11, btn12, btn13, btn14,
		// btn15 });
		//
		// ComplexButton mainBtn2 = new ComplexButton();
		// mainBtn2.setName("学霸休闲");
		// mainBtn2.setSub_button(new Button[] { btn21, btn22, btn23, btn24,
		// btn25 });
		//
		// ComplexButton mainBtn3 = new ComplexButton();
		// mainBtn3.setName("更多服务");
		// mainBtn3.setSub_button(new Button[] { btn31, btn32, btn33, btn34,
		// btn35 });

		/**
		 * 
		 * 在某个一级菜单下没有二级菜单的情况，menu该如何定义呢？<br>
		 * 比如，第三个一级菜单项不是“更多体验”，而直接是“幽默笑话”，那么menu应该这样定义：<br>
		 * menu.setButton(new Button[] { mainBtn1, mainBtn2, btn33 });
		 */
		Menu menu = new Menu();
		// menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });
		JdbcDao dao = JdbcDao.getInstance();
		try {
			List<WcMenu> list = dao
					.queryForList(
							"select t.wcmuid,t.wcmu_type wcmutype,t.wcmu_name wcmuname ,t.wcmu_key wcmukey,t.wcmu_url wcmuurl,t.wcmu_fid wcmufid,t.wcmu_order wcmuorder,t.creattime,t.createid,t.enabled from WC_MENU t where t.enabled=0 order by t.wcmu_fid,t.wcmu_order ",
							WcMenu.class);
			if (list != null && list.size() > 0) {
				int i = 0;
				for (WcMenu wcMenu : list) {
					if (wcMenu.getWcmuFid() == -1 && i < 3) {
						if ("click".equals(wcMenu.getWcmuType())) {
							CommonButton button = new CommonButton();
							button.setName(wcMenu.getWcmuName());
							button.setType(wcMenu.getWcmuType());
							button.setKey(wcMenu.getWcmuKey());
							menu.add(button);
						} else if ("view".equals(wcMenu.getWcmuType())) {
							ViewButton button = new ViewButton();
							button.setName(wcMenu.getWcmuName());
							button.setType(wcMenu.getWcmuType());
							button.setUrl(wcMenu.getWcmuUrl());
							menu.add(button);
						} else {
							// 有子菜单的情况
							ComplexButton mainBtn = new ComplexButton();
							mainBtn.setName(wcMenu.getWcmuName());
							int j = 0;
							for (WcMenu wcMenu2 : list) {
								if (wcMenu2.getWcmuFid() == wcMenu.getWcmuid()) {
									if ("click".equals(wcMenu2.getWcmuType())) {
										CommonButton button = new CommonButton();
										button.setName(wcMenu2.getWcmuName());
										button.setType(wcMenu2.getWcmuType());
										button.setKey(wcMenu2.getWcmuKey());
										mainBtn.add(button);
									} else if ("view".equals(wcMenu2
											.getWcmuType())) {
										ViewButton button = new ViewButton();
										button.setName(wcMenu2.getWcmuName());
										button.setType(wcMenu2.getWcmuType());
										button.setUrl(wcMenu2.getWcmuUrl());
										mainBtn.add(button);
									}
									if (j > 4) {
										break;
									}
									j++;
								}
							}
							menu.add(mainBtn);
						}

						if (i > 2) {
							break;
						}
						i++;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menu;
	}

}
