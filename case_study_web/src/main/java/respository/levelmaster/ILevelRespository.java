package respository.levelmaster;

import model.LevelMaster;
import model.RentTypeMaster;

import java.util.List;

public interface IRentLevelRespository {
    List<LevelMaster> selectAllLevel();
}
