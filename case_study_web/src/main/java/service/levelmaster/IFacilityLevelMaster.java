package service.levelmaster;

import model.LevelMaster;
import model.ServiceTypeMaster;

import java.util.List;

public interface IFacilityLevel {
    List<LevelMaster> selectAllLevel();
}
