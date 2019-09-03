package com.finalsky.shoppingcart.service.impl.system;

import com.finalsky.shoppingcart.entity.system.ShoppingCart;
import com.finalsky.shoppingcart.dao.system.ShoppingCartDao;
import com.finalsky.shoppingcart.model.ShoppingCartVO;
import com.finalsky.shoppingcart.service.system.ShoppingCartService;
import com.finalsky.user.entity.system.UserInfo;
import com.finalsky.user.service.UserInfoService;
import info.joyc.core.service.impl.BaseServiceImpl;
import info.joyc.tool.bean.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * com.finalsky.shoppingcart.service.impl.system.ShoppingCartServiceImpl.java
 * ==============================================
 * Copy right 2015-2019 by http://www.finalsky.com
 * ----------------------------------------------
 * This is not a free software, without any authorization is not allowed to use and spread.
 * ==============================================
 *
 * @desc : 购物车表服务实现类
 * @author : hejw
 * @version : v1.0.0
 * @since : 2019-08-26 16:38
 */
@Service
public class ShoppingCartServiceImpl extends BaseServiceImpl<ShoppingCart> implements ShoppingCartService {

    @Resource
    private ShoppingCartDao shoppingCartDao;

    @Autowired
    private UserInfoService userInfoService;

    @Override
    public List<ShoppingCartVO> getShoppingCartList(Map<String, Object> parameterMap) {
        List<ShoppingCart> shoppingCartList = shoppingCartDao.queryForList(parameterMap);
        List<ShoppingCartVO> resultList = new ArrayList<>();
        shoppingCartList.stream().parallel().forEach(shoppingCart -> {
            ShoppingCartVO shoppingCartVO = new ShoppingCartVO();
            BeanUtil.copyProperties(shoppingCart, shoppingCartVO);
            ResponseEntity<UserInfo> userInfoResponse = userInfoService.getUserInfo(shoppingCart.getUserId());
            if (userInfoResponse.getStatusCode().is2xxSuccessful() && userInfoResponse.getBody() != null) {
                shoppingCartVO.setUserName(userInfoResponse.getBody().getName());
            }
            resultList.add(shoppingCartVO);
        });
        return resultList;
    }
}
