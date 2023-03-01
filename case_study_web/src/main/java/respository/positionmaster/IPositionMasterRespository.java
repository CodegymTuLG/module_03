package respository.positionmaster;

import model.PositionMaster;
import model.RentTypeMaster;

import java.util.List;

public interface IPositionMasterRespository {
    List<PositionMaster> selectAllPosition();
}
