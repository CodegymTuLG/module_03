package service.contract;

import model.Accompaniedservice;
import model.Contract;
import model.ContractDetail;
import respository.contract.ContractRespository;
import respository.contract.IContractRespository;

import java.util.List;

public class FacilityContract implements IFacilityContract{
    IContractRespository contractRespository = new ContractRespository();
    @Override
    public List<Contract> selectAllContract() {
        return contractRespository.selectAllContract();
    }

    @Override
    public void insertContract(Contract contract) {
        contractRespository.insertContract(contract);
    }

    @Override
    public List<Accompaniedservice> getContractDetailbyContractId(int contract_id) {
        return contractRespository.getContractDetailbyContractId(contract_id);
    }

    @Override
    public void insertContractDetail(ContractDetail contractDetail) {
        contractRespository.insertContractDetail(contractDetail);
    }

}
