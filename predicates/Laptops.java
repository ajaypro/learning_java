package predicates;

public class Laptops {
	
	private long mPrice;
	private String mBrand;

	public Laptops(String brand, long price) {
		this.mPrice = price;
		this.mBrand = brand;
	}

	public long getPrice() {
		return mPrice;
	}
	public void setPrice(long mPrice) {
		this.mPrice = mPrice;
	}
	
	public String getBrand() {
		return mBrand;
	}
	public void setBrand(String brand) {
		this.mBrand = brand;
	}
	@Override
	public String toString() {

		return "Laptop ( Brand: " + this.getBrand() + 
				", Price:"+ this.getPrice() + " ) ";
	}


}
