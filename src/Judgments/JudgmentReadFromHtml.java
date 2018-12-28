package Judgments;

import SharedObjects.IBaseChangeObserver;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class JudgmentReadFromHtml {
    private HashMap<String,Judgment> judgments;
    private JudgmentFactoryFromHtml judgmentFactoryFromHtml;

    public JudgmentReadFromHtml(HashMap<String,Judgment> judgments, IBaseChangeObserver observer){
        this.judgments = judgments;
        this.judgmentFactoryFromHtml = new JudgmentFactoryFromHtml(observer);
    }

    public void readItem(String path) throws IOException {
        File direction = new File(path);

        Document document = Jsoup.parse(direction, "UTF-8");
        Judgment judgment = this.judgmentFactoryFromHtml.createJudgmentFromDocument(document);

        judgments.put(judgment.getCourtCases().get(0),judgment);

    }
}
