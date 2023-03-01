package service.positionmaster;

import model.PositionMaster;
import model.ServiceTypeMaster;

import java.util.List;

public interface IFacilityPositionMaster {
    List<PositionMaster> selectAllPosition();
}
