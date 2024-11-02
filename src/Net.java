import java.net.InetAddress; 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class Net{   
    
    private String host; 
    //Regular Expression for IP Address 
    private final String REGEX_IP = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$";
    private final String REGEX_COMPUTER_NAME = "^(?![0-9]{1,15}$)[a-zA-Z0-9-]{1,15}$";

    boolean ping(String addr, int duration)
     { //addr = address
        try{ 
            InetAddress address = InetAddress.getByName(addr);
            host = address.getHostName();
            return address.isReachable(duration); 
        }catch(Exception e )
        {
            e.printStackTrace(); 
        }
        return false;
    }

    String getHost() { /* return host name */
        String res = host == null ? null : host;
        return res;  
    }

    boolean validateAddress(String addr){
        try { 
            Pattern hostname_pattern = Pattern.compile(REGEX_COMPUTER_NAME);
            Pattern ip_pattern = Pattern.compile(REGEX_IP);
            Matcher hostname_matcher = hostname_pattern.matcher(addr); 
            Matcher ip_matcher = ip_pattern.matcher(addr); 

            if(hostname_matcher.find() || ip_matcher.find()) {
                return true;
            }
        }catch(PatternSyntaxException pe) // pe -> pattern exception
        {
            pe.printStackTrace();
        }
        return false; 
    }
}