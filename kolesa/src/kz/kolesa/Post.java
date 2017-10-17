package kz.kolesa;

public class Post {
	private String id;
	private String title;
	private String city;
	private String year;
	private String capacity;
	private String mileage;
	private String color;
	private String drive;
	private String state;
	private String image;
	private String author;
	private String views;
	private String date;
	private String price;
	private String description;

	public Post(String title, String city, String year, String capacity, String mileage, String color, String drive, String state, String image, String author,String price, String description) {
		this.title = title;
		this.city = city;
		this.year = year;
		this.capacity = capacity;
		this.mileage = mileage;
		this.color = color;
		this.drive = drive;
		this.state = state;
		this.image = image;
		this.author = author;
		this.price = price;
		this.description = description;
	}
	
	public Post(String title,String image, String id) {
		this.title = title;
		this.image = image;
		this.id = id;
	}
	
	public String getPrice()
	{
		return price;
	}
	
	public void setId(String id)
	{
		this.id = id;
	}

	public void setDate(String date)
	{
		this.date = date;
	}
	
	public void setViews(String views)
	{
		this.views = views;
	}
	
	public String getId()
	{
		return id;
	}
	
	public String getViews()
	{
		return views;
	}
	
	public String getDate()
	{
		return date;
	}
	
	public String getTitle() {
		return title;
	}

	public String getCity() {
		return city;
	}

	public String getYear() {
		return year;
	}

	public String getCapacity() {
		return capacity;
	}

	public String getMileage() {
		return mileage;
	}

	public String getColor() {
		return color;
	}

	public String getDrive() {
		return drive;
	}

	public String getState() {
		return state;
	}

	public String getImage() {
		return image;
	}

	public String getAuthor() {
		return author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
