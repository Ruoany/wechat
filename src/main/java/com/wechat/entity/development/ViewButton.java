package com.wechat.entity.development;

/**
 * @author 若安择晴
 * @description ViewButton
 * @date 2020/4/20--10:52
 */

public class ViewButton extends BaseButton {

    private String type="view";
    private String url;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ViewButton(String name, String url) {
        super(name);
        this.url=url;
    }
}
