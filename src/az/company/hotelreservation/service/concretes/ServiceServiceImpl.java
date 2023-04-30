package az.company.hotelreservation.service.concretes;

import az.company.hotelreservation.dao.abstracts.ServiceDao;
import az.company.hotelreservation.dao.concretes.ServiceDaoImpl;
import az.company.hotelreservation.model.Service;
import az.company.hotelreservation.service.abstracts.ServiceService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ServiceServiceImpl implements ServiceService {
    private ServiceDao serviceDao = new ServiceDaoImpl();
    @Override
    public List<Service> getAll() throws SQLException, IOException {
        return serviceDao.getAll();
    }

    @Override
    public Service getById(String id) throws SQLException, IOException {
        return serviceDao.getById(id);
    }

    @Override
    public void create(Service entity) throws SQLException, IOException {
        serviceDao.create(entity);
    }

    @Override
    public void update(Service entity) throws SQLException, IOException {
        serviceDao.update(entity);
    }

    @Override
    public void delete(String id) throws SQLException, IOException {
        serviceDao.delete(id);
    }
}
