package respository.contract;

import model.Accompaniedservice;
import model.Contract;
import model.ContractDetail;

import java.util.List;

public interface IContractRespository {
    public void insertContract(Contract contract);

    public List<Contract> selectAllContract();

    public boolean deleteContract(int id);

    public boolean updateContract(Contract contract);

    public List<Accompaniedservice> getContractDetailbyContractId(int contract_id);

    public void insertContractDetail(ContractDetail contractDetail);
}
