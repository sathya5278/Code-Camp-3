import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CustomerTest {
	
	static Item itemOne, itemTwo, itemThree;
	static Customer customer;
	static String name;
	static ArrayList<Item> itemList;
	@BeforeAll
	public static void setup() {
		
		customer = new Customer();
		itemOne = Mockito.mock(Item.class);
		itemTwo = Mockito.mock(Item.class);
		itemThree = Mockito.mock(Item.class);
		name = new String("Sathya M");
		itemList = new ArrayList<Item>();
		
		itemList.add(itemOne);
		itemList.add(itemTwo);
		itemList.add(itemThree);
		
		Mockito.when(itemOne.getItemName()).thenReturn("Rice");
		Mockito.when(itemTwo.getItemName()).thenReturn("Wheat");
		Mockito.when(itemThree.getItemName()).thenReturn("Sugar");
		
		Mockito.when(itemOne.getItemRate()).thenReturn(50d);
		Mockito.when(itemTwo.getItemRate()).thenReturn(40d);
		Mockito.when(itemThree.getItemRate()).thenReturn(30d);
		
		Mockito.when(itemOne.getQuantity()).thenReturn(1);
		Mockito.when(itemTwo.getQuantity()).thenReturn(4);
		Mockito.when(itemThree.getQuantity()).thenReturn(2);
	}
	
	@Test
	public void happyFlowCalculateBill() {
		customer.setName(name);
		customer.setItemList(itemList);
		assertEquals(270, customer.calculateBill());
	}
	
	@Test
	public void happyFlowZeroItemCalculateBill() {
		customer.setName(name);
		customer.setItemList(new ArrayList<Item>());
		assertEquals(0, customer.calculateBill());
	}
	
	@Test
	public void nullPointerExceptionCalculateBill() {
		customer.setName(name);
		customer.setItemList(null);
		NullPointerException exception = assertThrows(NullPointerException.class, () -> customer.calculateBill());
		assertEquals("Sathya M your cart is empty",exception.getMessage());
	}
}
