package com.ivhhs.wechat.menu;

/**
 * �Զ���˵��������� 
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
		// // ��ҵId
		// String CorpID = "wx05da0973faea6eb2";
		// // �������ƾ֤��Կ��ÿ��secret�����˶�Ӧ�á�ͨѶ¼���ӿڵĲ�ͬȨ�ޣ���ͬ�Ĺ�����ӵ�в�ͬ��secret
		// String Secret =
		// "8GODzZowOmSfp45f6OH0o5CLwm9-R1NaUH-bJ_Ys5eLztgqGM4vhM1fFFKjZaopt";
		//
		// // ���ýӿڻ�ȡaccess_token
		// AccessToken at = WeixinUtil.getAccessToken(CorpID, Secret);
		//
		// if (null != at) {
		// // ���ýӿڴ����˵�
		// int result = WeixinUtil.createMenu(getMenu(), at.getToken());
		//
		// // �жϲ˵��������
		// if (0 == result) {
		// System.out.println("�˵������ɹ���");
		// } else
		// System.out.println("�˵�����ʧ�ܣ�");
		// }

		System.out.println(new Gson().toJson(getMenu()));
	}

	public static String CreateMenu() {
		String Result = "";
		// ���ýӿڻ�ȡaccess_token
		AccessToken at = WeixinUtil.getAccessToken(ParamesAPI.corpId,
				ParamesAPI.secret);

		if (null != at) {
			// ���ýӿڴ����˵�
			int result = WeixinUtil.createMenu(getMenu(), at.getToken());

			// �жϲ˵��������
			if (0 == result) {
				System.out.println("�˵������ɹ���");
				Result = "�ɹ�";
			} else
				System.out.println("�˵�����ʧ�ܣ�");
			Result = "ʧ��";
		}
		return Result;
	}

	/**
	 * ��װ�˵�����
	 * 
	 * @return
	 */
	@Test
	public static Menu getMenu() {
		// CommonButton btn11 = new CommonButton();
		// btn11.setName("ѧ������11");
		// btn11.setType("click");
		// btn11.setKey("11");
		//
		// CommonButton btn12 = new CommonButton();
		// btn12.setName("ѧ�Թ���");
		// btn12.setType("click");
		// btn12.setKey("12");
		//
		// CommonButton btn13 = new CommonButton();
		// btn13.setName("ѧ���ܱ�");
		// btn13.setType("click");
		// btn13.setKey("13");
		//
		// CommonButton btn14 = new CommonButton();
		// btn14.setName("ѧ�Ի�");
		// btn14.setType("click");
		// btn14.setKey("14");
		//
		// CommonButton btn15 = new CommonButton();
		// btn15.setName("��ʷ����");
		// btn15.setType("click");
		// btn15.setKey("15");
		//
		// CommonButton btn21 = new CommonButton();
		// btn21.setName("ѧ�Ե㲥");
		// btn21.setType("click");
		// btn21.setKey("21");
		//
		// CommonButton btn22 = new CommonButton();
		// btn22.setName("ѧ����Ϸ");
		// btn22.setType("click");
		// btn22.setKey("22");
		//
		// CommonButton btn23 = new CommonButton();
		// btn23.setName("ѧ�Է���");
		// btn23.setType("click");
		// btn23.setKey("23");
		//
		// CommonButton btn24 = new CommonButton();
		// btn24.setName("�������");
		// btn24.setType("click");
		// btn24.setKey("24");
		//
		// CommonButton btn25 = new CommonButton();
		// btn25.setName("ѧ�����");
		// btn25.setType("click");
		// btn25.setKey("25");
		//
		// // CommonButton btn31 = new CommonButton();
		// // btn31.setName("��Ȩ����");
		// // btn31.setType("click");
		// // btn31.setKey("31");
		//
		// ViewButton btn31 = new ViewButton();
		// btn31.setName("ѧ����Ȩ");
		// btn31.setType("view");
		// btn31.setUrl("http://112.124.111.3/jialian/");
		//
		// CommonButton btn32 = new CommonButton();
		// btn32.setName("ѧ�Կ��");
		// btn32.setType("click");
		// btn32.setKey("32");
		//
		// CommonButton btn33 = new CommonButton();
		// btn33.setName("ѧ��Ц��");
		// btn33.setType("click");
		// btn33.setKey("33");
		//
		// ViewButton btn34 = new ViewButton();
		// btn34.setName("ѧ��΢��");
		// btn34.setType("view");
		// btn34.setUrl("http://112.124.111.3/jialian/");
		//
		// CommonButton btn35 = new CommonButton();
		// btn35.setName("ͼƬ����");
		// btn35.setType("click");
		// btn35.setKey("35");
		//
		// ComplexButton mainBtn1 = new ComplexButton();
		// mainBtn1.setName("ѧ������");
		// mainBtn1.setSub_button(new Button[] { btn11, btn12, btn13, btn14,
		// btn15 });
		//
		// ComplexButton mainBtn2 = new ComplexButton();
		// mainBtn2.setName("ѧ������");
		// mainBtn2.setSub_button(new Button[] { btn21, btn22, btn23, btn24,
		// btn25 });
		//
		// ComplexButton mainBtn3 = new ComplexButton();
		// mainBtn3.setName("�������");
		// mainBtn3.setSub_button(new Button[] { btn31, btn32, btn33, btn34,
		// btn35 });

		/**
		 * 
		 * ��ĳ��һ���˵���û�ж����˵��������menu����ζ����أ�<br>
		 * ���磬������һ���˵���ǡ��������顱����ֱ���ǡ���ĬЦ��������ômenuӦ���������壺<br>
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
							// ���Ӳ˵������
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
