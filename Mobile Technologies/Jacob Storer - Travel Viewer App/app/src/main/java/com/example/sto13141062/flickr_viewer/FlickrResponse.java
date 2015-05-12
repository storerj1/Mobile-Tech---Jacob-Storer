package com.example.sto13141062.flickr_viewer;

import java.util.List;
/**
 * Created by STO13141062 on 11/05/2015.
 */
public class FlickrResponse {

    private FlickrPhotos photos;

    public FlickrPhotos getPhotos() {return photos;}

    public class FlickrPhotos
    {
        private List<FlickrPhoto> photo;
        public List<FlickrPhoto> getPhoto(){return photo;}

    }

    public class FlickrPhoto
    {

        private String title;
        private String url_o;
        private String url_m;

        public String getTitle(){return title;}
        public String getUrl_o(){return url_o;}
        public String getUrl_c(){return url_m;}

        //public String getImageURl(){};


    }

}
