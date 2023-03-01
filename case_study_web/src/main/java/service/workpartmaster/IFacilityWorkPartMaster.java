package service.workpartmaster;

import model.ServiceTypeMaster;
import model.WorkPartMaster;

import java.util.List;

public interface IFacilityWorkPartMaster {
    List<WorkPartMaster> selectAllWorkPart();
}
