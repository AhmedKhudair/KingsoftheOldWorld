package com.ahmed.salah.kingsoftheoldworld;

/**
 * Created by Ahmed on 21/10/2017.
 */

class KingsName {

    String name;
    int    image;
    String html;


    public KingsName(String name, int image, String html) {
        this.name = name;
        this.image = image;
        this.html = html;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }
}
