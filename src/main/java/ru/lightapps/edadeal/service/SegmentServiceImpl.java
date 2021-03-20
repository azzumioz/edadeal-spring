package ru.lightapps.edadeal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.lightapps.edadeal.dao.SegmentDAO;
import ru.lightapps.edadeal.entity.Segment;

import java.util.List;

@Service
public class SegmentServiceImpl implements SegmentService {

    @Autowired
    private SegmentDAO segmentDAO;

    @Override
    @Transactional
    public List<Segment> getAllSegments() {
        return segmentDAO.getAllSegments();
    }

    @Override
    @Transactional
    public Segment getSegment(int id) {
        return segmentDAO.getSegment(id);
    }


}
