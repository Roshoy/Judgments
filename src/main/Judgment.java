package main;

import Atributes.*;

import java.util.LinkedList;
import java.util.List;

public class Judgment {
    public int id;
    public CourtType courtType;
    public JudgmentType judgmentType;
    public LinkedList<String> courtCases = new LinkedList<>();
    public List<Judge> judges = new LinkedList<>();
    public JudgmentSource source;
    public List<String> courtReporters = new LinkedList<>();

}
