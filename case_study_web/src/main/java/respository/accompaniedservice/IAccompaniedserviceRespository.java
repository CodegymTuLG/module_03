package respository.accompaniedservice;

import model.Accompaniedservice;

import java.util.List;

public interface IAccompaniedserviceRespository {
    List<Accompaniedservice> showListAccompaniedservice();
    List<Accompaniedservice> showListAccompaniedserviceByContractId(int id);
}
