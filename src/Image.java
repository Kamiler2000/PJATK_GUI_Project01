import java.util.ArrayList;
import java.util.List;

public class Image {
	//Public static fields
	private static List<Image> imagesList = new ArrayList<Image>();

	//Private fields
	private String path;
	private String author = "";
	private String location = "";
	private String date = "";
	private String tag = "";
	
	//Constructor
	public Image(String path) {
		this.path = path;
	}

	//Getters and Setters
	public String getPath()						{ return path; }
	public void setPath(String path)			{ this.path = path; }
	public String getAuthor()					{ return author; }
	public void setAuthor(String author)		{ this.author = author; }
	public String getLocation()					{ return location; }
	public void setLocation(String location)	{ this.location = location; }
	public String getDate()						{ return date; }
	public void setDate(String date)			{ this.date = date; }
	public String getTag()						{ return tag; }
	public void setTag(String tag)				{ this.tag = tag; }
	public List<Image> getImagesList() 			{ return imagesList; }
	
	public static void addImage(Image image) {
		imagesList.add(image);
	}
	
	@Override
	public String toString() {
		return "Image [path=" + path + "]";
	}
	
	
}
