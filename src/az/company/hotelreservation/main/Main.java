package az.company.hotelreservation.main;

import az.company.hotelreservation.dao.abstracts.AddressDao;
import az.company.hotelreservation.dao.abstracts.CustomerDao;
import az.company.hotelreservation.dao.concretes.AddressDaoImpl;
import az.company.hotelreservation.dao.concretes.CustomerDaoImpl;
import az.company.hotelreservation.gui.MainFrame;
import az.company.hotelreservation.model.*;
import az.company.hotelreservation.service.abstracts.AddressService;
import az.company.hotelreservation.service.concretes.AddressServiceImpl;
import az.company.hotelreservation.service.concretes.CustomerServiceImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        
        try {
            for(javax.swing.UIManager.LookAndFeelInfo info:javax.swing.UIManager.getInstalledLookAndFeels()) {
            if("Nimbus".equals(info.getName())){
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
        CustomerDao customerDao = new CustomerDaoImpl();
        CustomerServiceImpl customerService = new CustomerServiceImpl(customerDao);
        
        AddressDao addressDao = new AddressDaoImpl();
        AddressService addressService = new AddressServiceImpl(addressDao);
        MainFrame mainFrame = new MainFrame(customerService,addressService);
        mainFrame.setVisible(true);
        } catch (Exception e) {
        }
    }
}
