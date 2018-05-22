package com.ppmall.controller.portal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ppmall.common.Const;
import com.ppmall.common.ServerResponse;
import com.ppmall.pojo.User;
import com.ppmall.service.ICartService;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired ICartService iCartService;
	
	@RequestMapping(value = "/get_order_cart_product.do", method = RequestMethod.GET)
	@ResponseBody
	public ServerResponse getOrderCartList(HttpSession session) {
		User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
		int userId = currentUser.getId();
		return iCartService.getCartListByChecked(userId, 1);
	}


}