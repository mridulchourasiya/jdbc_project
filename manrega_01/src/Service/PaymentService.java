package Service;


import DAO.Impl.PaymentDaoImpl;
import DAO.PaymentDao;
import Model.Payment;

import java.util.List;

public class PaymentService {

    private PaymentDao paymentsDao = new PaymentDaoImpl();

    public boolean addPayment(Payment payment) {
        return paymentsDao.addPayment(payment);
    }

    public Payment getPaymentById(int id) {
        return paymentsDao.getPaymentById(id);
    }

    public List<Payment> getAllPayments() {
        return paymentsDao.getAllPayment();
    }

    public boolean updatePayment(Payment payment) {
        return paymentsDao.updatePayment(payment);
    }

    public boolean deletePayment(int id) {
        return paymentsDao.deletePayment(id);
    }

}
