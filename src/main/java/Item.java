
public class Item {
	private String itemName;	
	private double itemRate;
	private int quantity;
	
	
	public Item(String itemName, double itemRate, int quantity) {
		super();
		this.itemName = itemName;
		this.itemRate = itemRate;
		this.quantity = quantity;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public double getItemRate() {
		return itemRate;
	}
	
	public int getQuantity() {
		return quantity;
	}
}
