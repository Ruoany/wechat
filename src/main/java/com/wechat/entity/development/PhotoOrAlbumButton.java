package com.wechat.entity.development;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 若安择晴
 * @description PhotoOrAlbumButton
 * @date 2020/4/20--11:56
 */

public class PhotoOrAlbumButton extends BaseButton {

    private String type="pic_photo_or_album";
    private String key;
    private List<BaseButton> sub_button=new ArrayList<>();

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

    public List<BaseButton> getSub_button() {
        return sub_button;
    }

    public void setSub_button(List<BaseButton> sub_button) {
        this.sub_button = sub_button;
    }

    public PhotoOrAlbumButton(String name, String key){
      super(name);
      this.key=key;
  }

}
