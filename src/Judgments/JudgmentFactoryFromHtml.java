package Judgments;

import Attributes.CourtType;
import Attributes.IJudgmentAttribute;
import Attributes.Judge;
import Attributes.Regulation;
import SharedObjects.IBaseChangeObserver;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class JudgmentFactoryFromHtml {
    Document document;
    private IBaseChangeObserver observer;

    public JudgmentFactoryFromHtml(IBaseChangeObserver observer){
        this.observer = observer;
    }

    public Judgment createJudgmentFromDocument(Document document){
        this.document = document;
        Judgment result = new Judgment();
        result.getCourtCases().add(readCaseSignature());

        Elements elements = document.getElementsByClass("niezaznaczona");
        readElements(result, elements);
        return result;
    }
    private String readCaseSignature(){
        String temp = this.document.getElementById("warunek").text();
        temp = temp.split("-")[0].trim();
        return temp;
    }

    private void readElements(Judgment judgment, Elements elements){

        for(Element element: elements){


            if(element.getElementsByClass("lista-label").text().equals("Data orzeczenia")){
                judgment.setJudgmentDate(readDate(element));
            } else if(element.getElementsByClass("lista-label").text().equals("Sąd")){
                judgment.setCourtType(readCourtType(element));
            } else if(element.getElementsByClass("lista-label").text().equals("Sędziowie")){
                judgment.setJudges(readJudges(element, judgment.getCourtCases().get(0)));
            } else if(element.getElementsByClass("lista-label").text().equals("Powołane przepisy")){
                judgment.setReferencedRegulations(readRegulations(element,judgment.getCourtCases().get(0)));
            } else if(element.getElementsByClass("lista-label").text().equals("Uzasadnienie")){
                judgment.setTextContent(readJustification(element));
            }
        }
    }

    private String readJustification(Element element) {
        StringBuilder result = new StringBuilder();

        for(Element temp: element.getElementsByClass("info-list-value-uzasadnienie")){
            result.append(temp.text());
        }

        return result.toString();
    }

    private List<IJudgmentAttribute> readRegulations(Element element, String judgmentId) {
        List<IJudgmentAttribute> result = new LinkedList<>();
        for(Element temp: element.getElementsByClass("nakt")){
            String regulation = temp.text();
            regulation = regulation.replace(" - tekst jedn","");
            regulation = regulation.replace(" - tekst jednolity","");
            regulation = regulation.replace(" - t.j","");
            if(regulation.endsWith("."))regulation = regulation.substring(0,regulation.length()-1);
            Regulation reg = new Regulation();
            reg.setJournalTitle(regulation);
            reg = (Regulation)this.observer.updateBaseRegulations(reg);
            reg.judgmentsIds.add(judgmentId);
            result.add(reg);
        }


        return null;
    }

    private List<IJudgmentAttribute> readJudges(Element element, String judgmentId) {

        String judgesS = element.getElementsByClass("info-list-value").toString();

        judgesS = (String)judgesS.subSequence(("<td class=\"info-list-value\">").length(),
                                                judgesS.length()-("</td>").length());
        judgesS = judgesS.trim();
        String[] judgesArray = judgesS.split("<br>");
        //// wszystkie <...> usunięte, sędziowie podzieleni na własne string, teraz usunąć /.../

        List<IJudgmentAttribute> result = new LinkedList<>();

        for(int i=0 ;i<judgesArray.length; i++){
            judgesArray[i] = judgesArray[i].split("/")[0];
            judgesArray[i] = judgesArray[i].replace("- ", "-");
            judgesArray[i] = judgesArray[i].replace(" - ", "-");
            judgesArray[i] = judgesArray[i].replace(" -", "-");
            Judge judge = new Judge();
            judge.setName(judgesArray[i]);
            judge = (Judge)this.observer.updateBaseJudges(judge);
            judge.judgmentsIds.add(judgmentId);
            result.add(judge);
        }
        /// usunięte /.../ oraz randomowe spacje w Nazwisko1- Nazwisko2, Nazwisko1 -Nazwisko2, Nazwisko1 - Nazwisko2

        return result;
    }

    private CourtType readCourtType(Element element) {
        String courtS = element.getElementsByClass("info-list-value").text();

        //wszystkie są administracyjne, ale jakby ktoś plików dorzucił to jest
        if(courtS.contains("Sąd Administracyjny"))return CourtType.ADMINISTRATIVE;

        if(courtS.contains("Sąd Najwyższy"))return CourtType.SUPREME;

        if(courtS.contains("Trybunał Konstytucyjny")) return CourtType.CONSTITUTIONAL_TRIBUNAL;
        if(courtS.contains("Krajowa Izba Odwoławcza")) return CourtType.NATIONAL_APPEAL_CHAMBER;
        return CourtType.COMMON; // powszechny tylko zostaje, brak nulli

    }

    private Date readDate(Element element) {
        String dateS = element.getElementsByClass("info-list-value").text();
        dateS = dateS.split(" ")[0];
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        try {

            return format.parse(dateS);
        }catch(ParseException e){
            System.out.println(e.getMessage());
        }
        return null;

    }

}
