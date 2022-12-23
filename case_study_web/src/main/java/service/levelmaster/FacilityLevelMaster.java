package service.levelmaster;

import model.LevelMaster;
import model.ServiceTypeMaster;
import respository.levelmaster.ILevelRespository;
import respository.levelmaster.LevelRespository;
import respository.servicetypemaster.IServiceTypeMasterRespository;
import respository.servicetypemaster.ServiceTypeMasterRespository;

import java.util.List;

public class FacilityLevel implements IFacilityLevel {
    ILevelRespository levelRespository = new LevelRespository();
    @Override
    public List<LevelMaster> selectAllLevel() {
        return levelRespository.selectAllLevel();
    }
}
