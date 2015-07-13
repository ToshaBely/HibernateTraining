package DAO;

import entity.Training;

import java.sql.SQLException;
import java.util.List;

public interface TrainingDAO {
    public void addTraining(Training training) throws SQLException;
    public List getAllTrainings() throws SQLException;
    public Training getTrainingById(long trainingID) throws SQLException;
    public void updateTraining (Training training) throws SQLException;
    public void deleteTraining (Training training) throws SQLException;
}
