import java.util.ArrayList;
public class Customer{
	private String name;
	private ArrayList<Item> itemList;
	
	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public double calculateBill() {
		double total = 0;
		if(itemList == null)
			throw new NullPointerException(name + " your cart is empty");	
		for(int i=0;i<itemList.size();i++) {
			total += itemList.get(i).getItemRate() * itemList.get(i).getQuantity();
		}
		return total;
	}
}
