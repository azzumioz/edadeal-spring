package ru.lightapps.edadeal.service;

import ru.lightapps.edadeal.entity.Segment;

import java.util.List;

public interface SegmentService {
    public List<Segment> getAllSegments();

    public Segment getSegment(int id);
}
