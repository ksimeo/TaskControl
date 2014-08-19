package service;

import dao.IAlbumDao;
import dao.IPhotoDao;
import models.Album;
import models.Photo;

import java.util.List;

/**
 * Created by VLAD on 19.08.2014.
 */
public class AlbumManager {

    IPhotoDao pd;
    IAlbumDao ad;

    public AlbumManager(IPhotoDao pd, IAlbumDao ad) {
        this.pd = pd;
        this.ad = ad;
    }

    public Album createAlbum(String name, String desc) {
        Album l = new Album();
        l.setId(ad.getSize());
        l.setName(name);
        l.setDescription(desc);
        ad.addAlbum(l);
        return l;
    }

    public Photo savePhoto(String ref) {
        Photo p = new Photo();
        p.setId(pd.getSize());
        p.setRef(ref);

        pd.addPhoto(p);
        return p;
    }

//    public List<Photo> getAllPhotos(){
//        return pd.getAllPhotos();
//    }

//    public void deletePhoto(Photo photo)
//    {
//        pd.delPhoto(photo);
//    }


    public List<Album> getAllAlbums() {
        return ad.getAllAlbums();
    }

    public void deletAlbum(Album album) {
        ad.delAlbum(album);
    }

    public void addPhotoToAlbum(Album album, Photo photo) {

        Album a = ad.getAlbumById(album.getId());

        a.getPhotos().add(photo);

    }

    public Album delPhotoFromAlbum(Album album, Photo photo) {


        pd.delPhoto(photo);

        album.getPhotos().remove(photo);
        if (album.getPhotos().size() != 0) {
            return album;
        } else {
            ad.delAlbum(album);
            return null;
        }

    }


}
