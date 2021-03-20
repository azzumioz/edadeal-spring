package ru.lightapps.edadeal.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.lightapps.edadeal.entity.Segment;

import java.util.List;

@Repository
public class SegmentDAOImpl implements SegmentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Segment> getAllSegments() {
        Session session = sessionFactory.getCurrentSession();
        Query<Segment> query = session.createQuery("from Segment", Segment.class);
        return query.getResultList();
    }

    @Override
    public Segment getSegment(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Segment.class, id);
    }
}
