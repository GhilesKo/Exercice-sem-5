package org.example;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{

    private static List<String> list = Arrays.asList("jo@pipo.org","ma_mu@m.ca","a.a@a.aa","ab@ab","a.b@ab","jo");
    public static void main( String[] args )
    {

        //FruitLegume();
        //BaliseA("https://departement-info-cem.github.io/3N5-Prog3/testbot/");

        for (String email:list
             ) {

            if (isValidEmailAddress(email)){
                System.out.println("OK : " + email);
            }
            else{System.out.println("KO : " + email);}
        }


    }
   public static void FruitLegume()
   {
       // C'est comme un set mais sans d'élément dupliquer. Tout comme un Set, il n'y a pas d'ordre.
       Multiset<String>FruitLegume = HashMultiset.create();
       FruitLegume.setCount(("Carotte"),50);
       FruitLegume.add("Pomme");
       FruitLegume.add("Patate");
       FruitLegume.add("Pomme");

       System.out.println(FruitLegume.size());
   }


   public static void BaliseA(String url)  {

       try {

           Document doc =  Jsoup.connect(url).get();
           Elements links = doc.select("a[href]");
           for (Element element:links)
           {
               URI uri = new URI(element.attr("abs:href"));
               String path = uri.getPath();
               String finpath = path.substring(path.lastIndexOf('/')+1);

               System.out.println(element.text()+" = " + finpath   );


           }


       } catch (IOException | URISyntaxException e) {
           e.printStackTrace();


       }


   }

    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;

    }





}
