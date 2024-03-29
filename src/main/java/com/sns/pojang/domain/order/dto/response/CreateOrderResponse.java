package com.sns.pojang.domain.order.dto.response;

import com.sns.pojang.domain.menu.entity.MenuOption;
import com.sns.pojang.domain.order.entity.Order;
import com.sns.pojang.domain.order.entity.OrderMenu;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Builder
@Getter
public class CreateOrderResponse {
    private Long orderId; // 주문 번호
    private String customer; // 주문자 닉네임
    private String store; // 가게명
    private int totalPrice; // 총 주문 금액
    private Map<String, Integer> orderMenuInfo; // 주문 메뉴 정보
    private Map<String, List<String>> orderMenuOptions; // 추가한 옵션 정보

    public static CreateOrderResponse from(Order order){
        Map<String, Integer> orderMenuInfo = new HashMap<>();
        Map<String, List<String>> orderMenuOptions = new HashMap<>();
        for (OrderMenu orderMenu : order.getOrderMenus()){
            orderMenuInfo.put(orderMenu.getMenu().getName(), orderMenu.getQuantity());
            List<String> menuOptions = new ArrayList<>();
            for (MenuOption menuOption : orderMenu.getMenuOptions()){
                menuOptions.add(menuOption.getName());
                orderMenuOptions.put(orderMenu.getMenu().getName(), menuOptions);
            }
        }
        return CreateOrderResponse.builder()
                .orderId(order.getId())
                .customer(order.getMember().getNickname())
                .store(order.getStore().getName())
                .totalPrice(order.getTotalPrice())
                .orderMenuInfo(orderMenuInfo)
                .orderMenuOptions(orderMenuOptions)
                .build();
    }
}
