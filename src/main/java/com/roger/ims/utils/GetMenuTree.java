package com.roger.ims.utils;

import java.util.ArrayList;
import java.util.List;

import com.roger.ims.dto.MenuVo;

/**  
* @Title: GetMenuTree  
* @Description: 将菜单列表转成树形式
* @author roger  
* @date 2019年7月17日  
*/  
public class GetMenuTree {
	
	public List<MenuVo> getMenuTree(List<MenuVo> menuList) {
		List<MenuVo> menuTree = new ArrayList<MenuVo>();
		//判断是否为最外层节点，如果是，递归获取子节点
		for(MenuVo menu : menuList) {
			if(menu.getParentRight()==0) {
				getChildrenMenu(menuList,menu);
				menuTree.add(menu);
			}
		}
		return menuTree;
	}
	
	/**  
	 * @Title: getChildrenMenu
	 * @Description: 如果存在子节点，添加子节点
	 * @param menuList
	 * @param parentMenu  
	 */  
	public void getChildrenMenu(List<MenuVo> menuList,MenuVo parentMenu) {
		for(MenuVo menu : menuList) {
			if(parentMenu.getRightId().equals(menu.getParentRight())) {
				parentMenu.getSubs().add(menu);
				getChildrenMenu(menuList,menu);
			}
		}
	}

}
