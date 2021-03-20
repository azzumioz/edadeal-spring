package ru.lightapps.edadeal.dao;

import ru.lightapps.edadeal.entity.Segment;

import java.util.List;

public interface SegmentDAO {
    public List<Segment> getAllSegments();

    public Segment getSegment(int id);
}
