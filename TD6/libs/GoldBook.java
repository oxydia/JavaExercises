package libs;
import java.util.Set;

abstract public class GoldBook implements Set {
    public void addMessages(String message){
        this.add(message);
    }
}