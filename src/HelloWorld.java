import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;
import com.tangosol.util.ConverterCollections.ConverterEntry;
import com.tangosol.util.Filter;
import com.tangosol.util.extractor.IdentityExtractor;
import com.tangosol.util.extractor.KeyExtractor;
import com.tangosol.util.filter.KeyFilter;
import com.tangosol.util.filter.LikeFilter;
import com.ttech.tims.imos.data.dto.PersonDTO;
import com.ttech.tims.imos.data.dto.SendSmsEntryDTO2;
import com.ttech.tims.imos.data.dto.UserDTO;
import com.ttech.tims.imos.data.entry.Person;
import com.ttech.tims.imos.data.entry.SmsEntry;
import com.ttech.tims.imos.data.entry.User;

public class HelloWorld {

   public static void main(String[] args) {
      basicTest();
      //printAllValues();
      filterDeleteTest();
      //poftest();
      // poftestPerson1();
      // poftestUser1();
      CacheFactory.shutdown();
   }

   public static void filterDeleteTest(){
      System.out.println("filterDeleteTest..");
      NamedCache sendSmsSizeCache = CacheFactory.getCache("SEND_SMS_SIZE_CACHE");
      String reqEx = "k1%";
     // Filter query = new LikeFilter(IdentityExtractor.INSTANCE,reqEx, '\\', true);  //value temelli bir filtre uygulanýr.
      Filter query = new LikeFilter(new KeyExtractor(),reqEx, '\\', true);  //value temelli bir filtre uygulanýr.
     
      Set<String> keySetDay = sendSmsSizeCache.keySet(query);
      Iterator ketIteratorFilter = keySetDay.iterator();
      
      while(ketIteratorFilter.hasNext()){
         String key = (String) ketIteratorFilter.next();
         System.out.println("key:"+key+" Value: "+sendSmsSizeCache.get(key));
      }
      
   }
   
   private static void poftestUser1() {

      NamedCache sendSmsSizeCache = CacheFactory.getCache("SEND_SMS_SIZE_CACHE");

      UserDTO userdto = new UserDTO();
      User user = new User("12", "Ahmet", "Karakaya", 200);
      // user.setId("12");
      // user.setName("Ahmet");
      // user.setSurname("Karakaya");
      userdto.setUser(user);
      sendSmsSizeCache.put("12", userdto);

      userdto = (UserDTO) sendSmsSizeCache.get("12");
      System.out.println(userdto.getUser());

   }

   public static void poftest() {

      NamedCache sendSmsSizeCache = CacheFactory.getCache("SEND_SMS_SIZE_CACHE");
      String key = "53305.09.2014";
      SendSmsEntryDTO2 dto = (SendSmsEntryDTO2) sendSmsSizeCache.get(key);
      if (dto == null) {
         sendSmsSizeCache.put(key, new SendSmsEntryDTO2(new SmsEntry("533", new Date(), 0)));
         sendSmsSizeCache.put(key, new SendSmsEntryDTO2(new SmsEntry("533", new Date(), 1)));
      }

      dto = (SendSmsEntryDTO2) sendSmsSizeCache.get(key);

      System.out.println(dto.getSmsEtry());

   }

   public static void basicTest() {

      NamedCache sendSmsSizeCache = CacheFactory.getCache("SEND_SMS_SIZE_CACHE");

      sendSmsSizeCache.put("k1", "v1");
      sendSmsSizeCache.put("key10", "v10");
      sendSmsSizeCache.put("key11", "v10ahmetv10");

      System.out.println("k1:" + sendSmsSizeCache.get("k1"));
      System.out.println("k2:" + sendSmsSizeCache.get("k2"));                

   }
   
   public static void printAllValues() {
      NamedCache sendSmsSizeCache = CacheFactory.getCache("SEND_SMS_SIZE_CACHE");
      
      Set set = sendSmsSizeCache.keySet();
      Iterator iterator = set.iterator();
      while (iterator.hasNext()) {
         System.out.println(iterator.next());
      }
   }

   /**
    * DtO'nun default contructor'i olmalý.
    */
   public static void poftestPerson1() {
      NamedCache sendSmsSizeCache = CacheFactory.getCache("SEND_SMS_SIZE_CACHE");
      PersonDTO pdto = new PersonDTO();

      Person person = new Person("ahmet", "karakaya", 32);
      pdto.setP(person);
      sendSmsSizeCache.put("ahmet", pdto);


      System.out.println(sendSmsSizeCache.get("ahmet"));
   }
}
