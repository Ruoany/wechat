package com.wechat.entity.development;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 若安择晴
 * @description SubButton
 * @date 2020/4/20--10:55
 */

public class SubButton extends BaseButton {

    private List<BaseButton> sub_button=new ArrayList<>();

    public List<BaseButton> getSub_button() {
        return sub_button;
    }

    public void setSub_button(List<BaseButton> sub_button) {
        this.sub_button = sub_button;
    }

    public SubButton(String name) {
        super(name);
    }
}
