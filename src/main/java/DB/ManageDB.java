package DB;

import entity.Training;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.*;

public class ManageDB {
    public static void main(String[] args) throws SQLException{
        Scanner sc = new Scanner(System.in);
        Training training;

        System.out.println("Enter name of new training:");
        String name = sc.nextLine();
        Factory.getInstance().getTrainingDAO().addTraining(new Training(name));

        System.out.println("Enter trainings audience:");
        String audience = sc.nextLine();
        training = Factory.getInstance().getTrainingDAO().getTrainingById(3);
        if (training != null){
            training.setDate(getDate());
            training.setAudience(audience);
            training.setTime("11.00-13.30");
        }
        Factory.getInstance().getTrainingDAO().updateTraining(training);

        System.out.println("All trainings:");
        Collection trainings = Factory.getInstance().getTrainingDAO().getAllTrainings();
        Iterator iterator = trainings.iterator();
        while (iterator.hasNext()){
            training = (Training) iterator.next();
            System.out.println("Name: " + training.getName() + ", id: " + training.getTrainingID()
                    + ", date: " + training.getDate() + ", time: " + training.getTime() + ", audience: " + training.getAudience());
        }

        training = Factory.getInstance().getTrainingDAO().getTrainingById(3);
        Factory.getInstance().getTrainingDAO().deleteTraining(training);
    }

    private static String getDate() {
        DateFormat formatter;
        formatter = DateFormat.getDateTimeInstance();
        formatter.setTimeZone(TimeZone.getTimeZone("Europe/Minsk"));
        return formatter.format(new Date());
    }
}
