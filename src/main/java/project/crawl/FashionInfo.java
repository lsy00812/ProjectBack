package project.crawl;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class FashionInfo {
	
	public Element getDoc() throws IOException{
	
		Document doc = Jsoup.connect("https://www.musinsa.com/mz/streetsnap/view/90455?p=1").get();
		
		Elements e1 = doc.getElementsByAttributeValue("class","snapImg");
		
		Element e2 = e1.get(0);
		Elements e3 = e2.select("a");
		String findString = e3.get(0).toString();
		int stringEndIdx = e3.get(0).toString().indexOf("?");
		String a = findString.substring(11, stringEndIdx);
		System.out.println(a);
		
		return e2;
	}
}
