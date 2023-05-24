import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void everyBranchTesting() {
     List<User> allUser=new ArrayList<>();

     RuntimeException ex;

     ex=assertThrows(RuntimeException.class, () -> SILab2.function(null,allUser));

     assertTrue(ex.getMessage().contains("Mandatory information missing!"));

     User user=new User(null,"pass","test");

     assertFalse(SILab2.function(user,allUser));

     user=new User(null,"pass space","test");

     assertFalse(SILab2.function(user,allUser));

     user=new User("test1","pass@12a","test@gmail.com");

     assertTrue(SILab2.function(user,allUser));

     User existingUser1=new User("test1","diffpass@","test@gmail.com");
     User existingUser2=new User("diffuser","diffpass@","psdfopsd@lol.com");
     allUser.add(existingUser1);
     allUser.add(existingUser2);

     assertFalse(SILab2.function(user,allUser));
     user=new User("test1","nospecialchar","test@gmail.com");
     assertFalse(SILab2.function(user,allUser));

    }

    @Test
    void MultipleConditionTesting(){
     List<User> allUser=new ArrayList<>();
     RuntimeException ex;

     ex=assertThrows(RuntimeException.class, () -> SILab2.function(null, allUser) );
     assertTrue(ex.getMessage().contains("Mandatory information missing!"));

     User user=new User("test1",null,"test@gmail.com");
     ex=assertThrows(RuntimeException.class, () -> SILab2.function(user, allUser) );
     assertTrue(ex.getMessage().contains("Mandatory information missing!"));

     User user2=new User("test1","lolol",null);
     ex=assertThrows(RuntimeException.class, () -> SILab2.function(user2, allUser) );
     assertTrue(ex.getMessage().contains("Mandatory information missing!"));

     User user3=new User("test1","pass@12a","test@gmail.com");
     assertTrue(SILab2.function(user3,allUser));
    }
}