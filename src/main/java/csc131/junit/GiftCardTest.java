package csc131.junit;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class GiftCardTest
{
    @Test
    public void getIssuingStore()
    {
        double       balance;        
        GiftCard     card;
        int          issuingStore;
        
        issuingStore = 1337;
        balance      = 100.00;
        card = new GiftCard(issuingStore, balance);

        assertEquals("getIssuingStore()", 
                     issuingStore, card.getIssuingStore());
    }
    @Test
    public void getBalance()
    {
        double balance = 100.00;        
        GiftCard card;
        int issuingStore = 1337;
        card = new GiftCard(issuingStore, balance);

        assertEquals("getBalance()",
                     balance, card.getBalance(), 0.001);
    }
    @Test
    public void deduct_Balance()
    {
        double balance = 100.00;        
        GiftCard card;
        int issuingStore = 1337;
        String string;
        card = new GiftCard(issuingStore, balance);

        string = "Remaining Balance: " + String.format("%6.2f", 90.00);
        assertEquals("deduct(10.00)", 
                     string, card.deduct(10.0));
    }
    @Test
    public void deduct_AmountDue()
    {
        double balance = 100.00;        
        GiftCard card;
        int issuingStore = 1337;
        String string;
        card = new GiftCard(issuingStore, balance);

        string = "Amount Due: " + String.format("%6.2f", 10.00);
        assertEquals("deduct 110.00 from 100.00", 
                     string, card.deduct(110.0));
    }

    @Test
    public void deduct_InvalidTransaction()
    {
        double balance = 100.00;        
        GiftCard card;
        int issuingStore = 1337;
        String string;
        card = new GiftCard(issuingStore, balance);

        string = "Invalid Transaction";
        assertEquals("deduct -10.00 from 100.00", 
                     string, card.deduct(-10.0));
    }
    @Test(expected = IllegalArgumentException.class)
    public void constructor_IncorrectBalance() throws IllegalArgumentException
    {
        new GiftCard(1, -100.00);
    }
  
    
    @Test(expected = IllegalArgumentException.class)
    public void constructor_IncorrectID_Low()
    {
        new GiftCard(-1, 100.00);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void constructor_IncorrectID_High()
    {
        new GiftCard(100000, 100.00);
    }
}
