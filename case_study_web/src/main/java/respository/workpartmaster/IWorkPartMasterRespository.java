package respository.workpartmaster;

import model.RentTypeMaster;
import model.WorkPartMaster;

import java.util.List;

public interface IWorkPartMasterRespository {
    List<WorkPartMaster> selectAllWorkPart();
}
