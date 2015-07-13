package DAO.impl;

import DAO.TrainingDAO;
import entity.Training;
import org.hibernate.Session;
import util.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrainingDAOImpl implements TrainingDAO {

    public void addTraining(Training training) throws SQLException{
        if (training == null){
            return;
        }

        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(training);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }

    public List getAllTrainings() throws SQLException{
        Session session = null;
        List trainings = new ArrayList<Training>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            trainings = session.createCriteria(Training.class).list();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return trainings;
    }

    public Training getTrainingById(long trainingID) throws SQLException{
        Session session = null;
        Training training = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
             training = (Training) session.get(Training.class, trainingID);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return training;
    }

    public void updateTraining(Training training) throws SQLException{
        if (training == null){
            return;
        }

        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(training);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }

    public void deleteTraining(Training training) throws SQLException{
        if (training == null) {
            return;
        }

        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(training);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }
}
