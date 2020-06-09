public class CamelCaseConverter {
    public String parse(String text){
        while(text.contains("_")){
            text = text.substring(0,text.indexOf("_")).concat(String.valueOf(text.charAt(text.indexOf("_")+1)).toUpperCase().concat(text.substring(text.indexOf("_")+2)));
        }
        while(text.contains("-")){
            text = text.substring(0,text.indexOf("-")).concat(String.valueOf(text.charAt(text.indexOf("-")+1)).toUpperCase().concat(text.substring(text.indexOf("-")+2)));
        }
        return text;
    }
}
