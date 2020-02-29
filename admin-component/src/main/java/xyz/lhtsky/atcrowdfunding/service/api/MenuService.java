package xyz.lhtsky.atcrowdfunding.service.api;

import xyz.lhtsky.atcrowdfunding.entity.Menu;

import java.util.List;

public interface MenuService {

    List<Menu> getAll();

    void saveMenu(Menu menu);

    Menu getMenuById(Integer menuId);

    void updateMenu(Menu menu);

}
