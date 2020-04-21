package com.wechat.entity.development;

/**
 * @author 若安择晴
 * @description ClickButton
 * @date 2020/4/20--10:46
 */
public class ClickButton extends BaseButton {

    private String type="click";
    private String key;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ClickButton(String name, String key) {
        super(name);
        this.key=key;
    }
}
