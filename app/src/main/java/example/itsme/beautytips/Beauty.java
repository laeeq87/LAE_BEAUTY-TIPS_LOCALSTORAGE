package example.itsme.beautytips;

import java.text.NumberFormat;

/**
 * Created by itsme on 10/7/2016.
 */
public class Beauty {
    private long id;
    private String title;
    private String type;
    private String description_first;
    private String description_mid;
    private String description_last;
    private String image_first;
    private String image_mid;
    private String image_last;





    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    ///////////////////////////////////////////////////

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    ////////////////////////////////////////////////////////

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
////////////////////////////////////////////////////////////////////////////////
    public String getDescription_first() {
        return description_first;
    }

    public void setDescription_first(String description_first) {
        this.description_first = description_first;
    }

    ////////////////////////////////////////////////////////////////////////
    public String getDescription_mid() {
        return description_mid;
    }

    public void setDescription_mid(String description_mid) {
        this.description_mid = description_mid;
    }
///////////////////////////////////////////////////////////////////////////////////
    public String getDescription_last() {
        return description_last;
    }

    public void setDescription_last(String description_last) {
        this.description_last = description_last;
    }
///////////////////////////////////////////////////////////////////////////////////////
    public String getImage_first() {
        return image_first;
    }

    public void setImage_first(String image_first) {
        this.image_first = image_first;
    }
//////////////////////////////////////////////////////////////////////////////////
    public String getImage_mid() {
        return image_mid;
    }

    public void setImage_mid(String image_mid) {
        this.image_mid = image_mid;

    }
///////////////////////////////////////////////////////////////////////////////////////////


    public String getImage_last() {
        return image_last;
    }

    public void setImage_last(String image_last) {
        this.image_last = image_last;
    }
    ///////////////////////////////////////////////////////////////////////////////////


//    @Override
//    public String toString() {
//        NumberFormat nf=NumberFormat.getCurrencyInstance();
//
//
//        return title +"\n("+nf.format(price)+")";
//    }
}
