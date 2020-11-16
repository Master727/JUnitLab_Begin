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
}
