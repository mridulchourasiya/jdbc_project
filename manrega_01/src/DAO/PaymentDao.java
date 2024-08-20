package DAO;

import Model.Payment;

import java.util.List;

public interface PaymentDao {
    boolean addPayment(Payment payment);

    Payment getPaymentById(int id);

    List<Payment> getAllPayment();

    boolean updatePayment(Payment payment);

    boolean deletePayment(int id);
}
