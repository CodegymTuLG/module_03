package service.accompaniedservice;

import model.Accompaniedservice;
import respository.accompaniedservice.AccompaniedserviceRespository;
import respository.accompaniedservice.IAccompaniedserviceRespository;

import java.util.List;

public class FacilityAccompaniedservice implements IFacilityAccompaniedservice{
    IAccompaniedserviceRespository accompaniedserviceRespository = new AccompaniedserviceRespository();
    @Override
    public List<Accompaniedservice> showListAccompaniedservice() {
        return accompaniedserviceRespository.showListAccompaniedservice();
    }

    @Override
    public List<Accompaniedservice> showListAccompaniedserviceByContractId(int id) {
        return accompaniedserviceRespository.showListAccompaniedserviceByContractId(id);
    }
}
