package service.workpartmaster;

import model.ServiceTypeMaster;
import model.WorkPartMaster;
import respository.servicetypemaster.IServiceTypeMasterRespository;
import respository.servicetypemaster.ServiceTypeMasterRespository;
import respository.workpartmaster.IWorkPartMasterRespository;
import respository.workpartmaster.WorkPartMasterRespository;

import java.util.List;

public class FacilityWorkPartMaster implements IFacilityWorkPartMaster {
    IWorkPartMasterRespository workPartMasterRespository = new WorkPartMasterRespository();
    @Override
    public List<WorkPartMaster> selectAllWorkPart() {
        return workPartMasterRespository.selectAllWorkPart();
    }
}
