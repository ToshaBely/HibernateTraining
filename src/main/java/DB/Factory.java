package DB;

import DAO.TrainingDAO;
import DAO.impl.TrainingDAOImpl;

public class Factory {
    private static TrainingDAO trainingDAO = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance(){
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }

    public TrainingDAO getTrainingDAO(){
        if (trainingDAO == null){
            trainingDAO = new TrainingDAOImpl();
        }
        return trainingDAO;
    }
}
