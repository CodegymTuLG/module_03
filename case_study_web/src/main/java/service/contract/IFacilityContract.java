package service.contract;

import model.Accompaniedservice;
import model.Contract;
import model.ContractDetail;

import java.security.PublicKey;
import java.util.List;

public interface IFacilityContract {
    List<Contract> selectAllContract();
    public void insertContract(Contract contract);
    public List<Accompaniedservice> getContractDetailbyContractId(int contract_id);
    public void insertContractDetail(ContractDetail contractDetail);
}
