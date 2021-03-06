package service.customer;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService implements ICustomerService {

    static public List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer(1, "thinh1", "thinh@email1", "thai binh1"));
        customerList.add(new Customer(2, "thinh2", "thinh@email1", "thai binh1"));
        customerList.add(new Customer(3, "thinh3", "thinh@email1", "thai binh1"));
        customerList.add(new Customer(4, "thinh4", "thinh@email1", "thai binh1"));
        customerList.add(new Customer(5, "thinh5", "thinh@email1", "thai binh1"));
    }

    @Override
    public List findAll() {
        return customerList;
    }

    @Override
    public Customer findById(int id) {

//        for (Customer c : customerList) {
//            if (c.getId() == id) {
//                return c;
//            }
//        }
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId() == id)
                return customerList.get(i);
        }
        return null;
    }

    @Override
    public void create(Customer customer) {

        customerList.add(customer);
    }

    @Override
    public void edit(Customer customer) {
        customerList.set(customer.getId(), customer);

    }


    @Override
    public void delete(int id) {
        Customer customer = this.findById(id);

        customerList.remove(customer);

    }
}
