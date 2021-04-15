package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Example {

    public static void main(String[] args) throws IOException {
        // Document doc = Jsoup.connect("https://en.wikipedia.org/").get();
        Document doc = Jsoup.connect("https://www.baidu.com/").get();
        System.out.println(doc.title());
        Elements newsHeadlines = doc.select(".mnav");
        for (Element headline : newsHeadlines) {
            // System.out.println("%s\n\t%s", headline.attr("title"), headline.absUrl("href"));
            System.out.println(headline.attr("title"));
            System.out.println(headline.absUrl("href"));
        }
    }

}
