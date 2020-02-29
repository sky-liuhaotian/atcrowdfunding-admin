package xyz.lhtsky.atcrowdfunding.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.lhtsky.atcrowdfunding.entity.Menu;
import xyz.lhtsky.atcrowdfunding.entity.MenuExample;
import xyz.lhtsky.atcrowdfunding.mapper.MenuMapper;
import xyz.lhtsky.atcrowdfunding.service.api.MenuService;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> getAll() {
        return menuMapper.selectByExample(new MenuExample());
    }

    @Override
    public void saveMenu(Menu menu) {
        menuMapper.insert(menu);
    }

    @Override
    public Menu getMenuById(Integer menuId) {
        return menuMapper.selectByPrimaryKey(menuId);
    }

    @Override
    public void updateMenu(Menu menu) {
        menuMapper.updateByPrimaryKey(menu);
    }
}
