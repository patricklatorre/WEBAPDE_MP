package beans;

import java.io.Serializable;

public class Photo implements Serializable {
	public static final String TABLE_NAME = "photos";
	public static final String COLUMN_IDPHOTO = "idphoto";
	public static final String COLUMN_PHOTO = "photo";
	
	private int idphoto;
	private String photo;
	
	public Photo() {
		
	}
	
	public Photo(String photo) {
		this.photo = photo;
	}
	
	public String getIdphoto() {
		return photo;
	}
	
	public void setIdphoto(int idphoto) {
		this.idphoto = idphoto;
	}
	
	public String getPhoto() {
		return photo;
	}
	
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
}
