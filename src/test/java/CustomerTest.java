import org.junit.Test;

import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;
import static org.junit.Assert.*;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

//소비자가 최대 3개를 살수있음
public class CustomerTest {
    //소비자의 가방의 개수가 0인지확인
    @Test
    public void CustomorInventoryISZero(){
        Customer customer =new Customer();
        assertThat(customer.getInventory(),is(3));
    }
    @Test(expected = Exception.class)
    public void moneyTesting() throws Exception {
        // customer의 돈이 0원 이하인 경우 Exception이 제대로 발생하는지 확인
        Customer customer = new Customer();
        customer.spendMoney(30000);
        customer.showMoney();
    }
    @Test(expected = IllegalAccessException.class)
    public void overMoneySpend() throws IllegalAccessException {
        Customer customer = new Customer();
        customer.spendMoney(100000);
    }
    @Test //Customer가 휴대폰을 살수있는지 없는지 금액확인
    public void CustomorIsBuyCellphone(){
        Customer customer =new Customer();
        Producer p=new Producer();
        assertThat(customer.getMoney(), greaterThanOrEqualTo(p.cellphone.price));
    }



}