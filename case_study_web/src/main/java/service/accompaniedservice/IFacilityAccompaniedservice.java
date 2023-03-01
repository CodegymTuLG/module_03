package service.accompaniedservice;

import model.Accompaniedservice;

import java.util.List;

public interface IFacilityAccompaniedservice {
    List<Accompaniedservice> showListAccompaniedservice();
    List<Accompaniedservice> showListAccompaniedserviceByContractId(int id);
}
