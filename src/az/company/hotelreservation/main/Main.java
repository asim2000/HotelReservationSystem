package az.company.hotelreservation.main;

import az.company.hotelreservation.model.*;
import az.company.hotelreservation.service.concretes.AddressServiceImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Choose below option\n" +
//                "1.Get address list\n" +
//                "2.Create address\n" +
//                "3.Update address\n" +
//                "4.Delete address");
//        int option = scanner.nextInt();
//        scanner.nextLine();
//
//        switch (option){
//            case 1:
//                new AddressServiceImpl().getAll().forEach(System.out::println);
//                break;
//            case 2:
//                System.out.println("Enter address name");
//                String name = scanner.nextLine();
//
//                System.out.println("Enter parent address id");
//                String parentAddressId = scanner.nextLine();
//
//                Address address = new Address();
//                address.setName(name);
//                address.setParentId(parentAddressId);
//
//                new AddressServiceImpl().create(address);
//                System.out.println("Address created");
//                break;
//            case 3:
//                System.out.println("Enter address id");
//                String addressId = scanner.nextLine();
//
//                System.out.println("Enter address name");
//                String addressName = scanner.nextLine();
//
//                System.out.println("Enter address parent id");
//                String parentAddressId2 = scanner.nextLine();
//
//                Address address2 = new Address();
//                address2.setId(addressId);
//                address2.setName(addressName);
//                address2.setParentId(parentAddressId2);
//
//                new AddressServiceImpl().update(address2);
//                System.out.println("Updated address");
//                break;
//            case 4:
//                System.out.println("Enter address id");
//                String id = scanner.nextLine();
//                new AddressServiceImpl().delete(id);
//                System.out.println("Address deleted");
//            default:new IllegalArgumentException();
//
//        }
    }
}
